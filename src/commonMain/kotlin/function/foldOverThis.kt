package function

fun <S, T> S.foldOverThis(iterable: Iterable<T>, operation: (acc: S, T) -> S) = iterable.fold(this, operation)