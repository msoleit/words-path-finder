package main.java.models;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class WordPath {
    private LinkedList<WordNode> path;
    public WordPath() {
    	path = new LinkedList<>();
    }
	public void add(WordNode node) {
		path.addFirst(node);
	}
	public String toString() {
		
		return path.stream().map(node -> node.getWord()).collect(Collectors.joining(" > "));
//		StringBuilder sb = new StringBuilder();
//		for(WordNode node: path) {
//			sb.append(node.getWord());
//			sb.append(" > ");
//		}
//		sb.delete(sb.length()-3, sb.length());
//		return sb.toString();
	}

}
