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


























//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//class Word{
//	public String value = "";
//	//-1起始 0 数字 1 元素 2 ( 3 ) 4 = 5 + 6$
//	public int kind;
//}
//
//public class Main {
//	
//	public static int n;
//	public static List<Map<String,Integer>> levelList = new ArrayList<>();
//	public static Map<String,Integer> left;
//	public static Map<String,Integer> right;
//	public static String element;
//	public static int number;
//	public static char lastChar;
//	public static char nextChar;
//	
//	public static Word lastWord;
//	public static Word nextWord;
//	
//	public static int exprNum = 1;
//	
//	public static Word[] words= new Word[1000];
//	public static int wordLength = 0;
//	
//	
//	public static void wordsplit(String a) {
//		Word word = new Word();
//		word.kind = -1;
//		for (int j = 0; j<a.length(); j++) {
//			char c = a.charAt(j);
//			if ((c >= 'a') && (c<='z')) {
//				word.value = word.value+c;
//				continue;
//			}
//			if ((c >= '0') && (c<='9')) {
//				if ((word.value.length()>0) && (word.value.charAt(0)>'0') &&(word.value.charAt(0)<'9')) {
//					word.value = word.value +c;
//					continue;
//				} else {
//					words[wordLength] = word;
//					wordLength++;
//					word = new Word();
//					word.kind = 0;
//					word.value = String.valueOf(c);
//					continue;
//				}
//			}
//			words[wordLength] = word;
//			wordLength++;
//			word = new Word();
//			if ((c >= 'A') && (c<='Z')) {
//				word.value = String.valueOf(c);
//				word.kind = 1;
//			}
//			
//			if (c == '(') {
//				word.kind = 2;
//			}
//			if (c == ')') {
//				word.kind = 3;
//			}
//			if (c == '=') {
//				word.kind = 4;
//			}
//			if (c == '+') {
//				word.kind = 5;
//			}
//			
//		}
//		words[wordLength] = word;
//		wordLength++;
//	}
//	
//	public static void figure(Word word) {
//		
//		switch(word.kind) {
//		case 0:
//			if (lastWord.kind == 3) {
//				Map<String,Integer> map = levelList.get(levelList.size()-1);
//				Map<String,Integer> aboveMap = levelList.get(levelList.size()-2);
//				for (String s:map.keySet()) {
//					if (!aboveMap.containsKey(s)) {
//						aboveMap.put(s, 0);
//					}
//					int old = aboveMap.get(s);
//					aboveMap.put(s, old+map.get(s)*Integer.parseInt(word.value));
//				}
//				levelList.remove(levelList.size()-1);
//			}
//			if (lastWord.kind == 1) {
////				Map<String,Integer> map = levelList.get(levelList.size()-1);
////				int old = map.get(lastWord.value);
////				map.put(lastWord.value, old + Integer.parseInt(word.value)-1);
//			}
//			if ((lastWord.kind == -1) || (lastWord.kind == 4) ||(lastWord.kind == 5)) {
//				exprNum = Integer.parseInt(word.value);
//			}
//			break;
//		case 1:
//			Map<String,Integer> map = levelList.get(levelList.size()-1);
//			int addtion = 1;
//			if (nextWord.kind == 0) {
//				addtion = Integer.parseInt(nextWord.value);
//			}
//			if (!map.containsKey(word.value)) {
//				map.put(word.value, 0);
//			}
//			map.put(word.value, map.get(word.value)+addtion);
//			break;
//		case 2:
//			Map<String,Integer> nmap = new HashMap<String, Integer>();
//			levelList.add(nmap);
//			break;
//		case 3:
//			if (nextWord.kind != 0) {
//				Map<String,Integer> tmap = levelList.get(levelList.size()-1);
//				Map<String,Integer> aboveMap = levelList.get(levelList.size()-2);
//				for (String s:tmap.keySet()) {
//					if (!aboveMap.containsKey(s)) {
//						aboveMap.put(s, 0);
//					}
//					int old = aboveMap.get(s);
//					aboveMap.put(s, old+tmap.get(s));
//				}
//				levelList.remove(levelList.size()-1);
//			}
//			break;
//		case 4:
//			Map<String,Integer> fmap = levelList.get(levelList.size()-1);
//			Map<String,Integer> aboveMap = levelList.get(levelList.size()-2);
//			for (String s:fmap.keySet()) {
//				if (!aboveMap.containsKey(s)) {
//					aboveMap.put(s, 0);
//				}
//				int old = aboveMap.get(s);
//				aboveMap.put(s, old+fmap.get(s)*exprNum);
//			}
//			exprNum = 1;
//			left = levelList.get(0);
//			levelList = new ArrayList<Map<String,Integer>>();
//			levelList.add(new HashMap<String,Integer>());
//			levelList.add(new HashMap<String,Integer>());
//			break;
//		case 5:
//			Map<String,Integer> fimap = levelList.get(levelList.size()-1);
//			Map<String,Integer> fiAboveMap = levelList.get(levelList.size()-2);
//			for (String s:fimap.keySet()) {
//				if (!fiAboveMap.containsKey(s)) {
//					fiAboveMap.put(s, 0);
//				}
//				int old = fiAboveMap.get(s);
//				fiAboveMap.put(s, old+fimap.get(s)*exprNum);
//			}
//			fimap.clear();
//			exprNum = 1;
//			break;
//		}
//		
//	}
//
//	
//	public static boolean decide() {
//		boolean flag = true;
//		for (String s:left.keySet()) {
//			if (!right.containsKey(s)) {
//				flag = false;
//				break;
//			}
//			if (left.get(s) != right.get(s)) {
//				flag = false;
//				break;
//			}
//		}
//		return flag;
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		String a;
//		a = sc.nextLine();
//		for (int i = 0; i<n; i++) {
//			a = sc.nextLine();
//			levelList = new ArrayList<Map<String,Integer>>();
//			levelList.add(new HashMap<String,Integer>());
//			levelList.add(new HashMap<String,Integer>());
//			wordLength = 0;
//			wordsplit(a);
//			Word word = new Word();
//			word.kind = 6;
//			words[wordLength] = word;
//			for (int j=1; j<wordLength;j++) {
//				lastWord = words[j-1];
//				nextWord = words[j+1];
//				figure(words[j]);
//			}
//			
//			Map<String,Integer> fimap = levelList.get(levelList.size()-1);
//			Map<String,Integer> fiAboveMap = levelList.get(levelList.size()-2);
//			for (String s:fimap.keySet()) {
//				if (!fiAboveMap.containsKey(s)) {
//					fiAboveMap.put(s, 0);
//				}
//				int old = fiAboveMap.get(s);
//				fiAboveMap.put(s, old+fimap.get(s)*exprNum);
//			}
//			
//			exprNum = 1;
//			
//			right = levelList.get(0);
//			if (decide()) {
//				System.out.println("Y");
//			} else {
//				System.out.println("N");
//			}
//		}
//	}
//
//}


