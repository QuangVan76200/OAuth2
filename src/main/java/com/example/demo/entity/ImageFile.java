package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "imageFile")
public class ImageFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postImageId;

	@NotBlank
	@Size(min = 5, max = 100)
	@Column(name = "title")
	private String title;

	@Lob
	@Column(name = "files", length = 50000000)
	@JsonIgnore
	private byte[] files;

	@Column(name = "type")
	private String type;

	public ImageFile() {

	}

	public ImageFile(@NotBlank @Size(min = 5, max = 100) String title, byte[] files, String type) {
		this.title = title;
		this.files = files;
		this.type = type;
	}

	public ImageFile(Long postImageId, @NotBlank @Size(min = 5, max = 100) String title, byte[] files, String type) {
		super();
		this.postImageId = postImageId;
		this.title = title;
		this.files = files;
		this.type = type;
	}

	public Long getPostImageId() {
		return postImageId;
	}

	public void setPostImageId(Long postImageId) {
		this.postImageId = postImageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}