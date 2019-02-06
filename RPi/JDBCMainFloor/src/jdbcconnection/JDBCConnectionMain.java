package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JDBCConnectionMain {
	
	final static String DATABASE_URL = "jdbc:mysql://192.168.1.105:3306/iot_customer_data";
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
		String lights_living = "";
		String new_lights_living = "";
		String lights_kitchen = "";
		String new_lights_kitchen = "";
		String lights_porch = "";
		String new_lights_porch = "";
		String garage_open = "";
		String new_garage_open = "";
		String[] security = new String[3];
		String[] new_security = new String[3];

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
					dw_sensor_on  = rs.getString("main_on");

					//Display values
					if(dw_sensor_on.equals(new_dw_sensor_on)){

					}
					else
						System.out.print("dw_sensor status is: " + dw_sensor_on + "\n");
				}

				ResultSet rs1 = stmt.executeQuery(dw_sensor);
				while(rs1.next()){
					//Retrieve by column name
					new_dw_sensor_on  = rs1.getString("main_on");

					//Display values
					if(new_dw_sensor_on.equals(dw_sensor_on)){

					}
					else
						System.out.print("dw_sensor status is: " + new_dw_sensor_on + "\n");
				}

				//Fan

				String fan_thermo = "SELECT * FROM main_floor WHERE user_name = 'rmanjre'";
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
							new PowerUsageMain("Fan");
						}
						else
							PowerUsageMain.Fan = false;
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
							new PowerUsageMain("Fan");
						}
						else
							PowerUsageMain.Fan = false;
						System.out.println();
					}
				}

				//Thermostat

				String thermo = "SELECT * FROM main_floor WHERE user_name = 'rmanjre'";
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
							new PowerUsageMain("Thermostat");
						}
						else
							PowerUsageMain.thermostat = false;
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
							new PowerUsageMain("Thermostat");
						}
						else
							PowerUsageMain.thermostat = false;
						System.out.println();
					}
				}


				//Lights living room

				String living = "SELECT * FROM lights_main WHERE user_name = 'rmanjre'";
				Statement stmt_living = connection.createStatement();
				ResultSet rs_living = stmt_living.executeQuery(living);
				//STEP 5: Extract data from result set
				while(rs_living.next()){
					//Retrieve by column name
					lights_living = rs_living.getString("living_room");

					//Display values
					if(lights_living.equals(new_lights_living)){

					}
					else
					{
						if(Integer.parseInt(lights_living) > 0)
						{
							new PowerUsageMain("Light");
						}
						else
							PowerUsageMain.light = false;
						System.out.print("Living room lights is at level: " + lights_living + "\n");
					}
				}

				ResultSet rs1_living = stmt_living.executeQuery(living);
				while(rs1_living.next()){
					//Retrieve by column name
					new_lights_living  = rs1_living.getString("living_room");

					//Display values
					if(new_lights_living.equals(lights_living)){

					}
					else
					{
						if(Integer.parseInt(new_lights_living) > 0)
						{
							new PowerUsageMain("Light");
						}
						else
							PowerUsageMain.light = false;
						System.out.print("Living room lights is at level: " + new_lights_living + "\n");
					}
				}


				//Lights kitchen

				String kitchen = "SELECT * FROM lights_main WHERE user_name = 'rmanjre'";
				Statement stmt_kitchen = connection.createStatement();
				ResultSet rs_kitchen = stmt_kitchen.executeQuery(kitchen);
				//STEP 5: Extract data from result set
				while(rs_kitchen.next()){
					//Retrieve by column name
					lights_kitchen = rs_kitchen.getString("kitchen");

					//Display values
					if(lights_kitchen.equals(new_lights_kitchen)){

					}
					else
						System.out.print("Kitchen lights is at level: " + lights_kitchen + "\n");
				}

				ResultSet rs1_kitchen = stmt_kitchen.executeQuery(kitchen);
				while(rs1_kitchen.next()){
					//Retrieve by column name
					new_lights_kitchen  = rs1_kitchen.getString("kitchen");

					//Display values
					if(new_lights_kitchen.equals(lights_kitchen)){

					}
					else
						System.out.print("Guest bed lights is at level: " + new_lights_kitchen + "\n");
				}

				
				
				//Lights porch

				String porch = "SELECT * FROM lights_main WHERE user_name = 'rmanjre'";
				Statement stmt_porch = connection.createStatement();
				ResultSet rs_porch = stmt_porch.executeQuery(porch);
				//STEP 5: Extract data from result set
				while(rs_porch.next()){
					//Retrieve by column name
					lights_porch = rs_porch.getString("porch");

					//Display values
					if(lights_porch.equals(new_lights_porch)){

					}
					else
						System.out.print("Porch lights is at level: " + lights_porch + "\n");
				}

				ResultSet rs1_porch = stmt_porch.executeQuery(porch);
				while(rs1_porch.next()){
					//Retrieve by column name
					new_lights_porch  = rs1_porch.getString("porch");

					//Display values
					if(new_lights_porch.equals(lights_porch)){

					}
					else
						System.out.print("Porch lights is at level: " + new_lights_porch + "\n");
				}
				
				
				//garage control

				String garage_control = "SELECT * FROM garage_control WHERE user_name = 'rmanjre'";
				Statement stmt_garage = connection.createStatement();
				ResultSet rs_garage = stmt_garage.executeQuery(garage_control);
				//STEP 5: Extract data from result set
				while(rs_garage.next()){
					//Retrieve by column name
					garage_open  = rs_garage.getString("open_door");

					//Display values
					if(garage_open.equals(new_garage_open)){

					}
					else
						System.out.print("Garage door status is: " + garage_open + "\n");
				}

				ResultSet rs1_garage = stmt.executeQuery(garage_control);
				while(rs1_garage.next()){
					//Retrieve by column name
					new_garage_open  = rs1_garage.getString("open_door");

					//Display values
					if(new_garage_open.equals(garage_open)){

					}
					else
						System.out.print("Garage door status is: " + new_garage_open + "\n");
				}

				
				
				//Thermostat

				String security_sys = "SELECT * FROM security_system WHERE user_name = 'rmanjre'";
				Statement stmt_security = connection.createStatement();
				ResultSet rs_security = stmt_security.executeQuery(security_sys);
				//STEP 5: Extract data from result set
				while(rs_security.next()){
					//Retrieve by column name

					security[0] = rs_security.getString("disarm");
					security[1]  = rs_security.getString("arm_stay");
					security[2]  = rs_security.getString("arm_away");
					//Display values
					if(Arrays.equals(security, new_security)){

					}
					else{
						System.out.print("Security Sys: ");
						for(int i = 0; i < 3; i++){
							System.out.print(security[i] + " ");
						}
						System.out.println();
					}

				}

				ResultSet rs1_security = stmt_security.executeQuery(security_sys);
				while(rs1_security.next()){
					//Retrieve by column name
					new_security[0] = rs1_security.getString("disarm");
					new_security[1]  = rs1_security.getString("arm_stay");
					new_security[2]  = rs1_security.getString("arm_away");

					//Display values
					if(Arrays.equals(security, new_security)){

					}
					else{
						System.out.print("Security Sys: ");
						for(int i = 0; i < 3; i++){
							System.out.print(new_security[i] + " ");
						}
						
						System.out.println();
					}
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
