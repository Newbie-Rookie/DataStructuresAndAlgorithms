package sort.bucket;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,2,6,1,2,4,5,4,7,3,8,3,4,5};
        countSort(arr);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 计数排序：数组中的数小于数组的长度
     * @param arr
     */
    public static void countSort(int[] arr){
        int[] num = new int[arr.length];
        for(int i = 0;i < arr.length;++i){
            num[arr[i]]++;
        }
        int index = 0;
        for(int i = 0;i < arr.length;++i){
            while(num[i]-- > 0){
                arr[index++] = i;
            }
        }
    }
}
