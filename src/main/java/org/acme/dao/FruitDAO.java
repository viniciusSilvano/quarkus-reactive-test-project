package org.acme.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.acme.models.fruit.Fruit;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.mutiny.Mutiny.Session;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class FruitDAO {
	
	@Inject
	private Mutiny.SessionFactory sf;
	
	public Uni<Set<Fruit>> getFruits(){
		
		return sf.withSession(session -> 
			queryGetFruits(session)
		).invoke(fruits -> System.out.println("fruitas encontradas: " + fruits))
		.onItem()
		.transform(fruits -> fruits.stream().collect(Collectors.toSet()))
		.onFailure()
		.retry()
		.atMost(2);			
	}

	private Uni<List<Fruit>> queryGetFruits(Session session) {
		return session.createQuery("SELECT f FROM Fruit f",Fruit.class).getResultList();
	}
	
	public Uni<Set<Fruit>> addFruit(Fruit fruit){
		return sf.withTransaction(session -> 
			{
				return session.persist(fruit)
				.onItem()
				.invoke(fruitResult -> System.out.println("persistindo fruit" + fruitResult))
				.chain(() -> queryGetFruits(session))
				.onFailure()
				.retry()
				.atMost(2)
				.invoke(e -> System.out.println("Erro ao persistir fruta")); 
				 
			}
		).onItem()
		.transform(fruits -> fruits.stream().collect(Collectors.toSet()));
	}
}
