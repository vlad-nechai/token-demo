package me.leantech.tokendemo.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import me.leantech.tokendemo.TokenDemoApplication;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
@UtilityClass
public class NativeLibrariesUtils {

    public static void importDynamicLibraryFromResources(String libName) {
        try {
            var libExtension = SystemUtils.IS_OS_MAC ? ".dylib" : ".so";
            var url = TokenDemoApplication.class.getResource("/libs/" + libName + libExtension);
            var tmpDir = Files.createTempDirectory("lib").toFile();
            assert (url != null);
            tmpDir.deleteOnExit();
            var nativeLibTmpFile = new File(tmpDir, libName);
            nativeLibTmpFile.deleteOnExit();
            try (InputStream in = url.openStream()) {
                Files.copy(in, nativeLibTmpFile.toPath());
            }
            System.load(nativeLibTmpFile.getAbsolutePath());
        } catch (Exception e) {
            log.error("Failed to load dynamic library {} with the exception: ", libName, e);
        }
    }
}
