import java.util.Scanner;

public class Main {
	
	public static int m,n,p,q,col,row;
	public static int[][][] a;	//记录颜色数组
	public static int[] curColor = {0,0,0};
	
	public static void fillColor(int i, int j, String s) {
		if (s.length() == 4) {
			s = ""+s.charAt(1)+s.charAt(1)+s.charAt(2)+s.charAt(2)+s.charAt(3)+s.charAt(3);
		} else if (s.length() == 2) {
			StringBuilder sb = new StringBuilder();
			s = ""+s.charAt(1)+s.charAt(1)+s.charAt(1)+s.charAt(1)+s.charAt(1)+s.charAt(1);
		} else {
			s = s.substring(1,7);
		}
		a[i][j][0] = Integer.valueOf(s.substring(0,2),16);
		a[i][j][1] = Integer.valueOf(s.substring(2,4),16);
		a[i][j][2] = Integer.valueOf(s.substring(4,6),16);
	}
	
	public static boolean isColorChange(int r, int g, int b) {
		if ((r == curColor[0]) && (g == curColor[1]) && (b == curColor[2])) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int figAvg(int b1, int b2, int c) {
		int sum = 0;
		for (int i = b1; i<b1+q; i++) {
			for (int j = b2; j<b2+p; j++) {
				sum += a[i][j][c];
			}
		}
		return sum/(q*p);
	}
	
	public static String figColorStr() {
//		String s = String.valueOf(curColor[0])+String.valueOf(curColor[1])+String.valueOf(curColor[2]);
		String s;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<3; i++) {
			s = String.valueOf(curColor[i]);
			for (int j = 0; j<s.length(); j++) {
				sb.append("\\x3"+s.charAt(j));
			}
			if (i<2) {
				sb.append("\\x3B");
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int in = Integer.valueOf("AB",16);
//		System.out.println(in);
//		String st = Integer.toHexString(in).toUpperCase();
//		System.out.println(String.format("\\%s",st));
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		col = m/p;
		row = n/q;
		sc.nextLine();
		a = new int[n][m][3];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				String color = sc.nextLine();
				fillColor(i,j,color);
			}
		}
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				int r = figAvg(i*q,j*p,0);
				int g = figAvg(i*q,j*p,1);
				int b = figAvg(i*q,j*p,2);
				
				if (isColorChange(r,g,b)) {
					curColor[0] = r;
					curColor[1] = g;
					curColor[2] = b;
					String s = "";
					if ((r==0)&&(g==0)&&(b==0)) {
						s = "\\x1B\\x5B\\x30\\x6D";
					} else {
						s = "\\x1B\\x5B\\x34\\x38\\x3B\\x32\\x3B"+
								figColorStr()+"\\x6D";
					}
					System.out.print(s);
				}
				System.out.print("\\x20");	
			}
			if (!((curColor[0]==0)&&(curColor[1]==0)&&(curColor[2]==0))) {
				System.out.print("\\x1B\\x5B\\x30\\x6D");
				curColor[0] = 0;
				curColor[1] = 0;
				curColor[2] = 0;
			}
			System.out.print("\\x0A");
		}
	}
}
