package com.company.boj.dfs

import java.util.*

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2022/02/26
 * Time: 12:56 오전
 */

private var n = 0
private var lotto = intArrayOf()
private var visited = booleanArrayOf()

fun main(args: Array<String>) {

    val sc: Scanner = Scanner(System.`in`)

    while (true) {
        n = sc.nextInt()
        if (n == 0) break
        lotto = IntArray(n)
        visited = BooleanArray(n)
        for (i in 0 until n) {
            lotto[i] = sc.nextInt()
        }
        println()
        dfs(0, 0, lotto, visited)
    }
}

fun dfs(start: Int, depth: Int, lotto: IntArray, visited: BooleanArray) {

    if (depth == 6) {
        for (i in lotto.indices) {
            if (visited[i]) print(lotto[i])
        }
        println()
    }

    for (i in start until n) {
        if (!visited[i]) {
            visited[i] = true;
            dfs(i + 1, depth + 1, lotto, visited)
            visited[i] = false;
        }
    }
}