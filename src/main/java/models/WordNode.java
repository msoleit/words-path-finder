package main.java.models;

import main.java.utilities.WordsUtils;

public class WordNode {

	private String word;
	private int heurestic;
	private WordHash hash;
	public WordNode(String word, WordHash hash) {
		// TODO Auto-generated constructor stub
		this.word = word;
		this.hash = hash;
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other) return true;
		if(!(other instanceof WordNode)) return false;
		WordNode casted = (WordNode) other;
		return this.word.equals(casted.getWord()) && this.getHash().equals(casted.getHash());
	}
	@Override
	public int hashCode() {
		return this.getHash().hashCode();
	}
	public String getWord() {
		return word;
	}
	public int getHeurestic() {
		return heurestic;
	}
	public void setHeurestic(int heurestic) {
		this.heurestic = heurestic;
	}
	public WordHash getHash() {
		return hash;
	}
}
