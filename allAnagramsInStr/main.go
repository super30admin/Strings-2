func findAnagrams(s, p string) []int {
    if len(p) > len(s) { return nil }
    pMap := map[string]int{}
    for _, ele := range p {
        pMap[string(ele)]++
    }
    
    left := 0
    out := []int{}
    count := len(pMap)
    for right := 0; right < len(s); right++ {
        // perform calc
        // for this we have to decrement the count of char in our pMap if found
        char := string(s[right])
        _, inPattern := pMap[char]
        if inPattern {
            pMap[char]--
            if val := pMap[char]; val == 0 {
                count--
            }
        }
        if right-left+1 == len(p) {
            // get the answer first
            if count == 0 {
                out = append(out, left)
            }
            
            // undo calculations
            leftChar := string(s[left])
            if charCount, ok := pMap[leftChar]; ok {
                if charCount == 0 {
                    count++
                }
                pMap[leftChar]++
            }
            left++
        }
    }
    return out
}
