package me.leantech.tokendemo;

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
        try {
            String libName = "libstoken-wrapper.dylib";
            URL url = TokenDemoApplication.class.getResource("/libs/" + libName);
            File tmpDir = Files.createTempDirectory("stoken").toFile();
            tmpDir.deleteOnExit();
            File nativeLibTmpFile = new File(tmpDir, libName);
            nativeLibTmpFile.deleteOnExit();
            try (InputStream in = url.openStream()) {
                Files.copy(in, nativeLibTmpFile.toPath());
            }
            System.load(nativeLibTmpFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(TokenDemoApplication.class, args);

    }

}
