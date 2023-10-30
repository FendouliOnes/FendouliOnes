package gestionzoo.entities;

public class Zoo1 {
    private final int numberOfCages;
    private int numberOfAnimals;

    public Zoo1(int numberOfCages) {
        this.numberOfCages = numberOfCages;
        this.numberOfAnimals = 0;
    }

    public void addAnimal() throws ZooFullException {
        if (numberOfAnimals >= numberOfCages) {
            throw new ZooFullException("The zoo is full, cannot add more animals.");
        }
        numberOfAnimals++;
        System.out.println("Animal added. Number of animals: " + numberOfAnimals);
    }

    public static void main(String[] args) {
        Zoo1 zoo = new Zoo1(3);
        try {
            zoo.addAnimal();
            zoo.addAnimal();
            zoo.addAnimal();
            zoo.addAnimal(); // This line will throw a ZooFullException
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        }
    }
}
