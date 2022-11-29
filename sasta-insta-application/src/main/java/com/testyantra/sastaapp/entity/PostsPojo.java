package com.testyantra.sastaapp.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostsPojo {
	private String post;
	private String name;
}
