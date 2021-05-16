//Time Complexity:O(s+p)
//Space Complexity:O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int len=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int count=map.get(c);
                count--;
                map.put(c,count);
                if(count==0)len++;
            }
            if(i>=p.length()){
                char out =s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int count=map.get(out);
                    count++;
                    map.put(out,count);
                    if(count==1)len--;
                }
            }
            if(len==map.size()){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}