//https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Time Complexity :O(n)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result=new ArrayList<>();
        
        HashMap<Character,Integer> map=new HashMap<>();//frequency map
        for(int i=0;i<p.length();i++)
        {
            char c=p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            
        }
        System.out.println(map);
        int match=0;
        for(int i=0;i<s.length();i++)
        {
            char in=s.charAt(i);
            if(map.containsKey(in))
            {
                int cnt=map.get(in);
                cnt--;
                map.put(in,cnt);
                if(cnt==0) //means all the occurences of the character are there in the window
                    match++;
            }
            if(i>=p.length())
            {
                char out=s.charAt(i-p.length());
                if(map.containsKey(out))
                {
                    int cnt=map.get(out);
                    cnt++;
                    map.put(out,cnt);
                    if(cnt==1) //one of the occurence of character is not there so reduce match
                        match--;
                }
            }
            if(match==map.size())
                result.add(i-p.length()+1);
        }
        return result;
        
    }
}