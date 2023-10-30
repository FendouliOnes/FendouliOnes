package gestionzoo.entities;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Zoo {
    private int numberOfCages;
    private int numberOfAnimals;

    public Zoo(int numberOfCages) {
        this.numberOfCages = numberOfCages;
        this.numberOfAnimals = 0;
    }

    public void addAnimal(Animal animal) throws ZooFullException {
        if (numberOfAnimals >= numberOfCages) {
            throw new ZooFullException("The zoo is full, cannot add more animals.");
        }
        numberOfAnimals++;
        System.out.println("Animal added. Number of animals: " + numberOfAnimals);
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo(3);
        try {
            Animal lion = new Animal("Lion", 5);
            Animal elephant = new Animal("Elephant", -2); // This line will throw an InvalidAgeException
            Animal giraffe = new Animal("Giraffe", 3);
            zoo.addAnimal(lion);
            zoo.addAnimal(elephant);
            zoo.addAnimal(giraffe);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        }
    }
}