//Pawel Adamczuk - 1
//import java.util.Arrays;
import java.util.Scanner;
public class Source {
  
  public static int quickSelect (int[] arr, int start, int end, int i)
  {
    if (start == end)
      return arr[start];
    int k = partition2(arr, start, end, start + (end - start)/2); //median(arr, start, end)
    //k = k - start + 1;
    if (i == k)
      return arr[k];
    else if (i < k)
      return quickSelect(arr, start, k - 1, i);
    else
      return quickSelect(arr, k + 1, end, i);
  }
  
  public static void swap (int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static int selectionSort (int[] arr, int start, int end) { //sorts and returns the median
    int j;
    for (int i = start + 1; i <= end; ++i)
    {
      j = i;
      while ( j > 0 && arr[j-1] > arr[j] )
      {
          swap(arr, j, j-1);
          j--;
      }
    }    
    return start + ((end-start)/2);          // arr[2], arr[6], arr[4]
  }
  
  public static int median (int[] arr, int start, int end) {
    if (end - start + 1 <= 5)
    {
      // TODO bottom recursive case
      return selectionSort(arr, start, end);
    }
    else
    {
      int n = 0;
      for ( int i = start; i < end; i = i + 5)
      {
        swap(arr, n++, selectionSort(arr, i, Math.min(i + 4, arr.length - 1)));
      }
      return median (arr, start, n - 1);
    }
  }
  
  public static int partition2 ( int[] arr, int start, int end, int pivot ) {
    int x = arr[pivot];
    swap(arr, end, pivot);
    //int x = arr[end];
    int i = start;
    for (int j = start; j <= end - 1; ++j)
    {
      if (arr[j] < x)
      {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, end);
    return i;
  }
  
  public static int partition ( int[] arr, int left, int right, int pivot ) {
    int i = left - 1, j = right;
    
    swap(arr, pivot, right);

    int pivot2 = arr[right];

    while (true) 
    {
      while (arr[++i] < pivot2) 
      {
        //i++;
      }
      
      while (j > left && arr[--j] > pivot2) 
      {
        //j--;
      }
      
      if (i >= j) 
        break;
      else
      {
        swap(arr, i, j);
      }
    }
    swap (arr, i, right);
    return i;
  }
  
  public Source() {
  }

  public static void main(String[] args) {
    
//    int arr[] = {1, 4, 3, 2, 5, 8, 11, 10, 15, 6, 9, 13, 12, 17, 19, 20, 18, 7, 14, 16};
//    System.out.println(quickSelect(arr, 0, arr.length - 1, 4));
//    //int temp =  median(arr, 0, arr.length - 1);
//    //System.out.println(temp);
//    //System.out.println(partition(arr, 0, arr.length - 1, temp));
//    //System.out.println(median(arr, 0, arr.length - 1));
//    //java.util.Arrays.sort(arr);
//    System.out.println();
//    for (int i = 0; i < arr.length; ++i)
//      System.out.print(arr[i] + " ");

    Scanner mainScanner = new Scanner(System.in);
    
    int setCount = mainScanner.nextInt();
    int length;
    int k;
    
    for (int i = 0; i < setCount; ++i)
    {
      length = mainScanner.nextInt();
      int arr[] = new int[length];
      
      for (int j = 0; j < length; ++j)
        arr[j] = mainScanner.nextInt();
      
      length = mainScanner.nextInt();
      for (int j = 0; j < length; ++j)
      {
        k = mainScanner.nextInt();
        System.out.print(k);
        System.out.print(" ");
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
      }
    }
  }

}
