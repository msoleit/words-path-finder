package main.java.models;

import java.util.LinkedList;

public class WordPath {
    private LinkedList<WordNode> path;
    public WordPath() {
    	path = new LinkedList<>();
    }
	public void add(WordNode node) {
		path.addFirst(node);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(WordNode node: path) {
			sb.append(node.getWord());
			sb.append(" > ");
		}
		sb.delete(sb.length()-3, sb.length());
		return sb.toString();
	}

}
