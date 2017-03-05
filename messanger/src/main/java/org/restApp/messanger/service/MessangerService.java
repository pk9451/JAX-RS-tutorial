package org.restApp.messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.restApp.messanger.Database.DatabaseClass;
import org.restApp.messanger.model.Comment;
import org.restApp.messanger.model.Message;

public class MessangerService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	public MessangerService(){
		Map<Long,Comment> comments1 = new HashMap<Long, Comment>();
		comments1.put(1L, new Comment(1L,"Nice one","pk"));
		comments1.put(2L, new Comment(2L,"hacker","kp"));
		Map<Long,Comment> comments2 = new HashMap<Long, Comment>();
		comments2.put(1L, new Comment(1L,"Nice one","pk"));
		messages.put(1L, new Message(1L,"hell rest","kp",comments2));
		messages.put(2L, new Message(2L,"hell jersey","kp", comments1));	
	}
	
    public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
    }
    
    public Message getMessage(Long id){
		return messages.get(id);
    	}
    
    public Message addMessage(Message message){
    	message.setId(messages.size()+1);
    	messages.put(message.getId(), message);
    	return message;	}
    
    public Message updateMessage(Message message){
    	if(message.getId()<=0){
    		return null;}
    	messages.put(message.getId(), message);
    	return message;
    }
    
    public Message removeMessage(Long id)
    {
		return messages.remove(id);	}
    }