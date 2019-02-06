<?php
require "conn.php";
require "conn_utility.php";
$open_door = $_POST["open_door"];
$close_door = $_POST["close_door"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update garage_control set open_door = '$open_door' , close_door = '$close_door' where user_name = '$user_name'";	
$mysql_qry = "update utility_garage_control set open_door = '$open_door' , close_door = '$close_door' where user_name = '$user_name'";			


if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Garage Door Close Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
