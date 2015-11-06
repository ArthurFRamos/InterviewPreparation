 public static void mergeSortedArrays(int[] B, int [] A, int b, int a)
   {
	   int positionB = b - 1;
	   int positionA = a - 1;
	   int currentPos = B.length - 1;
	   
	   while (positionB >= 0 && positionA >= 0)
	   {
		   if(B[positionB] > A[positionA])
		   {
			   B[currentPos] = B[positionB];
			   positionB--;
		   }
		   else
		   {
			   B[currentPos] = A[positionA];
			   positionA--;
		   }
		   
		   currentPos--;
	   }
	   while(positionA >= 0)
	   {
		   B[currentPos] = A[positionA];
		   positionA--;
		   currentPos--;
	   }
   }