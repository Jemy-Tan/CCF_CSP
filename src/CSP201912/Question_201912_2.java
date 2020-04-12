import java.util.Scanner;

public class Main {
	
	public static int a[][];
	public static int n;
	public static boolean b[] = new boolean[4];
	public static int res[] = new int[5];
	public static int c;
	public static int d;
	
	public static void check(int i, int j) {
		int x1 = a[i][0];
		int y1 = a[i][1];
		int x2 = a[j][0];
		int y2 = a[j][1];
		if (((Math.abs(x1 - x2) == 1) && (y1 == y2)) || ((Math.abs(y1 - y2) == 1) && (x1 == x2))) {
			c++;
		}
		if (((Math.abs(x1 - x2) == 1) && (Math.abs(y1 - y2) == 1))) {
			d++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i<5; i++) {
			res[i] = 0;
		}
		
		n = sc.nextInt();
		a = new int[n][2];
		for (int i = 0; i<n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		for (int i = 0; i<n; i++) {
			c = 0;
			d = 0;
			for (int j = 0; j<n; j++) {
				check(i,j);
			}
			if (c==4) {
				res[d] ++;
			}
		}
		for (int i = 0; i<5; i++) {
			System.out.println(res[i]);
		}
		
	}

}
