package org.acme.resources.photo;

import java.util.Set;

import org.acme.rest_clients.json_place_holder.photos.IJsonPlaceHolderPhotosClient;
import org.acme.rest_clients.json_place_holder.photos.model.Photo;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/json_place_holder_api/photos")
public class PhotoResource {
	
	@RestClient
	IJsonPlaceHolderPhotosClient photoClient;
	
	@GET
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
