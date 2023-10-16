package k21;

public class Main {
    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A"); Node nodeB = new Node("B");
        Node nodeC = new Node("C"); Node nodeD = new Node("D");
        Node nodeE = new Node("E"); Node nodeF = new Node("F");
        Node nodeG = new Node("G"); Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
        ISearchAlgo bfs = new BreadthFirstSearchAlgo();
        ISearchAlgo dfs = new DepthFirstSearchAlgo();
        Node result = dfs.execute(nodeS,"B" ,"G");

//        System.out.println(NodeUtils.printPath(result) + " " + result.getPathCost());
        DepthLimitedSearch depthFirstSearchAlgo = new DepthLimitedSearch();
        UniformCostSearchAlgo uniformCostSearchAlgo = new UniformCostSearchAlgo();

//        System.out.println(NodeUtils.printPath( uniformCostSearchAlgo.execute(nodeS,"G")) +" "+ uniformCostSearchAlgo.execute(nodeS,"G").getPathCost());
        System.out.println(NodeUtils.printPath(depthFirstSearchAlgo.execute(nodeS,"G",3)));
    }
}
