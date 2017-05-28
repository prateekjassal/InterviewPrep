package Math;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/greatest-common-divisor/
 */
public class GCD {
    public int gcd(int a, int b) {
        int rem = -1;
        int m = -1;
        int n = -1;

        if(a == 0)
            return b;
        else if(b == 0)
            return a;


        while(rem != 0) {
            if(rem == -1) {
                m = (a>=b)?a:b;
                n = (a<b)?a:b;
            }
            // System.out.println(m+" "+n);
            rem = (m%n);
            m = n;
            n = rem;
        }
        return m;
    }
}
