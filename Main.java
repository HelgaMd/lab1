package lab1;

public class Main {
    public static void main (String[] args) {
        Calculator calc = new Calculator ();
        try {
            System.out.println (calc.add ("//[;][,][avc]\n1;36avc12,4"));
        } catch (ExceptionNegative exc) { exc.printStackTrace (); }
    }
}
