package forelesningRekursivtBinarySearch;

import java.util.Arrays;

public class Hashing {
    public static void main(String[] args) {
        String[] s = {"A"};
        String a = "A", b = "A", c = new String("A"), d = s[0];

        boolean lik1 = (a == b), lik2 = (a == c), lik3 = (a == d);
        boolean eq1 = a.equals(b), eq2 = b.equals(c), eq3 = a.equals(d);
        int h1 = a.hashCode(), h2 = b.hashCode(), h3 = c.hashCode(), h4 = d.hashCode();

        System.out.println("lik1: " + lik1 + " lik2: " + lik2 + " lik3: " + lik3);
        System.out.println("eq1: " + eq1 + " eq2: " + eq2 + " eq3: " + eq3);
        System.out.println("h1: " + h1 + " h2: " + h2 + " h3: " + h3);


        int[] av = {1, 2, 3}, bc = av, cd = {1, 2, 3};
        boolean like1 = (av == bc), like2 = (av == cd), like3 = av.equals(cd);

        System.out.println(like1);
        System.out.println(like2);
        System.out.println(like3);
        System.out.println(Arrays.equals(av,cd));
    }
}
