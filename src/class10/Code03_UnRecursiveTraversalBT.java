package class10;

import java.util.Stack;

public class Code03_UnRecursiveTraversalBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int v) {
			value = v;
		}
	}
	//先中后，指的是头打印的位置
	// 先序打印所有节点 //先序遍历, 头左右
	public static void pre(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				// 因为是先序，头左右 ，所以进栈的一定先右后左，出栈的时候才能先左后右
				// 有右压入右
				if (head.right != null) {
					stack.push(head.right);
				}
				//有左压入左
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	//中序遍历, 左头右
	public static void in(Node cur) {
		System.out.print("in-order: ");
		if (cur != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || cur != null) {
				//先压入整条左边界
				if (cur != null) {
					stack.push(cur);
					cur = cur.left;
				} else {
					//取出打印
					cur = stack.pop();
					System.out.print(cur.value + " ");
					cur = cur.right;
				}
			}
		}
	}
	//后续遍历 左右头
	public static void pos1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop(); // 头 右 左
				//先续打印的时候不打印，直接放到最后一个栈中
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			// 左 右 头
			//最后再打印 第二个栈
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}


	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		pre(head);
		System.out.println("========");
		in(head);
		System.out.println("========");
		pos1(head);
		System.out.println("========");

	}

}
