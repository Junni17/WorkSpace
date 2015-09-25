package diceExercise;

public class PairOfDiceTester {
	// tester med to terninger på 12 sider
	public static void main(String[] args) {
		PairOfDice dice = new PairOfDice();
		dice.rollbothdice();
		System.out.println("Antal 6ere: " + dice.getsixes());
		System.out.println("Antal gange, de har vist det samme: " + dice.getsamefaces());
		System.out.println("Antal gange, der blevet rullet: " + dice.getrollnumber());
		System.out.println("Summen af terningerne: " + dice.sumofdice());
		System.out.println("Der blev slået: " + dice.toString());
	}

}
