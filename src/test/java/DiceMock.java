import otus.game.Dice;

public class DiceMock implements Dice {
    @Override
    public int roll() {
        return 10;
    }
}
