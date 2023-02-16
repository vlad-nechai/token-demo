package me.leantech.tokendemo;

import org.springframework.context.annotation.Configuration;
//import org.stoken.LibStoken;


@Configuration
public class StokenConfig {
    static {
        System.loadLibrary("stoken-wrapper");
//        LibStoken lib = new LibStoken();
    }
}