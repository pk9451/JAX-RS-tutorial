package org.restApp.messanger.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.restApp.messanger.Database.DatabaseClass;
import org.restApp.messanger.model.Comment;
import org.restApp.messanger.model.Message;
public class CommentService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}
	
	public Comment getComment(long messageId,long commentId){
		return messages.get(messageId).getComments().get(commentId);
	}
	
	public Comment addComment(long messageId,Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1L);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId,Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		if(comment.getId()<=0)
			return null;
		else
		{
			comments.put(comment.getId(), comment);
			return comment;
		}
	}
	public void deleteComment(long messageId,long commentId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		 comments.remove(commentId);
	}
}
