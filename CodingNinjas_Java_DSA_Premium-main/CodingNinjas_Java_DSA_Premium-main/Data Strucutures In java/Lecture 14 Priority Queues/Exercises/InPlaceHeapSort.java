//here in place Heap sort will chnage space complexity from O(n) to 0(1).
public class InPlaceHeapSort {
    // coding ninjas solution
    public static void inplaceHeapSort(int input[]) {
       for(int i=0;i<input.length;i++){
           insertIntoVirtualHeap(input, i); //here we pass the array and the index
       }
       for(int i: input) {
    	   System.out.print(i+ " "); //this will print the array in the form of a heap 0 1 2 6 5 9
       }
       System.out.println();
       //now we remove all elements from the heap
       for(int i=0;i<input.length;i++) {
    	   input[input.length-1-i]=removeMinFromVirtaulHeap(input, input.length-i); //input.length-i is the size of heap, every time the heap size will decrease when we remove an element from the Heap
    	   //here when we remove the first minElemnt we place at it arr.legth-1 position when i=0, for 2nd minElement we place it at arr.length -1-1 , arr.length-i, hence the formula
    	   
         }
    }

    private static int removeMinFromVirtaulHeap(int[] input, int heapSize) {
	  int minElement = input[0]; //in heap the minElemnt will always be at the head/root
	  System.out.println(minElement);
	  input[0]=input[heapSize-1]; //place the last element from the array to the top/root/head
	  //remove the last element
	  heapSize--;
	  //Now we do down heapify from root to leaf or from 0 to end of the array
	  int parentIndex=0;
	  int leftChildIndex = 2*parentIndex +1;
	  int rightChildIndex = 2*parentIndex +2;
	  //we run the loop till we reach the leaf node
	  while(leftChildIndex<heapSize) {
		  int minIndex = parentIndex;
		  //compare with the left child, if it is less then swap
		  if(input[leftChildIndex]<input[minIndex]) {
			  minIndex = leftChildIndex;
		  }if(rightChildIndex<heapSize && input[rightChildIndex]<input[minIndex]) {
			  minIndex = rightChildIndex;
		  }
		  if(minIndex!=parentIndex) {
			  int temp = input[parentIndex];
			  input[parentIndex] = input[minIndex];
			  input[minIndex] = temp;
			  parentIndex = minIndex;
			  leftChildIndex = 2*parentIndex +1;
			  rightChildIndex = 2*parentIndex +2;
		  }else {
			  break; //come out of the while loop
		  }
	  }
	  return minElement;
		
	}

	private static void insertIntoVirtualHeap(int[] input, int i) {
        //here just now we have inserted the ith element, so childIndex is i
    	int childIndex = i;
    	int parentIndex = (childIndex-1)/2;
    	//here we are adding, whenever we are adding we go from leaf to root/head, end of array to start
    	//so we do upHeapify here
    	while(childIndex >0) {
    		if(input[childIndex]<input[parentIndex]) {
    			//if child has less priority than parent then swap
    			int temp = input[childIndex];
    			input[childIndex] = input[parentIndex];
    			input[parentIndex] = temp;
    			childIndex = parentIndex;
    			parentIndex = (childIndex-1)/2;
    		}else {
    			return; //this will return from the while loop
    		}
    	}
    }

    // Driver Code to check the solution
    public static void main(String[] args) {
        int[] input = { 2,6,8,5,4,3};
        inplaceHeapSort(input);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

}
