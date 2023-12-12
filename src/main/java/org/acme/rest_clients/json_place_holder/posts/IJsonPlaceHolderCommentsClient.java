package org.acme.rest_clients.json_place_holder.posts;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.posts.models.Comment;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/comments")
@RegisterRestClient
public interface IJsonPlaceHolderCommentsClient {
	
	@GET
	Set<Comment> getAllComments();
	
	@GET
	Uni<Set<Comment>> getAllCommentsAsync();
	
	@GET
	@Path(value = "/{id}")
	Comment getCommentById(@PathParam("id") Long id);
	
	@GET
	@Path(value = "/{id}")
	Comment getCommentByIdAsync(@PathParam("id") Long id);
}
