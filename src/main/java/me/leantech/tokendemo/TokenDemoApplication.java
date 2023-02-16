package me.leantech.tokendemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stoken.LibStoken;

@SpringBootApplication
public class TokenDemoApplication {

	static {
		System.loadLibrary("stoken-wrapper");
	}

	public static void main(String[] args) {
		SpringApplication.run(TokenDemoApplication.class, args);

	}

}
