public class Dog extends Animal {

    private boolean canSwim;

    public Dog(String name, int age, boolean canSwim) {
        super(name, age);
    }

    public void swim() {
        if (canSwim) {
            System.out.println("Собака идеть купаться");
        } else {
            System.out.println("Собака не хочет идти купаться");
        }
    }
    public void makeSound() {
        System.out.println("Гав-Гав!");
    }
}
