package CSP201903;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201903-1 小中大
 * @score 100
 */
public class Question_201903_1 {
    public static void main(String[] args) {
        new Question_201903_1().run();
        /* 测试数据
            输入:3 -1 2 4     输出:4 2 -1
            输入:4 -2 -1 3 4     输出:4 1 -2
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int max = nums[0] > nums[n - 1] ? nums[0] : nums[n - 1];
        int min = nums[0] < nums[n - 1] ? nums[0] : nums[n - 1];

        if (n % 2 == 1) {  // 如有有奇数个数,取中间那个输出即可
            System.out.printf("%d %d %d", max, nums[n / 2], min);
        } else {
            double middle = (nums[n / 2] + nums[n / 2 - 1]) / 2.0;
            if (middle == (int) middle) {
                System.out.printf("%d %d %d", max, (int) middle, min);
            } else {
                System.out.printf("%d %.1f %d", max, middle, min);
            }
        }

    }
}
