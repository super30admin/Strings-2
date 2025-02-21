class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null || p==null || s.length() == 0 || p.length() == 0){
            return new ArrayList<>();
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                count--;
                if(count == 0){
                    match++;
                }
                map.put(c, count);
            }

            if(i >= p.length()){
                c = s.charAt(i - p.length());
                if(map.containsKey(c)) {
                    int count = map.get(c);
                    count++;
                    if(count == 1){
                        match--;
                    }
                    map.put(c, count);
                }
            }

            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
