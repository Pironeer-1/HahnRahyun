class Animal {
    String name; // 객체 변수(=인스턴스 변수, 멤버 변수, 속성)

    public void setName(String name) { // 입력으로 name을 받아 객체 변수에 저장하는 메서드이기 때문에 리턴 값 없음
        this.name = name; // this.name = "body";
        // this는 클래스에서 생성된 객체를 지칭함
    }
}

public class ch05_2 {
    public static void main(String[] args) {
        Animal cat = new Animal(); // cat 객체 생성
        cat.setName("body"); // this = cat
        System.out.println(cat.name); // body

        Animal dog = new Animal();
        dog.setName("happy");
        System.out.println(dog.name); // happy
    }
}
