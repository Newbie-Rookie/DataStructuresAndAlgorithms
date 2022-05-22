package test;

import java.util.Arrays;

import static sort.InsertSort.insertSort;

public class Test {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxNum = 100;
        boolean flag = true;
        for(int i = 1;i <= testTime;++i){
            int[] arr1 = generateRandomArray(maxSize, maxNum);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            insertSort(arr1);
            Arrays.sort(arr2);
            if(!isEquals(arr1, arr2)){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Nice" : "Fuck");
    }

    public static int[] generateRandomArray(int maxSize, int maxNum){
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for(int i = 0;i < arr.length;++i){
            arr[i] = (int)((maxNum+1)*Math.random()) - (int)((maxNum+1)*Math.random());
        }
        return arr;
    }

    public static boolean isEquals(int[] arr1, int[] arr2){
        for(int i = 0;i < arr1.length;++i){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
