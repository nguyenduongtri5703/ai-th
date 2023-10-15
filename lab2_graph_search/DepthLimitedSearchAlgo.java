package lab2_graph_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearchAlgo {

	public Node execute(Node root, String goal, int limitedDepth) {
		Stack<Node> stack = new Stack<Node>();
		List<Node> explored = new ArrayList<Node>();
		root.setDepth(0);
		stack.push(root);
		while (!stack.isEmpty()) {
			Node currentNode = stack.pop();
			explored.add(currentNode);
			if (currentNode.getLabel().equals(goal)) 
				return currentNode;
			if (currentNode.getDepth() < limitedDepth) {
					List<Node> listChild = currentNode.getChildrenNodes();
					for (int i = listChild.size()-1; i >= 0; i--) {
					if (!explored.contains(listChild.get(i)) && !stack.contains(listChild.get(i))) {
						stack.push(listChild.get(i));
						listChild.get(i).setParent(currentNode);
						listChild.get(i).setDepth(currentNode.getDepth() + 1);
					}
				}
			}
		}
		return null;
	}

}
