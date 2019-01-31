package recitation1;

public class Cat {
	
	// Data Fields
	
	// Public stuff, can get it anywhere
	public String name;
	public String color;
	
	// Private stuff, only the class knows it
	private int age;
	
	// Default Constructor
	public Cat() {
		name = "Justin";
		color = "White";
		age = 27;
	}
	
	// Tell me what the name, color, and age is
	public Cat(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		// can use the this operator, but don't need to unless there are duplicates
		this.age = newAge;
	}
	
	public static void main(String[] args) {
		
		// Make a default cat
		Cat newCat;
		newCat = new Cat();
		System.out.println(newCat.name);
		
		// Make another cat
		Cat veryNewCat = new Cat("Bobby", "Red", 12345);
		System.out.println(veryNewCat.name);
		// Can call age, because we are in the same class. Need getter/setter for other ones
		System.out.println(veryNewCat.age);
		// Do this for better practice, and always outside the class
		System.out.println(veryNewCat.getAge());
		
		// Alter age using our setter
		veryNewCat.setAge(321);
		System.out.println("New age is " + veryNewCat.getAge());
	}
	
}
