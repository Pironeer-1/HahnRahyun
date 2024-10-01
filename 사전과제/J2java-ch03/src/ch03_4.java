public class ch03_4 {
    public static void main(String[] args) {
        // ========== 03 - 4 : 문자열 ==========

        String a = "rahyun"; // 리터럴 표기 방식 권장
        String b = new String("rahyun"); // 항상 새로운 String 객체를 만드는 방식

        if (a == b) // == 연산자는 같은 객체인지 판별.
            System.out.println("same");
        if (a.equals(b)) // 문자열 내장 비교 메서드
            System.out.println("samesame"); // 출력 O

        String c = "Hi ~ I am Rahyun";
        System.out.println(c.indexOf("R"));
        System.out.println(c.indexOf(" ")); // 공백이 여러 개면 가장 먼저 발견한 위치 출력

        System.out.println(c.contains("Rahyun")); // true

        System.out.println(c.charAt(10)); // R
        System.out.println(c.charAt(4)); // 공백
        System.out.println(c.charAt(5)); // I

        System.out.println(c.replaceAll("Rahyun", "pironeer"));
        System.out.println(c); // replaceAll은 출력 값만 영향을 주는군

        System.out.println(c.substring(0, 2)); // 0 포함 2 미포함

        System.out.println(c.toUpperCase());
        System.out.println(c.toLowerCase());

        String d = "rarrArrraa";
        String[] result = d.split("a");
        System.out.println(result); // 예상 : {"r", "rrArr"} 실제 : [Ljava.lang.String;@7ef20235

        System.out.println(String.format("I eat %s apples", "two")); // '%s'는 문자열

        System.out.println(String.format("I eat %d apples", 2)); // '%d'는 숫자

        // 여러 개는 순서대로
        int number = 2;
        String day = "two";
        System.out.println(String.format("I ate %d apples. so I was sick for %s days", number, day));

        System.out.println(String.format("I have %s roses", 3)); // 꼭 쌍따옴표를 붙이지 않아도 됨
        System.out.println(String.format("I have %s roses", 3.14)); // 실수도 문자열로 취급해서 대입
        System.out.println(String.format("I have %s roses", "3"));

        System.out.println(String.format("Error is %d%%.", 98)); // 98%

        System.out.println(String.format("%-10sjane", "hi")); // i 와 jane 사이 공백 8자리

        System.out.println(String.format("%10.4f", 3.42134234)); // 공백 4개 + 소수점 4자리

        System.out.printf("I eat %d apples", 2);
    }
}
