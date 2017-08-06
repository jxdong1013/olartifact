package com.jxd.olartifact;

import java.util.Random;

/**
 * Created by jinxiangdong on 2017/8/6.
 */

public class StringUtils {
    public static String getRandomString(int paramInt)
    {
        Random localRandom = new Random();
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; ; i++)
        {
            if (i >= paramInt)
                return localStringBuffer.toString();
            localStringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
    }

}
