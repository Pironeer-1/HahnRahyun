public class ch05_3 {
    int sum(int a, int b) { // a, b는 매개변수
        return a+b;
    }

    // 입력값이 없는 메서드
    String say() {
        return "Hi";
    }
    // 리턴값이 없는 메서드
    void sum2(int a, int b) {
        System.out.println(a + "과 " + b + "의 합은 " + (a+b) + "입니다.");
    }
    // 입력값과 리턴값이 모두 없는 메서드
    void say2() {
        System.out.println("Hi");
    }



    public static void main(String[] args) {
        class Sample2 {
            void sayNick(String nick) {
                if ("바보".equals(nick)) {
                    return; // 즉시 메서드를 빠져나감
                }
                System.out.println("나의 별명은 " + nick + " 입니다.");
            }
        }

        class Sample3 {
            void varTest(int a) {
                a++;
            }
        }

        ch05_3 sample = new ch05_3(); // 자기 자신 클래스에서 sample 객체 생성
        int c = sample.sum(3, 4); // 3, 4는 인수
        System.out.println(c);

        // 입력값이 없는 메서드
        String a = sample.say(); // a에 Hi라는 문자열 리턴
        System.out.println(a);
        // 리턴값이 없는 메서드
        sample.sum2(3, 4); // 3과 4의 합은 7입니다. 출력
        // 입력값과 리턴값이 모두 없는 메서드
        sample.say2(); // Hi

        Sample2 sample2 = new Sample2();
        sample2.sayNick("야호"); // 나의 별명은 야호 입니다.
        sample2.sayNick("바보"); // 출력되지 않음

        int a1 = 1;
        Sample3 sample3 = new Sample3();
        sample3.varTest(a1);
        System.out.println(a1); // 1
    }

    /*
    public class Sample {
        int varTest(int a) {
            a++;
            return a;
        }

    public static void main(String[] args) {
        int a = 1;
        Sample sample = new Sample();
        a = sample.varTest(a);
        System.out.println(a); // 2
    }
    */

    /* varTest 메서드의 입력값이 자료형이 아닌 "객체"인 경우
    public class Sample {
        int a;

        void varTest(Sample sample) {
            sample.a++;
            // this.a++; 도 가능
        }

        public static void main(String[] args) {
            Sample sample = new Sample();
            sample.a = 1;
            sample.varTest(sample);
            System.out.println(sample.a); // 2
        }
    */
}
