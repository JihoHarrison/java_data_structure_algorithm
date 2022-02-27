package com.company.leetcode

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/27
 * Time: 8:15 오후
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */
class Solution {
fun firstBadVersion(n: Int) : Int {

        var start = 0
        var end = n
        var answer = 0;

        while(start <= end) {
            var mid = start + (end - start) / 2

            if(!isBadVersion(mid)) {
                start = mid + 1
            } else {
                end = mid - 1
                answer = mid;
            }
        }

        return answer
    }

    // do not use. sample
    private fun isBadVersion(mid: Int): Boolean {
            return false
    }
}