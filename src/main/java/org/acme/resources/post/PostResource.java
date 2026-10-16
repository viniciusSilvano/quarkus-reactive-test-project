package org.acme.resources.post;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.posts.IJsonPlaceHolderPostsClient;
import org.acme.json_place_holder.posts.model.Post;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@Path("/json_place_holder_api/posts")
public class PostResource {
	
	@RestClient
	IJsonPlaceHolderPostsClient postClient;
	
	@GET
	@Blocking
	public Set<Post> getAllPosts(){
		return postClient.getAllPosts();
	}
	
	@GET
	@Path("/async")
	@NonBlocking
	public Uni<Set<Post>> getAllPostsAsync(){
		return postClient.getAllPostsAsync();
	}
	
	@GET()
	@Path(value = "/{id}")
	@Blocking
	public Post getPostById(@PathParam("id") Integer id) {
		return postClient.getPostById(id);
	}
	
	@GET()
	@Path(value = "/{id}/async")
	@NonBlocking
	public Uni<Post> getPostByIdAsync(@PathParam("id") Integer id) {
		return postClient.getPostByIdAsync(id);
	}

}
