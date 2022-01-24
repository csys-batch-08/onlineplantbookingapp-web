package com.onlineplantbooking.dao;

import java.util.List;

public interface ProductDao {
	public List<ProductDao> showProduct();
	public   int findProductId(ProductDao productDao);
	public  ProductDao findProduct(int productId);
	public  void updateProduct(String plantName,int plantId);
	public  void deleteProduct(int plantId);
}
