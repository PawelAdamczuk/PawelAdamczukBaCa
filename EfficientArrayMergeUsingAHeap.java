//Pawel Adamczuk - 1

//Merge 'n' sorted Integer arrays not longer than 'm' in O(m*n*log(n)) time, using O(n) memory

import java.util.Scanner;

public class Source {
  
  private static class MinHeap {
    private primitiveStack[] mainArray;
    private int currentRange;
    
    public MinHeap(int size) {
      currentRange = -1;
      mainArray = new primitiveStack[size];
    }
    
    public int pop() {
      int temp = mainArray[0].returnTop();
      if ( mainArray[0].decrease() )
      {//exists
        heapify(0);
      }
      else
      {//ceases to exist
        swap(0, currentRange);
        --currentRange;
        heapify(0);
      }
      return temp;
    }
    
    public void heapify (int i)
    {
      int l = leftChild(i);
      int r = rightChild(i);
      int smallest;
      if (l <= currentRange && mainArray[l].returnTop() < mainArray[i].returnTop())
        smallest = l;
      else
        smallest = i;
      if (r <= currentRange && mainArray[r].returnTop() < mainArray[smallest].returnTop())
        smallest = r;
      if (smallest != i)
      {
        swap(i, smallest);
        heapify(smallest);
      }     
    }
    
    public void addElement(primitiveStack elem) {
      ++currentRange;
      mainArray[currentRange] = elem;
    }    
    
    public void buildHeap() {
      for (int i = parent(currentRange); i >= 0; --i)
      {
        heapify(i);
      }
    }
    private int parent(int i)
    {
      return (i - 1) / 2;
    }
    
    private int leftChild(int i)
    {
      return 2 * i + 1;
    }
    
    private int rightChild(int i)
    {
      return 2 * i + 2;
    }
    
    private void swap(int a, int b) {
      primitiveStack temp = mainArray[a];
      mainArray[a] = mainArray[b];
      mainArray[b] = temp;
    }
    
    
  }

  private class EmptyStackException extends Exception {    
  }
  
  private static class primitiveStack {
    private int top;
    public int[] arr;
    
    public primitiveStack (int[] arr) {
      this.arr = arr;
      this.top = 0;      
    }
    
    public boolean decrease() { // true - stack exists, false - stack empty
      ++top;
      if (top < arr.length)
        return true;
      else
        return false;
    }
    
    public int returnTop() /*throws EmptyStackException*/  {
//      if (top > -1)
//      {
        return this.arr[top];
//      }
//      else
//        throw new EmptyStackException();
    }
  }

  public Source() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    
    Scanner mainScanner = new Scanner(System.in);
    
    StringBuilder tempStr = new StringBuilder("");
    
    int setCount = mainScanner.nextInt();
    int length;
    for (int i = 0; i < setCount; ++i)
    {
      int sequenceCount = mainScanner.nextInt();
      int elemCount = 0;
      int[] lengths = new int[sequenceCount]; 
      for (int j = 0; j < sequenceCount; ++j)
      {
        lengths[j] = mainScanner.nextInt();
        elemCount += lengths[j];
      }
      MinHeap mainHeap = new MinHeap(sequenceCount);
      
      for (int j = 0; j < sequenceCount; ++j)
      {
        int[] tempArr = new int[lengths[j]];
        for (int k = 0; k < lengths[j]; ++k)
        {
          tempArr[k] = mainScanner.nextInt();
        }
        primitiveStack tempStack = new primitiveStack(tempArr);
        mainHeap.addElement(tempStack);
      }
      
      mainHeap.buildHeap();
      
      for (int l = 0; l < elemCount; ++l)
      {
        tempStr.append(mainHeap.pop());
        tempStr.append(" ");
      }
      
      System.out.println(tempStr);      
      tempStr.setLength(0);
    }

  }

}
