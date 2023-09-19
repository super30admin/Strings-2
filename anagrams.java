class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> m = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<p.length();i++)
        {
            int c = p.charAt(i);
            m.put(p.charAt(i),m.getOrDefault(c,0)+1);

        }
        int match = 0;

        for(int i=0;i<s.length();i++)
        {
          char _incoming = s.charAt(i);
          if(m.containsKey(_incoming))
          {
              int cnt = m.get(_incoming)-1;
              if(cnt == 0)
              {
                  match++;
              }
              m.put(_incoming,cnt);

          }
          if(i>=p.length())
          {
              char out = s.charAt(i-p.length());
              if(m.containsKey(out))
              {
                int cnt = m.get(out);
                cnt++;
                if(cnt == 1)
                {
                    match--;
                }
                m.put(out,cnt);

                }
          }
          if(m.size()==match)
          {
              li.add(i-p.length()+1);
          }



    }
    return li;
}
}