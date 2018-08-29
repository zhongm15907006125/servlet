package cn.java.mydoc.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.java.mydoc.bean.Profile;
import cn.java.mydoc.dao.*;
public class ProfileDaoImpl extends BaseDao implements ProflieDao{

	@Override
	public List<Profile> getAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		List<Profile> profiles=new ArrayList<>(); 
		
		try {
			conn=getConnection();
			String sql="select * from Profile";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			
		    if(rs!=null){
		    	while(rs.next()){
		    		Profile pro= new Profile();
		    		pro.setId(rs.getInt("id"));
		    		pro.setName(rs.getString("name"));
		    		pro.setGender(rs.getString("gender"));
		    		pro.setBirthday(rs.getString("birthday"));
		    		pro.setCareer(rs.getString("career"));
		    		pro.setAddress(rs.getString("address"));
		    		pro.setMoblie(rs.getString("mobile"));
		    		
		    		profiles.add(pro);
		    	}
		    	
		    }
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
			closeAll(conn,pst,rs);
		}
		
		return profiles;
	}

	@Override
	public Profile getById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			String sql="select * from Profile where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
		    if(rs!=null){
		    	if(rs.next()){
		    		Profile pro= new Profile();
		    		pro.setId(rs.getInt("id"));
		    		pro.setName(rs.getString("name"));
		    		pro.setGender(rs.getString("gender"));
		    		pro.setBirthday(rs.getString("birthday"));
		    		pro.setCareer(rs.getString("career"));
		    		pro.setAddress(rs.getString("address"));
		    		pro.setMoblie(rs.getString("mobile"));
		    		
		            return pro;
		    	}
		    }
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
			closeAll(conn,pst,rs);
		}
		return null;
		
	}

	@Override
	public int updateProfile(Profile Profile) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		conn=getConnection();
		
		String sql="UPDATE Profile SET [name] = ?,[birthday] = ?"
				+ ",[gender] = ?,[career] = ?,"
				+ "[address] = ?,[mobile] = ? WHERE id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, Profile.getName());
			pst.setString(2, Profile.getBirthday());
			pst.setString(3, Profile.getGender());
			pst.setString(4, Profile.getCareer());
			pst.setString(5, Profile.getAddress());
			pst.setString(6, Profile.getMoblie());
			pst.setInt(7, Profile.getId());
			
			return pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll(conn, pst, null);
		}
		return -1;
	}

}
