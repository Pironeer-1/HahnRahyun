import java.util.Arrays;
import java.util.HashSet;

public class ch03_9 {
    public static void main(String[] args) {
        // ========== 03 - 9 : 집합 ==========
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set); // [e, H, l, 0]
        // 중복 허용 안함, unordered -> 인덱싱 없음

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        // 제네릭스로 int를 사용하려면 int의 Wrapper 클래스인 Integer를 사용해야 함.

        // s1과 s2의 교집합 구하기 - retainAll
        HashSet<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        System.out.println(intersection); // [4, 5, 6]

        // s1과 s2의 합집합 구하기 - addAll
        HashSet<Integer> union = new HashSet<>(s1);
        union.addAll(s2);
        System.out.println(union); // [1, 2, ... , 9] 중복 값은 하나씩만 출력

        // 차집합 구하기 - removeAll
        HashSet<Integer> substract = new HashSet<>(s1);
        substract.removeAll(s2);
        System.out.println(substract); // [1, 2, 3] s1 기준에서 s2 요소를 뺐기 때문에

        // add 메서드
        HashSet<String> set2 = new HashSet<>();
        set2.add("Jump");
        set2.add("To");
        set2.add("Java");
        System.out.println(set2); // [Java, To, Jump] 무작위여도 규칙이 있나?

        // addAll 메서드
        HashSet<String> set3 = new HashSet<>();
        set3.add("Jump");
        set3.addAll(Arrays.asList("To", "Java"));
        System.out.println(set3); // [Java, To, Jump]

        // remove 메서드
        set2.remove("To");
        set3.remove("Java"); // 어떤 리턴 값이 출력되지는 않음
        System.out.println(set2);
        System.out.println(set3);
    }
}
