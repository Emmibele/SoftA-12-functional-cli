package ohm.softa.a12.cnjdb.suppliers;

import ohm.softa.a12.cnjdb.CNJDBApi;
import ohm.softa.a12.cnjdb.CNJDBService;
import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.function.Supplier;

/**
 * @author Peter Kurfer
 */

public final class RandomJokeSupplier implements Supplier<JokeDto> {

    /* ICNDB API proxy to retrieve jokes */
    private final CNJDBApi icndbApi;

    public RandomJokeSupplier() {
        icndbApi = new CNJDBService().getInstance();
    }

    public JokeDto get() {
		try{
			 return icndbApi.getRandomJoke().get();
		}catch (Exception e){
			return null;
		}
    }
}
