package main.java.utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import main.java.models.WordHash;
import main.java.models.WordNode;
import main.java.models.WordPath;

public class PathFinderUtils {

	public PathFinderUtils() {
		// TODO Auto-generated constructor stub
	}

	public static WordPath BFS(WordNode start, WordNode goal, Map<WordHash, WordNode> words) {
		LinkedList<WordNode> queue = new LinkedList<>();
		HashSet<WordNode> visited = new HashSet<>();
		HashMap<WordNode, WordNode> predecessors = new HashMap<>();
		visited.add(start);
		queue.add(start);
		while (!queue.isEmpty()) {
			WordNode u = queue.poll();
			for (WordNode adj : WordsUtils.getAdjacentWords(u, words)) {
				if (!visited.contains(adj)) {
					visited.add(adj);
					predecessors.put(adj, u);
					queue.add(adj);
					if (adj.equals(goal))
						return constructPath(start, goal, predecessors);
				}
			}
		}
		return null;

	}

	public static WordPath aStar(WordNode start, WordNode goal, Map<WordHash, WordNode> words) {
		Set<WordNode> closedSet = new HashSet<>();
		Set<WordNode> openSet = new HashSet<>();
		Queue<WordNode> pqueue = new PriorityQueue<>();
		HashMap<WordNode, WordNode> predecessors = new HashMap<>();
		openSet.add(start);
		pqueue.add(start);
		start.setgScore(0);
		start.setfScore(start.getHeuristicCostEstimateFrom(goal));
		while (!openSet.isEmpty()) {
			WordNode current = pqueue.poll();
			if (current.equals(goal))
				return constructPath(start, goal, predecessors);
			openSet.remove(current);
			closedSet.add(current);
			for (WordNode adj : WordsUtils.getAdjacentWords(current, words)) {
				if (!closedSet.contains(adj)) {
					int tentativeGScore = current.getgScore() + 1;
					if (!openSet.contains(adj)) {
						openSet.add(adj);
						pqueue.add(adj);
					} else if (tentativeGScore >= adj.getgScore()) {
						continue;
					}

					predecessors.put(adj, current);
					adj.setgScore(tentativeGScore);
					adj.setfScore(adj.getgScore() + adj.getHeuristicCostEstimateFrom(goal));
				}
			}
		}
		return null;
	}

	public static WordPath constructPath(WordNode start, WordNode goal, Map<WordNode, WordNode> predecessors) {
		WordPath path = new WordPath();
		path.add(goal);
		WordNode crawl = goal;
		while (predecessors.containsKey(crawl)) {
			path.add(predecessors.get(crawl));
			crawl = predecessors.get(crawl);
		}
		return path;
	}
}
