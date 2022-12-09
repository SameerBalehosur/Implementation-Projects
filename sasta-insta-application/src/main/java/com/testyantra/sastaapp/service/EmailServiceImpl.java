package com.testyantra.sastaapp.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.testyantra.sastaapp.entity.EmailData;
import com.testyantra.sastaapp.response.UserResponse;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@Service
@JsonInclude(value = Include.NON_ABSENT)
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender javaMailSender;

	public UserResponse sendMail(EmailData data) {
		if (data != null) {
			try {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setFrom(data.getFromMail());
				mailMessage.setTo(data.getToEmail());
				mailMessage.setText(data.getBody());
				mailMessage.setSubject(data.getSubject());
				javaMailSender.send(mailMessage);
				return UserResponse.builder().emailData(data).message("Mail Sent Successfully...").build();
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return UserResponse.builder().message("Error while Sending Mail").build();
	}

	public UserResponse sendMailWithAttachement(EmailData data) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(data.getFromMail());
			mimeMessageHelper.setTo(data.getToEmail());
			mimeMessageHelper.setText(data.getBody());
			mimeMessageHelper.setSubject(data.getSubject());

			FileSystemResource file = new FileSystemResource(new File(data.getAttachements()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMessage);
			return UserResponse.builder().message("Mail Sent With Attachement").emailData(data)
					.build();
		}

		catch (MessagingException e) {

			return UserResponse.builder().message("Something wrong").build();
		}
	}
}
