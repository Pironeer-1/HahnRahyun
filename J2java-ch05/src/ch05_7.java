interface Predator { // predator.java와 같은 단독 파일로 저장하는 것이 일반적
    String getFood();

    default void printFood() { // 디폴트 메서드
        System.out.printf("my food is %s\n", getFood());
    }
}

class Animal7 {
    String name;

    void setName7(String name) {
        this.name = name;
    }
}

class Tiger extends Animal7 implements Predator {
    public String getFood() {
        return "apple";
    }
}

class Lion extends Animal7 implements Predator {
    public String getFood() {
        return "banana";
    }
}

class Crocodile extends Animal7 implements Predator {
    public String getFood() {
        return "carrot";
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    } // 인터페이스를 통해 ZooKeeper 클래스가 동물 클래스와의 독립성 확보
}

public class ch05_7 {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        Crocodile crocodile = new Crocodile();
        zooKeeper.feed(tiger); // feed apple
        zooKeeper.feed(lion); // feed banana
        zooKeeper.feed(crocodile);
    }
}
