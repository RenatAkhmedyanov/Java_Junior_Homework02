public class Cat extends Animal {

    private boolean canClimb;

    public Cat(String name, int age, boolean canClimb) {
        super(name, age);
        this.canClimb = canClimb;
    }

    public void climbToTree() {
        if (canClimb) {
            System.out.println("Кот полез на дерево");
        } else {
            System.out.println("Кот не хочет лезть на дерево");
        }
    }
}
