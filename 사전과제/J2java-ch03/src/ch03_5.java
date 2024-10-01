public class ch03_5 {
    public static void main(String[] args) {
        // ========== 03 - 5 : StringBuffer ==========

        StringBuffer sb = new StringBuffer(); // sb라는 객체 생성
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String resultt = sb.toString(); // sb를 string 자료형으로 변환 후 생성한 result 객체에 대입
        System.out.println(resultt);

        String result = ""; // result 객체 생성
        result += "hello"; // hello를 담는 객체 생성
        result += " "; // 공백을 담는 객체 생성
        result += "jump to java"; // ~을 담는 객체 생성
        System.out.println(result);

        // String 자료형은 값이 한번 생성되면 변경 불가
        // 그러나 StringBuffer 자료형은 값 변경 가능
        // 따라서 문자열 변경이 많으면 StringBuffer, 적으면 String 사용이 좋음
        // + StringBuilder는 StringBuffer와 동일한 사용법, 그러나 멀티 스레드에 취약하기 때문에
        // 동기화를 고려한다면 StringBuffer 유리

        StringBuffer sb2 = new StringBuffer();
        sb2.append("jump to java");
        sb2.insert(0, "hello ");
        System.out.println(sb2); // hello jump to java
        System.out.println(sb2.toString()); // hello jump to java

        System.out.println(sb2.substring(0, 4));
    }
}
