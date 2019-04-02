package main.java.utilities;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.java.models.WordHash;
import main.java.models.WordNode;

public class WordsUtils {
	private static final int PRIME_ONE = 1000000009;
	private static final int PRIME_TWO = 1000000021;
	private static final int BASE = 31;

	public WordsUtils() {
		// TODO Auto-generated constructor stub
	}

	public static int hammingDistance(String start, String end) throws IllegalArgumentException {
		if (start.length() != end.length())
			throw new IllegalArgumentException("The two strings must be of equal length");
		int hammingDistance = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) != end.charAt(i)) {
				hammingDistance++;
			}
		}
		return hammingDistance;
	}

	public static WordHash computeWordHash(String word) {
		int hash1 = 0;
		int hash2 = 0;
		int p_pow1 = 1;
		int p_pow2 = 1;
		for (char c : word.toCharArray()) {
			hash1 = (hash1 + (c - 'a' + 1) * p_pow1) % PRIME_ONE;
			hash2 = (hash2 + (c - 'a' + 1) * p_pow2) % PRIME_TWO;
			p_pow1 = (p_pow1 * BASE) % PRIME_ONE;
			p_pow2 = (p_pow2 * BASE) % PRIME_TWO;
		}

		return new WordHash(hash1, hash2);
	}

	// for debugging with small word lengths, for longer than 6 chars the reverse is
	// not right
	public static String getWordFromHash(WordHash hash) {
		StringBuilder sb = new StringBuilder();
		long remainder = hash.getHash1();
		while (remainder != 0) {
			sb.append(Character.toString((char) (remainder % BASE + 'a' - 1)));
			remainder /= BASE;
		}
		return sb.toString();
	}

	public static Set<WordNode> getAdjacentWords(WordNode u, Map<WordHash, WordNode> words) {
		Set<WordNode> adjacentWords = new HashSet<>();
		int pow1 = 1;
		int pow2 = 1;
		for (char c : u.getWord().toCharArray()) {
			for (int i = 'a' - c; i < 'z' - c + 1; i++) {
				int hash1 = u.getHash().getHash1() + i * pow1;
				int hash2 = u.getHash().getHash2() + i * pow2;
				WordHash wh = new WordHash(hash1, hash2);
				if (i != 0 && words.containsKey(wh)) {
					adjacentWords.add(words.get(wh));
				}
			}
			pow1 = (pow1 * BASE) % PRIME_ONE;
			pow2 = (pow2 * BASE) % PRIME_TWO;
		}

		return adjacentWords;
	}

}
