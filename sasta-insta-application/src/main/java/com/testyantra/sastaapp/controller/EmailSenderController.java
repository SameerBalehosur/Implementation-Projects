package com.testyantra.sastaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.sastaapp.entity.EmailData;
import com.testyantra.sastaapp.response.UserResponse;
import com.testyantra.sastaapp.service.EmailServiceImpl;

/**
 * @author Sameer Balehosur
 *
 * 
 */
@RestController
@RequestMapping("/apis/sasta/emails")
public class EmailSenderController {

	@Autowired
	EmailServiceImpl emailService;

	@PostMapping("/sendMail")
	public ResponseEntity<UserResponse> sendEmail(@RequestBody EmailData data) {
		if (data != null) {
			UserResponse sendMail = emailService.sendMail(data);
			if (sendMail.getMessage().equalsIgnoreCase("Mail Sent Successfully...")) {
				return new ResponseEntity<>(sendMail, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/sendMail/attachement")
	public ResponseEntity<UserResponse> sendMailWithAttachement(@RequestBody EmailData data) {
		if (data != null) {
			UserResponse sendMail = emailService.sendMailWithAttachement(data);
			if (sendMail.getMessage().equalsIgnoreCase("Mail Sent With Attachement")) {
				return new ResponseEntity<>(sendMail, HttpStatus.OK);
				System.err.println("Eroor");
				System.out.println("trying");
				
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
