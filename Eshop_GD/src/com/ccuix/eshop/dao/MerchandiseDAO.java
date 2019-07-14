package com.ccuix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ccuix.eshop.po.CategoryPO;
import com.ccuix.eshop.po.MerchandisePO;
import com.ccuix.eshop.util.DBManagerConnection;

public class MerchandiseDAO {

	public List<CategoryPO> findAllCategory() {
		List<CategoryPO> cateList= new ArrayList<CategoryPO>();
		try {
			Connection Zhao = DBManagerConnection.getConnection();
			String sql="select id,cateName,cateDesc from category";
			PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				CategoryPO categoryPO = new CategoryPO(set.getInt("id"),set.getString("cateName"),set.getString("cateDesc"));
			    cateList.add(categoryPO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cateList;
	}
	
	public List<MerchandisePO> findAllByspecialmer(int special) {
		List<MerchandisePO> merchandiseList = new ArrayList<MerchandisePO>();
		try {
			Connection Zhao = DBManagerConnection.getConnection();
			String sql="select id,category,merName,price,sprice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,special from merchandise where special=?";
			PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
			preparedStatement.setInt(1, special);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				MerchandisePO merchandisePO = new MerchandisePO(set.getInt("id"),set.getInt("category"),
						set.getString("mername"), set.getDouble("price"),
						set.getDouble("sprice"),set.getString("mermodel"), set.getString("picture"),
						set.getString("merdesc"),
						set.getString("manufacturer"),
						set.getString("leavefactorydate"),
						 set.getInt("special"));
				merchandiseList.add(merchandisePO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchandiseList;
	}
	
	public MerchandisePO findAllByspecialId(int id) {
		MerchandisePO merchandisePO = null;
		try {
			Connection connection = null;
			connection = DBManagerConnection.getConnection();
			String sql = "select id,category,merName,price,sprice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,special from merchandise where id=?";

			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
				merchandisePO = new MerchandisePO(
						set.getInt("id"), set.getInt("category"),
						set.getString("mername"),set.getDouble("price"),
						set.getDouble("sprice"),set.getString("mermodel"), set.getString("picture"),
						set.getString("merdesc"),
						set.getString("manufacturer"),
						set.getString("leavefactorydate"),
						 set.getInt("special"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return merchandisePO;
	}


	public MerchandisePO findAllmerById(int id) {
		MerchandisePO merchandisePO = null;
		try {
			Connection connection = null;
			connection = DBManagerConnection.getConnection();
			String sql = "select merchandise.id,category,merName,price,sprice,merModel,picture,merDesc," +
					      "manufacturer,leaveFactoryDate,special,category.cateName " +
					      "from merchandise,category " +
					      "where merchandise.Category=category.ID and merchandise.id=?";

			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				merchandisePO = new MerchandisePO(
						set.getInt("id"), set.getInt("category"),
						set.getString("mername"),set.getDouble("price"),
						set.getDouble("sprice"),set.getString("mermodel"), set.getString("picture"),
						set.getString("merDesc"),
						set.getString("manufacturer"),
						set.getString("leaveFactoryDate"),
						 set.getInt("special"),set.getString("cateName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchandisePO;
	}

	public List<MerchandisePO> findMerbyCategory(int category) {
		List<MerchandisePO> merchandiseList = new ArrayList<MerchandisePO>();
		try {
			Connection Zhao = DBManagerConnection.getConnection();
			String sql="select id,category,merName,price,sprice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,special from merchandise where category=?";
			PreparedStatement preparedStatement = Zhao.prepareStatement(sql);
			preparedStatement.setInt(1, category);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				MerchandisePO merchandisePO = new MerchandisePO(set.getInt("id"),set.getInt("category"),
						set.getString("mername"), set.getDouble("price"),
						set.getDouble("sprice"),set.getString("mermodel"), set.getString("picture"),
						set.getString("merdesc"),
						set.getString("manufacturer"),
						set.getString("leavefactorydate"),
						 set.getInt("special"));
				merchandiseList.add(merchandisePO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchandiseList;
	}
	//按照商品名模糊查询  
		public List<MerchandisePO> findMerListByLikeName(String nameKey,int category){
			List<MerchandisePO> merchadiseList = new ArrayList<MerchandisePO>();
			try {
				Connection connection = null;
				connection = DBManagerConnection.getConnection();
				String sql = "select id,category,merName,price,sprice,merModel,picture,merDesc," +
						      "manufacturer,leaveFactoryDate,special from  merchandise   " +
						      "    where 1=1 ";
                //拼接字符串
				if("商品关键字".equals(nameKey) && nameKey!=null){
					sql = sql+"and  merName like '%"+nameKey+"%'";
				}
				if(category!=-1){
					sql = sql+"and category = "+category;
				}
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				ResultSet set = preparedStatement.executeQuery();
				while (set.next()) {
					MerchandisePO merchandisePO = new MerchandisePO(
							set.getInt("id"), set.getInt("category"),
							set.getString("mername"), set.getDouble("price"),
							set.getDouble("sprice"),set.getString("mermodel"),
							set.getString("picture"),set.getString("merdesc"),
							set.getString("manufacturer"),set.getString("leavefactorydate"),
							 set.getInt("special"));
					
					merchadiseList.add(merchandisePO);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return merchadiseList;
			
		}

	public static void main(String[] args) {
		System.out.println(new MerchandiseDAO().findMerbyCategory(1)
				.size());
}
}
