// Time Complexity :O(M+N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m= s.length(); 
        int n= p.length();
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char c= p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match=0;
        List<Integer> result= new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            char in= s.charAt(i);
            if(map.containsKey(in))
            {
                int freq=map.get(in);
                freq--;
                map.put(in,freq);
                
                if(freq==0)
                match++;

            }
            if(i>=n)
            {
                char out =s.charAt(i-n);
                if(map.containsKey(out))
                {
                    int freq= map.get(out);
                    freq++;
                    map.put(out,freq);

                    if(freq ==1)
                    match--;

                }
            }
            if(map.size()==match)
            {
                result.add(i-n+1);
            }
        }
        return result;
    }
}