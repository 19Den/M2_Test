package ua.goit.GroceryStore;

import lombok.NonNull;

public class ShoppingCart {
    private final FoodStuffs foodStuffs;

    public ShoppingCart(FoodStuffs foodStuffs) {
        this.foodStuffs = foodStuffs;
    }

    public double calculateTotalCost(@NonNull String allProductCodeInCart) {
        //use such formatting for long lines
        //true
        // and it will be nice to extract "productCode.length() - productCode.replace("A", "").length()" in separate method
        //true
        double cost_A_InTheShoppingCart = calculateItemDiscountedCost(quantityOfOneItem(allProductCodeInCart, "A"),
                //Review#2
                //it's a bad practice to call some object directly. groceryList should be private with accessor methods
                foodStuffs.getGroceryList().get("A").getPrice(), foodStuffs.getGroceryList().get("A").getPromotionalPrice(),
                foodStuffs.getGroceryList().get("A").getPromotionalQuantity());
        double cost_B_InTheShoppingCart = calculateStandardCost(quantityOfOneItem(allProductCodeInCart, "B"),
                foodStuffs.getGroceryList().get("B").getPrice());
        double cost_C_InTheShoppingCart = calculateItemDiscountedCost(quantityOfOneItem(allProductCodeInCart, "C"),
                foodStuffs.getGroceryList().get("C").getPrice(), foodStuffs.getGroceryList().get("C").getPromotionalPrice(),
                foodStuffs.getGroceryList().get("C").getPromotionalQuantity());
        double cost_D_InTheShoppingCart = calculateStandardCost(quantityOfOneItem(allProductCodeInCart, "D"),
                foodStuffs.getGroceryList().get("D").getPrice());

        return cost_A_InTheShoppingCart + cost_B_InTheShoppingCart + cost_C_InTheShoppingCart + cost_D_InTheShoppingCart;
    }

    private double calculateItemDiscountedCost(int quantityOfProductsOfOneKind, double prise, double promotionalPrice, int promotionalQuantity) {
        if (quantityOfProductsOfOneKind >= promotionalQuantity) {
            // use more brackets for Math operations like
            // ((quantityProdactsInTheShoppingCart / promotionalQuantity) * promotionalPrice) + ((quantityProdactsInTheShoppingCart % promotionalQuantity) * prise)
            //true
            // anyway such expressions are extremely hard to understand
            //true
            // try to create more methods with human-readable description (name)
            //true
            return discountPrice(quantityOfProductsOfOneKind, prise, promotionalPrice, promotionalQuantity);
        } else
            return salePriceithoutDiscount(quantityOfProductsOfOneKind, prise);
    }

    private double calculateStandardCost(int quantityProdactsInTheShoppingCart, double price) {
        return quantityProdactsInTheShoppingCart * price;
    }

    private int quantityOfOneItem(String allProductCodeInCart, String singleProductCode) {
        return allProductCodeInCart.length() - allProductCodeInCart.replace(singleProductCode, "").length();
    }

    private double discountPrice(int quantityOfProductsOfOneKind, double prise, double promotionalPrice, int promotionalQuantity) {
        return ((quantityOfProductsOfOneKind / promotionalQuantity) * promotionalPrice) + ((quantityOfProductsOfOneKind % promotionalQuantity) * prise);
    }

    private double salePriceithoutDiscount(int quantityOfProductsOfOneKind, double prise) {
        return quantityOfProductsOfOneKind * prise;
    }
}
