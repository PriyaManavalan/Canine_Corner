package com.niit.EcomBackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Category")
public class Category
{
	@Column(nullable=false,unique=true)
	@NotEmpty(message="cannot be blank")
	String categoryname;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int categoryid;
	
	@Column(nullable=false)
	@NotEmpty(message="cannot be blank")
	String categorydescription;

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategorydescription() {
		return categorydescription;
	}

	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}

		
	
	
}
