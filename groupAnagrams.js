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
        // We need to match each word with an unique key
        // that have exactly the same letters.
        // The sorted word will match with all of them
        let key = strs[i].split('').sort().join('');
        let words = hashMap.get(key) || [];
        // Push the word in the respective key-array
        words.push(strs[i]);
        hashMap.set(key, words);
    }
    return [...hashMap.values()];
};