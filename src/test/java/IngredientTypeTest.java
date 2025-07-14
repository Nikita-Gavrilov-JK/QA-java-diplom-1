import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void shouldReturnSauce(){
        IngredientType type = IngredientType.valueOf("SAUCE");
        assertEquals(IngredientType.SAUCE, type);
    }

    @Test
    public void shouldReturnFilling() {
        IngredientType type = IngredientType.valueOf("FILLING");
        assertEquals(IngredientType.FILLING, type);
    }
}
