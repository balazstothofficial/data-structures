package binarySearchTree

import binarySearchTree.BinarySearchTree.Leaf
import order.TotalOrder
import order.TotalOrder.LessOrEqual

operator fun <T : Comparable<T>> BinarySearchTree.Companion.invoke(
    order: TotalOrder<T> = LessOrEqual()
) = Leaf(order)