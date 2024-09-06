import java.util.ArrayList;
import java.util.Arrays;

public class ch04_5 {
    public static void main(String[] args) {
        // ========== 04 - 5 : for each문 ==========
        String[] numbers = {"one", "two", "three"};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]); // one two three
        }

        // for each
        // for (type 변수명: iterate)
        // iterate는 루프를 돌릴 객체, 배열이나 ArrayList만 가능
        // 또한 type은 iterate 객체에 포함된 자료형과 일치해야 함.
        for (String number: numbers) {
            System.out.println(number); // one two three
        }

        ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        for (String number2 : numbers2) {
            System.out.println(number2);
        }
    }
}
