/**
 * Created by VITTACH on 05.10.2016.
 */
public class calculator {
    public static void main(String[] argv) {
        calculate calc = new calculate();

        System.out.println("Zharikov Vitaliy. Example:");
        System.out.println("//;\\n,*\\n1;2,**4 = "+ calc.Add("//;\n,*\n1;2,**4"));
        System.out.println("//;*\\n1;2***1000 = " + calc.Add("//;*\n1;2***1000"));
        System.out.println("1,-2,-3\\n-6,7\\n = " + calc.Add("1,-2,-3\n-6,7\n"));
        System.out.println("1,\\n = " + calc.Add("1,\n"));
        System.out.println("1\\n8 = " + calc.Add("1\n8"));
    }
}
