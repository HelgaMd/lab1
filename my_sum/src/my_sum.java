/**
 * Created by Aqru on 04.10.16.
 *
 */
public class my_sum {

    public static void main(String[] args) {
        calc c = new calc();
        try {
            int r = c.add("1\n1,3,3\n1001");
            System.out.println(r);
        }
        catch (SubZero e){
            e.printStackTrace();
        }
    }
}
