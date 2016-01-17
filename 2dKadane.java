//Pawel Adamczuk - 1
//Two-dimensional Kadane algorithm

import java.util.Scanner;
public class Source {

	/**
	 * @param args
	 */
	
	static int[] singleArrayKadane ( int[] array, int n ) {
		
		int tempSum = 0;
		int maxSum = 0;
		
		int a = 0;
		int b = 0;
		
		for ( int i = 0; i < n; ++i )
		{
			tempSum = 0;
			for ( int j = i; j < n; ++j )
			{
				tempSum += array[j];
				if ( tempSum > maxSum )
				{
					a = i;
					b = j;
					maxSum = tempSum;
				}
				else if ( tempSum == maxSum && j-i < b-a )
				{
					a = i;
					b = j;
					maxSum = tempSum;
				}
					
			}
		}
		
		int[] result = new int[3];
		result[0] = a;
		result[1] = b;
		result[2] = maxSum;
		return result;
	}
	
	
	
	/*static int[] singleArrayKadane ( int[] array, int n ) {	
			
			int b1 = 0;
			int e1 = 0;
			int max1 = 0;
			int curr = 0;
			int b2 = 0;
			
			for ( int i=0; i < n; i++ )
			{ 
				curr = curr + array[i];
				
				if (curr < 0) 
				{ 
					curr = 0; 
					b2 = i+1; 
				} 
				else if (curr > max1) 
				{ 
					max1 = curr; 
					b1 = b2; 
					e1 = i; 
				}
				else if (curr == max1)
				{
					if ( (i - b2) < (e1 - b1) )
					{
						max1 = curr; 
						b1 = b2; 
						e1 = i; 
					}
				}
				
			}
			
			int[] result = new int[3];
			result[0] = b1;
			result[1] = e1;
			result[2] = max1;
			
			return result;		
	
	}*/
	
	static int[] twoDimArrayKadane ( int n, int m, int[][] array ) {
		
		int allNegative = 1;
		int allZeroes = 1;
		
		int startN = 0;
		int startM = 0;
		int endN= 0;
		int endM = 0;		
		int curr = 0;
		int[] tempArr = new int [m];
		int[] tempKadaneRes = new int[3];
		int maxSum = -1;
		
		for ( int i = 0; i < n; ++i )
		{
			for ( int it = 0; it < m; ++it ) //initialising the temporary table
				tempArr[it] = 0;
					
			for ( int j = i; j < n; ++j )
			{
				for ( int k = 0; k < m; ++k )
				{
					tempArr[k] += array[j][k];
					if ( array[i][k] > 0 )
						allNegative= 0;
					if ( array[i][k] != 0 )
					    allZeroes = 0;
				}
				
				if ( curr > 0 )
					allNegative= 0;
					
				tempKadaneRes = singleArrayKadane( tempArr, m );
				curr = tempKadaneRes[2];
				
				if ( curr > maxSum )
				{
					startN = i;
					startM = tempKadaneRes[0];
					endN = j;
					endM = tempKadaneRes[1];
					maxSum = curr;
				}
				else if ( curr == maxSum )
				{
					if ( (endM-startM + 1) * (endN-startN + 1) > (tempKadaneRes[1] - tempKadaneRes[0] + 1) * (j - i + 1) )
					{
						startN = i;
						startM = tempKadaneRes[0];
						endN = j;
						endM = tempKadaneRes[1];
						maxSum = curr;
					}
				}
				
								
			}
			
			
		}
		
		if ( allNegative == 1 )
			maxSum = -1;
			
		int[] result = { startN, endN, startM, endM, maxSum };
		
		if ( allZeroes == 1 )
		{
		    result[0] = 0;
		    result[1] = 0;
		    result[2] = 0;
		    result[3] = 0;
		    result[4] = 0;
		}
		
		return result;		
	}
	
	



	

	
	public static void main(String[] args) {
		
		
		
//		int[][] test = {{ 1, 2, -1, -4, -20 },
//						{ -8, -3, 4, 2, 1 },
//						{ 3, 8, 10, 1, 3 },
//						{ -4, -1, 1, 7, -6 }};
//				
//		//             0  1  2  3  4  5  6  7  8  9
//		
//		int[] result = twoDimArrayKadane( 4, 5, test );
//		
//		System.out.println("The beginning and ending o fthe maximum subset:  " + result[0] + "  " + result[1] + "  " + result[2] + "  " + result[3]);
//		
		Scanner mainScanner = new Scanner(System.in);
		
		int dataSetQuant = 0;
		int dataSetRowCount;
		int dataSetColumnCount;
		int[] finalResultArray = new int[5];
		
		dataSetQuant = mainScanner.nextInt();
		
		for ( int i = 0; i < dataSetQuant; ++i )
		{
			dataSetRowCount = mainScanner.nextInt();
			dataSetColumnCount = mainScanner.nextInt();
			
			int[][] dataArray = new int[dataSetRowCount][dataSetColumnCount];
			
			for ( int j = 0; j < dataSetRowCount; ++j )
				for ( int k = 0; k < dataSetColumnCount; ++k )
					dataArray[j][k] = mainScanner.nextInt();
			
			finalResultArray = twoDimArrayKadane( dataSetRowCount, dataSetColumnCount, dataArray );
			
			if ( finalResultArray[4] == -1 )
				System.out.println(0);
			else
			{
				System.out.println("max_sum=" + finalResultArray[4]);
				System.out.println("[" + finalResultArray[0] + ".." + 
										 finalResultArray[1] + ", " +
										 finalResultArray[2] + ".." +
										 finalResultArray[3] + "]");
			}
			
			
			
			
			
			
			
		}
		
		

	}

}

