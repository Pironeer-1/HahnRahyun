public class ch03_2 {
    public static void main(String[] args) {
        // ========== 03 - 2 : 불 ==========

        int base = 160;
        int height = 140;
        boolean isTall = height > base;

        if (isTall) { // isTall이 false이므로 출력 값 없음
            System.out.println("키가 쥐콩만합니다.");
        }

        int i = 3;
        boolean isOdd = i % 5 == 2;
        System.out.println(isOdd); // false 출력
    }
}
