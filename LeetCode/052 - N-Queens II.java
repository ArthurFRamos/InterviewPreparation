LeetCode OJ
LeetCode Premium Subscription
Problems 
Pick One!
Courses
Discuss
Book
Articles
arthur13 
N-Queens II My Submissions Question
Total Accepted: 35946 Total Submissions: 97006 Difficulty: Hard
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.



Subscribe to see which companies asked this question

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss




1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
public class Solution {
    
    private int grid;
    private int count;
    
    public int totalNQueens(int n) {
        grid = n;
        count = 0;
        int [] columns = new int[n];
        
        backTrack(0, columns);
        
        return count;
    }
    
    private void backTrack(int row, int [] columns)
    {
        if(row == grid)
            count++;
        else
        {
            for(int i = 0; i < grid; i++)
            {
                if(canPutQueen(columns,row,i))
                {
                    columns[row] = i;
                    backTrack(row + 1, columns);   
                }
            }
        }
    }
    
    private boolean canPutQueen(int[] columns, int row, int column)
    {
        
        for(int i = 0; i < row; i++)
        {
            int current = columns[i];
            
            if(current == column)
                return false;
            
            int columnDistance = Math.abs(column - current);
            
            int rowDistance = row - i;
            
            if(columnDistance == rowDistance)
                return false;
        }
        
        return true;
    }
}
Submit Solution Judge service is not available now.
Frequently Asked Questions | Terms of Service



Copyright © 2015 LeetCode

Send Feedback