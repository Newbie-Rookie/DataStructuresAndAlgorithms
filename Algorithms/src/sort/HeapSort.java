package sort;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,1,4,7,3};
        heapSort(arr, arr.length);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        arr = new int[]{6,10,7,3,4,8,1,9,2,5};
        sortedArrDistanceLessK(arr, 5);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 已知一个几乎有序的数组
     * 几乎有序：若将数组排好序，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小
     * @param arr
     * @param k
     */
    public static void sortedArrDistanceLessK(int[] arr, int k){
        // 默认小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        while(index < Math.min(arr.length, k)){
            heap.offer(arr[index++]);
        }
        int ind = 0;
        while(index < arr.length){
            heap.offer(arr[index++]);
            arr[ind++] = heap.poll();
        }
        while(!heap.isEmpty()){
            arr[ind++] = heap.poll();
        }
    }

    /**
     * 堆排序
     * @param arr
     * @param heapSize
     */
    public static void heapSort(int[] arr, int heapSize){
        // 先将数组变为大顶堆
        /*while(heapSize < arr.length){
            if(heapSize == 0){
                heapSize++;
            }else{
                heapInsert(arr, heapSize++);
            }
        }*/
        heapMax(arr, heapSize);
        // 将堆顶元素和最后一个元素交换，堆大小减1
        // 堆顶元素向下调整，直到堆大小为0
        while(heapSize > 0){
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    /**
     * 将数组变为大顶堆
     */
    public static void heapMax(int[] arr, int heapSize){
        for(int i = heapSize-1;i >= 0;--i) {
            heapify(arr, i, heapSize);
        }
    }

    /**
     * 堆插入
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index){
        // 直到父大于孩子/根节点（根节点的父节点为本身）
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    /**
     * 移除堆顶元素后堆化
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize){
        // 左孩子下标
        int left = index * 2 + 1;
        while(left < heapSize){
            // 两孩子中较大值的下标
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            // 父与孩子之间中较大值的下标
            largest = arr[index] > arr[largest] ? index : largest;
            // 两孩子都小于父
            if(index == largest){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
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
