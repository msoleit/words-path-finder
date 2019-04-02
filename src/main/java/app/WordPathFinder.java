package main.java.app;

import java.io.IOException;

import main.java.models.WordPath;
import main.java.models.WordsGraph;

public class WordPathFinder {
	private static final String PATH_NOT_FOUND = "No possible path between the two words";
	private static final String FILE_NOT_FOUND = "File provided is not valid or can not be read";
	private static final String MISSING_ARGUMENTS = "Required arguments are missing";

	public static void main(String[] args) {
		try {
			String filename = args[0];

			String start = args[1].toLowerCase();
			String goal = args[2].toLowerCase();
			if (start.length() != goal.length()) {
				System.out.println(PATH_NOT_FOUND);
				return;
			}
			WordPath path = new WordsGraph(filename, start, goal).findPath();

			System.out.println(path == null ? PATH_NOT_FOUND : path);
		} catch (IOException ioe) {
			System.out.println(FILE_NOT_FOUND);
		} catch (ArrayIndexOutOfBoundsException aie) {
			System.out.println(MISSING_ARGUMENTS);
		}

	}

}
