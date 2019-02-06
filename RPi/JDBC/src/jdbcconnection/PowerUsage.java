package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PowerUsage implements Runnable {
	
	
	final static String DATABASE_URL = "jdbc:mysql://192.168.1.102:3306/iot_powergen_data";
	static Connection connection = null;
	static Statement statement = null;
	public static boolean Fan , thermostat, light; 
	
	Thread t;
	int fanPower = 0;
	int thermoPower = 0;
	int lightPower = 0;
	String device;
	
	public PowerUsage(String device) {
		this.device = device;
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(device.contains("Fan"))
		{
			
			Fan = true;
			try {
				DriverManager.setLoginTimeout(23);
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(DATABASE_URL, "user", "my-password");
				
				while(Fan)
				{
					t.sleep(5000);
					fanPower += 1;
					String fan_query = "UPDATE power_pgen_first SET fan = ? WHERE user_name = 'rmanjre'";
					PreparedStatement preparedStmt = connection.prepareStatement(fan_query);
					preparedStmt.setInt(1, fanPower);
					preparedStmt.executeUpdate();
				}
				/*if(Fan == false)
				{
					Thread.currentThread().interrupt();
					System.out.println("Fan off");
				//	connection.close();
				}*/
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if(device.contains("Thermostat")) {
			thermostat = true;
			
			try {
				DriverManager.setLoginTimeout(23);
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(DATABASE_URL, "user", "my-password");
				
				while(thermostat)
				{
					t.sleep(5000);
					thermoPower += 10;
					String thermo_query = "UPDATE power_pgen_first SET thermostat = ? WHERE user_name = 'rmanjre'";
					PreparedStatement preparedStmt1 = connection.prepareStatement(thermo_query);
					preparedStmt1.setInt(1,thermoPower);
					preparedStmt1.executeUpdate();
				}
				
				/*if(thermostat == false)
				{
					Thread.currentThread().interrupt();
					System.out.println("Thermostat off");
				//	connection.close();
				}*/
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(device.contains("Light")) {
			light = true;
			
			try {
				DriverManager.setLoginTimeout(23);
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(DATABASE_URL, "user", "my-password");
				
				while(light)
				{
					t.sleep(5000);
					lightPower+= 5;
					String light_query = "UPDATE power_pgen_first SET light = ? WHERE user_name = 'rmanjre'";
					PreparedStatement preparedStmt2 = connection.prepareStatement(light_query);
					preparedStmt2.setInt(1, lightPower);
					preparedStmt2.executeUpdate();
				}
				
				/*if(light == false)
				{
					Thread.currentThread().interrupt();
					System.out.println("Light off");
				//	connection.close();
				}*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
 	
	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

}


