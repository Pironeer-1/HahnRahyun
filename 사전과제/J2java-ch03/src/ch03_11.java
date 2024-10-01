import java.util.ArrayList;
import java.util.Arrays;

public class ch03_11 {
    public static void main(String[] args) {
        // ========== 03 - 11 : 형 변환과 final ==========
        String num = "123"; // 문자열
        int n = Integer.parseInt(num); // 정수 자료형으로 변환
        System.out.println(n); // 123

        // 정수 -> 문자열로 변환
        int m = 123; // 정수형
        String string = "" + m; // 문자열로 변환, 정수 앞에 빈 문자열 더하기
        System.out.println(string); // 123
        String num1 = String.valueOf(m); // 정수 -> 문자열
        String num2 = Integer.toString(m); // 정수 -> 문자열
        System.out.println(num1); // 123
        System.out.println(num2); // 123

        // 실수 -> 문자열로 변환
        String string2 = "123.456";
        double d = Double.parseDouble(string2);
        System.out.println(d);

        // 정수 <-> 실수
        int n1 = 123;
        double d1 = n1; // 정수 -> 실수 : 캐스팅 x
        System.out.println(d1); // 123.0

        double d2 = 123.456;
        int n2 = (int) d2; // 실수 -> 정수 : 꼭 정수형으로 캐스팅
        System.out.println(n2); // 123

        // 실수 형태의 문자열을 숫자형으로 바꿀 때, NumberFormatException 발생
        String a = "123.456"; // 실수 형태의 문자열
        int n3 = Integer.parseInt(a); // Exception 발생
        double n4 = Double.parseDouble(a); // Exception 피할 수 있음

        // final : 프로그램을 수행하면서 값이 바뀌면 안될 때 사용
        final int n5 = 123;
        // n5 = 456; // 컴파일 에러 발생

        final ArrayList<String> c = new ArrayList<>(Arrays.asList("a", "b"));
        // c = new ArrayList<>(Arrays.asList("c", "d")); // 컴파일 에러 발생
    }
}
