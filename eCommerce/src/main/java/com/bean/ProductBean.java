package com.bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String PCODE,PNAME,PCOMPANY,PRICE,PQTY;

	public String getPCODE() {
		return PCODE;
	}

	public String getPNAME() {
		return PNAME;
	}

	public String getPCOMPANY() {
		return PCOMPANY;
	}

	public String getPRICE() {
		return PRICE;
	}

	public String getPQTY() {
		return PQTY;
	}

	public void setPCODE(String pCODE) {
		PCODE = pCODE;
	}

	public void setPNAME(String pNAME) {
		PNAME = pNAME;
	}

	public void setPCOMPANY(String pCOMPANY) {
		PCOMPANY = pCOMPANY;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	public void setPQTY(String pQTY) {
		PQTY = pQTY;
	}
	public ProductBean(){

}
}
