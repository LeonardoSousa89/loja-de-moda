package com.moda.loja.tendencia.config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParams(String text) throws UnsupportedEncodingException {

			return URLDecoder.decode(text, "UTF-8");	
	}
	
}
