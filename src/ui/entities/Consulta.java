package ui.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JTextField;


public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeMedico;
    private String medicacaoSolicitada;
    private String procedimentoSolicitado;
    private double valorConsulta;
    private Date dataConsulta;


    public Consulta(Integer id, String nomeMedico, String medicacaoSolicitada,  String procedimentoSolicitado, double valorConsulta, Date dataConsulta) {
        this.id = id;
        this.nomeMedico = nomeMedico;
        this.medicacaoSolicitada = medicacaoSolicitada;
        this.procedimentoSolicitado = procedimentoSolicitado;
        this.valorConsulta = valorConsulta;
        this.dataConsulta = dataConsulta;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNomeMedico() {
        return nomeMedico;
    }


    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }


    public String getMedicacaoSolicitada() {
        return medicacaoSolicitada;
    }


    public void setMedicacaoSolicitada(String medicacaoSolicitada) {
        this.medicacaoSolicitada = medicacaoSolicitada;
    }


    public String getProcedimentoSolicitado() {
        return procedimentoSolicitado;
    }


    public void setProcedimentoSolicitado(String procedimentoSolicitado) {
        this.procedimentoSolicitado = procedimentoSolicitado;
    }


    public double getValorConsulta() {
        return valorConsulta;
    }


    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }


    public Date getDataConsulta() {
        return dataConsulta;
    }


    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String toString() {
        return "Consulta [id=" + id + ", nomeMedico=" + nomeMedico + ", medicacaoSolicitada=" + medicacaoSolicitada + ", procedimentoSolicitado=" + procedimentoSolicitado + ", valorConsulta="
                + valorConsulta + "dataConsulta =" + dataConsulta + "]";
    }}