package ch8;
import java.util.*;

public class TowersOfHanoi {
	
	Tower t1;
	Tower t2;
	Tower t3;
	int size;
	
	
	public void solve(){
		moveDisks(t1, t2, t3, size);
	}
	
	public static void moveDisks(Tower start, Tower temp, Tower dest, int disks) {
		if(disks <= 0) {
			return;
		}
		
		moveDisks(start, dest, temp, disks - 1);
		moveTop(start, dest);
		moveDisks(temp, start, dest, disks - 1);
	}
	
	public static void moveTop(Tower start, Tower dest) {
		dest.add(start.get());
	}

	
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
