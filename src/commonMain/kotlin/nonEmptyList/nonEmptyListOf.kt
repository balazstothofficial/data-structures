package nonEmptyList

fun <T> nonEmptyListOf(value: T, vararg values: T) = NonEmptyList(value, values.asList())