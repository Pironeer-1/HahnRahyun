class Animal5 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal5 {
    // 상속받았기 때문에 setName, name 사용 가능
    void sleep() {
        System.out.println(this.name + " zzz");
    }
}

class HouseDog extends Dog {
    void sleep() { // 메서드 오버라이딩
        System.out.println(this.name + " zzz in house");
    }

    void sleep(int hour) { // 메서드 오버로딩
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    }
}

public class ch05_5 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("poppy");
        System.out.println(dog.name);
        dog.sleep();

        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        houseDog.sleep(); // happy zzz in house
        houseDog.sleep(3); // happy zzz in house for 3 hours
    }
}
