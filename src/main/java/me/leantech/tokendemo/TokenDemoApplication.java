package me.leantech.tokendemo;

import me.leantech.tokendemo.util.NativeLibrariesUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

@SpringBootApplication
public class TokenDemoApplication {
    static {
        NativeLibrariesUtils.importDynamicLibraryFromResources("libstoken-wrapper");
    }

    public static void main(String[] args) {
        SpringApplication.run(TokenDemoApplication.class, args);

    }

}
