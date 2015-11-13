public void rotate(int[][] matrix) {
	rotateHelper(0,matrix.length, matrix);
}

private void rotateHelper(int begin, int size, int[][] matrix)
{
	if(size <= 0)
		return;
	
	size = size - 1;
	
	for(int i = 0; i < size; i++)
	{
		int temp = matrix[begin][begin + i];
		matrix[begin][begin + i] = matrix[begin + size - i][begin];
		matrix[begin + size - i][begin] = matrix[begin + size][begin + size - i];
		matrix[begin + size][begin + size - i] = matrix[begin + i][begin + size];
		matrix[begin + i][begin + size] = temp;
	}
	
	rotateHelper(begin + 1, size -1, matrix);
}
