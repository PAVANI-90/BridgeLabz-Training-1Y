package com.gla.GenericsAndCollections.Generics;
import java.util.*;

interface MealPlan {
    void showMeal();
}


class VegetarianMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegetarian Meal: Salad, Paneer, Rice");
    }
}

class VeganMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegan Meal: Tofu, Quinoa, Vegetables");
    }
}

class KetoMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Keto Meal: Avocado, Eggs, Chicken");
    }
}

class HighProteinMeal implements MealPlan {
    public void showMeal() {
        System.out.println("High Protein Meal: Chicken, Lentils, Eggs");
    }
}

// Step 3: Generic Class with Bounded Type
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void displayMeal() {
        meal.showMeal();
    }
}


class MealGenerator {

    public static <T extends MealPlan> void generateMeal(T mealPlan) {
        System.out.println("Generating your personalized meal plan...");
        mealPlan.showMeal();
    }
}
public class PersonalMeal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose your meal type:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Vegan");
        System.out.println("3. Keto");
        System.out.println("4. High Protein");

        int choice = sc.nextInt();

        MealPlan selectedMeal = null;

        switch (choice) {
            case 1:
                selectedMeal = new VegetarianMeal();
                break;
            case 2:
                selectedMeal = new VeganMeal();
                break;
            case 3:
                selectedMeal = new KetoMeal();
                break;
            case 4:
                selectedMeal = new HighProteinMeal();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }


        Meal<MealPlan> meal = new Meal<>(selectedMeal);
        meal.displayMeal();


        MealGenerator.generateMeal(selectedMeal);

        sc.close();
    }
}
