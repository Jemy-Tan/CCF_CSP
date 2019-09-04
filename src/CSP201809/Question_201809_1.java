package CSP201809;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201809-1 卖菜
 * @score 100
 */
public class Question_201809_1 {
    public static void main(String[] args) {
        new Question_201809_1().run();
        /* 测试数据
            8
            4 1 3 1 6 5 17 9
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.printf("%d ", (int) (nums[0] + nums[1]) / 2);
        for (int i = 1; i < n - 1; i++) {
            System.out.printf("%d ", (int) (nums[i - 1] + nums[i] + nums[i + 1]) / 3);
        }
        System.out.printf("%d", (int) (nums[n - 1] + nums[n - 2]) / 2);
    }
}
