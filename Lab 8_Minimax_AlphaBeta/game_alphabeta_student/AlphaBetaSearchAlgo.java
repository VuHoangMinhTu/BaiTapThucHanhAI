package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int result = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("The result value is: " + result);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		}

		// Sort children alphabetically
		List<Node> sortedChildren = new ArrayList<>(node.getChildren());
		Collections.sort(sortedChildren, Node.LabelComparator);

		int v = Integer.MIN_VALUE;
		for (Node child : sortedChildren) {

			v = Math.max(v, minValue(child, alpha, beta));
			if (v >= beta) {
				System.out.println("Cut-off at node: " + child.getLabel());
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		return v;
	}

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		}

		// Sort children alphabetically
		List<Node> sortedChildren = new ArrayList<>(node.getChildren());
		Collections.sort(sortedChildren, Node.LabelComparator);

		int v = Integer.MAX_VALUE;
		for (Node child : sortedChildren) {

			v = Math.min(v, maxValue(child, alpha, beta));
			if (v <= alpha) {
				System.out.println("Cut-off at node: " + child.getLabel());
				return v;
			}
			beta = Math.min(beta, v);
		}
		return v;
	}
}
