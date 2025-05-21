import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void test_EveryStatement(){
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, ""));
        assertTrue(exception.getMessage().contains("allItems list can't be null!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("", 20, 150, 0.0)), ""));
        assertTrue(exception.getMessage().contains("Invalid item!"));

        assertEquals(7670.0, SILab2.checkCart(List.of(new Item("Computer", 14, 550, 0.0)), "0123456789678541"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Laptop", 24, 550, 0.3)), "98586983935"));
        assertTrue(exception.getMessage().contains("Invalid card number!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Laptop", 15, 450, 0.3)), "ivona43776@#4113"));
        assertTrue(exception.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    public void test_MultipleCondition(){

        assertEquals(7670.0, SILab2.checkCart(List.of(new Item("Laptop", 14, 550, 0.0)), "0123456789678541"));

        assertEquals(1720.0, SILab2.checkCart(List.of(new Item("Laptop", 14, 250, 0.5)), "0123456789678541"));

        assertEquals(3470.0, SILab2.checkCart(List.of(new Item("Laptop", 14, 250, 0.0)), "0123456789678541"));

        assertEquals(1750.0, SILab2.checkCart(List.of(new Item("Laptop", 7, 250, 0.0)), "0123456789678541"));
    }
}

 
 