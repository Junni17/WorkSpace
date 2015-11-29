package au_exam;

public class Tree {

	private String type;
	private int height;
	private boolean hasFruit;

	public Tree(String type, int height, boolean hasFruit) {
		this.type = type;
		this.height = height;
		this.hasFruit = hasFruit;
	}

	@Override
	public String toString() {
		return "\n" + this.type + ", " + this.height + " m, has fruits: " + this.hasFruit;
	}

	public String getType() {
		return this.type;
	}

	public int getHeight() {
		return this.height;
	}

	public boolean hasFruit() {
		return this.hasFruit;
	}
}
