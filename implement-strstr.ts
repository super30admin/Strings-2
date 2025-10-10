// Time complexity - Amortized O(m+n), O(m*n) worst case
// Space complexity - O(1)
function strStr(haystack: string, needle: string): number {
	const m = haystack.length;
	const n = needle.length;

	if (n === 0) return 0;
	if (m < n) return -1;

	// using a standard large prime modulus
	const B = 26;
	const MOD = 10 ** 9 + 7; // big prime number for larger distribution

	// pre-calculate B^(n-1) % MOD
	let BPowMinusOne = 1;
	for (let i = 0; i < n - 1; i++) {
		BPowMinusOne = (BPowMinusOne * B) % MOD;
	}

	let pHash = 0; // Pattern Hash
	let hash = 0; // Haystack Window Hash

	// calculate initial hashes
	for (let i = 0; i < n; i++) {
		const nval = charToValue(needle[i]);
		const hVal = charToValue(haystack[i]);

		// hash = (hash * B + val) % MOD
		pHash = (pHash * B + nval) % MOD;
		hash = (hash * B + hVal) % MOD;
	}

	if (pHash === hash) return 0;

	// for moving window
	for (let i = n; i < m; i++) {
		// get value for outgoing character
		const outVal = charToValue(haystack[i - n]);

		// calculate the modular contribution/weight of the leaving character
		const outValToRemove = (outVal * BPowMinusOne) % MOD;

		// remove the outgoing character weighted/moduler contribution from window hash
		hash = (hash - outValToRemove + MOD) % MOD;

		// adjust weight to the window hash to accomodate for next char
		hash = (hash * B) % MOD;

		// add incoming char to the hash
		const incVal = charToValue(haystack[i]);
		hash = (hash + incVal) % MOD;

		// if window hash value is same as pattern hash return the window start index
		if (hash === pHash) return i - n + 1;
	}

	return -1;
}

function charToValue(char: string): number {
	return char.charCodeAt(0) - "a".charCodeAt(0) + 1;
}
