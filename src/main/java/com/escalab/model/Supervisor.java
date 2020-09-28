package com.escalab.model;

import javax.persistence.*;

@Entity
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupervisor;
    @Column(name = "nombre", length = 30)
    private String nombre;
    @Column(name = "supervisor", length = 20)
    private String supervisor;
    @Column(name = "dir_upervisor", length = 50)
    private String dirSupervisor;
    @Column(name = "tel_supervisor", length = 15)
    private String telSupervisor;

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

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getDirSupervisor() {
        return dirSupervisor;
    }

    public void setDirSupervisor(String dirSupervisor) {
        this.dirSupervisor = dirSupervisor;
    }

    public String getTelSupervisor() {
        return telSupervisor;
    }

    public void setTelSupervisor(String telSupervisor) {
        this.telSupervisor = telSupervisor;
    }
}
