package com.java4.popcorn.member;

import lombok.Data;

@Data
public class MemberVO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_knickname;
	private String member_tel;
	private String member_email;
	private Integer member_level;
	private Integer member_fav;
	private Integer member_view;
	private String member_img;
	private Integer member_age;
	private String member_gender;
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_knickname() {
		return member_knickname;
	}
	public void setMember_knickname(String member_knickname) {
		this.member_knickname = member_knickname;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public Integer getMember_level() {
		return member_level;
	}
	public void setMember_level(Integer member_level) {
		this.member_level = member_level;
	}
	public Integer getMember_fav() {
		return member_fav;
	}
	public void setMember_fav(Integer member_fav) {
		this.member_fav = member_fav;
	}
	public Integer getMember_view() {
		return member_view;
	}
	public void setMember_view(Integer member_view) {
		this.member_view = member_view;
	}
	public String getMember_img() {
		return member_img;
	}
	public void setMember_img(String member_img) {
		this.member_img = member_img;
	}
	public Integer getMember_age() {
		return member_age;
	}
	public void setMember_age(Integer member_age) {
		this.member_age = member_age;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	
}
