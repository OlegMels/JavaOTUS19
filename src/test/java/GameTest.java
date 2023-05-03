import org.junit.Test;
import otus.game.*;

import static org.mockito.Mockito.*;

public class GameTest {

    private final DiceImpl dice = mock(DiceImpl.class);
    private final GameWinnerPrinter winnerPrinter = mock(GameWinnerPrinter.class);
    private final Game game = new Game(dice, winnerPrinter);

    @Test
    public void firstPlayerWinTest() {
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        when(dice.roll()).thenReturn(5, 3);

        game.playGame(player1, player2);

        verify(winnerPrinter).printWinner(player1);
    }

    @Test
    public void secondPlayerWinTest() {
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        when(dice.roll()).thenReturn(1, 6);

        game.playGame(player1, player2);

        verify(winnerPrinter).printWinner(player2);
    }

    @Test
    public void tieTest() {
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        when(dice.roll()).thenReturn(2, 2);

        game.playGame(player1, player2);

        verify(winnerPrinter).printWinner(null);
    }
}
