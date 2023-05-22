<?php 
$hostname = '127.0.0.1';
$database = 'mysqlwebservices';
$username = 'root';
$password= '';

$conexion=new mysqli($hostname, $username, $password, $database);
if($conexion->connect_errno){
    echo "la bse de datos experimenta problemas";
}
?>