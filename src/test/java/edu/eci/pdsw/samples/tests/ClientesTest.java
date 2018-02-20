/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerItemsStub;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 */
public class ClientesTest {

    public ClientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    /**
     * Clases de quivalencia, resultado
     * el cliente ya esta registrado, no se registra de nuevo ni se o se pierde unfomacion debe arrojar la excepcion sin modificar.
     * El clinete es nuevo, se debe hacer el registro del cliente.
     * @throws ExcepcionServiciosAlquiler 
     */
    @Test
    public void registrarCliente() throws ExcepcionServiciosAlquiler{
        Cliente p = new Cliente();
        ServiciosAlquilerItemsStub serv = new ServiciosAlquilerItemsStub();
        serv.registrarCliente(p);
        List<Cliente> lc = serv.consultarClientes();
        boolean b = false;
        try{
            serv.registrarCliente(p);
        }catch(ExcepcionServiciosAlquiler e){
            b = true;
        }
        if(!serv.consultarClientes().equals(lc) || b){
            fail("se modificaron datos o no se envia la excepcion adecuada, fallo el caso");
        }
        
    }
    
    
    @Test
    public void additems1() throws ExcepcionServiciosAlquiler{
    	
    }
    
    
    
    
    
    
    
}
