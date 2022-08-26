package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 21:45
 **/
public class Cast {

    public static void main(String[] args) {

        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.
        Integer s = (Integer) lsa[1].get(0); // Run time error, but cast is explicit.
    }
}
