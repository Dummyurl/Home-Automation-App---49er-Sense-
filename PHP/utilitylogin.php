<?php
require "conn_utility.php";
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$mysql_qry = "select * from utility_data where user_name like '$user_name' and password like '$user_pass';";
$result = mysqli_query($connutil ,$mysql_qry);
if(mysqli_num_rows($result) > 0){
	$row = mysqli_fetch_assoc($result);
	$name = $row["company_name"];
echo "New Utility Company";
}
else{
echo "Error";
}
?>
