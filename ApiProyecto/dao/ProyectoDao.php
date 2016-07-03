<?php

require_once '../ds/MyPDO.php';

class ProyectoDao extends MyPDO 
{
    public function consultarCliente($dni) 
    {
        $rec = null;
        try 
        {            
            $query = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, 
				vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, 
				vch_clietelefono, vch_clieemail 
				from Cliente where chr_cliedni = ?";
            $stm = $this->pdo->prepare($query);
            $stm->bindParam(1, $dni);
            $stm->execute();
            $rec = $stm->fetch(PDO::FETCH_ASSOC);
        } 
        catch (Exception $e) 
        {
            throw $e;
        }
        return $rec;
    }

    public function registrarCliente($paterno,$materno,$nombres,$dni,$ciudad,$direccion,$telefono,$email) 
    {
        $estado = 'hoa';
        try 
        {            
            $stm = $this->pdo->prepare("call usp_Cliente_Registrar(?,?,?,?,?,?,?,?)");
            $stm->bindParam(1, $paterno);
            $stm->bindParam(2, $materno);
            $stm->bindParam(3, $nombres);
            $stm->bindParam(4, $dni);
            $stm->bindParam(5, $ciudad);
            $stm->bindParam(6, $direccion);
            $stm->bindParam(7, $telefono);
            $stm->bindParam(8, $email);
            $stm->execute();
            $estado = $stm->fetch(PDO::FETCH_ASSOC);
        } 
        catch (Exception $e) 
        {
            throw $e;
        }
        return $estado;
    } 
}
?>