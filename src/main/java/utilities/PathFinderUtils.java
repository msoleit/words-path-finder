package main.java.utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import main.java.models.WordHash;
import main.java.models.WordNode;
import main.java.models.WordPath;

public class PathFinderUtils {

	public PathFinderUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static WordPath BFS (WordNode start, WordNode goal, Map<WordHash,WordNode> words) {
		System.out.println(start.getWord());
		System.out.println(goal.getWord());
		LinkedList<WordNode> queue = new LinkedList<>();
		HashSet<WordNode> visited = new HashSet<>();
		HashMap<WordNode, WordNode> pred = new HashMap<>();
		visited.add(start);
		queue.add(start);
		while(!queue.isEmpty()) {
			WordNode u = queue.poll();
			System.out.println(u.getWord());
			for(WordNode adj : WordsUtils.getAdjacentWords(u, words)) {
				System.out.println(adj.getWord());
				if(!visited.contains(adj)) {
					visited.add(adj);
					pred.put(adj, u);
					queue.add(adj);
					if(adj.equals(goal)) return constructPath(start, goal, pred);
				}
			}
		}
		return null;
		
	}
	
	public static WordPath aStar(WordNode start, WordNode goal, Map<WordHash,WordNode> words) {
		return null;
	}

	private static WordPath constructPath(WordNode start, WordNode goal, HashMap<WordNode, WordNode> pred) {
		WordPath path = new WordPath();
		path.add(goal);
		WordNode crawl = goal;
//		for(Entry<WordNode, WordNode> e : pred.entrySet()) {
//			System.out.println(e.getKey().getWord());
//			System.out.println(e.getValue().getWord());
//		}
//		System.out.println(" ");
//		System.out.println(crawl.getWord());
//		System.out.println(pred.containsKey(crawl));
		while(pred.containsKey(crawl)) {
//			System.out.println("yes");
			path.add(pred.get(crawl));
			crawl = pred.get(crawl);
//			System.out.println(crawl.getWord());
		}
		return path;
	}
}
