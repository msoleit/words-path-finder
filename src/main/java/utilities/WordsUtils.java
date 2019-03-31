package main.java.utilities;

public class WordsUtils {

	public WordsUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static int hammingDistance(String start, String end) {
		int hammingDistance = 0;
		for(int i = 0; i < start.length(); i++) {
			if(start.charAt(i) != end.charAt(i)) {
				hammingDistance++;
			}
		}
		return hammingDistance;
	}

}
