package org.restApp.messanger.resources;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restApp.messanger.model.Profile;
import org.restApp.messanger.service.ProfileService;

@Path("/profiles")
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)

public class ProfileResource {
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllPrfiles()
	{
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName)
	{
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return profileService.addProfile(profile);
	}
	
	@Path("/{profileName}")
	@PUT
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile)
	{
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile removeProfile(@PathParam("profileName") String profileName)
	{
		return profileService.removeProfile(profileName);
	}
}
