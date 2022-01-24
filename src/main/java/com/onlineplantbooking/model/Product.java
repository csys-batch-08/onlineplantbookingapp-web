package com.onlineplantbooking.model;



public class Product {
	
	private int plantId;
	private String plantName;
	private String plantDescription;
	private int plantPrice;
	private String categoryName;
	private String image;
	
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantDescription() {
		return plantDescription;
	}
	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}
	public int getPlantPrice() {
		return plantPrice;
	}
	public void setPlantPrice(int plantPrice) {
		this.plantPrice = plantPrice;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product() {
		super();
		
	}
	public Product(String plantName, String plantDescription, int plantPrice, String categoryName) {
		super();
		this.plantName = plantName;
		this.plantDescription = plantDescription;
		this.plantPrice = plantPrice;
		this.categoryName = categoryName;
		// TODO Auto-generated constructor stub
	}
	public Product(int int1, String string, String string2, int parseInt, String string3) {
		// TODO Auto-generated constructor stub

		this.plantId=int1;
		this.plantName = string;
		this.plantDescription = string2;
		this.plantPrice = parseInt;
		this.categoryName = string3;
	}
	public Product(String plantName1,String catName2) {
		this.plantName=plantName1;
		this.categoryName=catName2;
	}
	
	
	
	public Product(int plantId, String plantName, String plantDescription, int plantPrice, String categoryName,
			String image) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantDescription = plantDescription;
		this.plantPrice = plantPrice;
		this.categoryName = categoryName;
		this.image = image;
	}
	
	public Product(String plantName2, String plantDescription2, int plantPrice2, String category, String image2) {
		this.plantName = plantName2;
		this.plantDescription = plantDescription2;
		this.plantPrice = plantPrice2;
		this.categoryName = category;
		this.image = image2;
	
	}
	public Product(int int1) {
		// TODO Auto-generated constructor stub
		this.plantId=int1;
	}
	@Override
	public String toString() {
		return "Product [plantName=" + plantName + ", plantDescription=" + plantDescription + ", plantPrice="
				+ plantPrice + ", categoryName=" + categoryName + "]";
	}
}