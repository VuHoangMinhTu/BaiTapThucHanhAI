package k21;

import java.util.*;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        Set<Node> explored = new HashSet<>();
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if(current.getLabel().equals(goal)) {
                return current;
            } else {
                explored.add(current);
                List<Node> childNode = current.getChildrenNodes();
                for(Node child : childNode) {
                    if(!frontier.contains(child) && !explored.contains(child)) {
                        frontier.add(child);
                        child.setParent(current);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        Set<Node> explored = new HashSet<>();
        boolean started =false;
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if(current.getLabel().equals(start)) {
                started = true;
                current.setParent(null);
            }
            if(current.getLabel().equals(goal)) {
                return current;
            } else {
                if(started) {
                    started = false;
                    explored.clear();
                    frontier.clear();
                }
                explored.add(current);
                List<Node> childNode = current.getChildrenNodes();
                List<Edge> childEdge = current.getChildren();
                for(Node child : childNode) {
                    if(!frontier.contains(child) && !explored.contains(child)) {
                       frontier.add(child);
                       child.setParent(current);
                   }
                }
            }
        }
        return null;
    }
}
