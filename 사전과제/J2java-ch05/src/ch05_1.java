class Calculator {
    //static int result = 0; // 이전에 계산한 결과값을 유지하기 위해 static 사용
    int result = 0;

    // static int add(int num) {
    int add(int num) { // 더하기 기능
        result += num;
        return result;
    }

    int sub(int num) { // 빼기 기능
        result -= num;
        return result;
    }
}

public class ch05_1 {
    public static void main(String[] args) {
        Calculator cal1 = new Calculator(); // cal1 객체 생성
        Calculator cal2 = new Calculator(); // cal2 객체 생성

        System.out.println(cal1.add(3)); // 3
        System.out.println(cal1.add(4)); // 4

        System.out.println(cal2.add(3)); // 3 : cal1과 독립적인 값 유지
        System.out.println(cal2.add(7)); // 10 : cal1과 독립적인 값 유지
    }
    // static 키워드를 사용하면 결과 값이 3 7 10 17로 나옴
}
