package lab2_graph_search;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> queue = new PriorityQueue<Node>(
				(edge1, edge2) -> Double.compare(edge1.getPathCost(), edge2.getPathCost()));
		List<Node> explored = new ArrayList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			explored.add(node);
			if (node.getLabel().equals(goal))
				return node;
			List<Edge> listNode = node.getChildren();
			for (Edge edge : listNode) {
				if (!explored.contains(edge.getEnd()) && !queue.contains(edge.getEnd())) {
					edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					edge.getEnd().setParent(edge.getBegin());
					queue.add(edge.getEnd());
				} else if (queue.contains(edge.getEnd())) {
					if (edge.getEnd().getPathCost() > edge.getBegin().getPathCost() + edge.getWeight()) {
						edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
						edge.getEnd().setParent(edge.getBegin());
					}
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
