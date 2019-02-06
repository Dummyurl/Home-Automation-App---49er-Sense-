package jdbcconnection;

import java.sql.*;
import java.util.Arrays;

public class JDBCConnection {

	final static String DATABASE_URL = "jdbc:mysql://10.220.67.251:3306/iot_customer_data";
	static Connection connection = null;
	static Statement statement = null;

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		String dw_sensor_on = "";
		String new_dw_sensor_on = "";
		String[] fan = new String[3];
		String[] new_fan = new String[3];
		String[] thermostat = new String[3];
		String[] new_thermostat = new String[3];
		String lights_master = "";
		String new_lights_master = "";
		String lights_guest = "";
		String new_lights_guest = "";

		// TODO Auto-generated method stub
		while(true){
			try {
				DriverManager.setLoginTimeout(23);
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(DATABASE_URL, "user", "my-password");
				//System.out.println(connection);

				//dw_sensor

				String dw_sensor = "SELECT * FROM dw_sensors WHERE user_name = 'rmanjre'";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(dw_sensor);
				//STEP 5: Extract data from result set
				while(rs.next()){
					//Retrieve by column name
					dw_sensor_on  = rs.getString("first_on");

					//Display values
					if(dw_sensor_on.equals(new_dw_sensor_on)){

					}
					else
						System.out.print("dw_sensor status is: " + dw_sensor_on + "\n");
				}

				ResultSet rs1 = stmt.executeQuery(dw_sensor);
				while(rs1.next()){
					//Retrieve by column name
					new_dw_sensor_on  = rs1.getString("first_on");

					//Display values
					if(new_dw_sensor_on.equals(dw_sensor_on)){

					}
					else
						System.out.print("dw_sensor status is: " + new_dw_sensor_on + "\n");
				}

				//Fan

				String fan_thermo = "SELECT * FROM first_floor WHERE user_name = 'rmanjre'";
				Statement stmt_fan = connection.createStatement();
				ResultSet rs_fan = stmt_fan.executeQuery(fan_thermo);
				//STEP 5: Extract data from result set
				while(rs_fan.next()){
					//Retrieve by column name

					fan[0] = rs_fan.getString("fan_off");
					fan[1]  = rs_fan.getString("fan_auto");
					fan[2]  = rs_fan.getString("fan_on");
					//Display values
					if(Arrays.equals(fan, new_fan)){

					}
					else{
						System.out.print("Fan: ");
						for(int i = 0; i < 3; i++){
							System.out.print(fan[i] + " ");
						}
						if(fan[0].contains("0"))
						{
							new PowerUsage("Fan");
						}
						else
							PowerUsage.Fan = false;
						System.out.println();
					}

				}

				ResultSet rs1_fan = stmt_fan.executeQuery(fan_thermo);
				while(rs1_fan.next()){
					//Retrieve by column name
					new_fan[0] = rs1_fan.getString("fan_off");
					new_fan[1]  = rs1_fan.getString("fan_auto");
					new_fan[2]  = rs1_fan.getString("fan_on");

					//Display values
					if(Arrays.equals(fan, new_fan)){

					}
					else{
						System.out.print("Fan: ");
						for(int i = 0; i < 3; i++){
							System.out.print(new_fan[i] + " ");
						}
						if(new_fan[0].contains("0"))
						{
							new PowerUsage("Fan");
						}
						else
							PowerUsage.Fan = false;
						System.out.println();
					}
				}

				//Thermostat

				String thermo = "SELECT * FROM first_floor WHERE user_name = 'rmanjre'";
				Statement stmt_thermo = connection.createStatement();
				ResultSet rs_thermo = stmt_thermo.executeQuery(thermo);
				//STEP 5: Extract data from result set
				while(rs_thermo.next()){
					//Retrieve by column name

					thermostat[0] = rs_thermo.getString("heat");
					thermostat[1]  = rs_thermo.getString("cool");
					thermostat[2]  = rs_thermo.getString("off");
					//Display values
					if(Arrays.equals(thermostat, new_thermostat)){

					}
					else{
						System.out.print("Thermostat: ");
						for(int i = 0; i < 3; i++){
							System.out.print(thermostat[i] + " ");
						}
						if(thermostat[2].contains("0"))
						{
							new PowerUsage("Thermostat");
						}
						else
							PowerUsage.thermostat = false;
						System.out.println();
					}

				}

				ResultSet rs1_thermo = stmt_thermo.executeQuery(thermo);
				while(rs1_thermo.next()){
					//Retrieve by column name
					new_thermostat[0] = rs1_thermo.getString("heat");
					new_thermostat[1]  = rs1_thermo.getString("cool");
					new_thermostat[2]  = rs1_thermo.getString("off");

					//Display values
					if(Arrays.equals(thermostat, new_thermostat)){

					}
					else{
						System.out.print("Thermostat: ");
						for(int i = 0; i < 3; i++){
							System.out.print(new_thermostat[i] + " ");
						}
						if(thermostat[2].contains("0"))
						{
							new PowerUsage("Thermostat");
						}
						else
							PowerUsage.thermostat = false;
						System.out.println();
					}
				}


				//Lights master bedroom

				String master = "SELECT * FROM lights_first WHERE user_name = 'rmanjre'";
				Statement stmt_master = connection.createStatement();
				ResultSet rs_master = stmt_master.executeQuery(master);
				//STEP 5: Extract data from result set
				while(rs_master.next()){
					//Retrieve by column name
					lights_master = rs_master.getString("master_bedroom");

					//Display values
					if(lights_master.equals(new_lights_master)){

					}
					else
					{
						if(Integer.parseInt(lights_master) > 0)
						{
							new PowerUsage("Light");
						}
						else
							PowerUsage.light = false;
						System.out.print("Master bed lights is at level: " + lights_master + "\n");
					}
				}

				ResultSet rs1_master = stmt_master.executeQuery(master);
				while(rs1_master.next()){
					//Retrieve by column name
					new_lights_master  = rs1_master.getString("master_bedroom");

					//Display values
					if(new_lights_master.equals(lights_master)){

					}
					else
					{
						if(Integer.parseInt(new_lights_master) > 0)
						{
							new PowerUsage("Light");
						}
						else
							PowerUsage.light = false;
						System.out.print("Master bed lights is at level: " + new_lights_master + "\n");
					}
				}


				//Lights guest bedroom

				String guest = "SELECT * FROM lights_first WHERE user_name = 'rmanjre'";
				Statement stmt_guest = connection.createStatement();
				ResultSet rs_guest = stmt_guest.executeQuery(guest);
				//STEP 5: Extract data from result set
				while(rs_guest.next()){
					//Retrieve by column name
					lights_guest = rs_guest.getString("guest_bedroom");

					//Display values
					if(lights_guest.equals(new_lights_guest)){

					}
					else
						System.out.print("Guest bed lights is at level: " + lights_guest + "\n");
				}

				ResultSet rs1_guest = stmt_guest.executeQuery(guest);
				while(rs1_guest.next()){
					//Retrieve by column name
					new_lights_guest  = rs1_guest.getString("guest_bedroom");

					//Display values
					if(new_lights_guest.equals(lights_guest)){

					}
					else
						System.out.print("Guest bed lights is at level: " + new_lights_guest + "\n");
				}



			} catch (SQLException ex) {
				System.out.println("The following exception has occured: " + ex.getMessage());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
				} catch (SQLException ex) {
					System.out.println("The following exception has occured: " + ex.getMessage());
				}
			}
		}

	}
}







