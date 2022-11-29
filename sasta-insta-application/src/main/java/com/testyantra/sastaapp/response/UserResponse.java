package com.testyantra.sastaapp.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.testyantra.sastaapp.entity.Posts;
import com.testyantra.sastaapp.entity.PostsPojo;
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
public class UserResponse{
List<PostsPojo> postsPojosList;
User userProfile;
String message;

Posts posts;
List<Posts> listOfPosts;
private int totalNoOfPosts;
private int totalNoOfApprovedPosts;
private int totalNoOfRejectedPosts;
private int totalNoOfPendingPosts;
List<Posts> allListOfPosts;

} 
