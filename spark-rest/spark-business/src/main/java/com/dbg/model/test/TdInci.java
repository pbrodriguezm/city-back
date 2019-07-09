package com.dbg.model.test;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the td_inci database table.
 * 
 */
@Entity
@Table(name="td_inci")
@NamedQuery(name="TdInci.findAll", query="SELECT t FROM TdInci t")
public class TdInci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INCI")
	private int idInci;

	@Column(name="DESC_INCI")
	private String descInci;

	@Column(name="ESTA_INCI")
	private String estaInci;

	@Column(name="FECH_INCI")
	private String fechInci;

	@Column(name="TIPO_INCI")
	private String tipoInci;

	//bi-directional many-to-one association to TcInci
	@ManyToOne
	@JoinColumn(name="TC_INCI_ID_INCI")
	private TcInci tcInci;

	public TdInci() {
	}

	public int getIdInci() {
		return this.idInci;
	}

	public void setIdInci(int idInci) {
		this.idInci = idInci;
	}

	public String getDescInci() {
		return this.descInci;
	}

	public void setDescInci(String descInci) {
		this.descInci = descInci;
	}

	public String getEstaInci() {
		return this.estaInci;
	}

	public void setEstaInci(String estaInci) {
		this.estaInci = estaInci;
	}

	public String getFechInci() {
		return this.fechInci;
	}

	public void setFechInci(String fechInci) {
		this.fechInci = fechInci;
	}

	public String getTipoInci() {
		return this.tipoInci;
	}

	public void setTipoInci(String tipoInci) {
		this.tipoInci = tipoInci;
	}

	public TcInci getTcInci() {
		return this.tcInci;
	}

	public void setTcInci(TcInci tcInci) {
		this.tcInci = tcInci;
	}

}