<?php
    include '../connectDB.php';
    $conn = new mysqli($serverName, $username,$password,$dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
  
    $slq_getAll = "SELECT * FROM product";
    $result = $conn->query($slq_getAll);
    if($result && $result->num_rows>0){
        $productList = array();
        while($row = $result->fetch_assoc()){
           $product = array(
               "id"=>$row['id'],
               "name"=>$row['name'],
               "desc"=>$row['description'],
               "price"=>$row['price']
           );
           array_push($productList,$product);
        }
        echo json_encode($productList);
    }else{
        echo "Error: " . $conn->error;
    }
    $conn->close();
?>