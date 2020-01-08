package service;

import db.FakeDB;
import model.Pokemon;

public class PokemonService {
	
	public static Pokemon getPokemon(int id) {
		return FakeDB.team.get(id);
	}
	
	public static void addPokemon(Pokemon p) {
		FakeDB.team.put(p.getId(), p);
	}

}
