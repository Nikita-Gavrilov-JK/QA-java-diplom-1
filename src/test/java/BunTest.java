import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("red bun", 300);
        assertEquals("red bun", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("black bun", 150);
        assertEquals(150,bun.getPrice(), 0.001f);
    }
}
