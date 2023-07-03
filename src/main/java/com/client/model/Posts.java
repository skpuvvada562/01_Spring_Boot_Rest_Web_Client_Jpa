package com.client.model;

import java.util.List;

public class Posts {

	private List<Post> postList;

	
	public Posts(List<Post> postList) {
		super();
		this.postList = postList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	@Override
	public String toString() {
		return "Posts [postList=" + postList + "]";
	}
	
	
}
