package test.java.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.models.WordHash;
import main.java.models.WordNode;
import main.java.models.WordPath;
import main.java.utilities.PathFinderUtils;

class PathFinderUtilsTest {

	@Test
	void constructPathTest() {
		Map<WordNode, WordNode> predecessors = new HashMap<>();
		WordNode a = new WordNode("a");
		WordNode b = new WordNode("b");
		WordNode c = new WordNode("c");
		predecessors.put(c,b);
		predecessors.put(b,a);
		String expectedPath = "a > b > c";
		WordPath actualPath = PathFinderUtils.constructPath(a,c,predecessors);
		assertEquals(actualPath.toString(),expectedPath);
	}
	
	@Test
	void BFSAdjacentStartAndGoalTest() {
		WordNode a = new WordNode("a");
		WordNode z = new WordNode("z");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		String expectedPath = "a > z";
		WordPath actualPath = PathFinderUtils.BFS(a,z,dictionary);
		assertEquals(actualPath.toString(),expectedPath);
	}
	
	@Test
	void BFSGoalNotInDictionaryTest() {
		WordNode a = new WordNode("a");
		WordNode z = new WordNode("z");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		for (char c = 'a'; c <= 'y'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		assertNull(PathFinderUtils.BFS(a,z,dictionary));
	}
	
	@Test
	void BFSNoPossiblePathTest() {
		WordNode start = new WordNode("start");
		WordNode goal = new WordNode("goal");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		dictionary.put(start.getHash(), start);
		dictionary.put(goal.getHash(), goal);
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		assertNull(PathFinderUtils.BFS(start,goal,dictionary));
	}
	
	@Test 
	void BFSPossiblePathTest() {
		WordNode start = new WordNode("start");
		WordNode goal = new WordNode("goals");
		WordNode soart = new WordNode("soart");
		WordNode goart = new WordNode("goart");
		WordNode goalt = new WordNode("goalt");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		dictionary.put(start.getHash(), start);
		dictionary.put(goal.getHash(), goal);
		dictionary.put(goart.getHash(), goart);
		dictionary.put(goalt.getHash(), goalt);
		dictionary.put(soart.getHash(), soart);
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		
		String expectedPath = "start > soart > goart > goalt > goals";
		WordPath actualPath = PathFinderUtils.BFS(start,goal,dictionary);
		assertEquals(actualPath.toString(),expectedPath);
	}
	
	@Test
	void aStarAdjacentStartAndGoalTest() {
		WordNode a = new WordNode("a");
		WordNode z = new WordNode("z");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		String expectedPath = "a > z";
		WordPath actualPath = PathFinderUtils.aStar(a,z,dictionary);
		assertEquals(actualPath.toString(),expectedPath);
	}
	
	@Test
	void aStarGoalNotInDictionaryTest() {
		WordNode a = new WordNode("a");
		WordNode z = new WordNode("z");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		for (char c = 'a'; c <= 'y'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		assertNull(PathFinderUtils.aStar(a,z,dictionary));
	}
	
	@Test
	void aStarNoPossiblePathTest() {
		WordNode start = new WordNode("start");
		WordNode goal = new WordNode("goals");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		dictionary.put(start.getHash(), start);
		dictionary.put(goal.getHash(), goal);
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		assertNull(PathFinderUtils.aStar(start,goal,dictionary));
	}
	
	@Test 
	void aStarPossiblePathTest() {
		WordNode start = new WordNode("start");
		WordNode goal = new WordNode("goals");
		WordNode soart = new WordNode("soart");
		WordNode goart = new WordNode("goart");
		WordNode goalt = new WordNode("goalt");
		Map<WordHash, WordNode> dictionary = new HashMap<>();
		dictionary.put(start.getHash(), start);
		dictionary.put(goal.getHash(), goal);
		dictionary.put(goart.getHash(), goart);
		dictionary.put(goalt.getHash(), goalt);
		dictionary.put(soart.getHash(), soart);
		for (char c = 'a'; c <= 'z'; c++) {
			WordNode current = new WordNode(Character.toString(c));
			dictionary.put(current.getHash(), current);
		}
		
		String expectedPath = "start > soart > goart > goalt > goals";
		WordPath actualPath = PathFinderUtils.aStar(start,goal,dictionary);
		assertEquals(actualPath.toString(),expectedPath);
	}

}
