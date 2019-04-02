package test.java.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.utilities.WordsLoaderUtils;

class WordsLoaderUtilsTest {

	@Test
	void streamWordsOfSpeceficLengthFromFileTest() throws IOException {
			Stream<String> wordsStream = WordsLoaderUtils.streamWordsOfSpeceficLengthFromFile("src\\main\\java\\resources\\words",3);
			assertNotNull(wordsStream);
			wordsStream.forEach(word -> assertEquals(word.length(),3));
	}
	
	@Test
	void streamWordsOfSpeceficLengthFromInValidFileTest() throws IOException {
			Assertions.assertThrows(IOException.class, () -> WordsLoaderUtils.streamWordsOfSpeceficLengthFromFile("src\\main\\java\\resources\\not-found",3));
	}
	
	@Test
	void buildDictionaryTest() throws IOException {
		assertNotNull(WordsLoaderUtils.buildDictionary("src\\main\\java\\resources\\words", 3));
	}

}
