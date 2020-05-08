package machine;
import java.util.*;

public class CoffeeMachine {
    final int WATER_PER_CUP = 200;
    final int MILK_PER_CUP = 50;
    final int COFFEE_PER_CUP = 15;
    public static void brewCoffeeDialogue() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void amountOfIngredients() {
        final int WATER_PER_CUP = 200; //measured in ml
        final int MILK_PER_CUP = 50; //measured in ml
        final int COFFEE_PER_CUP = 15; //measured in g

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups you will need:");

        int numOfCups = scanner.nextInt();
        int amountOfWater = WATER_PER_CUP * numOfCups;
        int amountOfMilk = MILK_PER_CUP * numOfCups;
        int amountOfCoffee = COFFEE_PER_CUP * numOfCups;

        System.out.println("For " + numOfCups + " cups of coffee you will need:");
        System.out.println("" + amountOfWater + " ml of water");
        System.out.println("" + amountOfMilk + " ml of milk");
        System.out.println("" + amountOfCoffee + " g of coffee beans");


    }

    public static void main(String[] args) {
        //brewCoffeeDialogue();
        amountOfIngredients();
    }
}
