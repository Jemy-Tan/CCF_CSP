import java.util.Scanner;

public class Main {

	public static int n;
	
	public static int[] a = new int[4];
	
	public static boolean skip(int k) {
		if ((k % 7) == 0) {
			return true;
		}
		while (k != 0) {
			int i = k % 10;
			if (i == 7) {
				return true;
			}
			k = k /10;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i<4; i++) {
			a[i] = 0;
		}
		int i = 1;
		int j = 1;
		while (i<=n) {
			if (skip(j)) {
				a[(j-1) % 4] ++;
			} else {
				i++;
			}
			j++;
		}
		for (i = 0; i<4; i++) {
			System.out.println(a[i]);
		}
	}

}
