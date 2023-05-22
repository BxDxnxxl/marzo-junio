<?php 
include 'conexion.php';
$codigo=$_POST['codigo'];
$producto=$_POST['producto'];
$precio=$_POST['precio'];
$fabricante=$_POST['fabricante'];

$consulta = "update productos set producto = '$producto', precio='$precio', fabricante='$fabricante' where codigo='$codigo'";
mysqli_query($conexion,$consulta);
mysqli_close($conexion);
?>