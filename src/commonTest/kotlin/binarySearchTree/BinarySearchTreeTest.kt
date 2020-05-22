package binarySearchTree

import order.TotalOrder.GreaterOrEqual
import order.TotalOrder.LessOrEqual
import kotlin.test.Test

class BinarySearchTreeTest {
    @Test
    fun contains() = listOf(1, 2, 3, 4, 5, 6, 7).run {
        BinarySearchTree(order = LessOrEqual<Int>())
            .plus(this)
            .contains(this)
            .assertTrue()
    }

    @Test
    fun containsPartial() = BinarySearchTree(order = GreaterOrEqual<Int>())
        .plus(listOf(1, 2, 3, 4, 5, 6, 7))
        .contains(listOf(1, 2, 4, 5, 7))
        .assertTrue()

    @Test
    fun containsSingle() = BinarySearchTree(order = GreaterOrEqual<Int>())
        .plus(2)
        .contains(2)
        .assertTrue()

    @Test
    fun notContainsSingle() = BinarySearchTree(order = GreaterOrEqual<Int>())
        .plus(3)
        .contains(45)
        .assertFalse()

    @Test
    fun notContains() = BinarySearchTree(order = LessOrEqual<Int>())
        .plus(5, 2, 6, 4, 5, 7, 7)
        .contains(1, 2, 4, 5, 6, 7, 8)
        .assertFalse()
}