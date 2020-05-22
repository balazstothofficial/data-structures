package function

/**
 * Workaround for cases when the Kotlin Compiler cannot resolve receiver function to normal functions
 */
fun <Receiver, Input, Output> (Receiver.(Input) -> Output).receiverAsInput() =
    fun(receiver: Receiver, input: Input) = this(receiver, input)