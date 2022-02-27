package com.company.boj.dfs

import java.util.*

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/26
 * Time: 2:23 오전
 */

var operator = intArrayOf()
var array = intArrayOf()
private var n = 0
var max = Integer.MIN_VALUE
var min = Integer.MAX_VALUE

fun main() {

    val sc: Scanner = Scanner(System.`in`)

    n = sc.nextInt()

    array = IntArray(n)
    operator = IntArray(4)

    for (i in 0 until n) {
        array[i] = sc.nextInt()
    }

    for (i in 0 until 4) {
        operator[i] = sc.nextInt()
    }

    dfs(1, array[0])

    println(max)
    println(min)
}

private fun dfs(depth: Int, value: Int) {

    if (depth == n) {
        max = Math.max(max, value)
        min = Math.min(min, value)
    }

    for (i in 0 until 4) {

        if (operator[i] > 0) {
            operator[i]--
            when (i) {

                0 -> dfs(depth + 1, value + array[depth])

                1 -> dfs(depth + 1, value - array[depth])

                2 -> dfs(depth + 1, value * array[depth])

                3 -> dfs(depth + 1, value / array[depth])

            }
            operator[i]++
        }
    }
}