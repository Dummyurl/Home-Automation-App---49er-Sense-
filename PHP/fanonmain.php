<?php
require "conn.php";
require "conn_utility.php";
$fan_off = $_POST["fan_off"];
$fan_auto = $_POST["fan_auto"];
$fan_on = $_POST["fan_on"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update main_floor set fan_off = '$fan_off' , fan_auto = '$fan_auto',fan_on = '$fan_on' where user_name = '$user_name'";			
$mysql_qry = "update utility_main_floor set fan_off = '$fan_off' , fan_auto = '$fan_auto',fan_on = '$fan_on' where user_name = '$user_name'";

if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Main Floor Fan On Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
