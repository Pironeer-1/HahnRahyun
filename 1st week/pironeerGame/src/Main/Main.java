package Main;

import Player.Player;
import Player.PlayerAction;
import Enemy.Enemy;
import Enemy.EnemyAction;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private List<Player> playerList;
    private Enemy enemy;
    private int statusPoint = 13;
    private Scanner scanner;
    private Random random;

    public Main() {
        playerList = new ArrayList<>();
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void setPlayers() {
        int listNum;
        while (true) {
            try {
                System.out.print("플레이어 인원을 정하세요: ");
                listNum = Integer.parseInt(scanner.nextLine());
                if (listNum <= 0) {
                    System.out.println("플레이어 인원은 1 이상이어야 합니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }

        for (int i = 0; i < listNum; i++) {
            Player player = new Player();
            PlayerAction.statusSet(player, statusPoint, scanner);
            playerList.add(player);
        }
    }

    public void setEnemy() {
        enemy = new Enemy(playerList.size());
    }

    public boolean turnCheck() {
        playerList.removeIf(player -> player.getHp() <= 0);
        return !playerList.isEmpty() && enemy.getHp() > 0;
    }

    public Player selectTargetPlayer() {
        return playerList.get(random.nextInt(playerList.size()));
    }

    public void game() {
        setPlayers();
        setEnemy();

        while (turnCheck()) {
            for (int i = 0; i < playerList.size(); i++) {
                if (!turnCheck()) {
                    break;
                }
                Player player = playerList.get(i);
                PlayerAction.attack(player, enemy, i, scanner);
                if (enemy.getHp() <= 0) {
                    break;
                }
            }

            if (turnCheck()) {
                Player targetPlayer = selectTargetPlayer();
                int targetIndex = playerList.indexOf(targetPlayer);
                EnemyAction.attack(enemy, targetPlayer, targetIndex);
            }
        }

        if (enemy.getHp() <= 0) {
            System.out.println("축하합니다! 승리하셨습니다!");
        } else {
            System.out.println("아쉽지만 패배하셨습니다.");
        }
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.game();
    }
}
