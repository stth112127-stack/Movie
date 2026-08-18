package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MovieBean;

public class MovieRepository {

	public List<MovieBean> getMoviesByCatId(int categoryid){
		 List<MovieBean> movlist = new ArrayList<MovieBean>();

				String sql = "SELECT * FROM movie where category_id=?";

				try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

					ps.setInt(1, categoryid);
					ResultSet rs = ps.executeQuery();

				while (rs.next()) {
						MovieBean obj=new MovieBean();
						obj.setId(rs.getInt("id"));
						obj.setTitle(rs.getString("title"));
						obj.setRelease_year(rs.getDate("release_year").toLocalDate());
						obj.setDuration(rs.getString("duration"));
						obj.setDescription(rs.getString("description"));
						obj.setCategory_id(rs.getInt("category_id"));
						
						
						movlist.add(obj);
					
					}

				} catch (SQLException e) {
					System.out.println("movie listt error : " + e.getMessage());
				}

				return movlist;

			
			}
	
	public int rentMovie(int memberId,int movieId) {
		int i = 0;

		String sql = " insert into movie_rented(member_id,movie_id) values(?,?)";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, memberId);
			ps.setInt(2, movieId);
			

			i = ps.executeUpdate();
			if (i > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						i = rs.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("movie rented error : " + e.getMessage());
		}

		return i;

	}

	
}
