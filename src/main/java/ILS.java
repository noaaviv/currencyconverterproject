public class ILS extends Coin {
    final static double value = 0.28;
//    set double value for nis of 0.28

    @Override
//    to fix error, i can pull method calculate to coin.
    public double calculate(double input) {
        return input*getValue();
    }

    @Override
    public double getValue() {
        return value;
    }
}