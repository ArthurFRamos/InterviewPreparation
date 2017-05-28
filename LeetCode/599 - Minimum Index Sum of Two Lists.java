public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> best = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i],i);
        
        for(int i = 0; i < list2.length;i++)
        {
            if(map.containsKey(list2[i]))
            {
                int index = map.get(list2[i]) + i;
                if(index == indexSum)
                    best.add(list2[i]);
                else if(index < indexSum)
                {
                    best = new ArrayList<>();
                    best.add(list2[i]);
                    indexSum = index;
                }
            }
        }
        
        String[] ans = new String[best.size()];
        
        for(int i = 0; i < ans.length; i++)
            ans[i] =  best.get(i);
        
        return ans;
    }
}