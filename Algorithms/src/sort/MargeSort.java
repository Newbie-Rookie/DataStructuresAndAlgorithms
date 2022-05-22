package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MargeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,1,4,7,3};
        margeSort(arr, 0, arr.length-1);
        for(int i = 0;i < arr.length;++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println(sum);
        for(Map.Entry<Integer,ArrayList<Integer>> m : map.entrySet()){
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }

    public static void margeSort(int[] arr, int l, int r){
        if(l == r) return;
        int m = l + ((r - l) >> 1);
        margeSort(arr, l, m);
        margeSort(arr, m + 1, r);
        marge3(arr, l, m, r);
    }

    public static void marge1(int[] arr, int l, int m, int r){
        int[] help = new int[r - l + 1];
        int l1 = l;
        int r1 = m + 1;
        int ind = 0;
        while(l1 <= m && r1 <= r){
            help[ind++] = arr[l1] <= arr[r1] ? arr[l1++] : arr[r1++];
        }
        while(l1 <= m){
            help[ind++] = arr[l1++];
        }
        while(r1 <= r){
            help[ind++] = arr[r1++];
        }
        for(int i = 0;i < help.length;++i){
            arr[l + i] = help[i];
        }
    }

    public static int sum = 0;

    public static void marge2(int[] arr, int l, int m, int r){
        int[] help = new int[r - l + 1];
        int l1 = l;
        int r1 = m + 1;
        int ind = 0;
        while(l1 <= m && r1 <= r){
            if(arr[l1] < arr[r1]){
                help[ind++] = arr[l1];
                sum += arr[l1++]*(r - r1 + 1);
            }else{
                help[ind++] = arr[r1++];
            }
        }
        while(l1 <= m){
            help[ind++] = arr[l1++];
        }
        while(r1 <= r){
            help[ind++] = arr[r1++];
        }
        for(int i = 0;i < help.length;++i){
            arr[l + i] = help[i];
        }
    }

    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void marge3(int[] arr, int l, int m, int r){
        int[] help = new int[r - l + 1];
        int l1 = l;
        int r1 = m + 1;
        int ind = 0;
        while(l1 <= m && r1 <= r){
            if(arr[l1] > arr[r1]){
                if(map.containsKey(arr[l1])){
                    ArrayList<Integer> list = map.get(arr[l1]);
                    int index = r1;
                    while(index <= r){
                        list.add(arr[index++]);
                    }
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    int index = r1;
                    while(index <= r){
                        list.add(arr[index++]);
                    }
                    map.put(arr[l1], list);
                }
                help[ind++] = arr[l1++];
            }else{
                help[ind++] = arr[r1++];
            }
        }
        while(l1 <= m){
            help[ind++] = arr[l1++];
        }
        while(r1 <= r){
            help[ind++] = arr[r1++];
        }
        for(int i = 0;i < help.length;++i){
            arr[l + i] = help[i];
        }
    }
}
