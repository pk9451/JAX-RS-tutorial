package org.restApp.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restApp.messanger.Database.DatabaseClass;
import org.restApp.messanger.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = DatabaseClass.getProfSiles();
	
	public ProfileService()
	{
		profiles.put("kp", new Profile(1L, "Kamlesh", "Pandey", "kp"));
		profiles.put("pk", new Profile(2L, "Priyanka", "Kalra", "pk"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
	    return profiles.get(profileName);
	}	
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1L);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
	    if(profile.getId()<=0)
	    	return null;
	    else
	    {
	    	profiles.put(profile.getProfileName(), profile)	;
	    	return profile;
	    }
	}	
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);		 
	}
	
	
}
