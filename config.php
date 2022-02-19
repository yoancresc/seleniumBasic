<?php

$dbHost = 'localhost';
$dbName = 'ecommerce_db';
$dbUsername = 'root';
$dbPassword = '';
 
$mysqli = mysqli_connect($dbHost, $dbUsername, $dbPassword, $dbName); 
if($mysqli === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
 
?>