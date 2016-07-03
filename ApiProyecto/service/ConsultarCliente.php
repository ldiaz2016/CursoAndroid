<?php

require_once '../dao/ProyectoDao.php';

// Parámetros
$dni = $_REQUEST["dni"];
//$codigo='00003';

// Proceso
$dao = new ProyectoDao();
$rec = $dao->consultarCliente($dni);
if ($rec) {
    $rec["estado"] = 1; // Existe
} else {
    $rec["estado"] = 0; // No existe
}
$data = json_encode($rec);

// Retorno
echo $data;
?>