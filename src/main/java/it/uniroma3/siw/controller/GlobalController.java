package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.CredentialsService;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private CredentialsService credentialsService;
	
	@ModelAttribute("userDetails")
	public UserDetails getUser() {
		UserDetails user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();}
		return user;
	}
	
	@ModelAttribute("nickname")
    public String getUserNickname(HttpSession session) {
		 // Verifica se già salvato
        String nickname = (String) session.getAttribute("nickname");
        if (nickname != null)
            return nickname;
        // Recupera utente autenticato
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            Credentials credentials = credentialsService.getCredentials(username);
            if (credentials != null && credentials.getUser() != null) {
                nickname = credentials.getUser().getNickname();
                session.setAttribute("nickname", nickname); // Salva in sessione
                return nickname;
            }
        }
        return null;
    }
}
