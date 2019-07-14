package com.ccuix.eshop.service;

import java.util.List;

import com.ccuix.eshop.dao.MerchandiseDAO;
import com.ccuix.eshop.po.CategoryPO;
import com.ccuix.eshop.po.MerchandisePO;

public class MerchandiseManageService {

	public List<CategoryPO> findAllCategory() {
		
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		return merchandiseDAO.findAllCategory();
	}

	public List<MerchandisePO> findAllspecial(int special) {
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		return merchandiseDAO.findAllByspecialmer(special);
	}

	public MerchandisePO Allmerchandise(String id) {
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		int int_id = Integer.parseInt(id);
		return merchandiseDAO.findAllmerById(int_id);
		
	}
	public List<MerchandisePO> findMerbyCategory(int category) {
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		return merchandiseDAO.findMerbyCategory(category);
	}

	public List<MerchandisePO> findMerbykey(String nameKey,String category) {
		int int_category = Integer.parseInt(category);
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		return merchandiseDAO.findMerListByLikeName(nameKey,int_category);
	}
}
