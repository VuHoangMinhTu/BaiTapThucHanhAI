package k21;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        int compare;
        if(o1.getPathCost() == o2.getPathCost()) {
            compare = o1.getLabel().compareTo(o2.getLabel());
            return compare;
        }
        compare = Double.compare(o1.getPathCost(), o2.getPathCost());
        return compare;
    }
}
