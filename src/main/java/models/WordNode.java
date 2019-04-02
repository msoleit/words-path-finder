package main.java.models;

import main.java.utilities.WordsUtils;

public class WordNode implements Comparable<WordNode> {

	private String word;
	private int heurestic;
	private int gScore;
	private int fScore;
	private WordHash hash;

	public WordNode(String word) {
		// TODO Auto-generated constructor stub
		this.word = word;
		this.hash = WordsUtils.computeWordHash(word);
		this.setgScore(Integer.MAX_VALUE);
		this.setfScore(Integer.MAX_VALUE);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof WordNode))
			return false;
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

	public int getgScore() {
		return gScore;
	}

	public void setgScore(int gScore) {
		this.gScore = gScore;
	}

	public int getfScore() {
		return fScore;
	}

	public void setfScore(int fSocre) {
		this.fScore = fSocre;
	}

	@Override
	public int compareTo(WordNode o) {
		// TODO Auto-generated method stub
		return this.getfScore() - o.getfScore();
	}

	public int getHeuristicCostEstimateFrom(WordNode goal) {
		// TODO Auto-generated method stub
		return WordsUtils.hammingDistance(this.getWord(), goal.getWord());
	}
}
