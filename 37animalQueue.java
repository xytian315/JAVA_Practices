/*
3.7 An animal shelter holds only dogs and cats, and operates on a stricly "first in 
first out" basic. People must adopt either the oldest of all animals at the shelter,
or they can select whether they would prefer a dog or a cat(and will receive the oldest
animal of that type). They can not select which specific animal they would like.
Create the data structures to maintain this system and implement operations such as 
enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the built-in LinkedList datastructure.

*/

public class Animal{
	
	private String name;
	private int order;
	public Animal(String name){
		this.name = name;
	}

	public void setOrder(int order){
		this.order = order;
	}
	public int getOrder(){
		return this.order;
	}

	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder;
	}
}

public class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

public class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

public class AnimalQueue{
	LinkedList<Dog> dogs;
	LinkedList<Cat> cats;
	int order;
	public AnimalQueue(){
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
		order =0;
	}

	//don't forget to cast Animal to Dog/Cat!!!!
	public void enqueue(Animal a){
		a.setOrder(order);
		order ++;
		if(a instaneOf Dog)
			dogs.addLast((Dog)a);
		if(a instanceOf Cat)
			cats.addLast((Cat)a);
	}

	//don't forget to check if Dog/cat is empty, use size() method!!!!
	public Animal dequeueAny(){
		if(cats.size == 0){
			return this.dequeueDog();
		}
		if(dogs.size == 0 {
			return this.dequeueCat();
		}

		Cat tmpCat = cats.peek();
		Dog tmpDog = dogs.peek();
		if(tmpCat.isOlderThan(tmpDog))
			return this.dequeueCat();
		else
			return this.dequeueDog();
	}

	public Dog dequeueDog(){
		return dogs.pool();
	}

	public Cat dequeueCat(){
		return cats.pool();
	}


}

