abstract class Predator9 extends Animal9 {
    abstract String getFood();

    void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}

class Animal9 {
    String name;

    void setName8(String name) {
        this.name = name;
    }
}

interface Barkable9 {
    void bark();
}

class Tiger9 extends Predator9 implements Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion9 extends Predator9 implements Barkable {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper9 {
    void feed(Predator9 predator) {
        System.out.println("feed " + predator.getFood());
    } // 인터페이스를 통해 ZooKeeper 클래스가 동물 클래스와의 독립성 확보
}

class Bouncer9 {
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

public class ch05_9 {
    public static void main(String[] args) {
        Tiger9 tiger = new Tiger9();
        Lion9 lion = new Lion9();

        Bouncer9 bouncer = new Bouncer9();
        bouncer.barkAnimal(tiger); // 어흥
        bouncer.barkAnimal(lion); // 으르렁
    }
}
