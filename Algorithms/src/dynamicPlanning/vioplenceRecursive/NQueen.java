package dynamicPlanning.vioplenceRecursive;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题（返回方案数、返回所有方案、位运算优化）
 */
public class NQueen {
    public static void main(String[] args) {

    }

    // --------------------------------------方案数的位运算优化-----------------------------------------------------

    // 位运算优化
    // 第i行的递归([0,i-1]行已做决定，在此基础上确定第i行放置皇后的位置(哪一列))
    // limit：最终总限制，colLimit：列限制，leftLimit：左斜线限制，rightLimit：右斜线限制
    public int process(int limit, int colLimit, int leftLimit, int rightLimit){
        // 本次放置情况成立，返回1
        if(colLimit == limit){
            return 1;
        }
        // 放置情况数
        int res = 0;
        // 第i行总限制列
        int allLimit = colLimit | leftLimit | rightLimit;
        // 第i行非限制列
        int allNoLimit = limit & (~allLimit);
        // 遍历第i行的非限制列
        while(allNoLimit != 0){
            // 第i行最右非限制列
            int rightOne = allNoLimit & (~allNoLimit + 1);
            // 第i行剩余非限制列
            allNoLimit -= rightOne;
            // 选择最右非限制列放置皇后(不同行、列、斜线)，进入下一行
            res += process(limit, colLimit | rightOne, (leftLimit | rightOne) << 1, (rightLimit | rightOne) >>> 1);
        }
        return res;
    }

    // --------------------------------------方案数--------------------------------------------------------------

    // 第i行的递归([0,i-1]行已做决定，在此基础上确定第i行放置皇后的位置(哪一列))
    // int[] record：记录前i-1行皇后放置的列情况
    public int process1(int[] record, int i, int n){
        // 本次放置情况成立，返回1
        if(i == n){
            return 1;
        }
        // 放置情况数
        int res = 0;
        // 遍历第i行的所有列
        for(int j = 0;j < n;++j){
            // 判断第i行的第j列能否放置皇后(不同行、列、斜线)
            if(canPlace(record, i, j)){
                // 第i行的皇后放置在第j列
                record[i] = j;
                // 进入下一行
                res += process1(record, i + 1, n);
            }
        }
        return res;
    }

    // 判断第i行的第j列能否放置皇后(不同行、列、斜线)
    public boolean canPlace(int[] record, int i, int j){
        // 遍历前i-1行的皇后的列放置情况
        for(int k = 0;k < i;++k){
            // 不同列、不同斜线(斜率不为45度或135度)
            if(j == record[k] || (i - k) == Math.abs(j - record[k])){
                return false;
            }
        }
        return true;
    }

    // --------------------------------------所有方案的位运算优化---------------------------------------------------

    // 位运算优化
    // 第i行的递归([0,i-1]行已做决定，在此基础上确定第i行放置皇后的位置(哪一列))
    // res：所有方案，rows：当前方案，limit：最终总限制，colLimit：列限制，leftLimit：左斜线限制，rightLimit：右斜线限制
    public void process2(List<List<String>> res, int[] rows, int limit, int colLimit, int leftLimit, int rightLimit, int i){
        // 本次放置情况成立，返回1
        if(colLimit == limit){
            res.add(buildList(rows));
            return;
        }
        // 第i行总限制列
        int allLimit = colLimit | leftLimit | rightLimit;
        // 第i行非限制列
        int allNoLimit = limit & (~allLimit);
        // 遍历第i行的非限制列
        while(allNoLimit != 0){
            // 第i行最右非限制列
            int rightOne = allNoLimit & (~allNoLimit + 1);
            // 第i行剩余非限制列
            allNoLimit -= rightOne;
            // 记录第i行皇后放置的列位置
            rows[i] = rightOne;
            // 选择最右非限制列放置皇后(不同行、列、斜线)，进入下一行
            process2(res, rows, limit, colLimit | rightOne, (leftLimit | rightOne) << 1, (rightLimit | rightOne) >>> 1, i + 1);
        }
    }

    // 每种方案生成对应列表
    public List<String> buildList(int[] rows){
        List<String> res = new ArrayList<>();
        for(int num : rows){
            StringBuffer s = new StringBuffer();
            int n = rows.length;
            while(n > 0){
                n--;
                if(((num >> n) & 1) == 1){
                    s.append("Q");
                }else{
                    s.append(".");
                }
            }
            res.add(s.toString());
        }
        return res;
    }

    // --------------------------------------所有方案--------------------------------------------------------------

    // 第i行的递归([0,i-1]行已做决定，在此基础上确定第i行放置皇后的位置(哪一列))
    // String[] record：记录前i-1行皇后放置的列情况
    public void process3(List<List<String>> res, String[] str, int i, int n){
        // 本次放置情况成立，将本次放置情况放入res
        if(i == n){
            List<String> list = new ArrayList<>();
            for(String s : str) list.add(s);
            res.add(list);
            return;
        }
        // 第i行皇后(Q)和空位(.)的记录
        StringBuffer s = new StringBuffer();
        // 遍历第i行的所有列
        for(int j = 0;j < n;++j){
            // 判断第i行的第j列能否放置皇后(不同行、列、斜线)
            if(canPlace(str, i, j)){
                StringBuffer temp = new StringBuffer(s);
                temp.append("Q");
                int ind = j + 1;
                while(ind < n){
                    temp.append(".");
                    ind++;
                }
                // 记录当前行皇后和空位的情况
                str[i] = temp.toString();
                // 进入下一行
                process3(res, str, i + 1, n);
                // 进行下一列
                s.append(".");
            }else{
                s.append(".");
            }
        }
    }

    // 判断第i行的第j列能否放置皇后(不同行、列、斜线)
    public boolean canPlace(String[] str, int i, int j){
        // 遍历前i-1行的皇后的列放置情况
        for(int k = 0;k < i;++k){
            // 不同列、不同斜线(斜率不为45度或135度)
            if(str[k].charAt(j) == 'Q' || (i - k) == Math.abs(j - str[k].indexOf("Q"))){
                return false;
            }
        }
        return true;
    }
}
