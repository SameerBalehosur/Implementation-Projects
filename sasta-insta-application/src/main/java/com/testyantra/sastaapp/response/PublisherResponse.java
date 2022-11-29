package com.testyantra.sastaapp.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.testyantra.sastaapp.entity.PostsPojo;
import com.testyantra.sastaapp.entity.Publisher;
import com.testyantra.sastaapp.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class PublisherResponse {
	List<PostsPojo> postsPojosList;
	Publisher publisherProfile;
	String message;
	String statuscode;

}
