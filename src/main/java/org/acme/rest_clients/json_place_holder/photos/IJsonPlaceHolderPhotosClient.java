package org.acme.rest_clients.json_place_holder.photos;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.photos.model.Photo;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/photos")
@RegisterRestClient
public interface IJsonPlaceHolderPhotosClient {
	
	@GET
	Set<Photo> getAllPhotos();
	
	@GET
	Uni<Set<Photo>> getAllPhotosAsync();
	
	@GET
	@Path(value = "/{id}")
	Photo getPhotoById(@PathParam("id") Integer id);
	
	@GET
	@Path(value = "/{id}")
	Uni<Photo> getPhotoByIdAsync(@PathParam("id") Integer id);
}
