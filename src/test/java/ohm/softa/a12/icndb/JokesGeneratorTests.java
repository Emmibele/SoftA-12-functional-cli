package ohm.softa.a12.icndb;

import ohm.softa.a12.cnjdb.JokeGenerator;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class JokesGeneratorTests {

    private JokeGenerator jokeGenerator = new JokeGenerator();

    @Test
    void testRandomStream() {
		jokeGenerator.randomJokesStream()
			.limit(10)
			.map(x -> x.getValue())
			.forEach(x -> System.out.println(x));
        /* timeout to ensure that stream does not loop forever */
        /* TODO implement a test for the random joke stream */
    }


    @Test
    void testJokesStream() {
		jokeGenerator.randomJokesStream()
			.limit(10)
			.map(x -> x.getValue())
			.forEach(x -> System.out.println(x));
        /* TODO implement a test for the linear jokes generator */
    }

}
