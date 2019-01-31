package classroom;

public class Notebook extends Computer {
	
	private int screenSize;
	private double weight;
	
	public Notebook(String m, String p, double r, int d, double processorSpeed, int sS, double weight) {
		super(m, p, r, d, processorSpeed);
		screenSize = sS;
		this.weight = weight;
	}
	
	public String toString() {
		return "My Notebook is a " + super.toString() + " with a screen size " + screenSize;
	}
}
