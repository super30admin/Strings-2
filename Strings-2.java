//1.first occurence
//Time Complexity - > O(n)
//Space Complexity - > O(1)
class Solution {
    //Brute force
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m>n) return -1;
        int i = 0;
        int j = 0;
        while( i<=n-m){
            int k = i;
            if(haystack.charAt(k) == needle.charAt(j)){
                while(haystack.charAt(k) == needle.charAt(j)){
                j++;
                k++;
                if(j == m){
                return i;
                }
            }
            j = 0;  
        }
          
        i++;  
            
        }

        return -1;
        
    }
}

//2nd Find All anagrams in a string
//Time Complexity - > O(n)
//Space Complexity -> O(26)-> O(1)
class Solution {
    //Slinding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length(); int m = p.length();
        for(int i = 0; i < m;i++){
            char ch = p.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                int count = map.get(ch);
                count = count + 1;
                map.put(ch,count);
            }
        }
        int match = 0;
        for(int i = 0 ; i < n;i++){
            char in = s.charAt(i);
            //incoming character of the sliding window
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                if(count == 0){
                    match++;
                }
            }
            if(i>=m){
                char out = s.charAt(i-m);
                //outgoing character of the sliding window
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out,count);
                    if(count == 1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i-m+1);
            }


        }
        return result;
    }
}