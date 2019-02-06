<?php
require "conn.php";
require "conn_utility.php";
$front_lock = $_POST["front_lock"];
$front_unlock = $_POST["front_unlock"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update locks set front_lock = '$front_lock' , front_unlock = '$front_unlock' where user_name = '$user_name'";			
$mysql_qry = "update utility_locks set front_lock = '$front_lock' , front_unlock = '$front_unlock' where user_name = '$user_name'";

if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Front Lock Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
