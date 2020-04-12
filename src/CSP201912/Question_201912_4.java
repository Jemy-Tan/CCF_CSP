import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
* 70分，可能是超时，可以在之后考虑把Pack类给去掉
*/
class Node{
	public List<Node> neighbors;
	public LinkedList<List<Integer>> receiveLink;
	public List<Integer> link;
	
	public Node() {
		neighbors = new ArrayList<Node>();
		receiveLink = new LinkedList<List<Integer>>();
		link = new ArrayList<Integer>();
		link.add(0);
	}
	
	public boolean receive(Pack pack) {
		List<Integer> l = pack.data;
		if ((l.size()>link.size()) || 
				((l.size() == link.size()) && (l.get(l.size()-1)<link.get(link.size()-1)))) {
			link = new ArrayList<Integer>(l);
			return true;
		} else {
			return false;
		}
	}
	
	public void send(LinkedList<Pack> net, int slot) {
		for (Node n: neighbors) {
			Pack p = new Pack();
			p.aim = n;
			p.data = new ArrayList<Integer>(link);
			p.slot = slot;
			net.add(p);
		}
	}
}

class Pack{
	public int slot;	//到达时间
	public Node aim;
	public List<Integer> data;
}

public class Main {
	
	public static List<Node> a = new ArrayList<Node>();
	public static int n = 0;
	public static int m = 0;
	public static int t = 0;
	public static int k = 0;
	public static LinkedList<Pack> b = new LinkedList<Pack>();
	public static int curSlot = 0;
	public static Set<Node> changeNode = new HashSet<Node>();
	
	public static void network(int slot) {
//		if (curSlot < slot) {
//			for (Node no: changeNode) {
//				no.send(b, curSlot);
//			}
//			change.
//		}
		while ((!b.isEmpty()) && (b.get(0).slot+t<=slot)) {
			if (curSlot <= b.get(0).slot +t) {
				for (Node no: changeNode) {
					no.send(b, curSlot);
				}
				changeNode.clear();
				curSlot = b.get(0).slot +t;
			}
			boolean f = b.get(0).aim.receive(b.get(0));
			if (f) {
				changeNode.add(b.get(0).aim);
			}
			b.poll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		m = sc.nextInt();
		a.add(new Node());	//加个空节点控制节点序号从1开始
		for (int i = 0; i<n+1; i++) {
			a.add(new Node());
		}
		for (int i = 0; i<m; i++) {
			int j = sc.nextInt();
			int l = sc.nextInt();
//			System.out.println(""+j+" "+l);
			a.get(j).neighbors.add(a.get(l));
			a.get(l).neighbors.add(a.get(j));
		}
		t = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i<k; i++) {
			int no = sc.nextInt();
			int sl = sc.nextInt();
			network(sl);
			String s = sc.nextLine();
			if (i == 15) {
				int iii =1;
				iii = 0;
			}
			if (!s.equals("")) {
				int blo = Integer.parseInt(s.substring(1));
				a.get(no).link.add(blo);
//				changeNode.add(a.get(no));
				a.get(no).send(b, sl);
			}else {
				List<Integer> l = a.get(no).link;
				String res = String.valueOf(l.size());
				for (Integer in: l) {
					res = res+" "+in;
				}
				System.out.println(res);
			}
		}
	}

}
