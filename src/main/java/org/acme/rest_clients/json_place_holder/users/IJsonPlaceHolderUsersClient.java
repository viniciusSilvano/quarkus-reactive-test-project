package org.acme.rest_clients.json_place_holder.users;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.users.model.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/users")
@RegisterRestClient
public interface IJsonPlaceHolderUsersClient {
	
	@GET
	@Blocking
	Set<User> getAllUsers();
	
	@GET
	@NonBlocking
	Uni<Set<User>> getAllUsersAsync();
	
	@GET
	@Path(value = "/{id}")
	@Blocking
	User getUserById(@PathParam("id") Integer id);
	
	@GET
	@Path(value = "/{id}")
	@NonBlocking
	Uni<User> getUserByIdAsync(@PathParam("id") Integer id);
}
