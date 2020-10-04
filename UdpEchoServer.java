import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //核心流程 两步
    //1.初始化操作 实例化一个socket对象
    //2.进入主循环 接受并处理请求(主循环是
    // 一个死循环) 等待客户端输入字符串服务器才开始工作
    //1)读取数据并解析
    //2)根据请求计算响应
    //3)把响应结果返回给客户端
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        //实例化socket
        //port是端口号
        //构造方法new了一个socket对象 此时socket对象会和一个IP地址和端口号关联起来(绑定端口号)
        //客户端会按照这个IP+端口访问服务器
        //IP默认是0.0.0.0(特殊) 这个直接关联到主机的所有网卡的IP
        socket = new DatagramSocket(port);
    }
    private String process(String request) {
        //因为这个是回显操作 直接返回就可
        return request;
    }
    public void start() throws IOException {
        //启动服务器
        System.out.println("服务器启动");
        while (true) {
        //a)读取请求并解析
            //DatagramPacket是UDP发送和接收数据的基本单位
            //同时给packet指定一个缓冲区
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            //receive的时候会阻塞 因为服务器启动了不代表客户端立刻发起请求
            //等待客户端的数据发送过来后 receive才会把收到的数据放到DatagramPacket的缓冲区中
            socket.receive(requestPacket);
            //先把请求数据转换成字符串(好处理)从0开始到length结束
            //trim:得到的数据不一定是4096 它基本上都是比这个小 trim将空白的区域去除
            String request = new String(requestPacket.getData(),0,
                    requestPacket.getLength()).trim();

            //b)根据请求计算响应
            //这个地方为啥是搞了一个方法呢?
            //因为本程序我们写了一个简单的回显操作 但是并不是所有的服务器都是这么简单
            //后续碰到复杂的时候 直接修改process方法中的内容就行了
            String response = process(request);

            //c)把响应返回给客户端
            //响应是response 需要包装成一个packet对象
            //包的数据包括:指定的区域 指定的数组 发送给谁(客户端的地址和端口 来自服务器的IP和端口)
            //length得到的是字节数 一定别写成字符数
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());

            socket.send(responsePacket);

            //格式化打印
            //%s->String %d->int
            System.out.printf("[%s:%d] req: %s; resp: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        //服务器启动
        udpEchoServer.start();
    }


}
