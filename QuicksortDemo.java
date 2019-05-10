/* The following code is an implementation of the quicksort algorithm. The quicksort algorithm is one of the most effective ways to sort  
 * an array in ascending order. The quicksort algorithm is a divide and conquer algorithm, and involves dividing the array into two segments 
 * called partions. In order to do this, all elements are compared to the pivot.
 */

import java.util.Arrays;
public class QuicksortDemo
{
  //Passes an array, the starting index and final idex.
  public static void quickSort(int[] arr, int start, int end)
  {
    //The following is used to recursively call the quickSort method.
    int partition = partition(arr, start, end);
    
    //Left partition
    if(partition-1>start) 
    {
      int indexToPrint=partition - 1;
      System.out.println("*** Quicksort occurs recursively with starting position "+start +" and ending position "+indexToPrint + " ***"); 
      quickSort(arr, start, partition - 1);
      System.out.println("Using partition "+ partition + " after quicksort. Array is now "+Arrays.toString(arr));
    }
    
    //Right partition
    if(partition+1<end) {
       int indexToPrint=partition + 1;
      System.out.println("*** Quicksort occurs recursively with starting position " + indexToPrint + " end position "+end + " ***");
      quickSort(arr, partition + 1, end);
      System.out.println("Using partition " + partition + " after quicksort. Array is now "+Arrays.toString(arr));
    }
  }
  
  //Partitions the array.
  public static int partition(int[] arr, int start, int end)
  {
    //Last element is taken as the index.
    int pivot = arr[end];
    System.out.println("Pivot is "+pivot +" based on array start position "+start+ " and end position "+end); 
    
    //Goes through each element of the array.
    for(int i=start; i<end; i++)
    {
      System.out.println ("Is the element " + arr[i] + " at position " + i +" less than the pivot " + pivot + "?");
      if(arr[i]<pivot)
      {
 int temp= arr[start];
 arr[start]=arr[i];
 System.out.println ("Yes it is, swapping " + temp + " at the comparison position " + start + " and " + arr[i] + " at position " + i);
 arr[i]=temp;
 
 //Increments the 'start' or 'i' value, which is used for swapping.
 start++;
 System.out.println("After swap, incremented the comparison position to "+start+". Array is now "+Arrays.toString(arr));
 System.out.println ();
      }
      else
      {
 System.out.println("No, do nothing.");
 System.out.println ();
      }
    }
    
    System.out.println("Reached end of array, swapping values at position " + start + " and pivot position "+end);
    int temp = arr[start];
    arr[start] = pivot;
    arr[end] = temp;
    //Prints array after each iteration.
    System.out.println("The array is now "+Arrays.toString(arr));
    return start;
  }
  
  public static void main(String[] args) 
  {
    long start = System.currentTimeMillis();
    // int[] arr = {331,57,96,3,4,5,66};
 int[] arr = {1,2,3,4,5,6,7};
    System.out.println("Unsorted array "+Arrays.toString(arr));
    quickSort(arr, 0, arr.length-1);
    long end = System.currentTimeMillis();
    long timeElapsed = end - start;
    System.out.println("Final sorted array "+Arrays.toString(arr));
    System.out.println ("The total elapsed time is : " + timeElapsed + "ms.");
  }
  
}
