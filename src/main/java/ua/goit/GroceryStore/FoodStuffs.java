package ua.goit.GroceryStore;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class FoodStuffs {
    public FoodStuffs() {
        addProductsList();
    }

    //Review#2
    //change the filed to private and create accessor methods
    Map<String, Product> groceryList = new HashMap<>();

    private void addProductsList() {
        groceryList.put("A", new Product("Яблоко", 1.25, 3.0, 3));
        groceryList.put("B", new Product("Груша", 4.25, 0.0, 0 ));
        groceryList.put("C", new Product("Слива", 1.00, 5.0, 6));
        groceryList.put("D", new Product("Абрикос", 0.75, 0.0, 0));
    }
}
