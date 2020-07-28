import java.util.Arrays;

public class TestEnum {

    public static void main(String[] args) {
        Sex sex = Sex.Male;
        Sex sex2 = Sex.valueOf("Male");
        if (sex == sex2) {
            System.out.println("你是个男的!");
        }
        System.out.println(Arrays.toString(Sex.values()));


    }
}
