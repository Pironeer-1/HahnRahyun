/*class Updater {
    void update(int count) {
        count++;
    }
}

class Counter {
    int count = 0;
}

public class ch05_4 {
    public static void main(String[] args) {
        Counter mycounter = new Counter();
        System.out.println("before update : " + mycounter.count); // 0
        Updater myUpdater = new Updater();
        myUpdater.update(mycounter.count);
        System.out.println("after update : " + mycounter.count); // 0
    }
}*/

class Updater {
    void update(Counter counter) {
        counter.count++;
    }
}

class Counter {
    int count = 0;
}

public class ch05_4 {
    public static void main(String[] args) {
        Counter mycounter = new Counter();
        System.out.println("before update : " + mycounter.count); // 0
        Updater myUpdater = new Updater();
        myUpdater.update(mycounter);
        System.out.println("after update : " + mycounter.count); // 1
    }
}
