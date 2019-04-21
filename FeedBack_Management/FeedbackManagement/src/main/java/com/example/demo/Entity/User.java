package com.example.demo.Entity;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Entity
@Table(name="user1")
public class User {
	@Id
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_yoj")
	private int yoj;
	@Column(name = "user_yol")
	private int yol;
	@Column(name = "fk_user_role")
	private String role;
    @Column(name = "user_contact")
    private String phoneno;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_pass")
    private String pass;
    @Column(name="user_gender")
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yoj=" + yoj +
                ", yol=" + yol +
                ", role='" + role + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }


	public User() {
	}

	public int getId() {
		return id;
	}

	public User(int id, String name, String pass, int yoj, int yol, String status, String phoneno, String email) {
		super ();
		this.pass = pass;
		this.id = id;
		this.name = name;
		this.yoj = yoj;
		this.yol = yol;
		this.role = status;
		this.phoneno = phoneno;
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYoj() {
		return yoj;
	}

	public void setYoj(int yoj) {
		this.yoj = yoj;
	}

	public int getYol() {
		return yol;
	}

	public void setYol(int yol) {
		this.yol = yol;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}