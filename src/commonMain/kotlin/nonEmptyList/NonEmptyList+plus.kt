package nonEmptyList

operator fun <T> NonEmptyList<T>.plus(value: T) = copy(tail = tail + value)

operator fun <T> NonEmptyList<T>.plus(other: List<T>) = copy(tail = tail + other)

operator fun <T> List<T>.plus(
    other: NonEmptyList<T>
): NonEmptyList<T> = other.copy(head = other.firstOrNull() ?: other.head, tail = drop(1) + other.tail)

operator fun <T> NonEmptyList<T>.plus(other: NonEmptyList<T>): NonEmptyList<T> = copy(tail = tail + other)