package dynamicPlanning.vioplenceRecursive;

/**
 * 0 - 1背包问题（重量与价值，最大价值）
 */
public class ZeroOneBag {
    public static void main(String[] args) {

    }

    /**
     * @param weights
     * @param values
     * @param i
     * @param alreadyWeight
     * @param bag
     * @return
     */
    public static int process(int[] weights, int values[], int i, int alreadyWeight, int bag){
        if(alreadyWeight > bag || i == weights.length){
            return 0;
        }
        // 装和不装的价值较大值
        return Math.max(process(weights, values, i + 1, alreadyWeight, bag),
                values[i] + process(weights, values, i + 1, alreadyWeight + weights[i], bag));
    }
}
