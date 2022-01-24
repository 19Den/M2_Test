package ua.goit.GroceryStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ShoppingCartTest {
    ShoppingCart shoppingCart = new ShoppingCart(new FoodStuffs());

    //The general idea of unit testing - isolation
    // we have to mock all responses/information from FoodStuffs object

    public ShoppingCartTest() {
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @MethodSource("dataProvider")
    void calculateTotalCostTest(String input, double expected) {
        double result = shoppingCart.calculateTotalCost(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                arguments("ABCD", 7.25),
                arguments("AAACCCCCC", 8),
                arguments("BD", 5)
        );
    }
}
