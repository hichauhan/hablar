package com.expedia.expspeech.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;

public class sendSmsUtility {
	public static Boolean sendSms(long phone, String msgText) {
		HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
		try {
			HttpPost request = new HttpPost("http://api.msg91.com/api/v2/sendsms");
			StringEntity params =new StringEntity("{\"sender\":\"SOCKET\",\"route\":" +
					"\"4\",\"country\":\"91\",\"sms\":[{\"" +
					"message\":\"" + msgText +"\",\"to\":[\"" + phone + "\"" +
					"]}]}");
			request.addHeader("authkey", "228405Axhur7B6D45b59eac8");
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				return true;
			} else {
				return false;
			}
			//handle response here...
		}catch (Exception ex) {
			//handle exception here
		} finally {
			//Deprecated
			//httpClient.getConnectionManager().shutdown();
		}
		return false;
	}
}
