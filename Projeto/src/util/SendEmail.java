package util;

import java.util.logging.Level;


import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


import com.sun.istack.internal.logging.Logger;

public class SendEmail {

	
	
	public void sendLoginSenha(String nome,String user,String senha) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("projetorestauranteweb", "projetoweb"));
			email.setAuthentication("projetorestauranteweb@gmail.com", "projetoweb");
			email.setSSLOnConnect(true);
			email.setFrom(user);
			email.setSubject("Bem vindo a rede de franquias Restaurant");
			email.setMsg("Olá " + nome + " /n Seu login é: " + user + "\n Sua senha é : " + senha );
			email.addTo(user);
			email.send();
		} catch (EmailException ex) {
			Logger.getLogger(SendEmail.class.getName(), null).log(Level.SEVERE, null ,ex);
		}
	}
}
