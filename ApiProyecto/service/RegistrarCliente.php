<?php

require_once '../dao/ProyectoDao.php';

// Parámetros
$paterno= $_REQUEST["paterno"];
$materno=$_REQUEST["materno"];
$nombres = $_REQUEST["nombres"];
$dni= $_REQUEST["dni"];
$ciudad=$_REQUEST["ciudad"];
$direccion = $_REQUEST["direccion"];
$telefono= $_REQUEST["telefono"];
$email=$_REQUEST["email"];

// Proceso
$dao = new ProyectoDao();
$rec = $dao->registrarCliente($paterno,$materno,$nombres,$dni,$ciudad,$direccion,$telefono,$email);

if ($rec) {
    $rec["estado"] = 1; // Existe
} else {
    $rec["estado"] = 0; // No existe
}
$data = json_encode($rec);
// Retorno
echo $data;
?>