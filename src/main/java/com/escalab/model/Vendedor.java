package com.escalab.model;

import javax.persistence.*;

public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", nullable = false, foreignKey = @ForeignKey(name = "FK_vendedor_supervisor"))
    private Long idSupervisor;
    @Column(name = "nombre", length = 30)
    private String nombre;
    @Column(name = "vendedor", length = 20)
    private String vendedor;
    @Column(name = "dir_vendedor", length = 50)
    private String dirVendedor;

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Long getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Long idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getDirVendedor() {
        return dirVendedor;
    }

    public void setDirVendedor(String dirVendedor) {
        this.dirVendedor = dirVendedor;
    }
}
