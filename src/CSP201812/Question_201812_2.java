package CSP201812;

import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201812-2 小明放学
 * @score 100
 */
public class Question_201812_2 {
    int r, y, g;

    public static void main(String[] args) {
        new CSP201812.Question_201812_2().run();
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
        r = sc.nextInt();
        y = sc.nextInt();
        g = sc.nextInt();

        int n = sc.nextInt();
        int[] k_nums = new int[n];  //0 表示经过好使t秒, 1、2、3 时，分别表示看到了一个红灯、黄灯、绿灯
        int[] t_nums = new int[n];

        long sum_time = 0;
        for (int i = 0; i < n; i++) {
            k_nums[i] = sc.nextInt();
            t_nums[i] = sc.nextInt();
            switch (k_nums[i]) {
                case 0:
                    sum_time += t_nums[i];
                    break;
                default:
                    sum_time += checkLight(k_nums[i], t_nums[i], sum_time);
                    break;
            }
        }
        System.out.println(sum_time);

    }

    // color 表示灯的颜色, print_time是灯的显示时间, now_time是到达此处所花时间,返回要等待的时间
    public long checkLight(int color, int print_time, long now_time) {
        long sub_time;
        switch (color) {
            case 1:// 红灯
                sub_time = now_time - print_time;
                if (sub_time <= 0) {
                    return -sub_time;
                } else {
                    sub_time = sub_time % (r + g + y);
                    if (sub_time <= g) {
                        return 0;
                    } else {
                        return (r + y + g) - sub_time;
//                        return (r + y) - sub_time;
                    }
                }
            case 2://黄灯
                sub_time = now_time - print_time - r;
                if (sub_time <= 0) {
                    return -sub_time;
                } else {
                    sub_time = sub_time % (r + g + y);
                    if (sub_time <= g) {
                        return 0;
                    } else {
                        return (r + y + g) - sub_time;
                    }
                }
            case 3:
                sub_time = now_time - print_time;
                if (sub_time <= 0) {
                    return 0;
                }
                sub_time = now_time - print_time - r - y;
                if (sub_time <= 0) {
                    return -sub_time;
                } else {
                    sub_time = sub_time % (r + g + y);
                    if (sub_time <= g) {
                        return 0;
                    } else {
                        return (r + y + g) - sub_time;
                    }
                }
            default:
                break;
        }
        return 0;
    }
}