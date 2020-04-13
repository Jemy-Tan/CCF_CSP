import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int m;
	public static boolean[] f;
	public static long sum = 0;
	public static int d = 0;
	public static int e = 0;

	public static int ori;
//	public static boolean drop;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		f = new boolean[n+2];
		for (int i = 0; i<n; i++) {
			m = sc.nextInt();
			ori = sc.nextInt();
//			drop = false;
			f[i] = false;
			for (int j = 0; j<m-1; j++) {
				int k = sc.nextInt();
				if ((k > 0) && (k<ori)) {
					f[i] = true;
					ori = k;
				}
				if (k < 0) {
					ori += k;
				}
			}
			sum += ori;
//			System.out.println(ori);
		}
		f[n] = f[0];
		f[n+1] = f[1];
		for (int i = 0; i<n; i++) {
			if (f[i]) {
				d++;
				if (f[i+1] && f[i+2]) {
					e++;
				}
			}
		}
		System.out.println(""+sum+" "+d+" "+e);
	}

}
