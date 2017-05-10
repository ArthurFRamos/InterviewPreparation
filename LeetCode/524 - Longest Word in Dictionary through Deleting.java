public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String currentAnswer = "";
        
        for(int i = 0; i < d.size(); i++)
        {
     
            String temp = d.get(i);
            if(isSubsequence(s,temp))
            {
                if(temp.length() > currentAnswer.length())
                    currentAnswer = temp;
                else if(temp.length() == currentAnswer.length())
                    if(temp.compareTo(currentAnswer) < 0)
                        currentAnswer = temp;
            }
        }
        return currentAnswer;
    }
    
    public boolean isSubsequence(String s, String d)
    {
        int[][] matrix = new int[d.length() + 1][s.length() + 1];
        
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[i].length; j++)
            {
                if(s.charAt(j - 1) == d.charAt(i - 1))
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
            }
        }
        
        if(matrix[d.length()][s.length()] == d.length())
            return true;
        
        return false;
    }
}