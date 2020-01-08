package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Pokemon;
import service.PokemonService;

public class PokemonWebService {

	public static void getPokemon(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		Pokemon p = PokemonService.getPokemon(id);
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			String pokemonJSON = om.writeValueAsString(p);
			response.getWriter().append(pokemonJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	We need another method in our webservice to handle
//	adding pokemon. We already have a Service method
//	to do such. We just need to convert the info.
	
	public static void addPokemon(HttpServletRequest request, HttpServletResponse response) {
		
		//First get all 3 parameters we passed in:
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		System.out.println(id + " " + name + " " + type);
		//Then we will make a Pokemon from those fields:
		Pokemon p = new Pokemon(id, name, type);
		
		//Call your PokemonService to add it.
		PokemonService.addPokemon(p);
		
		//Send a simple response back in the response
		//just indicating something like:
		
		try {
			response.getWriter().append("Pokemon added to the database");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
