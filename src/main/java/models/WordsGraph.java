package main.java.models;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import main.java.models.WordPath;
import main.java.utilities.PathFinderUtils;
import main.java.utilities.WordsLoaderUtils;
import main.java.utilities.WordsUtils;

public class WordsGraph {
    private Map<WordHash, WordNode> dictionary;
    private WordNode start;
    private WordNode goal;
	public WordsGraph(String dictionaryFile, String start, String goal) throws IOException {
		this.start = new WordNode(start);
		this.goal = new WordNode(goal);
		this.dictionary = WordsLoaderUtils.buildDictionary(dictionaryFile, this.start.getWord().length());
		for(Entry<WordHash, WordNode> e : dictionary.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue().getWord());
		}
		System.out.println(" ");
	}
	
	public WordPath findPath() {
		return PathFinderUtils.BFS(start, goal, dictionary);
	}
	

}
