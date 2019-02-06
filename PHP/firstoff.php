<?php
require "conn.php";
require "conn_utility.php";
$first_on = $_POST["first_on"];
$first_off = $_POST["first_off"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update dw_sensors set first_on = '$first_on' , first_off = '$first_off' where user_name = '$user_name'";			
$mysql_qry = "update utility_dw_sensors set first_on = '$first_on' , first_off = '$first_off' where user_name = '$user_name'";	

if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "First Floor Door/Window Sensors Off Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
