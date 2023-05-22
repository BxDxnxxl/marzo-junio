<?php 
include 'conexion.php';
$codigo=$_POST['codigo'];
$producto=$_POST['producto'];
$precio=$_POST['precio'];
$fabricante=$_POST['fabricante'];

$consulta = "insert into productos values('codigo', 'producto', 'precio', 'fabricante')";
mysqli_query($conexion,$consulta);
mysqli_close($conexion);
?>