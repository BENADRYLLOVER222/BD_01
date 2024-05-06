package bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String role;
	private String password;



	public User(long id, String name, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
	}


	public long getId() {return id;}


	public String getPassword() {return password; }

	public void setPassword(String password) { this.password = password;}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, role);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Objects.equals(role, other.role) && Objects.equals(password, other.password);
	}
	
	

}


