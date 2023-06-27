package ohm.softa.a12.cnjdb.suppliers;

import ohm.softa.a12.cnjdb.CNJDBApi;
import ohm.softa.a12.cnjdb.CNJDBService;
import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Supplier implementation to retrieve all jokes of the ICNDB in a linear way
 * @author Peter Kurfer
 */

public final class AllJokesSupplier implements Supplier<JokeDto> {

    /* ICNDB API proxy to retrieve jokes */
    private final CNJDBApi icndbApi;
	private List<String> fetchedJokes = new ArrayList<>();

    public AllJokesSupplier() {
        icndbApi = new CNJDBService().getInstance();
    }

    public JokeDto get() {

		var randomJokeSupplier = new RandomJokeSupplier();
		JokeDto returnedJoke = null;
		int maxRetries = 25;

		do{
			returnedJoke = randomJokeSupplier.get();
			maxRetries--;
		}while(returnedJoke.equals(null) && maxRetries > 0 && fetchedJokes.contains(returnedJoke.getId()));

		if(maxRetries == 0)
			fetchedJokes.clear();

		fetchedJokes.add(returnedJoke.getId());

		return returnedJoke;
    }



}
