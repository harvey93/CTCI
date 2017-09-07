package ch8;
import java.util.*;

public class TowersOfHanoi {
	
	Tower t1;
	Tower t2;
	Tower t3;
	int size;
	
	
	public void solve(){
		moveDisks(size, t1, t2, t3);
	}
	
	public void moveDisks(int n, Tower current, Tower aux, Tower dest){
		if(n <= 0){
			return;
		}
		
		moveDisks(n - 1, current, dest, aux);
		
		moveTop(current, dest);
		
		moveDisks(n - 1, aux, current, dest);
	}
	
	public void moveTop(Tower current, Tower dest){
		dest.add(current.get());
	}
	
	
	
	
//	public void solve(){
//		moveDisks(size, t1, t2, t3);
//	}
//	
//	private void moveDisks(int n, Tower beg, Tower aux, Tower dest){
//		if(n <= 0){
//			return;
//		}
//		
//		moveDisks(n - 1, beg, dest, aux);
//		
//		moveTop(beg, dest);
//		
//		moveDisks(n - 1, aux, beg, dest);
//	}
//	
//	private void moveTop(Tower beg, Tower dest){
//		Disk top = beg.get();
//		dest.add(top);
//	}
	
	public TowersOfHanoi(int size){
		this.size = size;
		buildTowers(size);
	}
	
	private void buildTowers(int n){
		t1 = new Tower();
		t2 = new Tower();
		t3 = new Tower();
		
		while(n > 0){
			t1.add(new Disk(n));
			n--;
		}
	}
}

class Tower{
	private Stack<Disk> stack = new Stack<>();
	
	public Disk get(){
		return stack.pop();
	}
	
	public void add(Disk disk){
		stack.push(disk);
	}
	
	public String toString(){
		return this.stack.toString();
	}
}

class Disk{

	Integer size;
	public Disk(int size){
		this.size = size;
	}
	
	public String toString(){
		return this.size.toString();
	}
}
