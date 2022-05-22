package sort.bucket;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,6,1,42,74,31,100};
        //int[] arr = new int[]{0,0,0,0,0,0,0};
        radixSort(arr);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }

    public static void radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort(arr, 0, arr.length-1, maxbits(arr));
    }

    /**
     * 找出最长的数
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr){
        int maxNum = Integer.MIN_VALUE;
        for(int num : arr){
            maxNum = Math.max(maxNum, num);
        }
        int maxbits = 0;
        while(maxNum != 0){
            maxbits++;
            maxNum /= 10;
        }
        return maxbits != 0 ? maxbits : 1;
    }

    /**
     * 基数排序
     * @param arr
     * @param l
     * @param r
     * @param maxbits
     */
    public static void radixSort(int[] arr, int l, int r, int maxbits){
        // 数组中的数为几进制
        final int radix = 10;
        // 存储arr[i]的个/十/百...位上的数
        int digit;
        int[] bucket = new int[r - l + 1];
        for(int b = 1;b <= maxbits;++b){
            // 统计个/十/百...位数上为[0,radix-1]的数（出桶进桶的次数）
            int[] count = new int[radix];
            for(int i = l;i <= r;++i){
                digit = getDigit(arr[i], b);
                count[digit]++;
            }
            // 统计个/十/百...位数上小于等于[0,radix-1]的数有多少个
            for(int i = 1;i < radix;++i){
                count[i] += count[i - 1];
            }
            // 进桶
            for(int i = r;i >= l;--i){
                digit = getDigit(arr[i], b);
                bucket[--count[digit]] = arr[i];
            }
            // 更新原数组
            for(int i = l;i <= r;++i){
                arr[i] = bucket[i - l];
            }
        }
    }

    /**
     * 求下标
     * @param x
     * @param b
     * @return
     */
    public static int getDigit(int x, int b){
        return ((x/((int)Math.pow(10, b - 1))) % 10);
    }
}
