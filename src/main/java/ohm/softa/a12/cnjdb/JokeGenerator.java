package ohm.softa.a12.cnjdb;

import ohm.softa.a12.cnjdb.suppliers.AllJokesSupplier;
import ohm.softa.a12.cnjdb.suppliers.RandomJokeSupplier;
import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.stream.Stream;

/**
 * Generator instance to provide streams of jokes
 */

public final class JokeGenerator {

    /**
     * Generator for random jokes
     * @return stream of random jokes wrapped in ResponseWrapper objects
     */
    public Stream<JokeDto> randomJokesStream() {
		return Stream.generate(new RandomJokeSupplier());
    }

    /**
     * Generator for jokes ordered by their id
     * @return stream of jokes wrapped in ResponseWrapper objects
     */
    public Stream<JokeDto> allJokesStream() {
		return Stream.generate(new AllJokesSupplier());
    }
}
