package db;

import java.util.HashMap;
import java.util.Map;

import model.Pokemon;

public class FakeDB {

	public static Map<Integer, Pokemon> team = new HashMap<Integer, Pokemon>();
	
	static {
		Pokemon p1 = new Pokemon(1, "Bulbasaur", "Grass/Poision");		
		Pokemon p2 = new Pokemon(2, "Pikachu", "Electric");
		Pokemon p3 = new Pokemon(3, "Jigglypuff", "Fairy");
		
		team.put(1, p1);
		team.put(2, p2);
		team.put(3, p3);
	}
	
}
