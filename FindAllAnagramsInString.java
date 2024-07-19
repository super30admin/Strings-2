class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || s.length() == 0 || p.length() == 0){
            return new ArrayList<>();
        }
        int m = s.length();
        int n = p.length();
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for(int i = 0; i < n; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < m; i++){
            char incomm = s.charAt(i);
            if(map.containsKey(incomm)){
                int cnt = map.get(incomm);
                cnt--;
                // 
                if(cnt == 0){
                    match++;
                }
                map.put(incomm,cnt);
                

                }
                if(i >= p.length()){
                    char outgoing = s.charAt(i - p.length());
                    if(map.containsKey(outgoing)){
                        int cnt = map.get(outgoing);
                        cnt++;
                        if(cnt == 1){
                            match--;
                        }
                    
                    map.put(outgoing, cnt);
                    }


                }

                if(match == map.size()){
                    result.add(i - p.length() + 1);
                }
            }
            return result;

        }

        
    }
