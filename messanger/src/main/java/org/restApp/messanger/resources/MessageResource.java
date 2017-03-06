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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.restApp.messanger.model.Message;
import org.restApp.messanger.service.MessangerService;

@Path("/messages")
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessangerService messangerService = new MessangerService();
	@GET
	public List<Message> getAllMessages()
	{
		System.out.println(messangerService);
		System.out.println();
		List<Message> al = messangerService.getAllMessages();
		System.out.println(messangerService);
		return al;
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId,@Context UriInfo uriInfo){
		Message message = messangerService.getMessage(messageId);
		message.addLinks(uriForSelf(uriInfo, message), "self");
		message.addLinks(uriForProfile(uriInfo, message), "profile");
		message.addLinks(uriForComments(uriInfo, message), "comments");
		return message;}

	private String uriForComments(UriInfo uriInfo, Message message) {
		String uriComments = (uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class))
				.resolveTemplate("messageId", message.getId())
				.build()
				.toString();
		        return uriComments;
	}

	private String uriForProfile(UriInfo uriInfo, Message message) {
		String uriProfile = (uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor()))
				.build()
				.toString();
		        return uriProfile;
	}

	private String uriForSelf(UriInfo uriInfo, Message message) {
		String uriSelf = (uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(message.getId())))
				.build()
				.toString();
		        return uriSelf;
	}
	
	@POST
	public Message addMessage(Message message){
		return messangerService.addMessage(message);}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long messageId,Message message){
		message.setId(messageId);
		return messangerService.updateMessage(message);}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Long messageId){
		messangerService.removeMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
