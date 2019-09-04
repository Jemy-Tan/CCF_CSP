import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Test {

    public static boolean bubbleSort(String temp) {
        int index1 = 0, index2 = 0;
        int[] nums = new int[4];
        char[] operates = new char[3];

        int result_num = 0;
        for (int j = 0; j < 7; j++) {
            if (j % 2 == 0) {
                nums[index1++] = temp.charAt(j) - '0';
            } else {

                operates[index2++] = temp.charAt(j);
            }
        }
        for (int j = 0; j < 3; j++) {
            if (operates[j] == 'x') {
                nums[j] = nums[j] * nums[j + 1];
                nums[j + 1] = nums[j];
                result_num = nums[j];
            } else if (operates[j] == '/') {
                nums[j] = nums[j] / nums[j + 1];
                nums[j + 1] = nums[j];
                result_num = nums[j];
            }
        }
        for (int j = 0; j < 3; j++) {
            if (operates[j] == '+') {
                nums[j] = nums[j] + nums[j + 1];
                nums[j + 1] = nums[j];
                result_num = nums[j];
            } else if (operates[j] == '-') {
                nums[j] = nums[j] - nums[j + 1];
                nums[j + 1] = nums[j];
                result_num = nums[j];
            }
        }
        if (result_num == 24) {
//            System.out.println("Yes");
            return true;
        } else {
            return false;
//            System.out.println("No");
        }
    }

    // for test
    public static boolean comparator(String temp) {
        Stack<String> stack = new Stack<>();
        for (int j = 0; j < temp.length(); j++) {
            char tempOperate = temp.charAt(j);
            if (tempOperate == 'x' || tempOperate == '/') {
                int lastNum = Integer.parseInt(stack.pop());
                int next_num = temp.charAt(++j) - '0';
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
                    return true;
//                    System.out.println("Yes");
                } else {
                    return false;
//                    System.out.println("No");
                }
            }
            String operate = stack.pop();
            if ("+".equals(operate)) {
                result += nextNum;
            } else {
                result -= nextNum;
            }
        }
        System.out.println("Default");
        return false;
    }

    // for test
    public static String generateRandomArray() {
        char[] operates = {'+', '-', 'x', '/'};

        char[] chars = new char[7];
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                str.append(random.nextInt(9) + 1);
            } else {
                str.append(operates[random.nextInt(4)]);
            }
        }
        System.out.println(str.toString());
        return str.toString();

    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            String temp1 = generateRandomArray();
//            String temp2=generateRandomArray();

            if (bubbleSort(temp1) != comparator(temp1)) {
                System.out.println(temp1);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }

}
