package CSP201812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JemyTan
 * @question 201812-4 数据中心
 * @score 90 Java 超时?
 */
public class Question_201812_4 {
    int[] parents;

    public static void main(String[] args) {
        new Question_201812_4().run();
        /* 测试数据
            4
            5
            1
            1 2 3
            1 3 4
            1 4 4
            2 3 8
            3 4 2
         */
    }

    private int findEndFather(int node) {
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    // 判断是否成环
    private boolean join(int v, int u) {
        v = findEndFather(v);
        u = findEndFather(u);
        if (v != u) {
            parents[v] = u;
            return true;
        }
        return false;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int root = sc.nextInt();
        Edge[] edges = new Edge[m];
        parents = new int[m];

        for (int i = 0; i < m; i++) {
            parents[i] = i;
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(edges);

        int max_result = 0;
        for (int i = 0; i < m; i++) {
            Edge tmp = edges[i];
            if (join(tmp.v, tmp.u)) {
                max_result = tmp.t;
                n--;
            }
            if (n == 1) {
                break;
            }

        }
        System.out.println(max_result);
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