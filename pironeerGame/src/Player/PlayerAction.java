package Player;

import Enemy.Enemy;
import Enemy.EnemyAction;

import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class PlayerAction {
    private static final Random random = new Random();

    public static void statusSet(Player player, int point, Scanner scanner) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%d만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n", point);
        System.out.println("(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while (true) {
            try {
                System.out.print("체력 공격력 마법력을 공백으로 구분하여 입력하세요: ");
                String[] inputs = scanner.nextLine().split(" ");
                int hp = Integer.parseInt(inputs[0]);
                int ad = Integer.parseInt(inputs[1]);
                int ap = Integer.parseInt(inputs[2]);

                if (hp + ad + ap == point) {
                    player.setHp(player.getHp() + hp * 3);
                    player.setAd(player.getAd() + ad);
                    player.setAp(player.getAp() + ap);
                    System.out.printf("체력: %d, 공격력: %d, 마법력: %d\n", player.getHp(), player.getAd(), player.getAp());
                    break;
                } else {
                    System.out.printf("입력한 능력치의 총합이 %d와 같아야 합니다. 다시 입력해주세요.\n", point);
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void attack(Player player, Enemy enemy, int playerIndex, Scanner scanner) {
        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------");
                System.out.printf("%d번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)\n", playerIndex + 1);
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }

                int inputKey = Integer.parseInt(input);
                if (inputKey < 1 || inputKey > 4) {
                    System.out.println("1~4 사이의 정수를 입력해주세요.");
                    continue;
                }

                switch (inputKey) {
                    case 1:
                        checkStatus(player, enemy);
                        break;
                    case 2:
                        basicAttack(player, enemy);
                        break;
                    case 3:
                        magicAttack(player, enemy);
                        break;
                    case 4:
                        healSelf(player);
                        break;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }

    private static void checkStatus(Player player, Enemy enemy) {
        System.out.printf("현재 유저: 체력 %d, 공격력 %d, 마법력 %d\n", player.getHp(), player.getAd(), player.getAp());
        System.out.printf("적: 체력 %d, 공격력 %d, 방어력 %d, 마법방어력 %d\n\n", enemy.getHp(), enemy.getAd(), enemy.getAdDefence(), enemy.getApDefence());
        int damage = player.getAd() - enemy.getAdDefence();
        enemy.decreaseHp(damage);
        System.out.printf("일반 공격으로 %d의 데미지를 주었습니다.\n\n", damage);
    }

    private static void basicAttack(Player player, Enemy enemy) {
        int criticalPoint = random.nextInt(10) + 1;
        int damage = player.getAd() - enemy.getAdDefence();

        if (criticalPoint > 2) {
            enemy.decreaseHp(damage);
            System.out.printf("일반 공격으로 %d의 데미지를 주었습니다.\n", damage);
        } else {
            damage *= 2;
            enemy.decreaseHp(damage);
            System.out.printf("치명타가 적용되어 %d의 데미지를 주었습니다.\n", damage);
        }
    }

    private static void magicAttack(Player player, Enemy enemy) {
        int damage = player.getAp() * 2 - enemy.getApDefence();
        enemy.decreaseHp(damage);
        System.out.printf("마법 공격으로 %d의 데미지를 주었습니다.\n", damage);
    }

    private static void healSelf(Player player) {
        int healPoint = random.nextInt(6) + 5; // 5에서 10 사이의 랜덤 값
        player.setHp(player.getHp() + healPoint);
        System.out.printf("체력을 회복합니다. 현재 hp는 %d입니다.\n", player.getHp());
    }
}
