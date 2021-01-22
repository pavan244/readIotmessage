package com.microsoft.docs.iothub.samples.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.microsoft.docs.iothub.samples.pojo.Message;




@Repository
@Component
public class IotEntityConfig {

	
	
	public Connection getConnection() throws SQLException
	{
		String url = "jdbc:postgresql://localhost:5432/iotdevices";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","password");

		Connection conn = DriverManager.getConnection(url, props);
		return conn;
	}
	


	public void insertWithQuery(Message message) {
	
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		String sql = "INSERT INTO messages (messageId, telemetric, Date, source, deviceid, isvalid) VALUES (?,?,?,?,?,?)";
		
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, message.getMessageId());
            pstmt.setString(2,message.getTelemetricData());
            pstmt.setDate(3, date);
            pstmt.setString(4,message.getSource() );
            pstmt.setString(5,message.getDeviceId() );
            pstmt.setBoolean(6, true);
            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
}
	
	/*
	public String selectEmailQuery(String email) {
		 List  list =  entityManager.createNativeQuery("select name from account where email = ?")
	      .setParameter(1, email).getResultList();
	      if(list.size() > 0)
	      {
	    	  return (String) list.get(0);
	      }
	    return "";     
	}
	
	@Transactional
	public String insertDeviceMock(DeviceInfo deviceInfo)
	{
		try
		{
			String jsonDeviceSettings = new Gson().toJson(deviceInfo.getDeviceSettings() );	
			String jsonDataPoints = new Gson().toJson(deviceInfo.getDataPoints() );	
			
			
			
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		entityManager.createNativeQuery("insert into deviceinfo (id, name, description, date,status,version,location,datapoints,settings,userid) VALUES (?,?,?,?,?,?,?,?,?,?)")
		.setParameter(1, deviceInfo.getId()).setParameter(2, deviceInfo.getName()).setParameter(3, deviceInfo.getDescription())
		.setParameter(4, date).setParameter(5, deviceInfo.getStatus()).setParameter(6, deviceInfo.getVersion()).setParameter(7, deviceInfo.getLocation())
		.setParameter(8,jsonDataPoints).setParameter(9, jsonDeviceSettings).setParameter(10, "pavan424@gmail.com").
		executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "SucessFully inserted";
	}
	*/
	/*
	public List<DeviceInfo> getAllDevicesMock() {
		 List<String[]>  list =  entityManager.createNativeQuery("select * from deviceinfo")
	      .getResultList();
	    
		 List<DeviceInfo> res = new ArrayList();
		 for(Object arr[]:list)
		 {
			 DeviceInfo deviceinfo = new DeviceInfo((String)arr[0],(String)arr[1],(String)arr[2]);
			 Date date = (Date)arr[3];
			 deviceinfo.setDate(date.toString());
			 res.add(deviceinfo);
		 }
		 
		 
	    return res;     
	}
	
	*/
	
	
}
