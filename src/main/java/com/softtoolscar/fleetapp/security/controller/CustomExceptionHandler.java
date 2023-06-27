package com.softtoolscar.fleetapp.security.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HttpServletRequest request) throws UnsupportedEncodingException {
        String errorMessage = "Une erreur s'est produite : " + ex.getMessage();
        String encodedErrorMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8.toString());
        String redirectUrl = "redirect:/error?message=" + encodedErrorMessage;
        return redirectUrl;
    }
}
