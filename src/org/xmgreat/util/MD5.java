package org.xmgreat.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author 宋卓伟
 * @date 2018年8月28日
 * @description MD5加密
 */
public class MD5
{
	private static final String KEY_MD5 = "MD5";

	public static String getResult(String password)
	{
		BigInteger bigInteger = null;
		try
		{
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] pwd = password.getBytes();
			md.update(pwd);
			bigInteger = new BigInteger(md.digest());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return bigInteger.toString(16);
	}
}