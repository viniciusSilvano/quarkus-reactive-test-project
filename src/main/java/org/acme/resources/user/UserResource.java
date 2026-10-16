package org.acme.resources.user;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.users.IJsonPlaceHolderUsersClient;
import org.acme.json_place_holder.users.model.User;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@Path("/json_place_holder_api/users")
public class UserResource {
	
	@RestClient
	IJsonPlaceHolderUsersClient usersClient;
	
	@GET
	@Blocking
	public Set<User> getAllTodos(){
		return usersClient.getAllUsers();
	}
	
	@GET
	@Path(value = "/async")
	@NonBlocking
	public Uni<Set<User>> getAllTodosAsync(){
		return usersClient.getAllUsersAsync();
	}
	
	@GET()
	@Path(value = "/{id}")
	@Blocking
	public User getTodoById(@PathParam("id") Integer id) {
		return usersClient.getUserById(id);
	}
	
	@GET()
	@Path(value = "/{id}/async")
	@NonBlocking
	public Uni<User> getTodoByIdAsync(@PathParam("id") Integer id) {
		return usersClient.getUserByIdAsync(id);
	}
	
}
