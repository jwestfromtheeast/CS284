package classroom;

public interface Registrar {

	String classesAvailable();
	boolean register(String className);
	boolean deregister(String className);
	boolean giveMeTransferCredit(String foreignClass, String localClass);
}
