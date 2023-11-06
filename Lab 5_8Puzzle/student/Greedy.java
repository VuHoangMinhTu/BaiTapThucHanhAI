package puzzle_8.student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy implements IPuzzleAlgo{
    @Override
    public Node execute(Puzzle model) {
        Queue<Node> frointer = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        ArrayList<Node> explore = new ArrayList<>();
        frointer.add(model.getInitialState());
        while (!frointer.isEmpty()) {
            Node current = frointer.poll();
            if(current.getH() == 0) {
                return current;
            } else {
                explore.add(current);
                List<Node> children = model.getSuccessors(current);
                for(Node child: children) {
                    if(!frointer.contains(child) && !frointer.contains(child)) {
                        child.setG(current.getG() +1);
                        frointer.add(child);
                    }
                }

            }
        }
        return null;
    }
}
