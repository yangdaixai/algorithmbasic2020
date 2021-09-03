package class16;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		//入栈后就打印
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					//如果节点next节点（一个邻居）不存在set中就跳出循环，不在遍历这个节点其他邻居
					break;
				}
			}
		}
	}
	
	
	

}
