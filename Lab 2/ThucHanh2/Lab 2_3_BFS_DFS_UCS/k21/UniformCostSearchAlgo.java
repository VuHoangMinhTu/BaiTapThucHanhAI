package k21;

import java.util.*;

public class UniformCostSearchAlgo  implements ISearchAlgo{

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier  = new PriorityQueue<>(new NodeComparator());
        frontier.add(root);
        List<Node> explored = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if(current.getLabel().equals(goal)) {
                return current;
            } else {
                explored.add(current);
                List<Edge> childEdges = current.getChildren();
                for (Edge child : childEdges) {
                    Node n = child.getEnd();
                    if(!explored.contains(n) || frontier.contains(n)) {
                        frontier.add(n);
                        n.setParent(current);
                        n.setPathCost(current.getPathCost() + child.getWeight());
                    } else if(frontier.contains(n) && n.getPathCost() > (current.getPathCost() + child.getWeight()) ) {
                        n.setPathCost(current.getPathCost() + child.getWeight());
                        n.setParent(current);
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
