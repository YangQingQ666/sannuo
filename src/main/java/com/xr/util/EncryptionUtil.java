package com.xr.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncryptionUtil {
	private final static Base64.Decoder decoder = Base64.getDecoder();
	private final static Base64.Encoder encoder = Base64.getEncoder();
	/**
	 * base64加密
	 * @param 需要加密的字符串
	 * @return 返回加密后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String text) throws UnsupportedEncodingException{
		byte[] code = text.getBytes("UTF-8");
		String encodedText = encoder.encodeToString(code);
		return encodedText;
	}
	/**
	 * 解密方法
	 * @param text 解密base64的字符串
 	 * @return 解密后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String toencode(String text) throws UnsupportedEncodingException{
		byte[] code = text.getBytes("UTF-8");
		//String encodedText = encoder.encodeToString(code);
		return new String(decoder.decode(code), "UTF-8");
	}
}
