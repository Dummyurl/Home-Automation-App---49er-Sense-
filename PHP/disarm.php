<?php
require "conn.php";
require "conn_utility.php";
$disarm = $_POST["disarm"];
$arm_away = $_POST["arm_away"];
$arm_stay = $_POST["arm_stay"];
$user_name = $_POST["user_name"];

$mysql_qry = "update security_system set disarm = '$disarm' , arm_away = '$arm_away', arm_stay = '$arm_stay' where user_name = '$user_name'";
$mysql_qry1 = "update utility_security_system set disarm = '$disarm' , arm_away = '$arm_away', arm_stay = '$arm_stay' where user_name = '$user_name'";			


if($conn->query($mysql_qry) && $connutil->query($mysql_qry1) === TRUE){
echo "Disarm Initiated";
}
else{
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>
