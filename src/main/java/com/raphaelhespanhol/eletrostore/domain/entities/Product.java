package com.raphaelhespanhol.eletrostore.domain.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * @author Raphael Hespanhol
 * Data Access Objects for all Product fields
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name="id_category", referencedColumnName="id", nullable=false)
	private Category category;
	
	@NotBlank @Size(min=1, max=128)
	private String name;
	
	private double price;
	
	@Lob
	private byte[] image;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date lastUpdate;

	public Product() {}
	
	public Product(@JsonProperty("id") Long id, 
				   @JsonProperty("category") Category category,
				   @JsonProperty("name") String name, 
				   @JsonProperty("price") double price, 
				   @JsonProperty("image") byte[] image,
				   @JsonProperty("lastUpdate") Date lastUpdate) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.image = image;
		this.lastUpdate = lastUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + ", image="
				+ Arrays.toString(image) + ", lastUpdate=" + lastUpdate + "]";
	}
}
