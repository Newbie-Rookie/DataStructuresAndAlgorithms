package dynamicPlanning.vioplenceRecursive;

/**
 * 拿纸牌问题（拿左/拿右，先手/后手，最后谁胜出）
 */
public class CardsInLine {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,400,10,8};
        // A先手
        int a = f(arr, 0, arr.length - 1);
        // B后手
        int b = s(arr, 0, arr.length - 1);
        // 获胜者的分数
        System.out.println(a > b ? a : b);
    }

    /**
     * 先手函数
     */
    public static int f(int[] arr, int i, int j){
        if(i == j){
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    /**
     * 后手函数
     */
    public static int s(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i ,j - 1));
    }
}
