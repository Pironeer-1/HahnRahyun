package Enemy;

import java.util.Random;

public class Enemy {
    private int maxHp;
    private int hp;
    private int ad;
    private int adDefence;
    private int apDefence;

    public Enemy(int listNum) {
        this.maxHp = 100 * listNum;
        this.hp = 100 * listNum;
        this.ad = 25;
        this.adDefence = 7;
        this.apDefence = 7;
    }

    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    // Getters and setters
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAd() {
        return ad;
    }

    public int getAdDefence() {
        return adDefence;
    }

    public int getApDefence() {
        return apDefence;
    }

    public int getMaxHp() {
        return maxHp;
    }
}