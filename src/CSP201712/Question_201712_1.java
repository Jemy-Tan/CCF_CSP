package CSP201712;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201712-1 最小差值
 * @score 100
 */
public class Question_201712_1 {
    public static void main(String[] args) {
        new Question_201712_1().run();
        /* 测试数据
            5
            1 5 4 8 20
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int min_sub = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] < min_sub) {
                min_sub = nums[i] - nums[i - 1];
            }
        }

        System.out.println(min_sub);
    }
}
