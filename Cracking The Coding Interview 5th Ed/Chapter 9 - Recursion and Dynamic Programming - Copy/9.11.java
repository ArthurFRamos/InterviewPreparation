package Exercises;

import java.util.HashMap;

public class ExpressionEvaluator {

	HashMap<String,Integer> pd;
	
	public int countExp(String exp, boolean result)
	{
		pd = new HashMap<>();
		return evaluateExp(0,exp.length() - 1, result, exp);
	}
	private int evaluateExp(int begin, int end, boolean result, String exp)
	{
		String current = exp.substring(begin, end + 1);

		if(pd.containsKey(current))
			return pd.get(current);

		if(begin == end)
		{
			if(result && (exp.charAt(begin) == '1'))
				return 1;
			else if(!result && (exp.charAt(begin) == '0'))
				return 1;
			else
				return 0;
		}
		int c = 0;
		for(int i = begin + 1; i <= end; i += 2)
		{
			char op = exp.charAt(i);

			if(result)
			{
				if(op == '&')
					c += evaluateExp(begin, i - 1, true, exp) * evaluateExp(i + 1, end, true, exp);
				else if(op == '|')
				{
					c += evaluateExp(begin, i - 1, true, exp) * evaluateExp(i + 1, end, false, exp);
					c += evaluateExp(begin, i - 1, true, exp) * evaluateExp(i + 1, end, true, exp);
					c += evaluateExp(begin, i - 1, false, exp) * evaluateExp(i + 1, end, true, exp);
				}
				else
				{
					c += evaluateExp(begin, i- 1, true, exp) * evaluateExp(i + 1, end, false, exp);
					c += evaluateExp(begin, i- 1, false, exp) * evaluateExp(i + 1, end, true, exp);
					c += evaluateExp(begin, i- 1, false, exp) * evaluateExp(i + 1, end, false, exp);
				}
			}
			else
			{
				if(op == '&')
				{
					c += evaluateExp(begin, i - 1, false, exp) * evaluateExp(i + 1, end, true, exp);
					c += evaluateExp(begin, i - 1, true, exp) * evaluateExp(i + 1, end, false, exp);
				}
				else if(op == '|')
				{
					c += evaluateExp(begin, i - 1, false, exp) * evaluateExp(i + 1, end, false, exp);
				}
				else
				{
					c += evaluateExp(begin, i - 1, true, exp) * evaluateExp(i + 1, end, true, exp);
					c += evaluateExp(begin, i - 1, false, exp) * evaluateExp(i + 1, end, false, exp);
				}
			}
		}
		
		pd.put(current, c);
		
		return c;
	}
}
