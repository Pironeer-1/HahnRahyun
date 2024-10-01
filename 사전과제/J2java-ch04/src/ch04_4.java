public class ch04_4 {
    public static void main(String[] args) {
        // ========== 04 - 4 : for문 ==========
        String[] numbers = {"one", "two", "three"};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]); // one two three
        }

        // 총 5명의 학생이 시험을 보았는데 시험점수가 60점이 넘으면 합격하고 그렇지 않으면 불합격이다.
        // 합격, 불합격을 판단하여 출력하시오
        int[] scores = {90, 25, 67, 45, 80};
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) { // 인덱스 접근 말고 변수에 i값을 담아서 할 수는 없을까?
                System.out.println((i+1)+"번 학생은 합격");
            } else {
                System.out.println("불합격");
            }
        }

        // continue
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                continue;
            }
            System.out.println((i+1) + "번 학생 축하합니다. 합격입니다.");
        }

        // 이중 for문
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i*j + " ");
            }
            System.out.println(""); // 줄을 바꾸어 출력하는 역할을 함
        }
    }
}
