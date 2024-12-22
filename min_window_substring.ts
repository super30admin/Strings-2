function minWindow(s: string, t: string): string {
  if (t.length === 0 || s.length === 0) {
    return "";
  }

  const frequencyMap = new Map<string, number>();
  for (const char of t) {
    frequencyMap.set(char, (frequencyMap.get(char) || 0) + 1);
  }

  let left = 0;
  let right = 0;
  let match = 0;
  let minLen = Infinity;
  let result = "";

  while (right < s.length) {
    const charAtRight = s[right];

    if (frequencyMap.has(charAtRight)) {
      const newCount = frequencyMap.get(charAtRight)! - 1;
      frequencyMap.set(charAtRight, newCount);

      if (newCount === 0) {
        match++;
      }
    }

    while (match === frequencyMap.size) {
      if (right - left + 1 < minLen) {
        minLen = right - left + 1;
        result = s.substring(left, right + 1);
      }

      const charAtLeft = s[left];

      if (frequencyMap.has(charAtLeft)) {
        const newCount = frequencyMap.get(charAtLeft)! + 1;
        frequencyMap.set(charAtLeft, newCount);

        if (newCount > 0) {
          match--;
        }
      }
      left++;
    }
    right++;
  }

  return result;
}

describe("76. Minimum Window Substring", () => {
  it("Happy Path", () => {
    expect(minWindow("EADOBECODEBANC", "ABC")).toStrictEqual("BANC");
  });

  it("Negative Path", () => {
    expect(minWindow("bdab", "ab")).toStrictEqual("ab");
  });
});
