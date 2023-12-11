package org.acme.services.fruit;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletionException;

import org.acme.dao.FruitDAO;
import org.acme.models.fruit.Fruit;
import org.acme.services.ServiceBase;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class FruitService extends ServiceBase {
	
	@Inject
	private FruitDAO dao;

	private Collection<Fruit> fruits;

	public FruitService() {
		super();
		fruits = new HashSet<Fruit>();
	}

	public Uni<Set<Fruit>> getFruits() throws Throwable {
		try {
			return dao.getFruits();
		}catch(CompletionException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Uni<Set<Fruit>> addFruit(Fruit fruit) throws Throwable {
		try {
			
			return dao.addFruit(fruit);
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void remove(Fruit fruit) {
		fruits.removeIf(existingFruit -> existingFruit.getName().contentEquals(fruit.getName()));
	}

}
