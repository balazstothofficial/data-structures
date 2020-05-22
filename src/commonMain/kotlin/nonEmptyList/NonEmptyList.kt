package nonEmptyList

data class NonEmptyList<T> internal constructor(
    internal val head: T,
    internal val tail: List<T>
) : List<T> by listOf(head) + tail