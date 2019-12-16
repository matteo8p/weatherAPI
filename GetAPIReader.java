package com.mysitetwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class GetAPIReader 
{
	private String URL;
	JSONObject json;
	
	public GetAPIReader(String URL) throws IOException, JSONException
	{
		this.URL = URL;
		JSONObject json = readJsonFromUrl(this.URL);
		this.json = json;
	}
	
	
	
	
	//GET METHODS
	public JSONObject getJSON() throws IOException, JSONException
	{
		return json;
	}
	
	public String getJSONString()
	{
		return json.toString();
	}
	//GET METHODS
	
	
	
	
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
}
