package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,1,4,7,3};
        quickSort1(arr, 0, arr.length-1);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 快排1.0
     */
    public static void quickSort1(int[] arr, int l, int r){
        if(l < r){
            int[] p = partition(arr, l, r);
            // <=区
            quickSort3(arr, l, p[0]);
            // >区
            quickSort3(arr, p[1], r);
        }
    }

    public static int[] part(int[] arr, int l, int r){
        // <=右边界
        int leq = l - 1;
        while(l < r){
            if(arr[l] <= arr[r]){
                swap(arr, ++leq, l++);
            }else{
                l++;
            }
        }
        swap(arr, leq+1, r);
        return new int[]{leq, leq+2};
    }

    /**
     * 快排2.0
     */
    public static void quickSort2(int[] arr, int l, int r){
        if(l < r){
            int[] p = partition(arr, l, r);
            // <区
            quickSort3(arr, l, p[0]);
            // >区
            quickSort3(arr, p[1], r);
        }
    }

    /**
     * 快排3.0
     */
    public static void quickSort3(int[] arr, int l, int r){
        if(l < r){
            int ind = l + (int)(Math.random()*(r - l + 1));
            swap(arr, ind, r);
            int[] p = partition(arr, l, r);
            // <区
            quickSort3(arr, l, p[0]);
            // >区
            quickSort3(arr, p[1], r);
        }
    }

    public static int[] partition(int[] arr, int l, int r){
        // <右边界
        int less = l - 1;
        // >左边界
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less, more+1};
    }

    /**
     * 交换两值
     * @param arr
     * @param l
     * @param r
     */
    public static void swap(int[] arr, int l, int r){
        if(l != r){
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];
        }
    }
}
