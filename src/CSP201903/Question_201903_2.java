package CSP201903;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author JemyTan
 * @question 201903-2 二十四点
 * @score 100
 */
public class Question_201903_2 {
    public static void main(String[] args) {
        new Question_201903_2().run();
        /* 测试数据
10
9+3+4x3
5+4x5x5
7-9-9+8
5x6/5x4
3+5+7+9
1x1+9-9
1x9-5/9
8/5+6x9
6x7-3x6
6x4+4/5
         */
    }


    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < strings[i].length(); j++) {
                char tempOperate = strings[i].charAt(j);
                if (tempOperate == 'x' || tempOperate == '/') {
                    int lastNum = Integer.parseInt(stack.pop());
                    int next_num = strings[i].charAt(++j) - '0';
                    if (tempOperate == 'x') {
                        stack.push(String.valueOf(lastNum * next_num));
                    } else {
                        stack.push(String.valueOf(lastNum / next_num));
                    }
                } else {

                    stack.push(String.valueOf(tempOperate));
                }
            }

            int result = 0;
            while (!stack.isEmpty()) {
                int nextNum = Integer.parseInt(stack.pop());
                if (stack.isEmpty()) {
                    result += nextNum;
                    if (result == 24) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                }
                String operate = stack.pop();
                if ("+".equals(operate)) {
                    result += nextNum;
                } else {
                    result -= nextNum;
                }
            }
        }
    }
}