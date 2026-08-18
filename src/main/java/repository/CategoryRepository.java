package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category_Bean;

public class CategoryRepository {
	
	public List<Category_Bean> gellAllCategory(){
 List<Category_Bean> catlist = new ArrayList<Category_Bean>();

		String sql = "SELECT * FROM category ";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

		while (rs.next()) {
				Category_Bean obj=new Category_Bean();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				
				catlist.add(obj);
			
			}

		} catch (SQLException e) {
			System.out.println("category listt error : " + e.getMessage());
		}

		return catlist;  

	}

	
}
