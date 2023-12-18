package org.acme.rest_clients.json_place_holder.comments;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.comments.model.Comment;
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
	Comment getCommentById(@PathParam("id") Integer id);
	
	@GET
	@Path(value = "/{id}")
	Uni<Comment> getCommentByIdAsync(@PathParam("id") Integer id);
}
