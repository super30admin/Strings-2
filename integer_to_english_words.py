#Time complexity: O(1)
#Space complexity: O(1)
# Approach: traverse the string from backwards into 3 bits, by dividing it by thousand
# Have an helper function to process inside the 3 bits and return its value
# keep a thousand list to get values from it like thousand, million etc and append it.
# divide the number and append the processed value into result 
# until the quotient gets below 0,keep processing the same
# Now in the helper function, have two lists-below 20 and tens
# when the given number in helper is below 20, return the particular string from below 20 list
# if the number is below 100, add the number from tens list and append the remainder number's string value from tens list
# if the number is greater than or equal to 100, return the quotient of number / 100 and get its value from below 20 list and also add Hundred string and send the num%100 to the helper function, which will add up the appropriate value further.



class Solution:
    def __init__(self):
        self.thousands = ["","Thousand", "Million", "Billion"]
        self.below_20 = ["", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy", "Eighty","Ninety"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        result = ""
        i = 0
        while num > 0:
            if num%1000 > 0:
                result = self.helper(num%1000) + self.thousands[i] +" "+ result
            num = num // 1000
            i += 1
        return result.strip()
    def helper(self,n):
        if n == 0:
            return ""
        elif n < 20:
            return self.below_20[n]+" "
        elif n < 100:
            return self.tens[n//10] + " " + self.helper(n%10)
        else:
            return self.below_20[n//100] + " " + "Hundred" +" "+ self.helper(n%100)
        
            
            
        