package com.automation.GuruBank.Scripts;

import org.testng.annotations.Test;

import com.automation.gurubank.KeywordEngine.KeywordEngine;

public class Login  {
	public KeywordEngine keywordengine;

	
	@Test
	public void login() {
		keywordengine= new KeywordEngine();
		keywordengine.startExecution("login");
		
	}
}
