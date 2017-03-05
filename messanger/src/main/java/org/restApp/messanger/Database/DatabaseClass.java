package org.restApp.messanger.Database;

import java.util.HashMap;
import java.util.Map;

import org.restApp.messanger.model.Message;
import org.restApp.messanger.model.Profile;

public class DatabaseClass {
	public static Map<Long,Message> messages = new HashMap<>();
	public static Map<String,Profile> profSiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfSiles() {
		return profSiles;
	}

}
