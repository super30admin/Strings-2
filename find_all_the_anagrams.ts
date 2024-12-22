function findAnagrams(s: string, p: string): number[] {
  let frequencyMap = new Map();
  for (let index = 0; index < p.length; index++) {
    if (!frequencyMap.has(p.charAt(index))) {
      frequencyMap.set(p.charAt(index), 0);
    }
    frequencyMap.set(p.charAt(index), frequencyMap.get(p.charAt(index))! + 1);
  }
  let result: number[] = [];
  let match = 0;
  for (let high = 0; high < s.length; high++) {
    // Check if it contains char then reduce frequency
    let incomingChar = s.charAt(high);
    if (frequencyMap.has(incomingChar)) {
      let frequency = frequencyMap.get(incomingChar)!;
      frequency -= 1;
      frequencyMap.set(incomingChar, frequency);
      if (frequency == 0) {
        match += 1;
      }
    }

    // reduce the low if length exceed
    if (high >= p.length) {
      let outgoingChar = s.charAt(high - p.length);
      if (frequencyMap.has(outgoingChar)) {
        let frequency = frequencyMap.get(outgoingChar)!;
        frequency += 1;
        frequencyMap.set(outgoingChar, frequency);
        if (frequency == 1) {
          match -= 1;
        }
      }
    }

    // if match is 3 we have an anagram.
    if (match == frequencyMap.size) {
      result.push(high - p.length + 1);
    }
  }

  return result;
}

function findAnagrams_with_pointer(s: string, p: string): number[] {
  let frequencyMap = new Map();
  for (let index = 0; index < p.length; index++) {
    if (!frequencyMap.has(p.charAt(index))) {
      frequencyMap.set(p.charAt(index), 0);
    }
    frequencyMap.set(p.charAt(index), frequencyMap.get(p.charAt(index))! + 1);
  }
  let result: number[] = [];
  let match = 0;
  let low = 0;
  for (let high = 0; high < s.length; high++) {
    // Check if it contains char then reduce frequency
    let incomingChar = s.charAt(high);
    if (frequencyMap.has(incomingChar)) {
      let frequency = frequencyMap.get(incomingChar)!;
      frequency -= 1;
      frequencyMap.set(incomingChar, frequency);
      if (frequency == 0) {
        match += 1;
      }
    }

    // reduce the low if length exceed
    if (high >= p.length) {
      let outgoingChar = s.charAt(low);
      if (frequencyMap.has(outgoingChar)) {
        let frequency = frequencyMap.get(outgoingChar)!;
        frequency += 1;
        frequencyMap.set(outgoingChar, frequency);
        if (frequency == 1) {
          match -= 1;
        }
      }
      low++;
    }

    // if match is 3 we have an anagram.
    if (match == frequencyMap.size) {
      result.push(low);
    }
  }

  return result;
}

// TC: o(n!)
function find_all_anagrams(input: string): string[] {
  if (input.length == 1) {
    return [input];
  }
  let permutation: string[] = [];

  function backtrack(path: string[]) {
    console.log(path);
    if (path.length == input.length) {
      permutation.push(path.join(""));
      return;
    }

    for (let index = 0; index < input.length; index++) {
      let char = input.charAt(index);
      if (path.includes(char)) {
        console.log(char + " existing in path " + path);
        continue;
      }
      path.push(char);
      backtrack(path);
      path.pop();
    }
  }
  backtrack([]);
  return permutation;
}

describe("438. Find All Anagrams in a String", () => {
  it("Happy Path", () => {
    expect(findAnagrams("cbaebabacd", "abc")).toStrictEqual([0, 6]);
  });

  it("Happy Path - With Pointers", () => {
    expect(findAnagrams_with_pointer("cbaebabacd", "abc")).toStrictEqual([
      0, 6,
    ]);
  });
  it("Happy Path - With Pointers", () => {
    expect(find_all_anagrams("abc")).toStrictEqual([
      "abc",
      "acb",
      "bac",
      "bca",
      "cab",
      "cba",
    ]);
  });
});
