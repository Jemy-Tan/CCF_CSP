import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int m;
	public static int max = -1;
	public static int maxTree = -1;
	public static int sum = 0;
//	public static int ori;
//	public sta
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i<n; i++) {
			int ori = sc.nextInt();
			int d = 0;
			for (int j = 0; j<m; j++) {
//				System.out.println(j);
				int k = sc.nextInt();
				d -= k;
			}
			sum = sum + ori - d;
			if (d > max) {
				max = d;
				maxTree = i+1;
			}
		}
		System.out.println(""+sum+" "+maxTree+" "+" "+max);
	}

}
