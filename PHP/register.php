<?php
require "conn.php";
require "conn_utility.php";
require "conn_power.php";
$name = $_POST["name"];
$surname = $_POST["surname"];
$user_name = $_POST["user_name"];
$password = $_POST["password"];
$mobile_num = $_POST["mobile_num"];
$email_id = $_POST["email_id"];
$user = $_POST["user"];

$mysql_qry = "insert into customer_data (name, surname, user_name, password, mobile_num, email_id, user) values ('$name','$surname','$user_name','$password','$mobile_num','$email_id','$user')"; 
$mysql_qry1 = "insert into dw_sensors (user_name) values ('$user_name')";	
$mysql_qry2 = "insert into first_floor (user_name) values ('$user_name')";	
$mysql_qry3 = "insert into garage_control (user_name) values ('$user_name')";	
$mysql_qry4 = "insert into locks (user_name) values ('$user_name')";	
$mysql_qry5 = "insert into main_floor (user_name) values ('$user_name')";	
$mysql_qry6 = "insert into security_system (user_name) values ('$user_name')";
$mysql_qry7 = "insert into lights_main (user_name) values ('$user_name')";
$mysql_qry8 = "insert into lights_first (user_name) values ('$user_name')";	
$mysql_qry9 = "insert into utility_customer_data (name, surname, user_name, password, mobile_num, email_id, user) values ('$name','$surname','$user_name','$password','$mobile_num','$email_id','$user')"; 
$mysql_qry10 = "insert into utility_dw_sensors (user_name) values ('$user_name')";	
$mysql_qry11 = "insert into utility_first_floor (user_name) values ('$user_name')";	
$mysql_qry12 = "insert into utility_garage_control (user_name) values ('$user_name')";	
$mysql_qry13 = "insert into utility_locks (user_name) values ('$user_name')";	
$mysql_qry14 = "insert into utility_main_floor (user_name) values ('$user_name')";	
$mysql_qry15 = "insert into utility_security_system (user_name) values ('$user_name')";
$mysql_qry16 = "insert into utility_lights_main (user_name) values ('$user_name')";
$mysql_qry17 = "insert into utility_lights_first (user_name) values ('$user_name')";	
$mysql_qry18 = "insert into power_pgen_first (user_name) values ('$user_name')";
$mysql_qry19 = "insert into power_pgen_main (user_name) values ('$user_name')";


if($conn->query($mysql_qry) && $conn->query($mysql_qry1)&& $conn->query($mysql_qry2)&& $conn->query($mysql_qry3)&& $conn->query($mysql_qry4)&& $conn->query($mysql_qry5)&& $conn->query($mysql_qry6)&& $conn->query($mysql_qry7)&& $conn->query($mysql_qry8)&& $connutil->query($mysql_qry9)&& $connutil->query($mysql_qry10) && $connutil->query($mysql_qry11) && $connutil->query($mysql_qry12) && $connutil->query($mysql_qry13) && $connutil->query($mysql_qry14) && $connutil->query($mysql_qry15) && $connutil->query($mysql_qry16) && $connutil->query($mysql_qry17) && $connpower->query($mysql_qry18)&& $connpower->query($mysql_qry19)  === TRUE){
echo "Registration Successful";
}
else{
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>


