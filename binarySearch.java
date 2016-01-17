//Pawel Adamczuk - 1

//package baca2;
import java.util.Scanner;

public class Source {
	
	public static int binarySearchLeft(long[] arr, int n, long search) {
		int start = 0;
		int end = n-1;
				
		while (start <= end)
		{
			if ( arr[(start+end)/2] >= search )
			{
				end = (start+end)/2 - 1;
			}
			else
				start = (start+end)/2 + 1;
		}
		
		return start;
		
	}
	
	public static int binarySearchRight(long[] arr, int n, long search) {
		int start = 0;
		int end = n-1;
				
		while (start <= end)
		{
			if ( arr[(start+end)/2] > search )
			{
				end = (start+end)/2 - 1;
			}
			else
				start = (start+end)/2 + 1;
		}
		
		return end;
		
	}

	public static void main(String[] args) {
//		
//		long[] arr = {1, 3, 4, 5, 6, 7, 8, 12, 12, 12, 14, 15, 16, 18, 19, 20, 22, 22, 22, 25};
//		//            0  1  2  3  4  5  6  7    8   9  10  11  12  13  14  15  16  17  18  19
//		int n = 20;
//		System.out.println(binarySearchRight(arr, n, 22));
		
		Scanner mainScanner = new Scanner(System.in);
		int setCount;
		
		setCount = mainScanner.nextInt();
		
		for ( int i = 0; i < setCount; ++i )
		{
			int arrLen = mainScanner.nextInt();
			long[] arr = new long[arrLen];
			
			for ( int j = 0; j < arrLen; ++j )
				arr[j] = mainScanner.nextLong();
			
			int queryCount = mainScanner.nextInt();
			
			long a, b;
			int result;
			
			for ( int j = 0; j < queryCount; ++j )
			{
				a = mainScanner.nextLong();
				b = mainScanner.nextLong();
				
				if (a > b)
					result = 0;
				else				
					result = binarySearchRight(arr, arrLen, b) - binarySearchLeft(arr, arrLen, a) + 1;

				System.out.println( result );
				
				
			}
			
			
			
			
					
			
		}
		
		
		
		

		mainScanner.close();
	}

}
