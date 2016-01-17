//Pawel Adamczuk - 1
import java.util.Scanner;


public class Source {
  
  public static void Sort (long[] arr) {
    int temp;
    int L = 0;
    int R = arr.length - 1;
    
    while (true)
    {
      if (L < R) 
      {
//        for (int i = 0; i < arr.length; ++i)
//        {
//          if (i == L || i == R)
//            System.out.print(arr[i] + ". ");
//          else
//            System.out.print(arr[i] + " ");          
//        }
//        System.out.println();
        
        temp = Partition (arr, L, R);
        //if (R - L > 2)
          arr[R] = 0 - arr[R]; //add the flag      
          
        R = temp - 1;
      }
      else
      {
        //[L, R]= pop();      
        L = R + 2;
        if (L >= arr.length)
        {
          if (arr[arr.length - 1] < 0)
            arr[arr.length - 1] = 0 - arr[arr.length - 1];
            
            break;
          
        }
          
        R = L - 1;
        while (arr[R] > 0)
          ++R;
        
  //      int i = L - 1;
  //      while (i <= arr.length - 1 && arr[i] > 0)
  //      {
  //        ++i;
  //      }
  //      
  //      if (i >= arr.length)
  //        break;
  //      else
  //        R = i;
        arr[R] = 0 - arr[R];
      }
        
        
//      if (arr[L] < 0)
//        arr[L] = 0 - arr[L];
    }
      
    
  }
  
//  public static int Partition ( long[] arr, int left, int right ) {
//    
//    int i = left - 1;
//    
//    swap (arr, left + (right-left)/2, right);
//      
//    long x = arr[right]; //last element as pivot
//
//    for ( int j = left; j < right; j++)
//
//    if (arr[j] < x)
//    {
//      i = i+1;
//      swap (arr, i, j);
//    }
//
//    swap (arr, i+1, right);
//
//    return (i+1);    
//  }
  
  public static int Partition ( long[] arr, int left, int right ) {
    int i = left - 1, j = right;
    
    swap (arr, left + (right-left)/2, right);

    long pivot = arr[right];

    while (true) 
    {
      while (arr[++i] < pivot) 
      {
        //i++;
      }
      
      while (j > left && arr[--j] > pivot) 
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
  
//  public static int Partition(long[] arr, int L, int R) {
//    int i = L-1, j = R;
//    int middle = L + (R - L)/2;
//    long x = arr[middle];
//    while(true) 
//    {
//      while( arr[++i] < x ) {}
//      while( j > L && arr[--j] > x ) {}
//        
//      if(i >= j)
//        break;  
//      else
//        swap(arr, i, j);
//    }
//      swap(arr, j, middle);
//    return j + 1;
//    }

  private static void swap(long[] arr, int i, int j) {
    long temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;    
  }

  public Source() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    
//    long arr[] = {1, 4, 3, 2, 5, 8, 11, 10, 15, 6, 9, 13, 12, 17, 19, 20, 18, 7, 14, 16};
//    for (int i = 0; i < arr.length; ++i)
//      System.out.print(arr[i] + " ");
//    System.out.println();
//    Sort(arr);
    
 Scanner mainScanner = new Scanner(System.in);
    
    int setCount = mainScanner.nextInt();
    int length;
    
    for (int i = 0; i < setCount; ++i)
    {
      length = mainScanner.nextInt();
      long arr[] = new long[length];
      for (int j = 0; j < length; ++j)
        arr[j] = mainScanner.nextLong();
      Sort(arr);
      for (int j = 0; j < length - 1; ++j)
        System.out.print(arr[j] + " ");
      System.out.println(arr[length - 1]);      
    }
    
    

  }

}
