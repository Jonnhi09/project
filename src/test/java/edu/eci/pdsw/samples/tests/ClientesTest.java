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
     * el cliente ya esta registrado, no se registra de nuevo ni se o se pierde infomacion debe arrojar la excepcion sin modificar.
     * El clinete es nuevo, se debe hacer el registro del cliente.
     * @throws ExcepcionServiciosAlquiler 
     */
    @Test
    public void registrarCliente() throws ExcepcionServiciosAlquiler{ //Clase de equivalecia 1 ya registrado
        Cliente p = new Cliente();
        ServiciosAlquilerItemsStub serv = new ServiciosAlquilerItemsStub();
        serv.registrarCliente(p);
        List<Cliente> listaClientes = serv.consultarClientes();
        boolean exception = false;
        try{
            serv.registrarCliente(p);
        }catch(ExcepcionServiciosAlquiler e){
            exception = true;
        }
        if(!serv.consultarClientes().equals(listaClientes) || !exception){
            fail("se modificaron datos o no se envia la excepcion adecuada, fallo el caso");
        }
        
    }
    
    
    @Test
    public void registrarNuevoClienteCE2() throws ExcepcionServiciosAlquiler{
        Cliente nuevoCliente = new Cliente();
        ServiciosAlquilerItemsStub servicio = new ServiciosAlquilerItemsStub();
        servicio.registrarCliente(nuevoCliente);
        assertTrue("Se registra un nuevo cliente", servicio.consultarClientes().contains(nuevoCliente));
    }
}