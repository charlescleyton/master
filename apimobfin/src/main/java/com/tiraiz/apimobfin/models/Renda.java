package com.tiraiz.apimobfin.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_RENDA")
public class Renda implements Serializable {

    @Id
    private Long id_Renda;

    @NotNull
    private Double rd_valor;

    @NotNull
    private String rd_periodo;

    @NotNull
    private String rd_tipo;

    @NotNull
    private double rd_extra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRd_valor() {
        return rd_valor;
    }

    public void setRd_valor(Double rd_valor) {
        this.rd_valor = rd_valor;
    }

    public String getRd_periodo() {
        return rd_periodo;
    }

    public void setRd_periodo(String rd_periodo) {
        this.rd_periodo = rd_periodo;
    }

    public String getRd_tipo() {
        return rd_tipo;
    }

    public void setRd_tipo(String rd_tipo) {
        this.rd_tipo = rd_tipo;
    }

    public double getRd_extra() {
        return rd_extra;
    }

    public void setRd_extra(double rd_extra) {
        this.rd_extra = rd_extra;
    }

}
