package lab2_graph_search;

public class TestClass {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2); nodeS.addEdge(nodeC, 4); 
		nodeA.addEdge(nodeD, 9); nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); 
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); 
		nodeF.addEdge(nodeG, 1);
		
//		ISearchAlgo algo1 = new DepthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "G");
		
//		ISearchAlgo algo1 = new DepthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "G");
		
//		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "G");
		
//		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "A", "H");
		
		DepthLimitedSearchAlgo algo = new DepthLimitedSearchAlgo();
		Node result = algo.execute(nodeS, "G", 2);
		
		NodeUtils nodeUtils = new NodeUtils();
		System.out.println(nodeUtils.printPath(result));
		
//		ISearchAlgo algo2 = new UniformCostSearchAlgo();
//		algo2.execute(nodeS, "G");
	}
}
