public class USD extends Coin {
     final static double value = 3.52;

     @Override
     public  double calculate(double input) {
         return input*getValue();
     }
     @Override
     public double getValue() {
          return value;
     }


}
