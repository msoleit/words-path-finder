package test.java.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.models.WordHash;
import main.java.models.WordNode;
import main.java.utilities.WordsUtils;

class WordsUtilsTest {

	@Test
	void hammingDistanceOfDifferentTotallyDifferentCharsStringsTest() {
		String start = "aaa";
		String end = "bbb";
		int hammingDistance = WordsUtils.hammingDistance(start, end);
		assertEquals(hammingDistance, start.length());
	}

	@Test
	void hammingDistanceOfEqualStringsTest() {
		String start = "aaa";
		String end = "aaa";
		int hammingDistance = WordsUtils.hammingDistance(start, end);
		assertEquals(hammingDistance, 0);
	}

	@Test
	void hammingDistanceOfEmptyStringsTest() {
		String start = "";
		String end = "";
		int hammingDistance = WordsUtils.hammingDistance(start, end);
		assertEquals(hammingDistance, 0);
	}

	@Test
	void hammingDistanceOfDifferentLengthStrings() {
		String start = "a";
		String end = "ab";
		Assertions.assertThrows(IllegalArgumentException.class, () -> WordsUtils.hammingDistance(start, end));

	}

	@Test
	void computeWordHashTest() {
		String word = "cat";
		WordHash wordHash = WordsUtils.computeWordHash(word);
		assertNotNull(wordHash);
	}

	// Only for small strings (less than or equal 6 chars)
	@Test
	void getWordFromHashTest() {
		String word = "abbbbb";
		WordHash wordHash = WordsUtils.computeWordHash(word);
		String reversed = WordsUtils.getWordFromHash(wordHash);
		assertEquals(word, reversed);
	}

	@Test
	void getAdjacentWordsTest() {
		WordNode word = new WordNode("a");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		Set<WordNode> adjacents = WordsUtils.getAdjacentWords(word, dictionary);
		assertEquals(adjacents.size(), 25);
	}

}
