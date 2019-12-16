package com.mysitetwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class weatherController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ModelAndView model = new ModelAndView("weather");
		String zipcode = request.getParameter("zipcode");	//Gets zip code from the URL																
		
		final String APIKey = "2890390d4133e8e4ac90339ed508390d";
		String weatherAPIUrl = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipcode + ",us&appid=" + APIKey;
		
		GetAPIReader weatherReader = new GetAPIReader(weatherAPIUrl);
		
		System.out.println(weatherReader.getJSONString());
		model.addObject("zipcode", zipcode);
		model.addObject("visibility", weatherReader.getJSON().get("visibility"));
		model.addObject("temperature", weatherReader.getJSON().getJSONObject("main").get("temp"));
		model.addObject("city", weatherReader.getJSON().get("name"));
		return model;
	}
}

