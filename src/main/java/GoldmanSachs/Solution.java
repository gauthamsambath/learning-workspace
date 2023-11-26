package GoldmanSachs;

import java.util.Scanner;

// Define the abstract class Food
abstract class Food {
    double proteins;
    double fats;
    double carbs;
    int tastyScore;

    // Abstract method to get macro nutrients
    abstract void getMacroNutrients();
}

// Define the class Egg which extends Food
class Egg extends Food {
    String type = "non-vegetarian";

    // Constructor to initialize the attributes
    public Egg(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.tastyScore = 7;
    }

    // Override the abstract method
    @Override
    void getMacroNutrients() {
        System.out.println("An egg has " + this.proteins + " gms of protein, " + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates.");
    }
}

// Define the class Bread which extends Food
class Bread extends Food {
    String type = "vegetarian";

    // Constructor to initialize the attributes
    public Bread(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.tastyScore = 8;
    }

    // Override the abstract method
    @Override
    void getMacroNutrients() {
        System.out.println("A slice of bread has " + this.proteins + " gms of protein, " + this.fats + " gms of fats and " + this.carbs + " gms of carbohydrates.");
    }
}

public class Solution {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            String name = sc.nextLine();

            if(name.equals("Bread")) {
                Bread breadObj = new Bread(4, 1.1, 13.8);
                for(int j = 0; j < 3; j++) {
                    String command = sc.nextLine();
                    if(command.equals("getMacros")) {
                        breadObj.getMacroNutrients();
                    } else if(command.equals("getTaste")) {
                        System.out.println("Taste: " + breadObj.tastyScore);
                    } else if(command.equals("getType")) {
                        System.out.println("Bread is " + breadObj.type);
                    }
                }
            } else if (name.equals("Egg")) {
                Egg eggObj = new Egg(6.3, 5.3, 0.6);
                for(int j = 0; j < 3; j++) {
                    String command = sc.nextLine();
                    if(command.equals("getMacros")) {
                        eggObj.getMacroNutrients();
                    } else if(command.equals("getTaste")) {
                        System.out.println("Taste: " + eggObj.tastyScore);
                    } else if(command.equals("getType")) {
                        System.out.println("Egg is " + eggObj.type);
                    }
                }
            }
        }
    }
}
