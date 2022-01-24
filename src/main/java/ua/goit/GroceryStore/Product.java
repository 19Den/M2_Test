package ua.goit.GroceryStore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private String itemName;
    private double price;
    private double promotionalPrice;
    private int promotionalQuantity;

    public Product(String itemName, double price, double promotionalPrice, int promotionalQuantity) {
        this.itemName = itemName;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.promotionalQuantity = promotionalQuantity;

    }
}
