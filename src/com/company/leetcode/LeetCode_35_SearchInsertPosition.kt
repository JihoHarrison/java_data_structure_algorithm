package com.company.leetcode

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/27
 * Time: 8:55 오후
 */

fun main() {

    val list = intArrayOf(1, 3, 5, 6)

    print(searchInsert(list, 2))
}

// log n이면 이분탐색밖에 답이 없음.
fun searchInsert(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.size - 1

    if (target < nums[0]) {
        return 0
    }

    if (target > nums[end]) {
        return nums.size
    }

    while (start <= end) {

        var mid = start + (end - start) / 2

        if (nums[mid] == target) {
            return mid
        }

        if (target > nums[mid]) {
            start = mid + 1
        } else if (target < nums[mid]) {
            end = mid - 1
        }
    }
    // 자리를 찾지 못했을 때는 그냥 원래 자기가 있어야 할 자리의 인덱스를 반환
    return start
}