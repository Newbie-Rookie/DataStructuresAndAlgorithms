package dynamicPlanning.vioplenceRecursive;

/**
 * 数字翻译为字母（翻译的种数）
 */
public class NumberTransformWord {
    public static void main(String[] args) {
        String str = "12234";
        System.out.println(process1(str, 0));
    }

    public static int process1(String str, int i){
        if(i == str.length()){
            // 该情况成立
            return 1;
        }
        int res = 0;
        if(str.charAt(i) == '1'){
            // 单独数字1转为字母b
            res += process1(str, i + 1);
            if(i + 1 < str.length()){
                // 两位数字(10 ~ 19)转为字母(k ~ t)
                res += process1(str, i + 2);
            }
            return res;
        }else if(str.charAt(i) == '2'){
            // 单数字2转为字母c
            res += process1(str, i + 1);
            if(i + 1 < str.length() && str.charAt(i + 1) <= '5'){
                // 两位数字(20 ~ 25)转为字母(u ~ z)
                res += process1(str, i + 2);
            }
            return res;
        }
        // 数字0（a）、3（d） ~ 9（j）
        return process1(str, i + 1);
    }

    public static int process2(String str, int i){
        if(i == str.length()){
            // 该情况成立
            return 1;
        }
        if(str.charAt(i) == '0'){
            // 该情况不成立
            return 0;
        }
        int res = 0;
        if(str.charAt(i) == '1'){
            // 单独数字1转为字母a
            res += process2(str, i + 1);
            if(i + 1 < str.length()){
                // 两位数字(10 ~ 19)转为字母(j ~ s)
                res += process2(str, i + 2);
            }
            return res;
        }else if(str.charAt(i) == '2'){
            // 单数字2转为字母b
            res += process2(str, i + 1);
            if(i + 1 < str.length() && str.charAt(i + 1) <= '6'){
                // 两位数字(20 ~ 26)转为字母(t ~ z)
                res += process2(str, i + 2);
            }
            return res;
        }
        // 数字3（c） ~ 9（i）
        return process2(str, i + 1);
    }
}
