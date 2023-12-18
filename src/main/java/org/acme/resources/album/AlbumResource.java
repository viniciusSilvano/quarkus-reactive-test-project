package org.acme.resources.album;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.albums.IJsonPlaceHolderAlbumsClient;
import org.acme.rest_clients.json_place_holder.albums.model.Album;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/json_place_holder_api/albums")
public class AlbumResource {

	@RestClient
	IJsonPlaceHolderAlbumsClient albumsClient;
	
	@GET
	public Set<Album> getAllPAlbums(){
		return albumsClient.getAllAlbums();
	}
	
	@GET
	@Path(value = "/async")
	public Uni<Set<Album>> getAllAlbumsAsync(){
		return albumsClient.getAllAlbumsAsync();
	}
	
	@GET()
	@Path(value = "/{id}")
	public Album getPostById(@PathParam("id") Integer id) {
		return albumsClient.getAlbumById(id);
	}
	
	@GET()
	@Path(value = "/{id}/async")
	public Uni<Album> getPostByIdAsync(@PathParam("id") Integer id) {
		return albumsClient.getAlbumByIdAsync(id);
	}
}
