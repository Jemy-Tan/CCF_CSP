package CSP201703;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201703-1 分蛋糕
 * @score 100
 */
public class Question_201703_1 {
    public static void main(String[] args) {
        new Question_201703_1().run();
        /* 测试数据
            6 9
            2 6 5 6 3 5
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int now = 1;
        int index = 0;
        int temp_sum = 0;
        while (index < n) {
            temp_sum += nums[index];
            if (temp_sum >= k) {
                now++;
                temp_sum = 0;
            }
            index++;
        }
        if (temp_sum == 0) {  // 注意这个坑,如果最后的人没有蛋糕,就要把人数减回来
            now--;
        }
        System.out.println(now);


    }
}
