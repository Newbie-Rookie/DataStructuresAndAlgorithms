package sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,2,1,4,3,7};
        System.out.println(selectMin(arr));
        insertSort(arr);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(selectDataIndex(arr,2));

        arr = new int[]{1,1,1,1,1,3,3,3,3,4,4,4,4,5,5};
        System.out.println(selectLeftMin(arr,2));
    }

    public static int selectLeftMin(int[] arr,int data){
        int l = 0;
        int r = arr.length-1;
        int m = l + ((r - l) >> 1);
        int ind = Integer.MIN_VALUE;
        while(l <= r){
            if(arr[m] > data){
                r = m - 1;
            }else{
                l = m + 1;
                ind = Math.max(ind, m);
            }
            // mid = (l + r)/2
            // 当数组长度很大时，l+r可能溢出
            m = l + ((r - l) >> 1);
        }
        return ind;
    }

    public static int selectMin(int[] arr){
        if(arr[0] < arr[1]) return arr[0];
        int len = arr.length;
        if(arr[len - 1] < arr[len - 2]) return arr[len - 1];
        int l = 0;
        int r = len - 1;
        int m = l + ((r - l) >> 1);
        while(arr[m - 1] < arr[m] || arr[m + 1] < arr[m]){
            if(arr[m - 1] < arr[m]){
                r = m - 1;
            }else{
                l = m + 1;
            }
            m = l + ((r - l) >> 1);
        }
        return arr[m];
    }

    /**
     * 二分法
     * @param arr
     * @param data
     * @return
     */
    public static int selectDataIndex(int[] arr, int data){
        int l = 0;
        int r = arr.length-1;
        int m = l + ((r - l) >> 1);
        while(arr[m] != data){
            if(data < arr[m]){
                r = m - 1;
            }else{
                l = m + 1;
            }
            m = l + ((r - l) >> 1);
        }
        return m;
    }

    public static void insertSort(int[] arr) {
        for (int i = 1;i < arr.length;++i) {
            for (int j = i;j > 0;--j) {
                if (arr[j - 1] > arr[j]) {
                    arr[j] = arr[j] ^ arr[j - 1];
                    arr[j - 1] = arr[j] ^ arr[j - 1];
                    arr[j] = arr[j] ^ arr[j - 1];
                } else {
                    break;
                }
            }
        }
    }
}