package com.dbg.model.test;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tc_inci database table.
 * 
 */
@Entity
@Table(name="tc_inci")
@NamedQuery(name="TcInci.findAll", query="SELECT t FROM TcInci t")
public class TcInci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INCI")
	private int idInci;

	//bi-directional many-to-one association to TmPer
	@ManyToOne
	@JoinColumn(name="TM_PERS_ID_PERS1")
	private TmPer tmPer;

	//bi-directional many-to-one association to TdInci
	@OneToMany(mappedBy="tcInci")
	private List<TdInci> tdIncis;

	public TcInci() {
	}

	public int getIdInci() {
		return this.idInci;
	}

	public void setIdInci(int idInci) {
		this.idInci = idInci;
	}

	public TmPer getTmPer() {
		return this.tmPer;
	}

	public void setTmPer(TmPer tmPer) {
		this.tmPer = tmPer;
	}

	public List<TdInci> getTdIncis() {
		return this.tdIncis;
	}

	public void setTdIncis(List<TdInci> tdIncis) {
		this.tdIncis = tdIncis;
	}

	public TdInci addTdInci(TdInci tdInci) {
		getTdIncis().add(tdInci);
		tdInci.setTcInci(this);

		return tdInci;
	}

	public TdInci removeTdInci(TdInci tdInci) {
		getTdIncis().remove(tdInci);
		tdInci.setTcInci(null);

		return tdInci;
	}

}