package main.java.models;

import java.util.Map;
import java.util.Map.Entry;

import main.java.models.WordPath;
import main.java.utilities.PathFinderUtils;
import main.java.utilities.WordsUtils;

public class WordsGraph {
    private Map<WordHash, WordNode> dictionary;
	public WordsGraph(Map<WordHash, WordNode> dictionary) {
		this.dictionary = dictionary;
		for(Entry<WordHash, WordNode> e : dictionary.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue().getWord());
		}
		System.out.println(" ");
	}
	
	public WordPath findPath(String start, String goal) {
		return PathFinderUtils.BFS(new WordNode(start, WordsUtils.computeWordHash(start)), new WordNode(goal, WordsUtils.computeWordHash(goal)), dictionary);
	}
	

}
