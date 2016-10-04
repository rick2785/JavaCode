// Since Cat extends Animal it gets all of Animals fields and methods
// This is called inheritance
public class Cat extends Animal{

	public Cat() {
		
		
	}
	
	// Overriding the Animal method
	public String makeSound(){
		
		return "Meow";
						
	}
	
	public static void main(String[] args) {
		
		Animal fido = new Dog();
		
		Animal fluffy = new Cat();
		
		// We can have an array of Animals that contain more specific subclasses
		// Any overridden methods are used instead because of polymorphism
		Animal[] theAnimals = new Animal[10];
		
		theAnimals[0] = fido;
		theAnimals[1] = fluffy;
		
		System.out.println("Fido says " + theAnimals[0].makeSound());
		System.out.println("Fluffy says " + theAnimals[1].makeSound());
		
		// We can also pass subclasses of Animal and they just work
		speakAnimal(fluffy);
		
	}

}