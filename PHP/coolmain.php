<?php
require "conn.php";
require "conn_utility.php";
$heat = $_POST["heat"];
$cool = $_POST["cool"];
$off = $_POST["off"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update main_floor set heat = '$heat',cool = '$cool' , off = '$off' where user_name = '$user_name'";		
$mysql_qry = "update utility_main_floor set heat = '$heat',cool = '$cool' , off = '$off' where user_name = '$user_name'";			


if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Main Floor Cool Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
