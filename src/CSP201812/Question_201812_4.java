package CSP201812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201812-4 数据中心
 * @score 待完
 */
public class Question_201812_4 {
    public static void main(String[] args) {
        new CSP201812.Question_201812_4().run();
        /* 测试数据
            4
            5
            1
            1 2 3
            1 3 4
            1 4 5
            2 3 8
            3 4 2
         */
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int root = sc.nextInt();
        Edge[] edges = new Edge[m];
        int[][] paths = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(edges);


    }

    class Edge implements Comparable<Edge> {
        int v, u, t;

        public Edge(int v, int u, int t) {
            this.v = v;
            this.u = u;
            this.t = t;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.t - edge.t;
        }
    }
}