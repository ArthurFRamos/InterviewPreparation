class TreeNode
{
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode(int val)
	{
		this.val = val;
		left = null;
		right = null;
	}
}

class Tree
{
	TreeNode root;
	
	public void add(TreeNode add)
	{
		if(root == null)
		{
			root = add;
			return;
		}
		
		TreeNode current = root;
		
		while(current != null)
		{
			if(add.val <= current.val)
			{
				if(current.left == null)
				{
					current.left = add;
					break;
				}
				else
					current = current.left;
			}
			else
			{
				if(current.right == null)
				{
					current.right = add;
					break;
				}
				else
					current = current.right;
			}
		}
	}
}

public class IntegerStream {
	
	private Tree stream;
	private boolean hasFound;
	private int count;
	
	public IntegerStream()
	{
		this.stream = new Tree();
	}
	
	public void track(int x)
	{
		TreeNode current = new TreeNode(x);
		stream.add(current);
	}
	
	public int getRank(int rank)
	{
		hasFound = false;
		count = 0;
		rankHelper(stream.root,rank);
		return count;
	}
	
	private void rankHelper(TreeNode current, int rank)
	{

		if(hasFound)
			return;
		
		if(current == null)
			return;
		
		rankHelper(current.left,rank);
		
		if(hasFound)
			return;
		
		count++;
		
		if(current.val == rank)
		{
			hasFound = true;
			return;
		}
	
		rankHelper(current.right,rank);
	}