package com.niit.EcomBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
public class Product {
	@Column
	@NotEmpty
	String productname;
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productid;
	@Column
	@NotEmpty
	String productdescription;
	@Column
	int quantity;
	@Column
	float price;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	Category category;
	
	@Transient
	MultipartFile productimage;
	
	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}
 
	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MultipartFile getProductimage() {
		return productimage;
	}

	public void setProductimage(MultipartFile productimage) {
		this.productimage = productimage;
	}


}

	