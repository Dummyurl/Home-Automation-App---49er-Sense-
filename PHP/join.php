<?php

require "conn_utility.php";
/* Attempt MySQL server connutilection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
 
$user_name = $_POST["user_name"];
// Check connutilection
if($connutil === false){
    die("ERROR: Could not connutilect. " . mysqli_connutilect_error());
}
 
// Attempt select query execution
$sql = "SELECT * from  utility_dw_sensors ud  
inner join utility_first_floor uf  
inner join utility_garage_control ug  
inner join utility_lights_first ufl 
inner join utility_lights_main ufm 
inner join utility_locks ulocks 
inner join utility_main_floor umanifloor 
inner join utility_security_system system
 on ud.user_name = uf.user_name and uf.user_name = ug.user_name and ug.user_name = ufl.user_name and ufl.user_name = ufm.user_name and ufm.user_name = ulocks.user_name and ulocks.user_name = umanifloor.user_name and umanifloor.user_name = system.user_name  
 where uf.user_name = 'rmanjre'";
if($result = mysqli_query($connutil, $sql)){
    if(mysqli_num_rows($result) > 0){
        while($row = mysqli_fetch_array($result)){
                echo "main_on=".$row['main_on']."\nmain_off=".$row['main_off']."\nfirst_on=".$row['first_off']."\nfan_off=".$row['fan_off']."\nfan_auto=".$row['fan_auto']."\nfan_on=".$row['fan_on']."\nheat=".$row['heat']."\ncool=".$row['cool']."\noff=".$row['off']."\nopen_door=".$row['open_door']."\nclose_door=".$row['close_door']."\nmaster_bedroom=".$row['master_bedroom']."\nguest_bedroom=".$row['guest_bedroom']."\nliving_room=".$row['living_room']."\nkitchen=".$row['kitchen']."\nporch=".$row['porch']."\nback_lock=".$row['back_lock']."\nback_unlock=".$row['back_unlock']."\nfront_lock=".$row['front_lock']."\nfront_unlock=".$row['front_unlock']."\ndisarm=".$row['disarm']."\narm_stay=".$row['arm_stay']."\narm_away=".$row['arm_away'];
        }
        // Free result set
        mysqli_free_result($result);
    } else{
        echo "No records matching your query were found.";
    }
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($connutil);
}
 
// Close connutilection
mysqli_close($connutil);
?>