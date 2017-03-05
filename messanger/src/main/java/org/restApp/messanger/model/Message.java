package org.restApp.messanger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
    private Long id;
    private String message;
    private String author;
    private Date created;
    private Map<Long,Comment> comments = new HashMap<Long,Comment>();
	private List<Link> links = new ArrayList<Link>();
    public List<Link> getLink() {
		return links;
	}

	public void setLink(List<Link> link) {
		this.links = link;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Message(){}
    
    @XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	
	public Message(long id, String message, String author,
			Map<Long, Comment> comments) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
		this.comments = comments;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void addLinks(String url,String rel ){
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
