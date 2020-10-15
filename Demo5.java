

public class Demo5 {
    private static int num = 0;
    public static void main(String[] args) {
        synchronized (Demo5.class) {
            for (int i = 0; i < 500; i++) {
                num++;
            }
        }
        for (int i = 0; i < 500; i++) {
            synchronized (Demo5.class) {
                num++;
            }
        }
    }

    public static void main1(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");
    }
}
