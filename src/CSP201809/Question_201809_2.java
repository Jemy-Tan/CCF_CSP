package CSP201809;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201809-2 买菜
 * @score 100
 */
public class Question_201809_2 {

    public static void main(String[] args) {
        new Question_201809_2().run();
        /* 测试数据
            4
            1 3
            5 6
            9 13
            14 15
            2 4
            5 7
            10 11
            13 14
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a_starts = new int[n];
        int[] a_ends = new int[n];
        int[] b_starts = new int[n];
        int[] b_ends = new int[n];

        for (int i = 0; i < n; i++) {
            a_starts[i] = sc.nextInt();
            a_ends[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b_starts[i] = sc.nextInt();
            b_ends[i] = sc.nextInt();
        }

        long sum_time = 0;
        int index1 = 0, index2 = 0;
        while (index1 < n && index2 < n) {
            if (a_starts[index1] <= b_starts[index2]) {
                if (a_ends[index1] >= b_ends[index2]) {
                    sum_time += b_ends[index2] - b_starts[index2];
                    index2++;
                } else if (a_ends[index1] >= b_starts[index2] && a_ends[index1] <= b_ends[index2]) {
                    sum_time += a_ends[index1] - b_starts[index2];
                    index1++;
                } else {
                    index1++;
                }
            } else {
                if (b_ends[index2] <= a_starts[index1]) {
                    index2++;
                } else if (b_ends[index2] <= a_ends[index1]) {
                    sum_time += b_ends[index2] - a_starts[index1];
                    index2++;
                } else {
                    sum_time += a_ends[index1] - a_starts[index1];
                    index1++;
                }


            }
        }
        System.out.println(sum_time);
    }
}