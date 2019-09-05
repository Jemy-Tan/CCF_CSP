package CSP201803;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201803-4 棋局评估
 * @score 待完成
 */
public class Question_201803_4 {
    public static void main(String[] args) {
        new Question_201803_4().run();
        /* 测试数据
            8
            4 1 3 1 6 5 17 9
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] chess = new int[3][3];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    chess[j][k] = sc.nextInt();
                }
            }
            boolean x_win = false;
            if (chess[0][0] != 0 && chess[0][0] == chess[0][1] && chess[0][0] == chess[0][2]) {
                if (chess[0][0] == 1) {
                    x_win = true;
                }
            } else if (chess[1][0] != 0 && chess[1][0] == chess[1][1] && chess[1][0] == chess[1][2]) {
                if (chess[1][0] == 1) {
                    x_win = true;
                }
            } else if (chess[2][0] != 0 && chess[2][0] == chess[2][1] && chess[2][0] == chess[2][2]) { // 横的
                if (chess[2][0] == 1) {
                    x_win = true;
                }
            } else if (chess[0][0] != 0 && chess[0][0] == chess[1][0] && chess[0][0] == chess[2][0]) {
                if (chess[0][0] == 1) {
                    x_win = true;
                }
            } else if (chess[0][1] != 0 && chess[0][1] == chess[1][1] && chess[0][1] == chess[2][1]) {
                if (chess[0][1] == 1) {
                    x_win = true;
                }
            } else if (chess[0][2] != 0 && chess[0][2] == chess[1][2] && chess[0][2] == chess[2][2]) { // 竖的
                if (chess[0][2] == 1) {
                    x_win = true;
                }
            } else if (chess[0][0] != 0 && chess[0][0] == chess[1][1] && chess[0][0] == chess[2][2]) { // 斜的
                if (chess[0][0] == 1) {
                    x_win = true;
                }
            } else if (chess[0][2] != 0 && chess[0][2] == chess[1][1] && chess[0][2] == chess[2][0]) {
                if (chess[0][2] == 1) {
                    x_win = true;
                }
            } else {
                System.out.printf("0\n");
                continue;
            }
            // 统计空格数
            int blank_num = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (chess[j][k] == 0) {
                        blank_num++;
                    }
                }
            }

            if (x_win) {
                System.out.println(blank_num + 1);
            } else {
                System.out.println(-(blank_num + 1));
            }


        }

    }
}
