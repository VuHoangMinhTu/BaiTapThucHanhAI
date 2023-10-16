package k21;

import java.util.*;

public class DepthLimitedSearch {
    public Node execute(Node root, String goal, int limitedDepth) {
        Stack<Node> frointer = new Stack<>();
        ArrayList<Node> explored = new ArrayList<>();
        frointer.add(root) ;

        while (!frointer.isEmpty()) {
            Node current = frointer.pop();
            if(current.getLabel().equals(goal)) {
                return current;
            } else {
                if(current.getDepth() <limitedDepth) {
                     if(true) {
                         Collections.sort(frointer, new Comparator<Node>() {
                             @Override
                             public int compare(Node o1, Node o2) {
                                 return o2.getLabel().compareTo(o1.getLabel());
                             }
                         });
                     }
                    List<Node> children = current.getChildrenNodes();
                    for(Node child : children) {
                        if(!frointer.contains(child)&& !explored.contains(child)) {
                            frointer.add(child);
                            child.setDepth(current.getDepth()+1);

                        }
                    }
                }
            }

        }
        return null;
    }
}
