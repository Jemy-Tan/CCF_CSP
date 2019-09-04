package CSP201712;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201712-2 游戏
 * @score 100
 */
public class Question_201712_2 {
    public static void main(String[] args) {
        new Question_201712_2().run();
        /* 测试数据
            5 2
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] game_overs = new boolean[n + 1];
        int game_over_num = 0;

        int now_person = 1;
        int now_num = 1;
        while (game_over_num < n - 1) {
            if (now_num % k == 0 || now_num % 10 == k) {
                game_over_num++;
//                System.out.printf("%d 淘汰\n",now_person);
                game_overs[now_person] = true;
            }
            now_num++;
            do {
                now_person++;
                if (now_person > n) {
                    now_person = 1;
                }
            } while (game_overs[now_person]);

        }

        System.out.println(now_person);
    }
}
