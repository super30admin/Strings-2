class Solution:

    # Time Complexity : O(1)
    # Space Complexity : O(1)

    below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"]

    tens = ["", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]

    thousand = ["","Thousand","Million","Billion"]

    def numberToWords(self, num):

        if num == 0:

            return "Zero" 

        word = ""

        i = 0

        while num > 0:

            if num%1000 != 0:

                word = self.helper(num%1000) + self.thousand[i] + " " + word

            i += 1

            num = num//1000

        return word.strip()

    def helper(self, num):

        if num == 0:

            return ""

        elif num < 20:

            return self.below_20[num] + " "

        elif num < 100:

            return self.tens[num//10] + " " + self.helper(num%10)

        else:

            return self.below_20[num//100]+" Hundred " + self.helper(num%100)