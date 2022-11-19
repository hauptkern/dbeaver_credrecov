package com.hauptkern.dbeaver_credrecov.utils;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DBeaverDecrypt {
    private final Path path;
    private static final byte[] LOCAL_KEY_CACHE = new byte[] { -70, -69, 74, -97, 119, 74, -72, 83, -55, 108, 45, 101, 61, -2, 84, 74 };

    public String decrypt() throws Exception {
        byte[] contents = Files.readAllBytes(path);
        try (InputStream byteStream = new ByteArrayInputStream(contents)) {
            byte[] fileIv = new byte[16];
            byteStream.read(fileIv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKey aes = new SecretKeySpec(LOCAL_KEY_CACHE, "AES");
            cipher.init(Cipher.DECRYPT_MODE, aes, new IvParameterSpec(fileIv));
            try (CipherInputStream cipherIn = new CipherInputStream(byteStream, cipher)) {
                return inputStreamToString(cipherIn);
            }
        }
    }

    static String inputStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public DBeaverDecrypt(Path filePath) {
        path=filePath;
    }
}