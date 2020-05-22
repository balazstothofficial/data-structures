package order

sealed class TotalOrder<T : Comparable<T>> : (T, T) -> Boolean {

    class LessOrEqual<T : Comparable<T>> : TotalOrder<T>() {
        override fun invoke(first: T, second: T): Boolean = first <= second
    }

    class GreaterOrEqual<T : Comparable<T>> : TotalOrder<T>() {
        override fun invoke(first: T, second: T): Boolean = first >= second
    }
}