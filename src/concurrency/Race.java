package concurrency;

public class Race {
	
	Runner winner;
	public void start(Runner runner){
		
		try{
//			System.out.println("Start: " + runner.name);
			int random = (int)(Math.random() * 500);
			Thread.sleep(random);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		
//		System.out.println("End: " + runner.name);
		
		
		if(winner == null){
			System.out.println(runner.name);
			winner = runner;
		}
		
	}
}
