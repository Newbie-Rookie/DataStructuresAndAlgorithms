package dynamicPlanning.vioplenceRecursive;

import java.util.ArrayList;

/**
 * 打印字符串的全排列
 * (一个一个字符试)
 */
public class PrintAllPermutations {
    public static void main(String[] args) {
        ArrayList<String> res = printAllPermutations("abcd");
        for(String s : res){
            System.out.println(s);
        }
    }

    public static ArrayList<String> printAllPermutations(String s){
        ArrayList<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        char[] c = s.toCharArray();
        process(c, 0, res);
        return res;
    }

    /**
     *  每个字符去尝试
     */
    public static void process(char[] c, int i, ArrayList<String> res){
        if(i == c.length){
            res.add(String.valueOf(c));
        }
        // 记录某个字符是否试过
        boolean[] visit = new boolean[26];
        for(int j = i;j < c.length;j++){
            // 保证不重复进行全排列（某个字符是否已经试过）
            if(!visit[c[j] - 'a']){
                visit[c[j] - 'a'] = true;
                swap(c, i, j);
                process(c, i + 1, res);
                swap(c, i, j);
            }
        }
    }

    public static void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
