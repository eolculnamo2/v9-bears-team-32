package com.chingu.stocks.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chingu.stocks.helper.Helpers;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@PostMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
		String payloadString = Helpers.convertJsonToString( request.getInputStream() );
		JSONObject payloadJson = new JSONObject(payloadString);
		
		String username = payloadJson.getString("username");
		String password = payloadJson.getString("password");
		
		System.out.println(username);
		System.out.println(password);
		// @TODO handle authentication here.
		
		
		// @TODO Create appropriate response based on successful/failed login
		JSONObject responsePayload = new JSONObject();
		responsePayload.put("status", "success");
		
		// Sends response
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responsePayload);
        out.flush();;
	}
}