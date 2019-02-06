<?php
require "conn_utility.php";
$name = $_POST["name"];
$user_name = $_POST["user_name"];
$password = $_POST["password"];
$mobile_num = $_POST["mobile_num"];
$email_id = $_POST["email_id"];
$user = $_POST["user"];

$mysql_qry = "insert into utility_data (company_name, user_name, password, mobile_num, email_id, user) values ('$name','$user_name','$password','$mobile_num','$email_id','$user')"; 


if($connutil->query($mysql_qry) === TRUE){
echo "Utility Company Registration Successful!!!";
}
else{
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$connutil->close();
?>
