package concurrency;

public class Runner extends Thread{

	String name;
	Race race;
	public Runner(String name, Race race){
		this.name = name;
		this.race = race;
	}
	
	public void run(){
		race.start(this);
//		System.out.println(name);
	}
}
