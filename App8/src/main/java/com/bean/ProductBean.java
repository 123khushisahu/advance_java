package com.bean;
import java.io.Serializable;

public class ProductBean implements Serializable{//1st


		//2nd
		private String pcode;
		private String pname;
		private String pcompany;
		private int pprice;
		private String pqty;
		//3rd
		public String getpcode() {
			return pcode;
		}
		public void setpcode(String pcode) {
			this.pcode = pcode;
		}
		public String getpname() {
			return pname;
		}
		public void setpname(String pname) {
			this.pname = pname;
		}
		public String getpcompany() {
			return pcompany;
		}
		public void setpcompany(String pcompany) {
			this.pcompany = pcompany;
		}
		public int getpprice() {
			return pprice;
		}
		public void setpprice(int pprice) {
			this.pprice = pprice;
		}
		public String getpqty() {
			return pqty;
		}
		public void setpqty(String pqty) {
			this.pqty = pqty;
		}
		//4th
		public ProductBean() {
			
		}
		public void set(String string) {
			// TODO Auto-generated method stub
			
		}
			
		

	}



