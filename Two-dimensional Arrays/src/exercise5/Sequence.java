package exercise5;

import java.util.ArrayList;

public class Sequence {

	private ArrayList<Integer> values;

	public Sequence() {
		this.values = new ArrayList<Integer>();
	}

	public void add(int n) {
		this.values.add(n);
	}

	@Override
	public String toString() {
		return this.values.toString();
	}

	// appending two sequences
	public Sequence append(Sequence other) {
		Sequence sTEMP = new Sequence();
		for (int i = 0; i < this.values.size(); i++) {
			sTEMP.add(this.values.get(i));
		}
		for (int i = 0; i < other.values.size(); i++) {
			sTEMP.add(other.values.get(i));
		}

		return sTEMP;
	}

	// merging two sequences
	public Sequence merge(Sequence other) {
		Sequence sTEMP = new Sequence();
		for (int i = 0; i < Math.max(this.values.size(), other.values.size()); i++) {
			if (i < this.values.size()) {
				sTEMP.add(this.values.get(i));
			}
			if (i < other.values.size()) {
				sTEMP.add(other.values.get(i));
			}
		}

		return sTEMP;
	}

}
