package com.escalab.model;

import javax.persistence.*;
@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVendedor;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", nullable = false, foreignKey = @ForeignKey(name = "FK_vendedor_supervisor"))
    private Supervisor supervisor;
    @Column(name = "nombre_vendedor", length = 30)
    private String nombreVendedor;
    @Column(name = "dir_vendedor", length = 50)
    private String dirVendedor;

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getDirVendedor() {
        return dirVendedor;
    }

    public void setDirVendedor(String dirVendedor) {
        this.dirVendedor = dirVendedor;
    }
}
