package test.java.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.utilities.WordsUtils;

class WordsUtilsTest {

	@Test
	void hammingDistanceTest() {
		String start = "aaa";
		String end = "bbb";
		int hammingDistance = WordsUtils.hammingDistance(start, end);
		assertEquals(hammingDistance,3);
	}

}
