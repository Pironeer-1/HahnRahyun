import java.util.HashMap;

public class ch03_8 {
    public static void main(String[] args) {
        // ========== 03 - 8 : 맵 ==========
        HashMap<String, String> map = new HashMap<>();
        // 제네릭스를 사용하는데, 키와 value 값에 String 외 자료형은 불가함
        map.put("people", "사람");
        map.put("baseball", "야구");
        map.put("people", "rahyun"); // key값은 중복이 안되기 때문에 후자로 value 저장
        map.put("princess", "Rahyun");

        System.out.println(map.get("people")); // rahyun

        System.out.println(map.containsKey("people")); // true
        System.out.println(map.containsKey("없다")); //false

        System.out.println(map.remove("people")); // key와 value 모두 삭제 후 삭제된 value 출력
        System.out.println(map.get("people"));
        System.out.println(map.remove("없다")); // null

        System.out.println(map.size()); // 2

        System.out.println(map.keySet()); // [baseball, princess]
    }
}
