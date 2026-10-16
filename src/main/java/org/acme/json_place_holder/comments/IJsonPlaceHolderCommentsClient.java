package org.acme.json_place_holder.comments;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.comments.model.Comment;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

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
