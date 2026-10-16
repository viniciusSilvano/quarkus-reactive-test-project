package org.acme.resources.photo;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.json_place_holder.photos.IJsonPlaceHolderPhotosClient;
import org.acme.json_place_holder.photos.model.Photo;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

@Path("/json_place_holder_api/photos")
public class PhotoResource {
	
	@RestClient
	IJsonPlaceHolderPhotosClient photoClient;
	
	@GET
	@Blocking
	public Set<Photo> getAllPhotos(){
		return photoClient.getAllPhotos();
	}
	
	@GET
	@Path("/async")
	@NonBlocking
	public Uni<Set<Photo>> getAllPhotosAsync(){
		return photoClient.getAllPhotosAsync();
	}
	
	@GET()
	@Path(value = "/{id}")
	@Blocking
	public Photo getPhotoById(@PathParam("id") Integer id) {
		return photoClient.getPhotoById(id);
	}
	
	@GET()
	@Path(value = "/{id}/async")
	@NonBlocking
	public Uni<Photo> getPhotoByIdAsync(@PathParam("id") Integer id) {
		return photoClient.getPhotoByIdAsync(id);
	}

}
