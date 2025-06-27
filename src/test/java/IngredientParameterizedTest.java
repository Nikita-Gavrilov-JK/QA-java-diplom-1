import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Type {0}, Name {1}, Price {2}")
    public static Collection<Object[]> parmData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "chili sauce", 200},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 250}
                });
    }

    @Test
    public void testIngredientFields() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингридиента не совпадает", type, ingredient.getType());
        assertEquals("Наименование ингридиента не совпадает", name, ingredient.getName());
        assertEquals("Цена ингридиента не совпадает", price, ingredient.getPrice(), 0.001f);
    }
}
