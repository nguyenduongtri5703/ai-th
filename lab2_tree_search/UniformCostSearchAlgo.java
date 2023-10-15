package lab2_tree_search;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> queue = new PriorityQueue<Node>((edge1, edge2) 
				-> Double.compare(edge1.getPathCost(), edge2.getPathCost()));
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLabel().equals(goal))
				return node;
			List<Edge> listNode = node.getChildren();
			for (Edge edge : listNode) {
				if (!queue.contains(edge.getEnd())) {
					edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					edge.getEnd().setParent(edge.getBegin());
					queue.add(edge.getEnd());
				} else if (queue.contains(edge.getEnd())){
					Node cloneNode;
					cloneNode = (Node) edge.getEnd().clone();
					cloneNode.setParent(edge.getBegin());
					cloneNode.setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					queue.add(cloneNode);
				}
				
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		
		return null;
	}
}
