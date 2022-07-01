<?php
$con = mysqli_connect("localhost","root","","gs");
if(!$con){
	echo mysqli_error($con);}
$query = mysqli_query($con,"select * from smartphone");
if($query){
	$json = array();
	while($l = mysqli_fetch_assoc($query)){
	 	$json[] =$l;
		}
}
else {
	$json = array("response" => 'error', "status" => 1, "message" => 'Error');
}
	header("Content-Type:application/json");
	echo json_encode($json);
?>
