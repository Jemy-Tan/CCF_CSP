package CSP201812;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201812-1 小明上学
 * @score 100
 */
public class Question_201812_1 {
    public static void main(String[] args) {
        new CSP201812.Question_201812_1().run();
        /* 测试数据
            30 3 30
            8
            0 10
            1 5
            0 11
            2 2
            0 6
            0 3
            3 10
            0 3
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int y = sc.nextInt();
        int g = sc.nextInt();

        int n = sc.nextInt();
        int[] k_nums = new int[n];  //0 表示经过好使t秒, 1、2、3 时，分别表示看到了一个红灯、黄灯、绿灯
        int[] t_nums = new int[n];

        int sum_time = 0;
        for (int i = 0; i < n; i++) {
            k_nums[i] = sc.nextInt();
            t_nums[i] = sc.nextInt();
            switch (k_nums[i]) {
                case 0:
                case 1:
                    sum_time += t_nums[i];
                    break;
                case 2:
                    sum_time += t_nums[i] + r;
                    break;
                case 3:
                    break;
            }
        }
        System.out.println(sum_time);
    }
}
