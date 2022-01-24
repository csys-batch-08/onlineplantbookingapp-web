package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.util.ConnectionUtil;

public class ProductDaoImpl {
   //show product   
	
	
	public List<Product> showProduct(){
    	  List<Product> productList=new ArrayList<Product>();
    	  
    	  
    	  String showQuery="select *from product_details";
    	  Connection con=ConnectionUtil.getDbConnection();
    	  
    	  try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6));
				productList.add(product);
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		   	  
    	  
      }
    public static ResultSet findProductId(Product product)
    {
		String Query="select plant_id,plant_price from product_details where plant_name=? and category_name=?";
		Connection con=ConnectionUtil.getDbConnection();
		int productId=0;
		ResultSet rs=null;
	 
		    try {
				PreparedStatement ps=con.prepareStatement(Query);
				ps.setString(1,product.getPlantName());
				ps.setString(2,product.getCategoryName());
				rs=ps.executeQuery();
				
				//System.out.println(productId);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
			
    }
			
			
    public static Product findProduct(int productId)
	{
		String query="select * from product_details where plant_id=?";
		
		Connection con=ConnectionUtil.getDbConnection();
		Product products=null;
		try {
			PreparedStatement pre=con.prepareStatement(query);
			pre.setInt(1, productId);
			
			ResultSet rs=pre.executeQuery();
			
			if(rs.next())
			{
				products=new Product(rs.getInt(1),rs.getString(2), rs.getString(3),Integer.parseInt(rs.getString(4)), rs.getString(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return products;
		
	}
    
    
    
    
    
    public  int updateProduct(int plantId,int plantprice) throws ClassNotFoundException, SQLException {
    	
    	
    			String updateQuery = "update product_details set PLANT_PRICE=?  where PLANT_ID=?";
				
				Connection con = ConnectionUtil.getDbConnection();
				PreparedStatement pstmt2 = con.prepareStatement(updateQuery);
				System.out.print(plantprice);
				pstmt2.setInt(1, plantprice);
				pstmt2.setInt(2, plantId);
				
				int i = pstmt2.executeUpdate();
				System.out.println("update");
				System.out.println(i + "row updated");
				return i;
			
		}
							
//delete method 
				
				public static void deleteProduct(int plantId) throws ClassNotFoundException, SQLException {
					String deleteQuery = "delete from product_details where plant_id=?";

					Connection con = ConnectionUtil.getDbConnection();
					//System.out.println("Connection successfully");
					PreparedStatement pstmt = con.prepareStatement(deleteQuery);
					pstmt.setInt(1, plantId);
					int i = pstmt.executeUpdate();
					pstmt.close();
					con.close();
				}
				
			
//insert product
				    public void insertProduct(Product product) throws SQLException  {
					String insertQuery="insert into product_details(plant_name,plant_description,plant_price,category_name,picture) values(?,?,?,?,?)";
					Connection con=ConnectionUtil.getDbConnection();
					PreparedStatement pstmt=con.prepareStatement(insertQuery);
					pstmt.setString(1,product.getPlantName());
					pstmt.setString(2,product.getPlantDescription());
					pstmt.setInt(3,product.getPlantPrice());
					pstmt.setString(4,product.getCategoryName());
					pstmt.setString(5,product.getImage());
			        pstmt.executeUpdate();
							
				}
	public List<Product> filterPlant(String search){
		List<Product> plantList=new ArrayList<Product>();
		Product product=null;
		String Query="select * from product_details where PLANT_NAME like '"+search+"%' or  CATEGORY_NAME like '"+search+"%'"; 
		ConnectionUtil conUtil=new ConnectionUtil();
		Connection con=ConnectionUtil.getDbConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			while(rs.next())
			{
				product=new Product(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			    plantList.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plantList;
		
	}				
				    
		public ResultSet offerPlant() {
			String query="select  p.plant_name,p.PLANT_PRICE,p.CATEGORY_NAME,p.plant_id,p.PLANT_DESCRIPTION ,sum(o.quantity) quantiy from product_details p join order_details o on p.plant_id=o.plant_id group by (p.plant_name,p.plant_price,p.CATEGORY_NAME,p.plant_id,p.PLANT_DESCRIPTION ) order by sum(quantity) FETCH FIRST 1 ROWS ONLY";
					
			ConnectionUtil conUtil=new ConnectionUtil();
			Connection con=ConnectionUtil.getDbConnection();
			ResultSet resultSet=null;
			try {
				PreparedStatement preparedStatement=con.prepareStatement(query);
				resultSet=preparedStatement.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultSet;
		}
						
					}





		
    	
    
    
