// Time complexity - O(m+n)
// Space complexity - O(1)
function findAnagrams(s: string, p: string): number[] {
	let m = s.length;
	let n = p.length;
	const map = new Map<string, number>();
	const result = [];

	// add all the chacters from pattern string and occurence to the map
	for (let i = 0; i < n; i++) {
		const char = p[i];
		map.set(char, (map.get(char) || 0) + 1);
	}

	let match = 0;
	// loop through each character in string
	for (let i = 0; i < m; i++) {
		const inc = s[i];

		// process incoming chacter
		if (map.has(inc)) {
			// reduce the freq for inc char
			let freq = map.get(inc);
			// for incoming character, reduce the freq
			freq--;
			map.set(inc, freq);
			// if freq count decrease from 1 -> 0 for incoming character, increase the match count
			if (freq === 0) match++;
		}

		// if window size goes beyond n (patten string length)
		if (i >= n) {
			// process incoming chacter
			const out = s[i - n];
			if (map.has(out)) {
				let freq = map.get(out);
				// increase the freq for outgoing char
				freq++;
				map.set(out, freq);
				// if freq count increase from 0 -> 1 for outgoing character, increase the match count
				if (freq === 1) match--;
			}
		}

		// if match count is equal to all the characters in the pattern, add the current index of window size n to the result array
		if (match === map.size) result.push(i - n + 1);
	}

	return result;
}
