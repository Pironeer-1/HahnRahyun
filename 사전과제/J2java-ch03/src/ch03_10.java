public class ch03_10 {
    // ========== 03 - 10 : 상수 집합 ==========
    enum CoffeType {
        AMERICANO, ICE_AMERICANO, CAFE_LATTE
    };

    public static void main(String[] args) {
        System.out.println(CoffeType.AMERICANO); // AMERICANO
        System.out.println(CoffeType.ICE_AMERICANO); // ICE_AMERICANO
        System.out.println(CoffeType.CAFE_LATTE); // CAFE_LATTE

        for(CoffeType type: CoffeType.values()) { // values()는 배열 리턴
            System.out.println(type); // 순서대로 출력
        }
    }
}
