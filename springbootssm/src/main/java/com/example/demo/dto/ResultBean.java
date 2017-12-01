package com.example.demo.dto;

import java.io.Serializable;

public class ResultBean {
	private String name ;
	private long voteup;
	private long votedown;
	public ResultBean(String title, Serializable string, String string2) {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultBean(String name, long voteup, long votedown) {
		super();
		this.name = name;
		this.voteup = voteup;
		this.votedown = votedown;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getVoteup() {
		return voteup;
	}
	public void setVoteup(long voteup) {
		this.voteup = voteup;
	}
	public long getVotedown() {
		return votedown;
	}
	public void setVotedown(long votedown) {
		this.votedown = votedown;
	}
	@Override
	public String toString() {
		return "ResultBean [name=" + name + ", voteup=" + voteup + ", votedown=" + votedown + "]";
	}
	
}
