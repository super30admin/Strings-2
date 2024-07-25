//Problem 1
// TC O(n*m)
//SC O(1)

class Solution {
    public int strStr(String haystack, String needle) {
     int i=0;
     int k=needle.length();
     //if(haystack.length()==needle.length()&& haystack.equals(needle)) return 0;
    
     while(i+k<=haystack.length())
     {
        String sub=haystack.substring(i,i+k);
        if(sub.equals(needle)) return i;
       i++;
     }
     return -1;
    }
}

//Problem 2
// TC O(n)
//SC O(n)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()==0 || s.length()==0)
        {
            return new ArrayList<>();
        }
        HashMap<Character,Integer> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        int match=0;
        for(int i=0;i<p.length();i++)
        {
            char c= p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);

        }
        for(int i=0;i<s.length();i++)
        {
            char incoming=s.charAt(i);
            if(map.containsKey(incoming))
            {
            int count=map.get(incoming);
            count--;
            if(count==0)
                {
                     match++;
                    }
            map.put(incoming,count);
            }
            // increasing the window size // outgoing
            if(i>=p.length())
            {
                char outgoing=s.charAt(i-p.length());
                if(map.containsKey(outgoing))
                {
                    int count= map.get(outgoing);
                    count++;
                    if(count==1)
                    {
                        match--;
                    }
                    map.put(outgoing,count);
                }
            }
            if(map.size()==match)
            {
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}