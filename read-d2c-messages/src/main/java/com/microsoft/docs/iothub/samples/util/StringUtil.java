package com.microsoft.docs.iothub.samples.util;


import java.sql.SQLException;
import java.util.HashMap;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;





@Component
public class StringUtil {
	
	public HashMap<String,String> getMessageMap(String msg)
	{
		HashMap<String,String> hm = new HashMap();
		msg = msg.substring(1, msg.length()-1);
		System.out.println(msg);
		String arr[] = msg.split(",");
		for(String s:arr)
		{
			if(s.contains("="))
			{
			String sa[] = s.split("=");
			hm.put(sa[0], sa[1]);
			}
		}
		return hm;
	}
	
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
String msg = "{correlation-id=69cc9f0e-860c-4ed2-b0ed-1ffa545d49fd, iothub-connection-auth-method={\"scope\":\"device\",\"type\":\"sas\",\"issuer\":\"iothub\",\"acceptingIpFilterRule\":null}, iothub-enqueuedtime=Thu Jan 21 06:53:43 PST 2021, absolute-expiry-time=0, iothub-connection-device-id=TestMyDevice, iothub-connection-auth-generation-id=637466689139457130, group-sequence=0, iothub-message-source=Telemetry, creation-time=0, message-id=ef3377df-0266-4f44-98dd-db0e43f5b813, content-type=UTF-8}";
ObjectMapper mapper = new ObjectMapper();







	}

}
