//TC:O(m+n)
//SC:O(1)
//FAcebook
//using 2 pointer slow and fast pointer, the variable called match used to how many character are matched to it.First mart the p list characters count in hashmap if it found in string s then remove the character from hashmap and count the character matches from 0 to 1.Then move the fast pointer forward and check again if it found do it continuously after completion of p list count reaches to 0 then move the slow pointer forward and the distance between slow and fast point is p arraylist character length and check the value in hashmap if it going out of bound then length of the window exceeds then left behind the fast pointer if its count =1 then decrement the match or if it "in" the move forward the fast pointer and increment the match.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if((s==null||s.length()==0) || p.length()>s.length()){
            return new ArrayList<>();
        }
        //lower case 26 characters in Hashmap
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0){
                    match++;
                }
                map.put(in,cnt);
            }
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt ==1){
                        match--;
                    }
                    map.put(out,cnt);
                }
            }
            if(match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}