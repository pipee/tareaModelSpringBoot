package com.escalab.model;

import javax.persistence.*;

@Entity
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSupervisor;
    @Column(name = "nombre_supervisor", length = 30)
    private String nombreSupervisor;
    @Column(name = "dir_upervisor", length = 50)
    private String dirSupervisor;
    @Column(name = "tel_supervisor", length = 15)
    private String telSupervisor;

    public long getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(long idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
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
