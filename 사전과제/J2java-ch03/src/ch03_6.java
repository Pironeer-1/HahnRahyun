import java.util.ArrayList;
import java.util.Arrays;

public class ch03_6 {
    public static void main(String[] args) {
        // ========== 03 - 6 : 배열 ==========

        int[] odds = {1, 3, 5, 7, 9};
        String[] weeksArray = {"월", "화", "수", "목", "금", "토", "일"};

        String[] weeks = new String[7]; // 초기값 없이 배열 변수를 만드려면 길이를 정해줘야 됨.
        weeks[0] = "월";
        weeks[1] = "화";
        weeks[2] = "수";
        weeks[3] = "목";
        weeks[4] = "금";
        weeks[5] = "토";
        weeks[6] = "일";

        System.out.println((weeks[0])); // 월

        for (int i = 0; i < weeks.length; i++) { // 0부터 6까지
            System.out.println(weeks[i]);
        }

        System.out.println(weeks[7]); // ArrayIndexOutOfBoundsException
    }
}
