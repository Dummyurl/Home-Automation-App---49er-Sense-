<?php
require "conn.php";
require "conn_utility.php";
$back_lock = $_POST["back_lock"];
$back_unlock = $_POST["back_unlock"];
$user_name = $_POST["user_name"];

$mysql_qry7 = "update locks set back_lock = '$back_lock' , back_unlock = '$back_unlock' where user_name = '$user_name'";		
$mysql_qry = "update utility_locks set back_lock = '$back_lock' , back_unlock = '$back_unlock' where user_name = '$user_name'";		

if($conn->query($mysql_qry7) && $connutil->query($mysql_qry) === TRUE){
echo "Back Lock Initiated";
}
else{
echo "Error: " . $mysql_qry7 . "<br>" . $conn->error;
}
$conn->close();
?>
