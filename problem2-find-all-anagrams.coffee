#https://leetcode.com/problems/find-all-anagrams-in-a-string/
#runtime:
#space:
#passing leetcode:
#obstacles:
#explanation:
#https://www.youtube.com/watch?v=aDiS4I2l7EY&feature=youtu.be
#
# /**
# * @param {string} s
# * @param {string} p
# * @return {number[]}
# */
findAnagrams = (s, p) ->
  hashmap = new Map()

  output = []
  S = 0
  match = 0
  for E in [0...s.length]
    eChar = s[E]

    # Incoming
    if hashmap.has(eChar)
      hashmap.set(eChar, hashmap.get(eChar) - 1)
      if hashmap.get(eChar) is 0
        match += 1

    # Outgoing
    if (E - S + 1) > p.length
      sChar = s[S]
      if hashmap.has(sChar)
        hashmap.set(sChar, hashmap.get(sChar) + 1)
        if hashmap.get(sChar) is 1
          match -= 1

    # Add to output
    if match is hashmap.length
      output.push(S)

  output
