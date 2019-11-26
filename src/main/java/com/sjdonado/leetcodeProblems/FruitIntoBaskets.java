/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjdonado.leetcodeProblems;

import java.util.*;
import org.junit.Assert;

/**
 *
 * @author sjdonado
 */
public class FruitIntoBaskets {
    //  [3,3,3,1,2,1,1,2,3,3,4]
    //   ^
    // First we can get the first fruit and put it into the first basket.
    // We need to save the current position because we help us to save the
    // left limit of our sliding window.
    // Inside our hash table we will have only two baskets as (key,values) couples.
    // The store hash table will have ["3" => 0] with the first iteration.
    // For the second and third iteration we just update the hash table index
    // [3,3,3,1,2,1,1,2,3,3,4]
    //      ^                  Hash table: ["3" => 2]
    // [3,3,3,1,2,1,1,2,3,3,4]
    //        ^                Hash table: ["3 => 2, "1" => 3]
    // In the next iteration we need to start saving the new fruit in a basket, so
    // the fruit saved in our Hash table with lower index is the leftmost element.
    // [3,3,3,1,2,1,1,2,3,3,4]
    //  ^     ^  
    //     3 <- Current max value
    // [3,3,3,1,2,1,1,2,3,3,4]
    //        ^       ^   
    //            5 <- Current max value
    
    public int totalFruit(int[] tree) {
        // Edge cases validation
        if (tree == null || tree.length == 0) {
            return 0;
        }
        
        // Memoization store
        HashMap<Integer, Integer> store = new HashMap();
        int i = 0;
        int j = 0;
        int max = 1;
        
        while (i < tree.length) {
            // Adding the fruits to the two baskets.
            if (store.size() <= 2) {
                store.put(tree[i], i++);
            }
            
            // If a new fruit its collected a new basket is created, therefore
            // in the next conditional stament is removed one basket.
            if (store.size() > 2) {
                int min = tree.length - 1;
                for (int value : store.values()) {
                    min = Math.min(min, value);
                }
                // We need to set min + 1 because the new left limit of our 
                // sliding window is the next element.
                j = min + 1;
                // The leftmost basket is removed.
                store.remove(tree[min]);
            }
            
            max = Math.max(max, i - j);
        }
        
        return max;
    }
    
    public void tests() {
        // Leetcode test cases
        try {
            Assert.assertEquals(3, this.totalFruit(new int[]{1,2,1}));
            Assert.assertEquals(3, this.totalFruit(new int[]{0,1,2,2}));
            Assert.assertEquals(4, this.totalFruit(new int[]{1,2,3,2,2}));
            Assert.assertEquals(5, this.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
            
            System.out.println("Tests passed sucessfully.");
        } catch (AssertionError assertionErr) {
            System.out.println("Test error:");
            System.out.println(assertionErr.getMessage());
        }
    }
    
    public static void main(String args[]) {
        new FruitIntoBaskets().tests();
    }
}
