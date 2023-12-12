package org.acme.resources.post;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.posts.IJsonPlaceHolderPostsClient;
import org.acme.rest_clients.json_place_holder.posts.models.Post;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/json_place_holder_api/posts")
public class PostResource {
	
	@RestClient
	IJsonPlaceHolderPostsClient postClient;
	
	@GET
	public Set<Post> getAllPosts(){
		return postClient.getAllPosts();
	}
	
	@GET()
	@Path(value = "/{id}")
	public Post getPostById(@PathParam("id") Long id) {
		return postClient.getPostById(id);
	}

}
