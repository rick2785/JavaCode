public class Tablespoons extends Expression{

	public String gallons(double quantity) {
		
		return Double.toString(quantity/256);
	}

	public String quarts(double quantity) {
		return Double.toString(quantity/64);
	}

	public String pints(double quantity) {
		return Double.toString(quantity/32);
	}

	public String cups(double quantity) {
		return Double.toString(quantity/16);
	}

	public String tablespoons(double quantity) {
		return Double.toString(quantity);
	}
	
}