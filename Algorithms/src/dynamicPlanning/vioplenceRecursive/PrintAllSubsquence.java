package dynamicPlanning.vioplenceRecursive;

/**
 * 打印字符串的所有子序列(子集、包括空字符串)
 */
public class PrintAllSubsquence {
    public static void main(String[] args) {
        printAllSubsquence("abc");
    }

    public static void printAllSubsquence(String str){
        char[] c = str.toCharArray();
        process(c, 0);
    }

    /**
     * 两条路：要不要i字符
     */
    public static void process(char[] c, int i){
        if(i == c.length){
            System.out.println(String.valueOf(c).replace("0",""));
            return;
        }
        // 要i字符的路
        process(c, i + 1);
        char s = c[i];
        c[i] = '0';
        // 不要i字符的路
        process(c, i + 1);
        c[i] = s;
    }
}
