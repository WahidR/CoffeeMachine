package machine;
import java.util.*;

public class CoffeeMachine {
    final int WATER_PER_CUP = 200; //measured in ml
    final int MILK_PER_CUP = 50; //measured in ml
    final int COFFEE_PER_CUP = 15; //measured in g

    int amountMoney = 550;
    int amountWater = 400;
    int amountMilk = 540;
    int amountCoffee = 120;
    int amountCups = 9;

    Scanner scanner = new Scanner(System.in);
    public void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.println("" + amountWater + " of water");
        System.out.println("" + amountMilk + " of milk");
        System.out.println("" + amountCoffee + " of coffee beans");
        System.out.println("" + amountCups + " of disposable cups");
        System.out.println("" + amountMoney + " of money");
    }

    public void performAction() {
        System.out.println("\n" + "Write action (buy, fill, take):");
        String action = scanner.next();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            default:
                System.out.println("Invalid input, action process cancelled");
        }
        System.out.println();
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeType = scanner.nextInt();
        switch (coffeeType) {
            //Espresso
            case 1:
                amountMoney += 4;
                amountWater -= 250;
                amountCoffee -= 16;
                amountCups -= 1;
                break;
            //Latte
            case 2:
                amountMoney += 7;
                amountWater -= 350;
                amountMilk -= 75;
                amountCoffee -= 20;
                amountCups -= 1;
                break;
            //Cappuccino
            case 3:
                amountMoney += 6;
                amountWater -= 200;
                amountMilk -= 100;
                amountCoffee -= 12;
                amountCups -= 1;
                break;
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        amountWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        amountMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        amountCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        amountCups += scanner.nextInt();
    }

    public void take() {
        System.out.println("I gave you $" + amountMoney);
        amountMoney = 0;
    }

    public int calculateCups(int givenWater, int givenMilk, int givenCoffee) {
        final int WATER_PER_CUP = 200; //measured in ml
        final int MILK_PER_CUP = 50; //measured in ml
        final int COFFEE_PER_CUP = 15; //measured in g

        int numCups = 0;
        while (true) {
            int waterDifference = givenWater - WATER_PER_CUP;
            int milkDifference = givenMilk - MILK_PER_CUP;
            int coffeeDifference = givenCoffee - COFFEE_PER_CUP;
            if (waterDifference < 0 || milkDifference < 0 || coffeeDifference < 0) {
                break;
            }
            givenWater -= WATER_PER_CUP;
            givenMilk -= MILK_PER_CUP;
            givenCoffee -= COFFEE_PER_CUP;
            numCups++;
        }
        return numCups;
    }

    public void checkIngredients() {
        final int WATER_PER_CUP = 200; //measured in ml
        final int MILK_PER_CUP = 50; //measured in ml
        final int COFFEE_PER_CUP = 15; //measured in g

        int waterAmount;
        int milkAmount;
        int coffeeBeansAmount;
        int coffeeCupsReq;
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml if water the coffee machine has:");
        waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansAmount = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        coffeeCupsReq = scanner.nextInt();

        int maxCups = calculateCups(waterAmount, milkAmount, coffeeBeansAmount);

        //If statement checking if currentCupCount = cups requested.
        if (maxCups == coffeeCupsReq) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > coffeeCupsReq) {
            int extraCups = maxCups - coffeeCupsReq;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        }
        else {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        }
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

        /*
        System.out.println("For " + numOfCups + " cups of coffee you will need:");
        System.out.println("" + amountOfWater + " ml of water");
        System.out.println("" + amountOfMilk + " ml of milk");
        System.out.println("" + amountOfCoffee + " g of coffee beans");
        */

    }

    public static void brewCoffeeDialogue() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }


    public static void main(String[] args) {
        //brewCoffeeDialogue();
        //amountOfIngredients();
        //checkIngredients();
        CoffeeMachine cm = new CoffeeMachine();
        //cm.checkIngredients();
        cm.printInventory();
        cm.performAction();
        cm.printInventory();

    }
}
