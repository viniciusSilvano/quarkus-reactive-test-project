package org.acme.rest_clients.json_place_holder.todos;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.todos.model.Todo;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/todos")
@RegisterRestClient
public interface IJsonPlaceHolderTodosClient {
	
	@GET
	Set<Todo> getAllTodos();
	
	@GET
	Uni<Set<Todo>> getAllTodosAsync();
	
	@GET
	@Path(value = "/{id}")
	Todo getTodoById(@PathParam("id") Integer id);
	
	@GET
	@Path(value = "/{id}")
	Uni<Todo> getTodoByIdAsync(@PathParam("id") Integer id);
}
