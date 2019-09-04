package CSP201803;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201803-2 碰撞的小球
 * @score 100
 */
public class Question_201803_2 {


    public static void main(String[] args) {
        new Question_201803_2().run();
        /* 测试数据
            3 10 5
            4 6 8

            10 22 30
            14 12 16 6 10 2 8 20 18 4
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int t = sc.nextInt();
        boolean[] is_left = new boolean[n];
        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            balls[i] = new Ball(i, sc.nextInt());
        }
        Arrays.sort(balls);
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                if (balls[j].is_right) {
                    balls[j].posi++;
                } else {
                    balls[j].posi--;
                }
            }

            Arrays.sort(balls);
            for (int j = 0; j < n; j++) {
                if (j < n - 1 && balls[j].posi == balls[j + 1].posi) {
                    balls[j].is_right = !balls[j].is_right;
                    balls[j + 1].is_right = !balls[j + 1].is_right;
                } else if (balls[j].posi == l || balls[j].posi == 0) {
                    balls[j].is_right = !balls[j].is_right;
                }
            }

        }
        Arrays.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball ball, Ball t1) {
                return ball.code - t1.code;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", balls[i].posi);
        }
    }

    class Ball implements Comparable<Ball> {
        int posi;
        boolean is_right = true;
        int code;

        public Ball(int code, int posi) {
            this.posi = posi;
            this.code = code;
        }

        @Override
        public int compareTo(Ball ball) {
            return posi - ball.posi;
        }
    }
}
