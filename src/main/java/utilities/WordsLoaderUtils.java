package main.java.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class WordsLoaderUtils {

	public WordsLoaderUtils() {
		// TODO Auto-generated constructor stub
	}

	public static Set<String> loadWordsOfSpeceficLengthFromFile(String filename, int length) throws IOException {
		return Files.lines(Paths.get(filename).toAbsolutePath()).filter(word -> word.length() == length)
				.collect(Collectors.toSet());
	}

}
