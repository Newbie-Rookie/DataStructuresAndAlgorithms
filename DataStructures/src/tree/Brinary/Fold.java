package tree.Brinary;

/**
 * 长纸条对折n次，折痕顺序（凹折痕、凸折痕）
 */
public class Fold {
    public static void main(String[] args) {
        fold(1, 3, true);
    }

    /**
     * @param i
     * @param n
     * @param down true:凹，false;凸
     */
    public static void fold(int i, int n, boolean down){
        if(i > n){
            return;
        }
        fold(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        fold(i + 1, n, false);
    }
}
