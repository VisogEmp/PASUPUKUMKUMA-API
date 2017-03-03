package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.CartOrdersDao;
import com.visog.pasupukumkuma.model.transactional.CartOrders;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.CartOrdersReq;
import com.visog.pasupukumkuma.res.transactional.CartOrdersRes;
import com.visog.pasupukumkuma.service.transactional.CartOrdersService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CartOrdersServiceImpl implements CartOrdersService {
	
	private static final Logger logger = Logger.getLogger(CartOrdersServiceImpl.class);

	@Inject
	CartOrdersDao dao;

	
	public void saveCartOrders(CartOrdersReq req) {
		
		
		Users users = new Users();
		//CartOrders cartorders = new CartOrders();
		users.setId(req.getUserid());
		users.setId(req.getPujaid());

		DaoUtils.setEntityCreateAuditColumns(users);
		
		dao.save(users);

		logger.info("cartorders created successfully : " + users.getId());
	}


	public void updateCartOrders(CartOrdersReq req, String roleId) {
		CartOrders cartorders = (CartOrders) dao.getByKey(CartOrders.class, roleId);
		
		Users users = new Users();
		cartorders.setId(req.getUserid());
		cartorders.setId(req.getPujaid());
		dao.update(users);
		logger.info("cartorders updated successfully : " + users.getId());
	}

	
	public List<CartOrdersRes> getCartOrders() {

		List<CartOrders> cartorders  = dao.getCartOrders();

		List<CartOrdersRes> CartOrdersList = new ArrayList<>();
		CartOrdersRes cartordersRes = null;

		for (CartOrders cartorder : cartorders) {
			cartordersRes = new CartOrdersRes();
			cartordersRes.setUserid(cartorder.getUserid().getId());
			cartordersRes.setPujaid(cartorder.getPujaid().getId());
			//cartordersRes.setDescription(cartorder.getDescription());
			CartOrdersList.add(cartordersRes);
		}

		return CartOrdersList;
	}

	
	public CartOrdersRes getCartOrder(String id) {
		CartOrders cartorders = (CartOrders) dao.getByKey(CartOrders.class, id);
		CartOrdersRes cartordersRes = new CartOrdersRes();
		cartordersRes.setUserid(cartorders.getId());
		cartordersRes.setPujaid(cartorders.getId());
		//cartordersRes.setDescription(cartorders.getDescription());
		return cartordersRes;
	}

	
	public Boolean deleteCartOrders(String userId) {
		return (dao.delete(CartOrders.class, userId) != 0);
		
	}

}

