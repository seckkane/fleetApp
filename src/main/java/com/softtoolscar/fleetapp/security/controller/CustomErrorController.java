package com.softtoolscar.fleetapp.security.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String ERROR_MAPPING = "/error";

    @GetMapping(ERROR_MAPPING)
    public String handleError(@RequestParam(required = false) String message, Model model) {
    	// Vérifier si un message d'erreur est présent dans l'URL
        if (message != null && !message.isEmpty()) {
            try {
                // Décoder le message d'erreur
                String decodedMessage = URLDecoder.decode(message, StandardCharsets.UTF_8.toString());
                // Ajouter le message d'erreur au modèle pour l'afficher dans la vue
                model.addAttribute("errorMessage", decodedMessage);
            } catch (UnsupportedEncodingException e) {
                // Gérer l'erreur de décodage si nécessaire
                e.printStackTrace();
            }
        }
        // Gérez l'affichage de votre page d'erreur personnalisée
        return "error";
    }

    public String getErrorPath() {
        return ERROR_MAPPING;
    }
}