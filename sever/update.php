<?php
include '../connectDB.php';
    $conn = new mysqli($serverName, $username,$password,$dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    $id = $_POST['id'];
    $name = $_POST['name'];
    $desc = $_POST['desc'];
    $price = $_POST['price'];
    $sql_update = "UPDATE product SET name ='$name', description = '$desc', price = '$price' WHERE id = '$id'";
    if($conn->query($sql_update)){
        echo "Product was updated";
    }else{
        echo 'Error: ' . $sql_create . "\n" . $conn->error;
    }
    $conn->close();
?>