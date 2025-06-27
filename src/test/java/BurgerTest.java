import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private Burger burger;
    private Ingredient ingredient;
    private Bun bun;
    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient = mock(Ingredient.class);
    }
    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientTest(){
        Ingredient ing1 = mock(Ingredient.class);
        Ingredient ing2 = mock(Ingredient.class);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);
        burger.moveIngredient(0, 1);
        assertEquals(ing2, burger.ingredients.get(0));
        assertEquals(ing1, burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest(){
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(50f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(250f, burger.getPrice(), 0.001f);
    }
    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getType()).thenReturn(praktikum.IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("sour cream");
        when(ingredient.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expected = String.format("(==== %s ====)%n" +
                                        "= %s %s =%n" +
                                        "(==== %s ====)%n%n" +
                                        "Price: %f%n",
                                        "black bun",
                                        "sauce", "sour cream",
                                        "black bun",
                                        250f);

        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}
