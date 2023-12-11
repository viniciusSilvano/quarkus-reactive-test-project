package org.acme.resources.fruit;

import java.util.Set;

import org.acme.models.fruit.Fruit;
import org.acme.resources.ResourceBase;
import org.acme.services.fruit.FruitService;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/fruits")
public class FruitResource extends ResourceBase {
	
	@Inject
	private FruitService fruitService;
	
	@GET
	@NonBlocking
	public Uni<Set<Fruit>> list() throws Throwable {
	    return fruitService.getFruits();
	}
	
	@POST
	@NonBlocking
	public Uni<Set<Fruit>> add(Fruit fruit) throws Throwable {
		return fruitService.addFruit(fruit);
	}
	
	@DELETE
	@NonBlocking
	public Uni<Set<Fruit>> delete(Fruit fruit) throws Throwable {
		fruitService.remove(fruit);
	    return fruitService.getFruits();
	}
}
