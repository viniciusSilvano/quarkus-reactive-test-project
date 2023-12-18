package org.acme.rest_clients.json_place_holder.albums;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.albums.model.Album;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/posts")
@RegisterRestClient
public interface IJsonPlaceHolderAlbumsClient {
	
	@GET
	Set<Album> getAllAlbums();
	
	@GET
	Uni<Set<Album>> getAllAlbumsAsync();
	
	@GET
	@Path(value = "/{id}")
	Album getAlbumById(@PathParam("id") Integer id);
	
	@GET
	@Path(value = "/{id}")
	Uni<Album> getAlbumByIdAsync(@PathParam("id") Integer id);
}
