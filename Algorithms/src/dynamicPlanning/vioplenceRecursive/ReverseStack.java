package dynamicPlanning.vioplenceRecursive;

import java.util.Stack;

/**
 * 逆序栈中的数据（不借助其他数据结构）
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);
        reverseStack(stack);
        System.out.println("--------------");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * 逆序栈
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else{
            // 获取栈底元素
            int num = getStackBottom(stack);
            reverseStack(stack);
            stack.push(num);
        }
    }

    /**
     * 获取栈底元素
     * @param stack
     * @return
     */
    public static int getStackBottom(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getStackBottom(stack);
            stack.push(result);
            return last;
        }
    }
}
