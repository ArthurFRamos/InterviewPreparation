public void paintFill(int [][] color, int x, int y, int newColor)
{
	int oriColor = color[y][x];
	paintHelper(color,x,y,oriColor,newColor);

}

private void paintHelper(int[][] color, int x, int y, int oriColor, int newColor)
{
	if(x < 0 || y < 0 || x >= color[0].length || y >=color.length)
		return;
	if(color[y][x] != oriColor)
		return;
	
	color[y][x] = newColor;
	
	paintHelper(color, x-1, y, oriColor, newColor);
	paintHelper(color, x + 1, y, oriColor, newColor);
	paintHelper(color, x, y-1, oriColor, newColor);
	paintHelper(color,x, y+1, oriColor, newColor);
}