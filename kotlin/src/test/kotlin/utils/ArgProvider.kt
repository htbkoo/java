import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

// reference: https://discuss.kotlinlang.org/t/junit5-parameterized-tests/28168
open class ArgProvider(vararg val data: Arguments) : ArgumentsProvider {
    override fun provideArguments(
        context: ExtensionContext?
    ): Stream<out Arguments> =  Stream.of(*data)
}
