package au_exam;

import java.util.ArrayList;

public class Forrest {

	private String name;
	private ArrayList<Tree> trees = new ArrayList<Tree>();

	public Forrest(String name) {
		this.name = name;
	}

	public void add(Tree t) {
		this.trees.add(t);
	}

	public void remove(Tree t) {
		this.trees.remove(t);
	}

	public int tallestTree(String type) {
		int tallest_tree = 0;
		for (Tree element : this.trees) {
			if (element.getType().equals(type) && element.getHeight() > tallest_tree) {
				tallest_tree = element.getHeight();
			}
		}
		return tallest_tree;
	}

	public ArrayList<Tree> fruitTrees(int MaxAmmount) {
		ArrayList<Tree> fruitTrees = new ArrayList<>();
		for (Tree element : this.trees) {
			if (element.hasFruit()) {
				fruitTrees.add(element);
			}
		}

		if (fruitTrees.size() > MaxAmmount) {
			for (int i = MaxAmmount; i < fruitTrees.size(); i++) {
				fruitTrees.remove(i);
			}

		}

		return fruitTrees;
	}

	public void printFruits() {

	}

}
