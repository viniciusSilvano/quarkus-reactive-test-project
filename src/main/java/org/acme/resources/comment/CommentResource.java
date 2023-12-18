package org.acme.resources.comment;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.comments.IJsonPlaceHolderCommentsClient;
import org.acme.rest_clients.json_place_holder.comments.model.Comment;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/json_place_holder_api/comments")
public class CommentResource {

	@RestClient
	IJsonPlaceHolderCommentsClient commentClient;
	
	@GET
	public Set<Comment> getAllPosts(){
		return commentClient.getAllComments();
	}
	
	@GET
	@Path(value = "/async")
	public Uni<Set<Comment>> getAllPostsAsync(){
		return commentClient.getAllCommentsAsync();
	}
	
	@GET()
	@Path(value = "/{id}")
	public Comment getPostById(@PathParam("id") Integer id) {
		return commentClient.getCommentById(id);
	}
	
	@GET()
	@Path(value = "/{id}/async")
	public Uni<Comment> getPostByIdAsync(@PathParam("id") Integer id) {
		return commentClient.getCommentByIdAsync(id);
	}
}
