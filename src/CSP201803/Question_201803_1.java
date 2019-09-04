package CSP201803;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201803-1 跳一跳
 * @score 100
 */
public class Question_201803_1 {
    public static void main(String[] args) {
        new Question_201803_1().run();
        /* 测试数据
            1 1 2 2 2 1 1 2 2 0
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        long sum_score = 0;
        int last_score = 0;
        int jump = sc.nextInt();

        while (jump != 0) {
            if (jump == 1) {
                sum_score += 1;
                last_score = 1;
            } else {
                if (last_score <= 1) {
                    last_score = 2;
                } else {
                    last_score += 2;
                }
                sum_score += last_score;
            }
            jump = sc.nextInt();
        }
        System.out.println(sum_score);
    }
}
