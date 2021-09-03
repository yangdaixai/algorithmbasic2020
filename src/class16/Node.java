package class16;

import java.util.ArrayList;

// 点结构的描述
public class Node {
	public int value;
	public int in; //有多少个点指向本点
	public int out;//本点指向多少其他的点
	public ArrayList<Node> nexts; //有那些邻居
	public ArrayList<Edge> edges;//从本点出发有多少直接的边

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
