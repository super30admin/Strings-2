import { lchown } from "graceful-fs";

// Brute Force O(mxn)
function strStr(haystack: string, needle: string): number {
  let result: number = 0;
  let n = haystack.length;
  let m = needle.length;

  let left = 0;
  while (left < n - m) {
    let comparision = 0; // pointer at needle
    if (haystack.charAt(left) == needle.charAt(comparision)) {
      let right = left;
      while (haystack.charAt(right) == needle.charAt(comparision)) {
        right++;
        comparision++;
        if (comparision == m) {
          return left;
        }
      }
    }
    left++;
  }
  return result;
}

function strStr_with_rolling_hash(haystack: string, needle: string): number {
  let n = haystack.length;
  let m = needle.length;
  let letterCount: number = 26;
  let prime = 100001; // Max Input Value
  let posFactor = 1;

  for (let index = 0; index < m; index++) {
    posFactor = (posFactor * 26) % prime;
  }
  function getHashOfChar(char: string): number {
    return char.charCodeAt(0) - "a".charCodeAt(0) + 1;
  }

  let needleHash = 0;
  for (let index = 0; index < needle.length; index++) {
    needleHash =
      (needleHash * letterCount + getHashOfChar(needle.charAt(index))) % prime;
  }

  console.log("Needle Hash = " + needleHash);
  // Sliding Window
  let left = 0;
  let rollingHash = 0;
  for (let right = 0; right < n; right++) {
    let inChar = haystack.charAt(right);
    let inCharHash = getHashOfChar(inChar);
    rollingHash = (rollingHash * letterCount + inCharHash) % prime;

    if (right >= m) {
      // Remove contribution of left value
      let outChar = haystack.charAt(right - m);
      let outCharHash = getHashOfChar(outChar);
      rollingHash = (rollingHash - posFactor * outCharHash) % prime;
      left++;
    }

    if (rollingHash < 0) {
      rollingHash = rollingHash + prime;
    }
    console.log("Rolling Hash Final " + rollingHash);
    if (rollingHash == needleHash) {
      return left;
    }
  }
  return -1;
}

function minimizeResult(expression: string): string {
  const [num1, num2] = expression.split("+"); // Split into two parts
  let minValue = Infinity;
  let result = "";

  // Try all possible positions for parentheses
  for (let i = 0; i < num1.length; i++) {
    // Position for '(' in num1
    for (let j = 1; j <= num2.length; j++) {
      // Position for ')' in num2
      // Split num1 and num2 into parts
      const num1Left = num1.substring(0, i); // Before '('
      const num1Right = num1.substring(i); // After '('
      const num2Left = num2.substring(0, j); // Before ')'
      const num2Right = num2.substring(j); // After ')'

      // Calculate the expression value
      const leftMultiplier = num1Left ? parseInt(num1Left) : 1;
      const middleSum = parseInt(num1Right) + parseInt(num2Left);
      const rightMultiplier = num2Right ? parseInt(num2Right) : 1;

      const currentValue = leftMultiplier * middleSum * rightMultiplier;

      // Update the result if a smaller value is found
      if (currentValue < minValue) {
        minValue = currentValue;
        result = `${num1Left}(${num1Right}+${num2Left})${num2Right}`;
      }
    }
  }

  return result;
}

describe("28. Find the Index of the First Occurrence in a String", () => {
  describe("Brute Force", () => {
    it("Happy Path", () => {
      const expression = "12+34";
      expect(minimizeResult(expression)).toStrictEqual("1(2+3)4");
    });

    it("Happy Path", () => {
      expect(strStr("sadbutsad", "sad")).toStrictEqual(0);
    });

    it("Happy Path - Complex", () => {
      expect(strStr("aaaabaaaa", "aba")).toStrictEqual(3);
    });
  });

  describe("Robin Karp Rolling Hash Tech", () => {
    it("Happy Path", () => {
      expect(strStr_with_rolling_hash("sadbutsad", "sad")).toStrictEqual(0);
    });

    it("Negative", () => {
      expect(strStr_with_rolling_hash("leetcode", "leeto")).toStrictEqual(-1);
    });

    it("Happy Path - Complex", () => {
      expect(strStr_with_rolling_hash("aaaabaaaa", "aba")).toStrictEqual(3);
    });
  });
});
