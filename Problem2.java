class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int c;
        for(int i=0;i<p.length();i++){
            c = p.charAt(i)-'a';

            map.put(c, map.getOrDefault(c,0)+1);
        }

        int match = 0;
        int count;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i) - 'a';

            if(map.containsKey(c)){
                count = map.get(c);
                map.put(c, count-1);

                if(count == 1)
                    match ++;
            }

            if(i>=p.length()){
                c = s.charAt(i-p.length())-'a';
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);

                    if(map.get(c)==1)
                        match --;
                }

            }

            if(match == map.size())
                result.add(i-p.length()+1);
        }
        return result;
    }
}