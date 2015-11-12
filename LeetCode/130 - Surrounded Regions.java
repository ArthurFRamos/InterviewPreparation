public class Solution {
    
    class Pair
    {
        public int x;
        public int y;
        
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    boolean visited[][];
    public void solve(char[][] board) {
        
        if(board.length == 0)
            return;
            
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 'O' && !visited[i][j])
                    capture(board,i,j);
            }
        }
    }
    
    
	private void capture(char[][] board, int x, int y)
	{
		boolean toCapture = true;

		Stack<Pair> stack = new Stack<>();

		stack.push(new Pair(x,y));

		Pair current;
		ArrayList<Pair> helper = new ArrayList<>();
		
		while(!stack.isEmpty())
		{
			current = stack.peek();

			if(visited[current.x][current.y])
			{
				helper.add(current);
				stack.pop();
			}

			else
			{
				visited[current.x][current.y] = true;

				if(current.x == 0 || current. y == 0 || current.x == board.length - 1 || current.y == board[0].length - 1)
					toCapture = false;
				
				if(current.x != board.length - 1)
					if(board[current.x + 1][current.y] == 'O' && !visited[current.x + 1][current.y])
						stack.push(new Pair(current.x +1, current.y));
				if(current.x != 0)
					if(board[current.x -1][current.y] == 'O' && !visited[current.x -1][current.y])
						stack.push(new Pair(current.x -1, current.y));
				if(current.y != board[0].length - 1)
					if(board[current.x][current.y + 1] == 'O' && !visited[current.x ][current.y + 1])
						stack.push(new Pair(current.x, current.y + 1));
				if(current.y != 0)
					if(board[current.x][current.y -1] == 'O' && !visited[current.x][current.y - 1])
						stack.push(new Pair(current.x, current.y - 1));

			}
		}
		
		for(Pair i : helper)
			if(toCapture)
				board[i.x][i.y] = 'X';
	}
    
}