<?php
include '../connectDB.php';
    $conn = new mysqli($serverName, $username,$password,$dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    $id = $_GET['id'];
    $sql_delete = "DELETE FROM product WHERE id = '$id'";
    if($conn->query($sql_delete)){
        echo "Delete product successfully";
    }else{
        echo 'Error: ' . $sql_create . "\n" . $conn->error;
    }
    $conn->close();
?>