TC - O(N) where N is {s.length+p.length}
SC - O(1)

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
   let sLen = s.length;
    let pLen = p.length; 
    let result = []
    
    let sArray = new Array(26).fill(0)
    let pArray = new Array(26).fill(0)
    
    for(let i=0; i<pLen; i++){
        sArray[s.charCodeAt(i)-97]++;
        pArray[p.charCodeAt(i)-97]++;
    }
    
    for(let i=0; i<sLen; i++){
        if(isAnagram(sArray,pArray)){
            result.push(i)
        }
        sArray[s.charCodeAt(i)-97]--
        sArray[s.charCodeAt(i+pLen)-97]++;
    }
     
    function isAnagram(sArray,pArray){
        for(let i=0;i<pArray.length;i++){
            if(sArray[i]!==pArray[i]){
                return false;
            }
        }
        return true;
    }
    return result;
};