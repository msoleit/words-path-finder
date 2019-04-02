package main.java.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.models.WordHash;
import main.java.models.WordNode;

public class WordsLoaderUtils {

	public WordsLoaderUtils() {
		// TODO Auto-generated constructor stub
	}

	public static Stream<String> streamWordsOfSpeceficLengthFromFile(String filename, int length) throws IOException {
		return Files.lines(Paths.get(filename).toAbsolutePath()).map(word -> word.toLowerCase()).filter(word -> {
			return word.length() == length;
		});
	}
	
	private static Map<WordHash, WordNode> getWordsMap(Stream<String> words) {
		return words.map(word -> new WordNode(word)).collect(Collectors.toMap(node -> node.getHash(), node -> node));
	}

	public static Map<WordHash, WordNode> buildDictionary(String filename, int length) throws IOException {
		return getWordsMap(streamWordsOfSpeceficLengthFromFile(filename, length));
	}

}
