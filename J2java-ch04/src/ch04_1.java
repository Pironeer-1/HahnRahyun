import java.util.ArrayList;
import java.util.Arrays;

public class ch04_1 {
    public static void main(String[] args) {
        // ========== 04 - 1 : if문 ==========
        boolean money = true;
        if (money) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }

        int x = 3;
        int y = 2;
        System.out.println(x > y); // true
        System.out.println(x < y); // false
        System.out.println(x == y); // false
        System.out.println(x != y); //true

        // 만약 3000원 이상의 돈을 가지고 있으면 택시를, 그렇지 않으면 걸어가라
        int money2 = 2000;
        if (money2 >= 3000) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라"); // 출력
        }

        // 돈이 3000원 이상 있거나 카드가 있다면 택시를, 그렇지 않으면 걸어가라
        int money3 = 2000;
        boolean hasCard = true;
        if (money3 >= 3000 || hasCard) {
            System.out.println("택시를 타고 가라"); // 출력
        } else {
            System.out.println("걸어가라");
        }

        // contains : 리스트 자료형에 해당 아이템이 있는지
        // 만약 주머니에 돈이 있으면 택시를 타고, 없으면 걸어가라
        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("handphone");
        pocket.add("money");

        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라"); // 출력
        } else {
            System.out.println("걸어가라");
        }

        // 지갑에 돈이 있으면 택시를, 돈은 없지만 카드가 있으면 택시를,
        // 지갑에 돈도 카드도 없으면 걸어가라
        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라"); // 출력
        } else if(hasCard) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }
    }
}
