package classroom;
//This will be an example on inheritance, to go with lecture 2.
/** Class that represents a computer */
public class Computer {
	
	//Data fields
	private String manufacturer;
	private String processor;
	private double ramSize;
	private int diskSize;
	private double processorSpeed;
	
	//Methods
	/** Initializes a Computer object with all properties specified.
	 * 
	 * @param args
	 */
	public Computer(String m, String p, double r, int d, double processorSpeed) {
		manufacturer = m;
		processor = p;
		ramSize = r;
		diskSize = d;
		this.processorSpeed = processorSpeed;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String toString() {
		return "Computer with manufacturer " + manufacturer
				+ " and processor " + processor;
	}
	
	public static void main(String[] args) {
		Computer myComputer = new Computer("Windows", "Intel i9", 16, 1, 3.6);
		System.out.println(myComputer.toString());
		Notebook myNotebook = new Notebook("Asus", "Intel i7", 16, 1, 3.6, 13, 5.5);
		System.out.println(myNotebook.toString());
	}
}
