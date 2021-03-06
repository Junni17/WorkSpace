package childArray;

public class Child {
	private String name;
	private double[] weights;// can contain weights for the first 11 years
	private int weightsCount;

	public Child(String name) {
		this.name = name;
		this.weights = new double[11];
		this.weightsCount = 0;
	}

	public String getName() {
		return this.name;
	}

	public double[] getWeights() {
		return this.weights;
	}

	public int getWeightsCount() {
		return this.weightsCount;
	}

	public double getWeight(int age) {
		return this.weights[age];
	}

	public double setWeight(double weight, int age) {
		// if (this.weightsCount > this.weights.length) {
		// this.weightsCount++;
		// for (int i = this.weightsCount - 1; i > age; i--) {
		// this.weights[i] = this.weights[i - 1];
		// }
		//
		// }
		return this.weights[age - 1] = weight;

	}

	public double maxYearlyWeighGain() {
		double temp = 0;
		double maxYearlyWeightGain = 0;
		for (int i = 0; i < this.weights.length; i++) {
			if (i < 10) {
				temp = this.weights[i + 1] - this.weights[i];
				if (temp > maxYearlyWeightGain) {
					maxYearlyWeightGain = temp;
				}
			}
		}
		return maxYearlyWeightGain;
	}
}
