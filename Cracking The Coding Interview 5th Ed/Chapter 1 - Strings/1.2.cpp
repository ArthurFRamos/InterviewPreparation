void reverseString(char* string)
{
	int size = 0;

	for (int i = 0; string[i] != '\0'; i++)
		size++;

	printf("%d\n", size);
	for (int i = 0; i < size / 2; i++)
	{
		char temp = string[i];
		string[i] = string[size - 1 - i];
		string[size - 1 - i] = temp;
	}
}