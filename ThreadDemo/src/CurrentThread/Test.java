package CurrentThread;

public class Test {
	public static void main(String[] args){
		
		MyThread myThread = new MyThread();
		myThread.setName("A");
		myThread.start();
		
	}
}

