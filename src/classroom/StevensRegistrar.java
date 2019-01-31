package classroom;

public class StevensRegistrar implements Registrar {

	private String allClasses;
	
	public StevensRegistrar() {
		allClasses = "CS115, CS284, CS496";
	}
	
	@Override
	public String classesAvailable() {
		// TODO Auto-generated method stub
		return allClasses;
	}

	@Override
	public boolean register(String className) {
		// TODO Auto-generated method stub
		if(className.equals("CS115")) return true;
		if(className.equals("CS284")) return true;
		if(className.equals("CS496")) return true;
		return false;
	}

	@Override
	public boolean deregister(String className) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean giveMeTransferCredit(String foreignClass, String localClass) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		Registrar r = new StevensRegistrar();
		if(r.register("CS115"))
			System.out.println("I am now in CS 115.");
	}

}
