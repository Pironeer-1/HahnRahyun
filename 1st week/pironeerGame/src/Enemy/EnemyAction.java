package Enemy;

import Player.Player;
import Player.PlayerAction;

import java.util.Random;

public class EnemyAction {
    private static final Random random = new Random();

    public static void attack(Enemy enemy, Player player, int playerIndex) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.\n");

        int enemyAction = random.nextInt(10) + 1;

        if (enemyAction == 1) {
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.\n");
        } else if (enemyAction >= 2 && enemyAction <= 8) {
            basicAttack(enemy, player, playerIndex);
        } else {
            healSelf(enemy);
        }
    }

    private static void basicAttack(Enemy enemy, Player player, int playerIndex) {
        player.decreaseHp(enemy.getAd());
        System.out.printf("%d번 유저에게 %d의 데미지. 적의 공격으로 현재 남은 체력은 %d입니다.\n",
                playerIndex + 1, enemy.getAd(), player.getHp());
    }

    private static void healSelf(Enemy enemy) {
        int healingAmount = 7;
        if (enemy.getMaxHp() < (enemy.getHp() + healingAmount)) {
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.\n");
        } else {
            enemy.setHp(enemy.getHp() + healingAmount);
            System.out.printf("적의 회복으로 현재 적의 체력은 %d입니다.\n", enemy.getHp());
        }
    }
}
