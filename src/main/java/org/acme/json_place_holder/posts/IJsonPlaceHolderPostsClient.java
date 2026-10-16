package org.acme.json_place_holder.posts;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.posts.model.Post;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

@Path("/albums")
@RegisterRestClient
public interface IJsonPlaceHolderPostsClient {
	
	@GET
	Set<Post> getAllPosts();
	
	@GET
	Uni<Set<Post>> getAllPostsAsync();
	
	@GET
	@Path(value = "/{id}")
	Post getPostById(@PathParam("id") Integer id);
	
	@GET
	@Path(value = "/{id}")
	Uni<Post> getPostByIdAsync(@PathParam("id") Integer id);
}
