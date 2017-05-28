package Greedy;

import java.util.List;

/**
 * Created by prateek on 28/05/17.
 * Source - https://www.interviewbit.com/problems/gas-station/
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        // List<Integer> effectiveGas = new ArrayList<Integer> ();
        int sum = 0;
        int positiveGas = 0;
        int negativeGas = 0;
        int minIndex = 0;

        for(int i=0;i<gas.size();i++) {
            int eg = gas.get(i)-cost.get(i);
            if(eg >=0) {
                positiveGas += Math.abs(eg);
            } else {
                negativeGas += Math.abs(eg);
            }
            // If total gas consumed at a point is greater than the total gas filled
            if(positiveGas < negativeGas) {
                minIndex = i+1;
                positiveGas = 0;
                negativeGas = 0;
            }
            sum = sum+eg;
            // effectiveGas.add(eg);
        }
        if(sum < 0 || minIndex >= gas.size()) {
            return -1;
        }

        return minIndex;
    }
}
