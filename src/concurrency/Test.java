package concurrency;

public class Test {

	public static void main(String[] args) {
		Race race = new Race();
		
		Runner jane = new Runner("jane", race);
		Runner nush = new Runner("nush", race);
		Runner john = new Runner("john", race);
		Runner hrant = new Runner("hrant", race);
		Runner vuzh = new Runner("vuzh", race);
		Runner khacho = new Runner("khacho", race);
		Runner papa = new Runner("papa", race);
		
		
		john.start();
		papa.start();
		hrant.start();
		jane.start();
		vuzh.start();
		khacho.start();
		nush.start();
		
		
		
//		MyThread a = new MyThread("a");
//		MyThread b = new MyThread("b");
//		MyThread c = new MyThread("c");
//		MyThread d = new MyThread("d");
//		
//		a.start();
//		b.start();
//		c.start();
//		d.start();
	}
}

class Thread2 implements Runnable{
	String name;
	public Thread2(String name){
		this.name = name;
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class MyThread extends Thread{
	String name;
	
	public MyThread(String name){
		this.name = name;
	}
	
	public void run(){
		System.out.println(name);
		
	}
}