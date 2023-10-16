package k21;

import java.util.*;

public class DepthFirstSearchAlgo implements ISearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(root);
        Set<Node> explored = new HashSet<>();
        int state = 1;

        while (!frontier.isEmpty()) {
            Node current = frontier.pop();

            if (current.getLabel().equals(goal)) {
                return current;
            }

            explored.add(current);
            List<Node> childNodes = current.getChildrenNodes();

            // Sắp xếp các nút con theo thứ tự ngược lại
            if(state == 1) {
                Collections.sort(childNodes, new Comparator<Node>() {
                    @Override
                    public int compare(Node node1, Node node2) {
                        return node2.getLabel().compareTo(node1.getLabel());
                    }
                });
                state++;
            }

            for (Node child : childNodes) {
                if (!explored.contains(child) && !frontier.contains(child)) {
                    frontier.add(child);
                    child.setParent(current);
                }
            }
        }

        return null;
    }



    @Override
    public Node execute(Node root, String start, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(root);
        Set<Node> explored = new HashSet<>();
        int state = 1;
        boolean started =false;
        while (!frontier.isEmpty()) {
            Node current = frontier.pop();

            if(current.getLabel().equals(start)) {
                started = true;
                current.setParent(null);
            }
            if (current.getLabel().equals(goal) ) {
                return current;
            } else {

                if(started) {
                    started = false;
                    explored.clear();
                    frontier.clear();
                }

                explored.add(current);
                List<Node> childNodes = current.getChildrenNodes();

                // Sắp xếp các nút con theo thứ tự ngược lại
                if(state == 1) {
                    Collections.sort(childNodes, new Comparator<Node>() {
                        @Override
                        public int compare(Node node1, Node node2) {
                            return node2.getLabel().compareTo(node1.getLabel());
                        }
                    });
                    state++;
                }

                for (Node child : childNodes) {
                    if (!explored.contains(child) && !frontier.contains(child)) {
                        frontier.add(child);
                        child.setParent(current);
                    }
                }
            }
        }

        return null;
    }

}
