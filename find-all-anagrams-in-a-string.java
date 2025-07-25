//Brute force: 
//make all possible substrings of p: TC = O(m*n), m is length of s, n is length of p
//option-1:use hashmap to find anagram: TC = O(n), SC=O(1). total TC = O(mn^2)
//option-2:sorting: TC=O(nlogn). total TC=O(m*n^2(logn))

//Two pointers:Sliding window
//hashmap(frequency map) for s, hashmap(frequency map) for p
//TC = O(26n) = O(n)

//Sliding window:
//using one hashmap & one variable/counter 'match'
//TC = O(m+n), m is smaller than n here = O(n)
//SC = O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null || p==null || s.length() == 0 || p.length()==0){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int m = p.length();
        int n = s.length();
        for(int i =0; i<m; i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int match = 0;
        for(int i =0; i<n; i++){
            //incoming element
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                if(count == 0) match++;
            }

            //outgoing element
            if(i >= m){ //till index 4, outgoing doesn't start
                char out = s.charAt(i-m);
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out,count);
                    if(count == 1) match--;
                }
            }
            if(match == map.size()){
                result.add(i - m + 1); //starting index of string
            }
        }
        return result;
    }
}