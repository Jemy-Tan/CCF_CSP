package CSP201712;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201712-4 行车路线
 * @score 待完成
 */
public class Main {
    Road[] roads;
    int n, m;
    long min;

    public static void main(String[] args) {
        new Main().run();
        /* 测试数据
            8
            4 1 3 1 6 5 17 9
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        roads = new Road[m];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            int from = sc.nextInt();
            int to = sc.nextInt();
            if (from <= to) {
                roads[i] = new Road(type, from, to, sc.nextInt());
            } else {
                roads[i] = new Road(type, to, from, sc.nextInt());
            }
        }

        Arrays.sort(roads);
        for (int i = 0; i < m; i++) {
            if (roads[i].start == 1) {
                dfs(i, 0, 0);
            } else {
                break;
            }
        }

        System.out.println(min);


    }

    public void dfs(int now_index, long sum_small, long now_time) {
        if (roads[now_index].type == 0) {
            now_time += roads[now_index].length;
            sum_small = 0;
        } else {
            now_time = now_time - sum_small * sum_small;
            sum_small = sum_small + roads[now_index].length;
            now_time = now_time + sum_small * sum_small;
        }

        if (roads[now_index].end == n || now_time >= min) {
            if (now_time < min) {
                min = now_time;
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            if (roads[i].start < roads[now_index].end) {
                continue;
            } else if (roads[i].start > roads[now_index].end) {
                break;
            } else {
                dfs(i, sum_small, now_time);
            }
        }


    }

    class Road implements Comparable<Road> {
        int type, start, end, length;

        public Road(int type, int start, int end, int length) {
            this.type = type;
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Road road) {
            return start - road.start;
        }
    }
}
