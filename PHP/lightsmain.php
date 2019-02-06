<?php
require "conn.php";
require "conn_utility.php";
$kitchen = $_POST["kitchen"];
$porch = $_POST["porch"];
$lroom = $_POST["lroom"];
$user_name = $_POST["user_name"];

$mysql_qry = "update lights_main set kitchen = '$kitchen',porch = '$porch', living_room = '$lroom' where user_name ='$user_name'"  ;			
$mysql_qry1 = "update utility_lights_main set kitchen = '$kitchen',porch = '$porch', living_room = '$lroom' where user_name ='$user_name'"  ;

if($conn->query($mysql_qry) && $connutil->query($mysql_qry1) === TRUE){
echo "Main floor lights change initiated";
}
else{
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>
