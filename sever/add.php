<?php
    include '../connectDB.php';
    $conn = new mysqli($serverName, $username,$password,$dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    $name = $_POST["name"];
    $desc = $_POST["desc"];
    $price = $_POST["price"];
    $sql_checkProduct = "SELECT name FROM product WHERE name='$name'";
    $result = $conn->query($sql_checkProduct);
    if($result){
        if( $result->num_rows>0){
            echo "Product: " . $name . " is already exists";
        }else{
            $slq_create = "INSERT INTO product(name,description,price) VALUES ('$name','$desc',$price)";
            if($conn->query($slq_create)){
                echo "Add new product successfully";
            }else{
                echo "Error: " . $conn->error;
            }
        }
    }else{
        echo "Error: " . $conn->error;
    }
    $conn->close();
?>