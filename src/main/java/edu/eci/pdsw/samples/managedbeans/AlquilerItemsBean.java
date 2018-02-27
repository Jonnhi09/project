/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "AlquilerItems")
@SessionScoped
public class AlquilerItemsBean implements Serializable {

    ServiciosAlquiler sp = ServiciosAlquiler.getInstance();
    private Cliente selected;
    private ArrayList<ItemRentado> rentados;
    private ArrayList<Long> multas;
    private String direccion;
    private Cliente nuevoCliente;
    private int idItem;
    private int diasAlquiler;
    

    public AlquilerItemsBean() {
        nuevoCliente = new Cliente();
    }
    
    public List<Cliente> getClientes() throws ExcepcionServiciosAlquiler {
        return sp.consultarClientes();
    }
    
    public void registrarCliente() throws ExcepcionServiciosAlquiler{
        sp.registrarCliente(nuevoCliente);
        nuevoCliente = new Cliente();
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<ItemRentado> getRentados() {
        return rentados;
    }

    public void setRentados(ArrayList<ItemRentado> rentados) {
        this.rentados = rentados;
    }

    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }   
}
