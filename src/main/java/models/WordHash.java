package main.java.models;

import java.util.Objects;

public class WordHash {
	private int hash1;
	private int hash2;

	public WordHash(int hash1, int hash2) {
		this.setHash1(hash1);
		this.setHash2(hash2);
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof WordHash))
			return false;
		WordHash casted = (WordHash) other;
		return this.getHash1() == casted.getHash1() && this.getHash2() == casted.getHash2();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getHash1(), this.getHash2());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(getHash1()));
		sb.append(",");
		sb.append(getHash2());
		return sb.toString();
	}

	public int getHash1() {
		return hash1;
	}

	private void setHash1(int hash1) {
		this.hash1 = hash1;
	}

	public int getHash2() {
		return hash2;
	}

	private void setHash2(int hash2) {
		this.hash2 = hash2;
	}
}
