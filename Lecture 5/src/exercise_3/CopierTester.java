package exercise_3;

public class CopierTester {
	public static void main(String[] args) {
		Copier copier1 = new Copier();
		copier1.insertPaper(500);
		copier1.makeCopy(450);
		copier1.makeCopy();
		copier1.makePaperJam();
		System.out.println("Så meget papir er der tilbage: " + copier1.getPaperCount());
		copier1.makeCopy(37);
		copier1.fixJam();
		copier1.makeCopy(37);
		System.out.println("Så meget papir er der tilbage: " + copier1.getPaperCount());
	}

}
