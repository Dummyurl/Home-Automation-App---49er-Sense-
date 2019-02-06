<?php
require "conn.php";
require "conn_utility.php";
$disarm = $_POST["disarm"];
$arm_away = $_POST["arm_away"];
$arm_stay = $_POST["arm_stay"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update security_system set disarm = '$disarm' , arm_away = '$arm_away', arm_stay = '$arm_stay' where user_name = '$user_name'";
$mysql_qry = "update utility_security_system set disarm = '$disarm' , arm_away = '$arm_away', arm_stay = '$arm_stay' where user_name = '$user_name'";			


if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Armaway Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
