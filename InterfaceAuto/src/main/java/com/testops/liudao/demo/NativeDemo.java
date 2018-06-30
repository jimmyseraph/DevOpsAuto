package com.testops.liudao.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeDemo {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://localhost:10002/account/login");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			String postBody = "username=liudao002&password=123456";
			OutputStream os = connection.getOutputStream();
			os.write(postBody.getBytes());
			os.flush();
			InputStream is = connection.getInputStream();
			Reader reader = new InputStreamReader(is, "utf-8");
			int c = -1;
			while((c = reader.read())!=-1) {
				System.out.print((char)c);
			}
			os.close();
			reader.close();
			is.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
