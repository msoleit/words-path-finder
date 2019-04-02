package test.java.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.utilities.WordsUtils;
import main.java.models.*;
class WordsUtilsTest {

	@Test
	void hammingDistanceTest() {
		String start = "aaa";
		String end = "bbb";
		int hammingDistance = WordsUtils.hammingDistance(start, end);
		assertEquals(hammingDistance,3);
	}
	@Test
	void computeWordHashTest() {
		String word = "cat";
		WordHash wordHash = WordsUtils.computeWordHash(word);
		assertNotNull(wordHash);
//		System.out.println(wordHash);
//		System.out.println(new WordNode(word).hashCode());
//		System.out.println(new WordNode("dog").hashCode());
	}
//	@Test
//	void getWordFromHashTest() {
//		String word = "zu";
//		WordHash wordHash = WordsUtils.computeWordHash(word);
//		String reversed = WordsUtils.getWordFromHash(wordHash);
//		System.out.println(reversed);
//		assertEquals(word, reversed);
//	}

}
