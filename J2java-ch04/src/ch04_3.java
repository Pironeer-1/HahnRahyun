public class ch04_3 {
    public static void main(String[] args) {
        // ========== 04 - 3 : while문 ==========
        int treeHit = 0;
        while (treeHit < 10) {
            treeHit++;
            System.out.println("나무를 " + treeHit + "번 찍었습니다.");
            if (treeHit == 10) {
                System.out.println("나무가 넘어갑니다.");
            }
        }

        /*
        while (true) {
            System.out.println("Ctrl-C 또는 중지버튼을 눌러야 while문을 빠져나갈 수 있습니다.");
        } -> 이 코드로 인해 다음 코드의 coffee가 unreachable 에러남
        */

        int coffee = 10;
        int money = 300;

        while (money > 0) {
            System.out.println("돈을 받았으니 커피를 줍니다.");
            coffee--;
            System.out.println("남은 커피의 양은 " + coffee + "입니다.");
            if (coffee == 0) {
                System.out.println("커피가 다 떨어졌습니다. 판매를 중지합니다.");
                break;
            }
        }

        int a = 0;
        while (a < 10) {
            a++;
            if (a % 2 == 0) {
                continue; // 짝수인 경우 조건문으로 돌아감
            }
            System.out.println(a); // 1 3 5 7 9
        }
    }
}
