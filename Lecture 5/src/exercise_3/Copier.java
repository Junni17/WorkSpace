package exercise_3;

public class Copier {
	private int paperCount;
	private boolean paperStuck = false;

	public Copier() {
		this.paperCount = 0;
	}

	public Copier(int paperCount) {
		this.paperCount = paperCount;
	}

	public void insertPaper(int amount) {
		if (this.paperStuck == true) {
			System.out.println("Error - Paper is stuck in the copier!");
		} else {
			int paper = this.paperCount + amount;
			if (paper > 500) {
				System.out.println("Error - Paper limit can't exceed 500");
			} else if (paper <= 500) {
				this.paperCount = paper;
			}
		}
	}

	public int getPaperCount() {
		return this.paperCount;
	}

	public void makeCopy() {
		if (this.paperStuck == true) {
			System.out.println("Error - Paper is stuck in the copier!");
		} else {
			if (this.paperCount <= 0) {
				System.out.println("Error - Insert paper!");
			} else if (this.paperCount >= 1) {
				this.paperCount = this.paperCount - 1;
			}
		}
	}

	public void makeCopy(int copies) {
		if (this.paperStuck == true) {
			System.out.println("Error - Paper is stuck in the copier!");
		} else {
			int paper = this.paperCount - copies;
			if (paper <= 0) {
				System.out.println("Error - Not enough paper");
			} else if (paper >= 0) {
				this.paperCount = paper;
			}
		}
	}

	public void makePaperJam() {
		this.paperStuck = true;
	}

	public void fixJam() {
		this.paperStuck = false;
	}

}
