class Animal6 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Dog6 extends Animal6 {
    // Dog() {} // 디폴트 생성자
    void sleep() {
        System.out.println(this.name + " zzz");
    }
}

class HouseDog6 extends Dog6 {
    HouseDog6(String name) { // 생성자
        this.setName(name);
    }

    HouseDog6(int type) { // 생성자 오버로딩
        if (type == 1) {
            this.setName("bulldog");
        } else if (type == 2) {
            this.setName("jindo");
        }
    }
    void sleep() {
        System.out.println(this.name + " zzz in house");
    }

    void sleep(int hour) {
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    }
}

public class ch05_6 {
    public static void main(String[] args) {
        HouseDog6 happy = new HouseDog6("happy"); // 문자열로 생성
        HouseDog6 jindo = new HouseDog6(2); // 숫자값으로 생성

        System.out.println(happy.name); // happy
        System.out.println(jindo.name); // jindo

    }
}
