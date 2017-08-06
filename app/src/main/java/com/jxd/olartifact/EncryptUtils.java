package com.jxd.olartifact;

import java.security.MessageDigest;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class EncryptUtils {

    public static String sha1(String paramString) {

        if ((paramString == null) || (paramString.length() == 0))
            return null;

        char[] localObject = new char[16];
        localObject[0] = 48;
        localObject[1] = 49;
        localObject[2] = 50;
        localObject[3] = 51;
        localObject[4] = 52;
        localObject[5] = 53;
        localObject[6] = 54;
        localObject[7] = 55;
        localObject[8] = 56;
        localObject[9] = 57;
        localObject[10] = 97;
        localObject[11] = 98;
        localObject[12] = 99;
        localObject[13] = 100;
        localObject[14] = 101;
        localObject[15] = 102;

        String result;

        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
            localMessageDigest.update(paramString.getBytes());
            byte[] arrayOfByte = localMessageDigest.digest();
            int j = arrayOfByte.length;
            char[] arrayOfChar = new char[j * 2];
            int n = 0;
            int m = 0;
            while (n < j) {
                int i = arrayOfByte[n];
                int k = m + 1;
                arrayOfChar[m] = localObject[(0xF & i >>> 4)];
                m = k + 1;
                arrayOfChar[k] = localObject[(i & 0xF)];
                n++;
            }
            result = new String(arrayOfChar);
        } catch (Exception localException) {
            result = null;
        }
        return  result;
    }
}
