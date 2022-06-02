package dynamicPlanning.vioplenceRecursive;

import java.util.Scanner;

/**
 * 汉诺塔问题
 */
public class Hanoi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        hanoi(s.nextInt());
    }

    public static void hanoi(int n){
        if(n > 0){
            func(n, "左", "中", "右");
        }
    }

    /**
     * (1) 将1 ~ i-1从起始柱移动到辅助柱
     * (2) 将i从起始柱移动到终点柱
     * (3) 将1 ~ i-1从辅助柱移动到终点柱
     */
    public static void func(int i, String start, String help, String end){
        if(i == 1){
            // 将最后一个盘从起始柱移动到终点柱 → end.add(start.size() - 1)
            System.out.println("Move 1 from " + start + " to " + end);
        }else{
            // 将1 ~ i-1从起始柱移动到辅助柱
            func(i - 1, start, end, help);
            // 将i从起始柱移动到终点柱 → end.add(start.size() - 1)
            System.out.println("Move " + i + " from " + start + " to " + end);
            // 将1 ~ i-1从辅助柱移动到终点柱
            func(i - 1, help, start, end);
        }
    }
}
