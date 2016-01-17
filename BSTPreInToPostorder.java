//Pawel Adamczuk - 1

/*
 * The goal of this program is to output a preorder or postorder  binary search tree walk 
 *node order having as input an inorder walk node order and either postorder or preorder walk 
 *node order respectively (doing do efficiently, without actually constructing the tree).
 *import java.util.Scanner;
*/

public class Source {

  private static StringBuilder tempStr = new StringBuilder();
  
  public static void generatePostorder (int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
    if (preEnd < preStart)
      return;
//    else if (preEnd - preStart + 1 == 3)
//    {
//      System.out.print(pre[preStart + 1]);
//      System.out.print(" ");
//      System.out.print(pre[preStart + 2]);
//      System.out.print(" ");
//      System.out.print(pre[preStart]);
//      System.out.print(" ");
//      return;
//    }
    else if (preEnd - preStart + 1 == 2)
    {
      tempStr.append(pre[preStart + 1]);
      tempStr.append(" ");
      tempStr.append(pre[preStart]);
      tempStr.append(" ");    
      return;
    }
    else if (preEnd - preStart + 1 == 1)
    {
      tempStr.append(pre[preStart]);
      tempStr.append(" ");
      return;
    }
    else //call recursion
    {
      int i = 0;
      while (in[inStart + i] != pre[preStart])
        ++i;
      // in[inStart + i] == pre[preStart]
      generatePostorder(pre, in, preStart + 1, preStart + i, inStart, inStart + i - 1 ); //left subtree
      generatePostorder(pre, in, preStart + 1 + i, preEnd, inStart + i + 1, inEnd); //right subtree      
      tempStr.append(pre[preStart]);
      tempStr.append(" ");      
    }    
  }
  
  public static void generatePreorder (int[] post, int[] in, int postStart, int postEnd, int inStart, int inEnd)
  {
    if (postEnd < postStart)
      return;
    /*else if (postEnd - postStart + 1 == 3)
    {
      System.out.print(post[postStart + 2]);
      System.out.print(" ");
      System.out.print(post[postStart]);
      System.out.print(" ");
      System.out.print(post[postStart + 1]);
      System.out.print(" ");
      return;
    }*/
    else if (postEnd - postStart + 1 == 2)
    {
      tempStr.append(post[postStart + 1]);
      tempStr.append(" ");
      tempStr.append(post[postStart]);
      tempStr.append(" ");    
      return;
    }
    else if (postEnd - postStart + 1 == 1)
    {
      tempStr.append(post[postStart]);
      tempStr.append(" ");
      return;
    }
    else //call recursion
    {
      int i = 0;
      while (in[inStart + i] != post[postEnd])
        ++i;
      // in[inStart + i] == post[postStart]
      
      tempStr.append(post[postEnd]);
      tempStr.append(" ");  
      generatePreorder(post, in, postStart, postStart + i - 1, inStart, inStart + i - 1 ); //left subtree
      generatePreorder(post, in, postStart + i, postEnd - 1, inStart + i + 1, inEnd); //right subtree         
    }    
  }
  
  
  public Source() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    
    
    
    // TODO Auto-generated method stub
    
    
    //           0  1  2  3  4  5  6  7 
    //int pre[] = {1, 2, 4, 8, 5, 7, 3, 6};
    //int in[] =  {8, 4, 2, 5, 7, 1, 6, 3};
    
//    int pre[] = {1, 2, 4, 8, 5, 9, 3, 6, 7, 10, 11};
//    int in[] = {8, 4, 2, 5, 9, 1, 6, 3, 10, 7, 11}; 
//    int post[] = {8, 4, 9, 5, 2, 6, 10, 11, 7, 3, 1};
//    
//    Source.generatePostorder(pre, in, 0, 10, 0, 10);
//    System.out.println();
//    Source.generatePreorder(post, in, 0, 10, 0, 10);
    
    
    
    
  //int post[]= {8, 4, 7, 5, 2, 6, 3, 1};
    
/*
 *                      1        
 *              2               3
 *          4       5        6
 *       8             7 
 *  
 */
    
Scanner mainScanner = new Scanner(System.in);
    
    int setCount = mainScanner.nextInt();
    int length;
    String temp;
    int arr[] = new int[10000];
    int in[] = new int[10000];
    for (int i = 0; i < setCount; ++i)
    {
      length = mainScanner.nextInt();
      
      temp = mainScanner.next();
      for (int j = 0; j < length; ++j)
        arr[j] = mainScanner.nextInt();
      mainScanner.next();
      for (int j = 0; j < length; ++j)
        in[j] = mainScanner.nextInt();
      
      if (temp.equals("POSTORDER"))
      {
        Source.generatePreorder(arr, in, 0, length - 1, 0, length - 1);
      }
      else
      {
        Source.generatePostorder(arr, in, 0, length - 1, 0, length - 1);
      }
      System.out.println(tempStr);
      tempStr.setLength(0);
    }

  }

}
