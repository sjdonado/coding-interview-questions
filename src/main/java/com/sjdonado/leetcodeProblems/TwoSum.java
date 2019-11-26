/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjdonado.leetcodeProblems;

import java.util.HashMap;
import org.junit.Assert;

/**
 *
 * @author sjdonado
 */
public class TwoSum {
    // Given nums = [2, 7, 11, 15], target = 9,
    // Because nums[0] + nums[1] = 2 + 7 = 9,
    // return [0, 1].
    
    public int[] twoSum(int[] nums, int target) {
        // With a hash table the O(n^2) is reduced to O(n).
        HashMap<Integer, Integer> hash = new HashMap();
        int complement;
        
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            // The hash.get(complement) != i avoid the numbers comparison with itself.
            if (hash.containsKey(complement) && hash.get(complement) != i) {
                return new int[]{i, hash.get(complement)};
            }
        }
        // Edge case validation
        return new int[]{-1, -1};
    }
    
    public void tests() {
        // Leetcode test cases
        try {
            Assert.assertArrayEquals(new int[]{0, 1}, this.twoSum(new int[]{2, 7, 11, 15}, 9));
            Assert.assertArrayEquals(new int[]{0, 1}, this.twoSum(new int[]{3, 3}, 6));

            System.out.println("Tests passed sucessfully.");
        } catch (AssertionError assertionErr) {
            System.out.println("Test error:");
            System.out.println(assertionErr.getMessage());
        }
    }
    
    public static void main(String args[]) {
        new TwoSum().tests();
    }
}
