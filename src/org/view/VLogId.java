package org.view;

/**
 * VLogId entity. @author MyEclipse Persistence Tools
 */

public class VLogId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String operation;
	private String time;

	// Constructors

	/** default constructor */
	public VLogId() {
	}

	/** minimal constructor */
	public VLogId(Integer id, String username, String operation) {
		this.id = id;
		this.username = username;
		this.operation = operation;
	}

	/** full constructor */
	public VLogId(Integer id, String username, String operation, String time) {
		this.id = id;
		this.username = username;
		this.operation = operation;
		this.time = time;
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

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VLogId))
			return false;
		VLogId castOther = (VLogId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getOperation() == castOther.getOperation()) || (this
						.getOperation() != null
						&& castOther.getOperation() != null && this
						.getOperation().equals(castOther.getOperation())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getOperation() == null ? 0 : this.getOperation().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		return result;
	}

}