package org.acme.json_place_holder.photos;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.photos.model.Photo;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

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
