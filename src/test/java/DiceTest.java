import org.junit.Test;
import otus.game.Dice;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    private final Dice dice = new DiceMock();

    @Test
    public void diceInBoundaryTest() {
        int result = dice.roll();

        assertTrue(result > 0);
        assertTrue(result <= 6);
    }
}
