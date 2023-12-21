package org.acme.resources.todo;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.todos.IJsonPlaceHolderTodosClient;
import org.acme.rest_clients.json_place_holder.todos.model.Todo;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/json_place_holder_api/todos")
public class TodoResource {

	@RestClient
	IJsonPlaceHolderTodosClient todosClient;
	
	@GET
	@Blocking
	public Set<Todo> getAllTodos(){
		return todosClient.getAllTodos();
	}
	
	@GET
	@Path(value = "/async")
	@NonBlocking
	public Uni<Set<Todo>> getAllTodosAsync(){
		return todosClient.getAllTodosAsync();
	}
	
	@GET()
	@Path(value = "/{id}")
	@Blocking
	public Todo getTodoById(@PathParam("id") Integer id) {
		return todosClient.getTodoById(id);
	}
	
	@GET()
	@Path(value = "/{id}/async")
	@NonBlocking
	public Uni<Todo> getTodoByIdAsync(@PathParam("id") Integer id) {
		return todosClient.getTodoByIdAsync(id);
	}
}
