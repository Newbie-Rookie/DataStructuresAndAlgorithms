package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,1,4,7,3};
        selectSort(arr);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0;i < arr.length-1;++i) {
            int minIndex = i;
            for (int j = i+1;j < arr.length;++j) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
            }
        }
    }
}
