package org.acme.json_place_holder.todos;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.todos.model.Todo;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

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
