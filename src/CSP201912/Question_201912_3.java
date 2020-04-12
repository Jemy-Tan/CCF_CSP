import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
	
	public static int n;
	public static String equation;
	
	public static Map<String,Integer> ans = new HashMap<String,Integer>();
	
	public static void putOrAddMap(String k, Integer v) {
		if (ans.containsKey(k)) {
			ans.put(k, ans.get(k)+v);
		} else {
			ans.put(k, v);
		}
	}
	
	public static int getDigit(int l,int r) {
		int d = 0;
		int i = l;
		while ((i<=r) && Character.isDigit(equation.charAt(i))) {
			d = d*10 + (equation.charAt(i) - '0');
			i++;
		}
		if (d == 0) {
			return 1;
		} else {
			return d;
		}
	}
	
	public static void handleCoefAndFormula(int l, int r, int e) {
		if (l>r) return;
		int coef = getDigit(l,r);
		e = coef * e;
		int k = l;
		StringBuilder sb = new StringBuilder();
		while (Character.isDigit(equation.charAt(k))) {
			k++;
		}
		while (k <= r) {
			if (Character.isUpperCase(equation.charAt(k))) {
				String s;
				int rCoef = 1;
				if ((k<r) && (Character.isLowerCase(equation.charAt(k+1)))){
					s = ""+equation.substring(k,k+2);
					rCoef = getDigit(k+2,r);
				} else {
					s = ""+equation.charAt(k);
					rCoef = getDigit(k+1,r);
				}
				 
				putOrAddMap(s,e*rCoef);
			} else if (equation.charAt(k) == '(') {
				int q = 1;
				int p = k+1;
				while (p<r) {
					if (equation.charAt(p) == '(') {
						q++;
					}
					if (equation.charAt(p) == ')') {
						q--;
					}
					if (q == 0) {
						break;
					}
					p++;
				}
				int rCoef = getDigit(p+1,r);
				handleCoefAndFormula(k+1,p-1,e*rCoef);
				k = p+1;
				continue;
			}
			k++;	//因为这个while循环只会处理(和大写字母，所以这里设置++就可以让k通过循环处理完这个原子和数字
		}
	}
	
	public static void handleExpr(int l, int r ,int e) {
		int k = l;
		for (int i = l; i<=r; i++) {
			if (equation.charAt(i) == '+') {
				handleCoefAndFormula(k,(i-1),e);
				k = i+1;
			}
		}
		handleCoefAndFormula(k,r,e);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i<n; i++) {
			ans.clear();
			equation = sc.nextLine();
			int p = equation.indexOf('=');
			handleExpr(0,p-1,1);
			handleExpr(p+1,equation.length()-1,-1);
			boolean flag = true;
			for (Integer v : ans.values()) {
				if (v!=0) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
	}
}





