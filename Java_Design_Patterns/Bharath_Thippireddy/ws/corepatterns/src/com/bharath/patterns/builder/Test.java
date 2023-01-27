package com.bharath.patterns.builder;

public class Test {
	public static void main(String[] args) {
		//HttpClient httpClient = new HttpClient("GET", "asd", null, null, null, null);
		  HttpClient build = new HttpClient.HttpClientBuilder().method("GET").url("http//asdadad").username("aaa").password("asd")
		  .body("asd").build();
		  System.out.println(build);
	}
}
