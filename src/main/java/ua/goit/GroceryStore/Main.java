package ua.goit.GroceryStore;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(new FoodStuffs());
        System.out.println(shoppingCart.calculateTotalCost("введите код продукта: ACACAABCCDCCC"));
    }
}
