package me.leantech.tokendemo;

import me.leantech.tokendemo.util.NativeLibrariesUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TokenDemoApplication {
    static {
        NativeLibrariesUtils.importDynamicLibraryFromResources("libstoken");
        NativeLibrariesUtils.importDynamicLibraryFromResources("libstoken-wrapper");
    }

    public static void main(String[] args) {
        SpringApplication.run(TokenDemoApplication.class, args);

    }

}
