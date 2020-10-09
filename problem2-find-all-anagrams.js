//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//runtime:
//space:
//passing leetcode:
//obstacles:
//explanation:
//https://www.youtube.com/watch?v=aDiS4I2l7EY&feature=youtu.be

// /**
// * @param {string} s
// * @param {string} p
// * @return {number[]}
// */
var findAnagrams;

findAnagrams = function(s, p) {
  var E, S, eChar, hashmap, i, match, output, ref, sChar;
  hashmap = new Map();
  output = [];
  S = 0;
  match = 0;
  for (E = i = 0, ref = s.length; (0 <= ref ? i < ref : i > ref); E = 0 <= ref ? ++i : --i) {
    eChar = s[E];
    // Incoming
    if (hashmap.has(eChar)) {
      hashmap.set(eChar, hashmap.get(eChar) - 1);
      if (hashmap.get(eChar) === 0) {
        match += 1;
      }
    }
    // Outgoing
    if ((E - S + 1) > p.length) {
      sChar = s[S];
      if (hashmap.has(sChar)) {
        hashmap.set(sChar, hashmap.get(sChar) + 1);
        if (hashmap.get(sChar) === 1) {
          match -= 1;
        }
      }
    }
    // Add to output
    if (match === hashmap.length) {
      output.push(S);
    }
  }
  return output;
};

//# sourceMappingURL=problem2-find-all-anagrams.js.map
