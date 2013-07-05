package com.geeky.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Handles requests for the application home page.
 */
public class HomeController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Locale locale = request.getLocale();
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		ModelAndView model = new ModelAndView("home");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addObject("serverTime", formattedDate );

		return model;
	}
	
}
