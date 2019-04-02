package main.java.app;

import java.io.IOException;
import java.util.HashMap;

import main.java.models.WordHash;
import main.java.models.WordNode;
import main.java.models.WordPath;
import main.java.models.WordsGraph;
import main.java.utilities.WordsLoaderUtils;

public class WordPaths {
    private static final String PATH_NOT_FOUND = "No possible path between the two words";
    private static final String FILE_NOT_FOUND = "File provided is not valid or can not be read";
	public static void main(String[] args) {
		String filename = args[0];
		String start = args[1];
		String goal = args[2];
		
		WordHash one = new WordHash(100,100);
		WordHash two = new WordHash(100,100);
		System.out.println(one.equals(two));
		HashMap<WordHash, WordNode> map = new HashMap<>();
		map.put(one, new WordNode("word",one));
		System.out.println(map.containsKey(two));
		if(start.length() != goal.length()) {
			System.out.println(PATH_NOT_FOUND);
		}
		try {
			WordPath path = new WordsGraph(WordsLoaderUtils.buildDictionary(filename,start.length())).findPath(start,goal);
			System.out.println(path == null ? PATH_NOT_FOUND : path);
		} catch (IOException e) {
			System.out.println(FILE_NOT_FOUND);
		}

	}

}
