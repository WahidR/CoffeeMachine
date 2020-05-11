package machine;
import java.util.*;

public class CoffeeMachine {
    final int WATER_PER_CUP = 200; //measured in ml
    final int MILK_PER_CUP = 50; //measured in ml
    final int COFFEE_PER_CUP = 15; //measured in g

    boolean powerIsOn = false;

    //Initial coffee machine resources
    int amountMoney = 550;
    int amountWater = 400;
    int amountMilk = 540;
    int amountCoffee = 120;
    int amountCups = 9;

    Scanner scanner = new Scanner(System.in);

    public void printInventory() {
        System.out.println("\nThe coffee machine has:");
        System.out.println("" + amountWater + " of water");
        System.out.println("" + amountMilk + " of milk");
        System.out.println("" + amountCoffee + " of coffee beans");
        System.out.println("" + amountCups + " of disposable cups");
        System.out.println("" + amountMoney + " of money\n");
    }

    public void performAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
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
            case "remaining":
                printInventory();
                break;
            case "exit":
                powerIsOn = false;
                break;
            default:
                System.out.println("Invalid input, action process cancelled");
        }

    }

    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.next();
        String missing;
        switch (coffeeType) {
            //Espresso
            case "1":
                missing = checkResources(1);
                if ("good".equals(missing)) {
                    amountMoney += 4;
                    amountWater -= 250;
                    amountCoffee -= 16;
                    amountCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    System.out.println("Sorry, not enough " + missing + "!");
                }
                System.out.println();
                break;
            //Latte
            case "2":
                missing = checkResources(2);
                if ("good".equals(missing)) {
                    amountMoney += 7;
                    amountWater -= 350;
                    amountMilk -= 75;
                    amountCoffee -= 20;
                    amountCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    System.out.println("Sorry, not enough " + missing + "!");
                }
                System.out.println();
                break;
            //Cappuccino
            case "3":
                missing = checkResources(3);
                if ("good".equals(missing)) {
                    amountMoney += 6;
                    amountWater -= 200;
                    amountMilk -= 100;
                    amountCoffee -= 12;
                    amountCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    System.out.println("Sorry, not enough " + missing + "!");
                }
                System.out.println();
                break;
            default:
                break;
        }
    }

    public void fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        amountWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        amountMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        amountCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        amountCups += scanner.nextInt();
        System.out.println();
    }

    public void take() {
        System.out.println("\nI gave you $" + amountMoney);
        amountMoney = 0;
        System.out.println();
    }

    //Checks if there are enough ingredients based off of the beverage chosen.
    public String checkResources(int beverage) {
        int costWater = 0;
        int costMilk = 0;
        int costCoffee = 0;
        int costCups = 1;

        //Finds resources required for the chosen beverage.
        switch (beverage) {
            //Espresso
            case 1:
                costWater = 250;
                costCoffee = 16;
                break;
            //Latte
            case 2:
                costWater = 350;
                costMilk = 75;
                costCoffee = 20;
                break;
            //Cappuccino
            case 3:
                costWater = 200;
                costMilk = 100;
                costCoffee = 12;
                break;
            default:
                System.out.println("Something went horribly wrong");
                break;
        }

        // These return which resource is needed.
        if (amountWater - costWater < 0) {
            return "water";
        } else if (amountMilk - costMilk < 0) {
            return "milk";
        } else if (amountCoffee - costCoffee < 0) {
            return "coffee";
        } else if (amountCups - costCups < 0) {
            return "cups";
        }

        return "good";
    }

    public void powerOn() {
        powerIsOn = true;

        while (powerIsOn) {
            performAction();
        }

    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        cm.powerOn();
    }
}
