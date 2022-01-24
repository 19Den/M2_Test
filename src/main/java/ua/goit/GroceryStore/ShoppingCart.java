package ua.goit.GroceryStore;

import lombok.NonNull;

public class ShoppingCart {
    private final FoodStuffs foodStuffs;

    public ShoppingCart(FoodStuffs foodStuffs) {
        this.foodStuffs = foodStuffs;
    }

    public double calculateTotalCost(@NonNull String productCode) {
        //use such formatting for long lines
        // and it will be nice to extract "productCode.length() - productCode.replace("A", "").length()" in separate method
        double cost_A_InTheShoppingCart = calculateItemDiscountedCost(productCode.length() - productCode.replace("A", "").length(),
                foodStuffs.groceryList.get("A").getPrice(), foodStuffs.groceryList.get("A").getPromotionalPrice(),
                foodStuffs.groceryList.get("A").getPromotionalQuantity());
        double cost_B_InTheShoppingCart = calculate_Standard_Cost(productCode.length() - productCode.replace("B", "").length(), foodStuffs.groceryList.get("B").getPrice());
        double cost_C_InTheShoppingCart = calculateItemDiscountedCost(productCode.length() - productCode.replace("C", "").length(), foodStuffs.groceryList.get("C").getPrice(), foodStuffs.groceryList.get("C").getPromotionalPrice(), foodStuffs.groceryList.get("C").getPromotionalQuantity());
        double cost_D_InTheShoppingCart = calculate_Standard_Cost(productCode.length() - productCode.replace("D", "").length(), foodStuffs.groceryList.get("D").getPrice());

        return cost_A_InTheShoppingCart + cost_B_InTheShoppingCart + cost_C_InTheShoppingCart + cost_D_InTheShoppingCart;
    }

    private double calculateItemDiscountedCost(int quantityProdactsInTheShoppingCart, double prise, double promotionalPrice, int promotionalQuantity) {
        double calculate_A_Cost;
        if (quantityProdactsInTheShoppingCart >= promotionalQuantity) {
            // use more brackets for Math operations like
            // ((quantityProdactsInTheShoppingCart / promotionalQuantity) * promotionalPrice) + ((quantityProdactsInTheShoppingCart % promotionalQuantity) * prise)
            // anyway such expressions are extremely hard to understand
            // try to create more methods with human-readable description (name)
            calculate_A_Cost = (quantityProdactsInTheShoppingCart / promotionalQuantity) * promotionalPrice + (quantityProdactsInTheShoppingCart % promotionalQuantity) * prise;
        } else {
            calculate_A_Cost = quantityProdactsInTheShoppingCart * prise;
        }
        return calculate_A_Cost;
    }

    private double calculate_Standard_Cost(int quantityProdactsInTheShoppingCart, double price) {
        return quantityProdactsInTheShoppingCart * price;
    }
}
