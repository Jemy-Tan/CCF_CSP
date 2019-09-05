package CSP201809;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201809-4 再卖菜
 * @score 100
 */
public class Question_201809_4 {
    int n;
    boolean[][][] visited;
    int[] todays;
    int[] firsts;
    boolean is_over = false;

    public static void main(String[] args) {
        new Question_201809_4().run();
        /* 测试数据
            8
            4 1 3 1 6 5 17 9
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        todays = new int[n];
        firsts = new int[n];
        visited = new boolean[n][401][401];
        for (int i = 0; i < n; i++) {
            todays[i] = sc.nextInt();
        }

        for (int i = 1; i <= 2 * todays[0]; i++) {
            firsts[0] = i;
            firsts[1] = 2 * todays[0] - i;
            if (firsts[1] > 0) {
                dfs(1);
            }


            firsts[0] = i;
            firsts[1] = 2 * todays[0] + 1 - i;
            if (firsts[1] > 0) {
                dfs(1);
            }
        }
    }


    public void dfs(int now) {
        if (is_over || visited[now][firsts[now]][firsts[now - 1]]) {
            return;
        }
        visited[now][firsts[now]][firsts[now - 1]] = true;

        if (now == n - 1) {
            if (firsts[now] + firsts[now - 1] == 2 * todays[now] || firsts[now] + firsts[now - 1] == 2 * todays[now] + 1) {
                for (int i = 0; i < n; i++) {
                    System.out.printf("%d ", firsts[i]);
                }
                is_over = true;
            }
            return;
        } else {
            for (int i = 0; i < 3; i++) {
                int temp = 3 * todays[now] - firsts[now] - firsts[now - 1] + i;
                firsts[now + 1] = temp;
                if (firsts[now + 1] > 0) {
                    dfs(now + 1);
                }
            }
        }
    }

}
