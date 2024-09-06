interface Predator8 {
    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}

interface Barkable {
    void bark();
}

interface BarkablePredator extends Predator, Barkable {
    // 인터페이스의 다중 상속
}

class Animal8 {
    String name;

    void setName8(String name) {
        this.name = name;
    }
}

class Tiger8 extends Animal8 implements Predator8, Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion8 extends Animal8 implements BarkablePredator {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper8 {
    void feed(Predator8 predator) {
        System.out.println("feed " + predator.getFood());
    } // 인터페이스를 통해 ZooKeeper 클래스가 동물 클래스와의 독립성 확보
}

class Bouncer {
    /* Barkable 인터페이스 선언 전
    void barkAnimal(Animal8 animal) {
        if (animal instanceof Tiger8) {
            System.out.println("어흥");
        } else if (animal instanceof Lion8) {
            System.out.println("으르렁");
        }
    }*/
    void barkAnimal(Barkable animal) {
        animal.bark();
    }
}

public class ch05_8 {
    public static void main(String[] args) {
        Tiger8 tiger = new Tiger8();
        Lion8 lion = new Lion8();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger); // 어흥
        bouncer.barkAnimal(lion); // 으르렁
    }
}
