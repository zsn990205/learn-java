
import sun.net.spi.nameservice.dns.DNSNameService;
public class Demo3 {
    public static void main(String[] args) {
        ClassLoader classLoader = Demo3.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = DNSNameService.class.getClassLoader();
        System.out.println(classLoader2);
    }
}
