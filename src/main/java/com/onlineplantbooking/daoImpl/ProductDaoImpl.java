package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.util.ConnectionUtil;

public class ProductDaoImpl {

	static final String PLANTID = "PLANT_ID";
	static final String PLANTNAME = "PLANT_NAME";
	static final String PLANTDESCRIPTION = "PLANT_DESCRIPTION";
	static final String PLANTPRICE = "PLANT_PRICE";
	static final String CATEGORYNAME = "CATEGORY_NAME";
	static final String PICTURE = "PICTURE";
	static final String PLANTSTATUS = "PLANT_STATUS";
	static final String ORDERSID = "ORDERS_ID";
	static final String QUANTITY = "QUANTITY";
	static final String SUMQUANTITY = "quantiy";

	// show product
	public List<Product> showProduct() {
		List<Product> productList = new ArrayList<>();

		String showQuery = "select PLANT_ID,PLANT_NAME,PLANT_DESCRIPTION,PLANT_PRICE,CATEGORY_NAME,PICTURE"
				+ " from product_details where plant_status='active'";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		try {
			preparedStatement=connection.prepareStatement(showQuery);
			resultSet =preparedStatement .executeQuery();
			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt(PLANTID), resultSet.getString(PLANTNAME),
						resultSet.getString(PLANTDESCRIPTION), Integer.parseInt(resultSet.getString(PLANTPRICE)),
						resultSet.getString(CATEGORYNAME), resultSet.getString(PICTURE));
				productList.add(product);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return productList;

	}

	// insert product
	public void insertProduct(Product product) {
		String insertQuery = "insert into product_details(plant_name,plant_description,plant_price,category_name,picture)"
				+ " values(?,?,?,?,?)";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement pstPreparedStatement = null;
		try {
			pstPreparedStatement = connection.prepareStatement(insertQuery);
			pstPreparedStatement.setString(1, product.getPlantName());
			pstPreparedStatement.setString(2, product.getPlantDescription());
			pstPreparedStatement.setInt(3, product.getPlantPrice());
			pstPreparedStatement.setString(4, product.getCategoryName());
			pstPreparedStatement.setString(5, product.getImage());
			pstPreparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstPreparedStatement,connection);
		}

	}

	public List<Product> showInactiveProduct() {
		List<Product> productList = new ArrayList<Product>();

		String showQuery = "select PLANT_ID,PLANT_NAME,PLANT_DESCRIPTION,PLANT_PRICE,CATEGORY_NAME,PICTURE from "
				+ "product_details where plant_status='inactive'";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		try {
			preparedStatement=connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt(PLANTID), resultSet.getString(PLANTNAME),
						resultSet.getString(PLANTDESCRIPTION), Integer.parseInt(resultSet.getString(PLANTPRICE)),
						resultSet.getString(CATEGORYNAME), resultSet.getString(PICTURE));
				productList.add(product);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return productList;

	}

	public List<Product> findProductId(Product product) {
		String Query = "select plant_id,PLANT_NAME,PLANT_DESCRIPTION,plant_price,CATEGORY_NAME from product_details where plant_name=? and category_name=?";
		Connection connection = ConnectionUtil.getDbConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, product.getPlantName());

			preparedStatement.setString(2, product.getCategoryName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product1 = new Product(resultSet.getInt(PLANTID), resultSet.getString(PLANTNAME),
						resultSet.getString(PLANTDESCRIPTION), resultSet.getInt(PLANTPRICE),
						resultSet.getString(CATEGORYNAME));
				productList.add(product1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);

		}
		return productList;

	}

	public Product findProduct(int productId) {
		String query = "select plant_id,PLANT_NAME,PLANT_DESCRIPTION,plant_price,CATEGORY_NAME from "
				+ "product_details where plant_id=?";

		Connection connection = ConnectionUtil.getDbConnection();
		Product products = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				products = new Product(resultSet.getInt(PLANTID), resultSet.getString(PLANTNAME),
						resultSet.getString(PLANTDESCRIPTION), Integer.parseInt(resultSet.getString(PLANTPRICE)),
						resultSet.getString(CATEGORYNAME));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return products;

	}

	public int updateStatus(int plantId) {

		String updateQuery = "update product_details set plant_status='active'  where PLANT_ID=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement PreparedStatement = null;
		int i = 0;
		try {
			PreparedStatement = connection.prepareStatement(updateQuery);
			PreparedStatement.setInt(1, plantId);

			i = PreparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection);
		}

		return i;

	}

	public int updateProduct(int plantId, int plantprice) {

		String updateQuery = "update product_details set PLANT_PRICE=?  where PLANT_ID=?";

		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, plantprice);
			preparedStatement.setInt(2, plantId);
			i = preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection);
		}

		return i;

	}

//delete method 

	public void deleteProduct(int plantId) {
		String deleteQuery = "update  product_details set PLANT_STATUS ='inactive' where plant_id=?";

		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement PreparedStatement = null;
		try {
			PreparedStatement = connection.prepareStatement(deleteQuery);
			PreparedStatement.setInt(1, plantId);
			PreparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection);

		}
	}

	public List<Product> filterPlant(String search) {
		List<Product> plantList = new ArrayList<Product>();
		Product product = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		String plantName="%"+search+"%";
		String categoryName="%"+search+"%";
		String Query = "select PLANT_NAME,PLANT_DESCRIPTION,PLANT_PRICE,CATEGORY_NAME,PICTURE from product_details where PLANT_NAME like ? or  CATEGORY_NAME like ?";
		Connection connection = ConnectionUtil.getDbConnection();
		try {
			preparedStatement=connection.prepareStatement(Query);
			preparedStatement.setString(1,plantName );
			preparedStatement.setString(2,categoryName );
			resultSet =preparedStatement .executeQuery();
			while (resultSet.next()) {
				product = new Product(resultSet.getString(PLANTNAME), resultSet.getString(PLANTDESCRIPTION),
						resultSet.getInt(PLANTPRICE), resultSet.getString(CATEGORYNAME), resultSet.getString(PICTURE));
				plantList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);

		}

		return plantList;

	}

	public List<Orders> offerPlant() {
		String query = "select  p.plant_name,p.PLANT_PRICE,p.CATEGORY_NAME,p.plant_id,p.PLANT_DESCRIPTION ,p.PICTURE,"
				+ "sum(o.quantity) as quantiy from product_details p join order_details o on p.plant_id=o.plant_id group by"
				+ " (p.plant_name,p.plant_price,p.CATEGORY_NAME,p.plant_id,p.PLANT_DESCRIPTION,p.PICTURE ) order by sum(quantity)"
				+ " FETCH FIRST 3 ROWS ONLY";
		Connection connection = ConnectionUtil.getDbConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		List<Orders> products = new ArrayList<Orders>();

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt(PLANTID), resultSet.getString(PLANTNAME),
						resultSet.getString(PLANTDESCRIPTION), resultSet.getInt(PLANTPRICE),
						resultSet.getString(CATEGORYNAME), resultSet.getString(PICTURE));

				Orders order = new Orders();
				order.setProduct(product);
				order.setQuantity(resultSet.getInt(SUMQUANTITY));
				products.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return products;
	}

}
