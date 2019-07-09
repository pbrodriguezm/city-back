package com.dbg.model.test;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tt_tipo_inci database table.
 * 
 */
@Entity
@Table(name="tt_tipo_inci")
@NamedQuery(name="TtTipoInci.findAll", query="SELECT t FROM TtTipoInci t")
public class TtTipoInci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_INCI")
	private int idTipoInci;

	@Column(name="ACTI_INCI")
	private byte actiInci;

	@Column(name="DESC_INCI")
	private String descInci;

	public TtTipoInci() {
	}

	public int getIdTipoInci() {
		return this.idTipoInci;
	}

	public void setIdTipoInci(int idTipoInci) {
		this.idTipoInci = idTipoInci;
	}

	public byte getActiInci() {
		return this.actiInci;
	}

	public void setActiInci(byte actiInci) {
		this.actiInci = actiInci;
	}

	public String getDescInci() {
		return this.descInci;
	}

	public void setDescInci(String descInci) {
		this.descInci = descInci;
	}

}