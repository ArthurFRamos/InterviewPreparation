
public class ClosestNode {
	
	private TreeNode root;
	private int closer;
	private int k;
	
	public ClosestNode(TreeNode root, int k)
	{
		this.root = root;
		this.k = k;
	}
	
	public void closest()
	{
		closest(root,Integer.MAX_VALUE);
	}
	private void closest(TreeNode node, int closest)
	{
		if(node == null)
			return;
		
		int diff = Math.abs(node.val - k);
		if(diff < closest)
		{
			closest = diff;
			closer = node.val;
		}
		if(k > node.val)
			closest(node.right,closest);
		else if(k < node.val)
			closest(node.left,closest);
	}
	
	public static void main(String[] args)
	{
		
		TreeNode root = new TreeNode(32);
		root.left = new TreeNode(24);
		root.right = new TreeNode(41);
		root.left.left = new TreeNode(21);
		root.left.right = new TreeNode(28);
		root.left.left.left = new TreeNode(14);
		root.left.right.left = new TreeNode(25);
		root.left.right.right = new TreeNode(31);
		root.right.left = new TreeNode(36);
		root.right.right = new TreeNode(47);
		root.right.left.right = new TreeNode(39);
		ClosestNode c = new ClosestNode(root, 29);
		c.closest();
		System.out.println(c.closer);
	}
}
