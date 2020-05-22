package binarySearchTree

import binarySearchTree.BinarySearchTree.Leaf
import binarySearchTree.BinarySearchTree.Node
import order.TotalOrder

fun <T : Comparable<T>, O: TotalOrder<T>> BinarySearchTree<T, O>.contains(
    vararg values: T
): Boolean = values.asIterable() in this

operator fun <T : Comparable<T>, O: TotalOrder<T>> BinarySearchTree<T, O>.contains(
    values: Iterable<T>
): Boolean = values.all(::contains)

operator fun <T : Comparable<T>, O: TotalOrder<T>> BinarySearchTree<T, O>.contains(
    value: T
): Boolean = when (this) {
    is Leaf -> false
    is Node -> value == this.value || value in left || value in right
}