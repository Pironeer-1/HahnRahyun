import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ch03_7 {
    public static void main(String[] args) {
        // ========== 03 - 7 : 리스트 ==========

        // 배열은 크기가 정해져 있지만 리스트는 변할 수 있다
        // 예를 들어 배열의 크기를 3으로 정했다면 3개를 초과해서 담을 수 없다
        // 따라서 담을 내용의 개수가 변한다면 배열이 아닌 리스트를 사용해야 한다

        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");
        pitches.add(0, "133");

        System.out.println(pitches.get(1)); // 138

        System.out.println(pitches.size()); // 4

        System.out.println(pitches.contains("156")); // false

        System.out.println(pitches); // [133, 138, 129, 142]

        System.out.println(pitches.remove("133")); // remove(객체) 방식은 객체가 있으면 true, 없으면 false 리턴
        System.out.println(pitches.remove("120")); // false
        System.out.println(pitches.remove(0)); // remove(인덱스) 방식은 해당하는 항목을 삭제 후 삭제한 항목 리턴
        System.out.println(pitches); // [129, 142]

        // 제네릭스 : 자료형을 강제로 바꿀 때 생길 수 있는 캐스팅 오류 줄여줌

        // 제네릭스 미적용 예시
        ArrayList pitches2 = new ArrayList();
        pitches.add("138"); // Object 자료형으로 인식

        String one = (String) pitches2.get(0); // String 자료형으로 형변환

        // 제네릭스 적용 예시
        ArrayList<String> pitches3 = new ArrayList<>(); // pitches 리스트에는 반드시 String만 추가될 수 있음을 컴파일러가 앎
        pitches3.add("138");

        //String one = pitches.get(0); // 따라서 형변환 작업 필요없음

        String[] data = {"138", "129", "142"}; // 문자열 배열에 데이터 있음
        ArrayList<String> pitches4 = new ArrayList<>(Arrays.asList(data)); // asList 메서드 : 이미 존재하는 문자열 배열 -> 리스트로
        System.out.println(pitches4);
        System.out.println(data); // 또 출력 결과 배열 주소로 알려주네

        String result = String.join(",", pitches4); // String.join("구분자", 리스트 객체)
        System.out.println(result);

        String[] fruits = new String[]{"배", "사과", "딸기"}; // String.join 배열에 사용
        String result_fruits = String.join(",", fruits);
        System.out.println(result_fruits);

        pitches.sort(Comparator.naturalOrder()); // 오름차순 리스트 정렬
        pitches.sort(Comparator.reverseOrder()); // 내림차순 리스트 정렬
    }
}
