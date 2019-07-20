package com.niit.EcomBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int supplierId;
	@Column(nullable=false)
	@NotEmpty(message="required")
	String supplierName;
	@Column(nullable=false)
	@NotEmpty(message="required")
	String supplierLocation;
	@Column(nullable=false,unique=true)
	@NotEmpty(message="required")
	String phNo;
	@Column(nullable=false,unique=true)
	@NotEmpty(message="required")
	String supplierEmailid;
	@Column(nullable=false)
	@NotEmpty(message="required")
	@Transient
	String supplierPassword;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierLocation() {
		return supplierLocation;
	}
	public void setSupplierLocation(String supplierLocation) {
		this.supplierLocation = supplierLocation;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getSupplierEmailid() {
		return supplierEmailid;
	}
	public void setSupplierEmailid(String supplierEmailid) {
		this.supplierEmailid = supplierEmailid;
	}
	public String getSupplierPassword() {
		return supplierPassword;
	}
	public void setSupplierPassword(String supplierPassword) {
		this.supplierPassword = supplierPassword;
	}
}
