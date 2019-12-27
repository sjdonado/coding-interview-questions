/**
 * Given an array of strings, group anagrams together.
 * @example
 * // returns [["ate","eat","tea"], ["nat","tan"], ["bat"]]
 * groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const hashMap = new Map();
    for (let i = 0; i < strs.length; i++) {
        // Sorting the word we get an unique key for each anagram
        let key = strs[i].split('').sort().join('');
        if (hashMap.has(key)) {
            hashMap.set(key, [...hashMap.get(key), strs[i]]);
        } else {
            hashMap.set(key, [strs[i]]);
        }
    }
    return [...hashMap.values()];
};