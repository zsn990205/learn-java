import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class httpServer3 {
    static class User {
        public String name;
        public int age;
        public String school;
    }
        private ServerSocket serverSocket = null;
    //sessions表示同一个用户的一组会话
        private HashMap<String,User> sessions = new HashMap<String, User>();

        public httpServer3(int port) throws IOException {
            serverSocket = new ServerSocket(port);
        }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    public void process(Socket clientSocket) {
        // 处理核心逻辑
        try {
            // 1. 读取请求并解析
            httpRequest request = httpRequest.build(clientSocket.getInputStream());
            httpResponse response = httpResponse.build(clientSocket.getOutputStream());
            // 2. 根据请求计算响应
            // 此处按照不同的 HTTP 方法, 拆分成多个不同的逻辑
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            } else {
                // 其他方法, 返回一个 405 这样的状态码
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            // 3. 把响应写回到客户端
            response.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doPost(httpRequest request, httpResponse response) {
    //实现login的处理
        if (request.getUrl().startsWith("/login")) {
            // 读取用户提交的用户名和密码
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            if ("abc".equals(userName) && "123".equals(password)) {
            //登陆成功
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                //登陆成功得随机生成一个字符串(使用session)
                //sessionId是随机生成的 user是输入的用户信息
                //此时就做到将用户的敏感信息放在服务器上 只返回sessionId
                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.name = "abc";
                user.age = 20;
                user.school = "skd";
                sessions.put(sessionId,user);
                //因为在sessions这个哈希表中 键和值是一一对应的
                // 所以有了对应的sessionId 就能找到了对应的user
                response.setHeaders("Set-Cookie", "sessionId=" + sessionId);
                response.writeBody("<html>");
                response.writeBody("<div>欢迎您!</div>");
                response.writeBody("</html>");
            } else {
            //登陆失败
            response.setStatus(403);
            response.setMessage("Forbidden");
            response.setHeaders("Content-Type: ","text/html; charset=utf-8");
            response.writeBody("<html>");
            response.writeBody("<div>登陆失败</div>");
            response.writeBody("</html>");
            }
        }
    }

    private void doGet(httpRequest request, httpResponse response) throws IOException {
        // 1. 能够支持返回一个 html 文件.
        if (request.getUrl().startsWith("/index.html")) {
            String sessionId = request.getCookie("sessionId");
            //通过sessionId找到user
            User user = sessions.get(sessionId);
            if (sessionId == null || user == null) {
                //此时尚未登陆
                // 这种情况下, 就让代码读取一个 index.html 这样的文件.
                // 要想读文件, 需要先知道文件路径. 而现在只知道一个 文件名 index.html
                // 此时这个 html 文件所属的路径, 可以自己来约定(约定某个 d:/...) 专门放 html .
                // 把文件内容写入到响应的 body 中
               response.setStatus(200);
               response.setMessage("OK");
               response.setHeaders("Content-Type: ","text/html;charset = utf-8");
               InputStream inputStream = httpServer3.class.getClassLoader().getResourceAsStream("index.html");
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
               // 按行读取内容, 把数据写入到 response 中
               String line = null;
               while ((line = bufferedReader.readLine()) != null) {
                      response.writeBody(line + "\n");
                 }
                bufferedReader.close();
            }
            else {
               //登陆过了
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeaders("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>" + "您已经登陆了! 无需再次登陆! 用户名: " + user.name + "</div>");
                response.writeBody(+ user.age + "</div>");
                response.writeBody("<div>" + user.school + "</div>");
                response.writeBody("</html>");
            }

        }
    }

    public static void main(String[] args) throws IOException {
        httpServer3 server3 = new httpServer3(9090);
        server3.start();
    }
}
