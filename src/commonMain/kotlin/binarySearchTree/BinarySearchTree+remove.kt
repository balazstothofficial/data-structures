package binarySearchTree

import binarySearchTree.BinarySearchTree.Leaf
import binarySearchTree.BinarySearchTree.Node
import order.TotalOrder

fun <T : Comparable<T>, O : TotalOrder<T>> BinarySearchTree<T, O>.remove(
    value: T
): BinarySearchTree<T, O> = when (this) {
    is Leaf -> this
    is Node -> remove(value)
}

private fun <T : Comparable<T>, O : TotalOrder<T>> Node<T, O>.remove(
    value: T
): BinarySearchTree<T, O> = when {
    value == this.value -> Leaf(order)
    order(value, this.value) -> copy(left = left.remove(value))
    else -> copy(right = right.remove(value))
}