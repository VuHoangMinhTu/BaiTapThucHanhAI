package puzzle_8.student;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Astar implements IPuzzleAlgo {
    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> openList = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        HashSet<Node> closedList = new HashSet<>();

        Node startNode = model.getInitialState();
        startNode.setG(0);
        startNode.setH(model.computeH2(startNode));
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();

            if (currentNode.equals(model.getGoalState())) {
                return currentNode;
            }

            closedList.add(currentNode);

            for (Node successor : model.getSuccessors(currentNode)) {
                if (closedList.contains(successor)) {
                    continue;
                }

                int tentativeG = currentNode.getG() + 1; // Assuming cost between nodes is 1

                if (!openList.contains(successor) || tentativeG < successor.getG()) {
                    successor.setG(tentativeG);
                    successor.setH(model.computeH2(successor));

                    if (!openList.contains(successor)) {
                        openList.add(successor);
                    }
                }
            }
        }

        return null; // No solution found
    }
}
