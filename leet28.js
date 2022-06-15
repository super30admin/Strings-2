TC - O(M*N) where M is length of haystack , N is length of needle
SC - O(1)


/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    var str="";
    for(var i=0;i<haystack.length;i++)
    {
        for(var j=i+1;j<=haystack.length;j++)
        {
            str = haystack.substring(i,j);
            if(str===needle)
            {
                return i;
            }
        }
    }
    return -1;
};