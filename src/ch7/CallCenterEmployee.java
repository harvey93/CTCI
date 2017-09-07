package ch7;

public abstract class CallCenterEmployee implements Comparable<CallCenterEmployee>{

	private boolean available;
	
	public abstract int getPriority();
	
	public boolean isAvailable(){
		return this.available;
	}

	public void toggleAbalability() {
		this.available = !this.available;
	};
	
	public int compareTo(CallCenterEmployee e) {
		// TODO Auto-generated method stub
		return new Integer(getPriority()).compareTo(e.getPriority());
	}


}
