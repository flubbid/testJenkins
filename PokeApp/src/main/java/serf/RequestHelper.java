package serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.PokemonWebService;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
		
		//This method will delegate other methods
		//on a different layer of our application
		//to process the request.
		
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch(uri) {
			
//		case "/PokeApp/MasterServlet": {
//			System.out.println("In this case.");
//		}
		
		case "/PokeApp/getPokemon.do": {
			PokemonWebService.getPokemon(request, response);
			break;
		}
//		We need another case for  addPokemon.do
//		fill in the string and implementation.
//		It should call one method from PokemonWebService
		case "/PokeApp/addPokemon.do": {
			PokemonWebService.addPokemon(request, response);
			break;
		}
		default: {
			try {
				response.sendError(451, "Get off my lawn!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		}
		
	}
	
}
