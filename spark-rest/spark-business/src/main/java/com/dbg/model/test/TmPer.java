package com.dbg.model.test;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tm_pers database table.
 * 
 */
@Entity
@Table(name="TM_PERS")
@NamedQuery(name="TmPer.findAll", query="SELECT t FROM TmPer t")
public class TmPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERS")
	private int idPers;

	@Column(name="DIRE_PERS")
	private String direPers;

	@Column(name="DNI_PERS")
	private String dniPers;

	@Column(name="EMAIL_PERS")
	private String emailPers;

	@Column(name="ID_USUA")
	private String idUsua;

	@Column(name="NB_PERS")
	private String nbPers;

	@Column(name="TELF_PERS")
	private String telfPers;

	//bi-directional many-to-one association to TcInci
	@OneToMany(mappedBy="tmPer")
	private List<TcInci> tcIncis;

	//bi-directional many-to-one association to TmUsua
	//@OneToMany(mappedBy="tmPer")
	//private List<TmUsua> tmUsuas;

	public TmPer() {
	}

	public int getIdPers() {
		return this.idPers;
	}

	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}

	public String getDirePers() {
		return this.direPers;
	}

	public void setDirePers(String direPers) {
		this.direPers = direPers;
	}

	public String getDniPers() {
		return this.dniPers;
	}

	public void setDniPers(String dniPers) {
		this.dniPers = dniPers;
	}

	public String getEmailPers() {
		return this.emailPers;
	}

	public void setEmailPers(String emailPers) {
		this.emailPers = emailPers;
	}

	public String getIdUsua() {
		return this.idUsua;
	}

	public void setIdUsua(String idUsua) {
		this.idUsua = idUsua;
	}

	public String getNbPers() {
		return this.nbPers;
	}

	public void setNbPers(String nbPers) {
		this.nbPers = nbPers;
	}

	public String getTelfPers() {
		return this.telfPers;
	}

	public void setTelfPers(String telfPers) {
		this.telfPers = telfPers;
	}

	public List<TcInci> getTcIncis() {
		return this.tcIncis;
	}

	public void setTcIncis(List<TcInci> tcIncis) {
		this.tcIncis = tcIncis;
	}

	public TcInci addTcInci(TcInci tcInci) {
		getTcIncis().add(tcInci);
		tcInci.setTmPer(this);

		return tcInci;
	}

	public TcInci removeTcInci(TcInci tcInci) {
		getTcIncis().remove(tcInci);
		tcInci.setTmPer(null);

		return tcInci;
	}

	//public List<TmUsua> getTmUsuas() {
	//	return this.tmUsuas;
	//}

	//public void setTmUsuas(List<TmUsua> tmUsuas) {
	//	this.tmUsuas = tmUsuas;
	//}

	/*public TmUsua addTmUsua(TmUsua tmUsua) {
		getTmUsuas().add(tmUsua);
		tmUsua.setTmPer(this);

		return tmUsua;
	}

	public TmUsua removeTmUsua(TmUsua tmUsua) {
		getTmUsuas().remove(tmUsua);
		tmUsua.setTmPer(null);

		return tmUsua;
	}*/

}