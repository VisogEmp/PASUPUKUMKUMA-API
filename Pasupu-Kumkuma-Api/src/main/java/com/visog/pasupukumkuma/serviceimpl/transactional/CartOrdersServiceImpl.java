package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.CartOrdersDao;
import com.visog.pasupukumkuma.model.master.Puja;
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
		
		
		CartOrders cartorders = new CartOrders();
		
		Users users = new Users();
		users.setId(req.getUser());
		cartorders.setUser(users);
		
		Puja puja = new Puja();
		puja.setId(req.getPuja());
		cartorders.setPuja(puja);
		
		
		
		DaoUtils.setEntityCreateAuditColumns(cartorders);
		
		dao.save(cartorders);

		logger.info("cartorders created successfully : " + cartorders.getId());
	}


	public void updateCartOrders(CartOrdersReq req, String cartorderId) {
		CartOrders cartorders = (CartOrders) dao.getByKey(CartOrders.class, cartorderId);
		
		Users users = new Users();
		users.setId(req.getUser());
		cartorders.setUser(users);
		
		Puja puja = new Puja();
		puja.setId(req.getPuja());
		cartorders.setPuja(puja);
		
		
		//cartorders.setId(req.getPuja());
		dao.update(cartorders);
		logger.info("cartorders updated successfully : " + cartorders.getId());
	}

	
	public List<CartOrdersRes> getCartOrders() {

		List<CartOrders> cartorders  = dao.getCartOrders();

		List<CartOrdersRes> CartOrdersList = new ArrayList<>();
		CartOrdersRes cartordersRes = null;

		for (CartOrders cartorder : cartorders) {
			cartordersRes = new CartOrdersRes();
			cartordersRes.setId(cartorder.getId());
			cartordersRes.setUser(cartorder.getUser().getId());
			cartordersRes.setPuja(cartorder.getPuja().getId());
			CartOrdersList.add(cartordersRes);
		}

		return CartOrdersList;
	}

	
	public CartOrdersRes getCartOrder(String id) {
		
		CartOrders cartorders = (CartOrders) dao.getByKey(CartOrders.class, id);
		CartOrdersRes cartordersRes = new CartOrdersRes();
		cartordersRes.setId(cartorders.getId());
		cartordersRes.setUser(cartorders.getUser().getId());
		cartordersRes.setPuja(cartorders.getPuja().getId());
		return cartordersRes;
	}

	
	public Boolean deleteCartOrders(String cartordersId) {
		return (dao.delete(CartOrders.class, cartordersId) != 0);
		
	}

}

