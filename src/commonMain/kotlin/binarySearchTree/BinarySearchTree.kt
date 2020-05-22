package binarySearchTree

import order.TotalOrder

sealed class BinarySearchTree<T : Comparable<T>, O : TotalOrder<T>> {

    data class Leaf<T : Comparable<T>, O : TotalOrder<T>> internal constructor(
        internal val order: O
    ) : BinarySearchTree<T, O>()

    data class Node<T : Comparable<T>, O : TotalOrder<T>> internal constructor(
        internal val order: O,
        val left: BinarySearchTree<T, O>,
        val value: T,
        val right: BinarySearchTree<T, O>
    ) : BinarySearchTree<T, O>()

    companion object
}