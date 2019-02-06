<?php
require "conn.php";
require "conn_utility.php";
$main_on = $_POST["main_on"];
$main_off = $_POST["main_off"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update dw_sensors set main_on = '$main_on' , main_off = '$main_off' where user_name = '$user_name'";			
$mysql_qry = "update utility_dw_sensors set main_on = '$main_on' , main_off = '$main_off' where user_name = '$user_name'";

if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Main Floor Door/Window Sensors On Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
