package com.example.UserManager.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, Model model) {
        // Log the exception message for debugging
        logger.error("Exception occurred: ", ex);

        // Add the error message to the model
        model.addAttribute("error", ex.getMessage());

        // Create a ModelAndView object for rendering the error page
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error"); // Ensure you have an 'error.html' or 'error.jsp' view
        return modelAndView;
    }
}