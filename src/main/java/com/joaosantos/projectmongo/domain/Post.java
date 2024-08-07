package com.joaosantos.projectmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import com.joaosantos.projectmongo.dto.AuthorDTO;
import com.joaosantos.projectmongo.dto.CommentDTO;

@Document(collection="post")
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	List<CommentDTO> comments = new ArrayList<>();
	
	public Post() {
	}

	public Post(String id, Date date, String title, String body, AuthorDTO AuthorDTO) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = AuthorDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthorDTO() {
		return author;
	}

	public void setAuthorDTO(AuthorDTO AuthorDTO) {
		this.author = AuthorDTO;
	}
	

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void addComment(CommentDTO comment) {
		comments.add(comment);
	}
	
	public void removeComment (CommentDTO comment) {
		comments.remove(comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
