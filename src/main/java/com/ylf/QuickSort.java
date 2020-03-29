package com.ylf;

/**
 * @author: leifeng.ye
 * @date: 2019-08-08
 * @desc: 快速排序
 */
public class QuickSort {

    public static int   KqPass(int[] array,int low,int high){
        int temp=array[low];
        while(low<high){
            while(low<high&&array[high]>=temp){
                high--;
            }
            array[low]=array[high];
            while(low<high&&array[low]<temp){
                low++;
            }
            array[high]=array[low];
        }
        array[low]=temp;
        return low;
    }

    public static void KqSort(int[] array,int left,int right){
        if(left<right){
            int mid=KqPass(array,left,right);
            KqSort(array,left,mid-1);
            KqSort(array,mid+1,right);
        }
    }

    public static void main(String[] args) {
        int array[]=new int[]{0,11,2,4,1,8,10,3,7};
        KqSort(array,0,array.length-1);
        ShellSort.printArray(array);
    }
}
