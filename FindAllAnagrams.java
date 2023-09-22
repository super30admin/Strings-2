//TC = O(n)
//SC = O(1)
// Here we are using map to keep count of char.
// We will keep track of incoming an outgoing char.

class FindAllAnagrams{

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Chracter, Integer> hmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(c,0)+1);
        }
        int match = 0;
        for(int i = 0; i<s.length; i++){
            //in
            char in  = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                if(count == 0) match++;
                map.put(in,count);
            }
            //out.
            if(i>p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                int count = map.get(out);
                count++;
                if(count == 1) match--;
                map.put(out,count);
            }
            }
            if(map.size()==match){
                result.add(i-p.length()+1);
            }
        }
return result;
    }

 }
