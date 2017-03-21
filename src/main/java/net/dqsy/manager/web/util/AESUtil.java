package net.dqsy.manager.web.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    private final static String algorithm = "AES";

    public static String asHex(byte buf[], int radix) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;

        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                strbuf.append("0");
            strbuf.append(Long.toString((int) buf[i] & 0xff, radix));
        }
        return strbuf.toString();
    }

    private static String asHex(byte buf[]) {
        return asHex(buf, 16);
    }

    private static byte[] asBin(String src) {
        if (src.length() < 1)
            return null;
        byte[] encrypted = new byte[src.length() / 2];
        int high = 0;
        int low = 0;
        for (int i = 0; i < src.length() / 2; i++) {
            high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
            low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);

            encrypted[i] = (byte) (high * 16 + low);
        }
        return encrypted;
    }

    public static String getRawKey() {

        try {
            // Get the KeyGenerator
            KeyGenerator kgen = KeyGenerator.getInstance(algorithm);
            kgen.init(128); // 192 and 256 bits may not be available

            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();
            return asHex(raw);
        } catch (Exception e) {
            return "";
        }
    }

    public static byte[] getEncrypt(String message, String rawKey) {
        if (rawKey == null || rawKey.length() != 32) {
            return null;
        }
        byte[] key = asBin(rawKey);
        byte[] msg = asBin(message);
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, algorithm);
            Cipher cipher = Cipher.getInstance("AES/ECB/Nopadding");// "算法/模式/补码方式
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(msg);
            return encrypted;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDecrypt(String encrypted, String rawKey) {
        if (rawKey == null || rawKey.length() != 32) {
            return null;
        }
        byte[] tmp = asBin(encrypted);
        byte[] key = asBin(rawKey);

        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, algorithm);
            Cipher cipher = Cipher.getInstance("AES/ECB/Nopadding");// "算法/模式/补码方式
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] decrypted = cipher.doFinal(tmp);
            return asHex(decrypted);
        } catch (Exception e) {
            return "";
        }

    }
}
