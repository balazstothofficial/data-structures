package binarySearchTree

import binarySearchTree.BinarySearchTree.Leaf
import binarySearchTree.BinarySearchTree.Node
import function.foldOverThis
import order.TotalOrder
import kotlin.jvm.JvmName

fun <T : Comparable<T>, O : TotalOrder<T>> BinarySearchTree<T, O>.plus(
    vararg values: T
): BinarySearchTree<T, O> = this + values.asIterable()

operator fun <T : Comparable<T>, O : TotalOrder<T>> BinarySearchTree<T, O>.plus(
    values: Iterable<T>
): BinarySearchTree<T, O> = foldOverThis(values, ::plus)

operator fun <T : Comparable<T>, O : TotalOrder<T>> BinarySearchTree<T, O>.plus(
    value: T
): BinarySearchTree<T, O> = when (this) {
    is Leaf -> Node(
        order = order,
        left = Leaf(order),
        value = value,
        right = Leaf(order)
    )
    is Node -> if (order(value, this.value)) {
        Node(
            order = order,
            left = left + value,
            value = this.value,
            right = right
        )
    } else {
        Node(
            order = order,
            left = left,
            value = this.value,
            right = right + value
        )
    }
}

/**
 * Workaround for faulty type interference of functions with receiver
 */
@JvmName("NonReceiverPlus")
private fun <T : Comparable<T>, O : TotalOrder<T>> plus(
    tree: BinarySearchTree<T, O>,
    value: T
) = tree + value