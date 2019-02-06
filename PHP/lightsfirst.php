<?php
require "conn.php";
require "conn_utility.php";
$masterbed = $_POST["master_bedroom"];
$guestbed = $_POST["guest_bedroom"];
$user_name = $_POST["user_name"];

$mysql_qry = "update lights_first set master_bedroom = '$masterbed',guest_bedroom = '$guestbed' where user_name ='$user_name'"  ;		
$mysql_qry1 = "update utility_lights_first set master_bedroom = '$masterbed',guest_bedroom = '$guestbed' where user_name ='$user_name'"  ;		

if($conn->query($mysql_qry) && $connutil->query($mysql_qry1) === TRUE){
echo "First floor lights change initiated";
}
else{
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>
