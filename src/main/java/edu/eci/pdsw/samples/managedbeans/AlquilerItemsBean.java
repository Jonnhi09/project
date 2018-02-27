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
    private long costoAlquiler;
    private Item item;
    

    public AlquilerItemsBean() {
    }
    
    public List<Cliente> getClientes() throws ExcepcionServiciosAlquiler {
        return sp.consultarClientes();
    }
    
    public void registrarCliente() throws ExcepcionServiciosAlquiler{
        sp.registrarCliente(nuevoCliente);
    }
    
    public void registrarAlquiler() throws ExcepcionServiciosAlquiler{
        sp.registrarAlquilerCliente(Date.valueOf(LocalDate.now()), selected.getDocumento(), this.item, this.diasAlquiler);
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
    
    /*public void setRentados(){
        this.rentados = this.selected.getRentados();
    }*/
    
    public ArrayList<ItemRentado> getRentados(){
        this.rentados = this.selected.getRentados();
        return this.rentados;
    }

    public ArrayList getMultas() throws ExcepcionServiciosAlquiler {
        for(ItemRentado i:this.rentados){
            this.multas.add(sp.consultarMultaAlquiler(i.getItem().getId(), i.getFechafinrenta()));
        }
        return multas;
    }

    /*public void setMultas() throws ExcepcionServiciosAlquiler {
        for(ItemRentado i:this.rentados){
            this.multas.add(sp.consultarMultaAlquiler(i.getItem().getId(), i.getFechafinrenta()));
        }
    }*/
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public long getCostoAlquiler() {
        return costoAlquiler;
    }

    public void calcularCostoAlquiler() throws ExcepcionServiciosAlquiler {
        this.costoAlquiler = this.item.getTarifaxDia()*this.diasAlquiler;
    }
    
    public void setItem() throws ExcepcionServiciosAlquiler{
        this.item=sp.consultarItem(idItem); 
    }

    public Item getItem() {
        return item;
    }

    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }
    
    
    
    
}
