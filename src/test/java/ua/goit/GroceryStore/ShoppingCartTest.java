package ua.goit.GroceryStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)

public class ShoppingCartTest {

    //The general idea of unit testing - isolation
    // we have to mock all responses/information from FoodStuffs object

    @Mock
    //Review#2
    // We shouldn't mock ShoppingCart because we actually test it,
    //but we have to mock the internal dependency -  FoodStuffs
    //we have to use when().thenReturn() method for all methods they will be called (for internal objects too)
    private ShoppingCart shoppingCart;

    @BeforeEach
    void init() {
        shoppingCart = new ShoppingCart(new FoodStuffs());
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
