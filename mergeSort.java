//Pawel Adamczuk - 1
import java.util.Scanner;


public class Source {
  
  public static int Counter;
  
  public static void MergeSort(long arr[], int left, int right, long tempArr[]) {
    if (left >= right)
      return;
    int middle = (left + right) / 2;
    MergeSort(arr, left, middle, tempArr);
    MergeSort(arr, middle+1, right, tempArr);
    Merge(arr, left, middle, right, tempArr);
  }
  
  public static void Merge (long arr[], int left, int middle, int right, long tempArr[]) {
    
    for (int i = left; i <= right; ++i) tempArr[i] = arr[i];
    int i = left;
    int j = middle + 1;
    int k = left;
    
    while ( i <= middle && j <= right )
    {
      if ( tempArr[i] <= tempArr[j] ) arr[k++] = tempArr[i++];
      else 
      {
        arr[k++] = tempArr[j++];
        Source.Counter += middle - i + 1;
        
      }
    }
    
    while ( i <= middle ) arr[k++] = tempArr[i++];
    while ( j <= right ) arr[k++] = tempArr[j++]; 

  }

  public Source() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
//    Source.Counter = 0;
//    
//    long arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
//    Source.MergeSort(arr, 0, 3);
//    
//    for ( int i = 0; i < arr.length; ++i )
//      System.out.println(arr[i]);
//    System.out.println(Source.Counter);
    
    Scanner mainScanner = new Scanner(System.in);
    
    int setCount = mainScanner.nextInt();
    int length;
    
    for (int i = 0; i < setCount; ++i)
    {
      Source.Counter = 0;
      length = mainScanner.nextInt();
      long arr[] = new long[length];
      long tempArr[] = new long[length];
      for (int j = 0; j < length; ++j)
        arr[j] = mainScanner.nextLong();
      MergeSort(arr, 0, arr.length - 1, tempArr);
      System.out.println(Source.Counter);
      
    }

  }

}
