package org.model;

/**
 * Fileio entity. @author MyEclipse Persistence Tools
 */

public class Fileio implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String filename;
	private Long uploadtime;

	// Constructors

	/** default constructor */
	public Fileio() {
	}

	/** full constructor */
	public Fileio(String username, String filename, Long uploadtime) {
		this.username = username;
		this.filename = filename;
		this.uploadtime = uploadtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(Long uploadtime) {
		this.uploadtime = uploadtime;
	}

}