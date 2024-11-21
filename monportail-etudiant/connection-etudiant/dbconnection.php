<?php
$conn = mysqli_connect("localhost","root","","test");
if($conn == false){
    die("Connection error ".mysqli_connect_error());
    
}