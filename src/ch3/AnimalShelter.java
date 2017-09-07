package ch3;

import java.util.HashMap;
import java.util.LinkedList;

public class AnimalShelter {

	private int count;
	private LinkedList<AnimalNode> dogList;
	private LinkedList<AnimalNode> catList;
	
	public AnimalShelter(){
		this.dogList = new LinkedList<>();
		this.catList = new LinkedList<>();
	}
	
	public void enqueue(Animal a){
		if(a instanceof Dog){
			this.dogList.add(new AnimalNode(a, this.count));
		}else if(a instanceof Cat){
			this.catList.add(new AnimalNode(a, this.count));
		}
		count++;
	}
	
	public Dog dequeuDog(){
		return (Dog)this.dogList.removeFirst().animal;
	}
	
	public Cat dequeuCat(){
		return (Cat)this.catList.removeFirst().animal;
	}
	
	public String toString(){
		return "Dogs: " + this.dogList.toString() + "\n" +
				"Cats: " + this.catList.toString();
	}
	
	public Animal dequeueAny(){
		Animal result = null;
		if(!this.catList.isEmpty() && !this.dogList.isEmpty()){
			AnimalNode firstDogNode = this.dogList.getFirst();
			AnimalNode firstCatNode = this.catList.getFirst();
			if(firstCatNode.count < firstDogNode.count){
				result = this.catList.removeFirst().animal;
			}else {
				result = this.dogList.removeFirst().animal;
			}
		}else if(!this.catList.isEmpty()){
			result = dequeuCat();
		}else if (!this.dogList.isEmpty()){
			result = dequeuDog();
		}
		return result;
	}
	

	private class AnimalNode{
		
		private Animal animal;
		private int count;
		
		private AnimalNode(Animal animal, int count){
			this.animal = animal;
			this.count = count;
		}
		
		public String toString(){
			return "{ Name: " + this.animal.getName()
					+ " Count: " + this.count + "} ";
		}
				
	}

}
