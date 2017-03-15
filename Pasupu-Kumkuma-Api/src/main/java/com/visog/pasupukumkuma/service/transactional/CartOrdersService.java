package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.CartOrdersReq;
import com.visog.pasupukumkuma.res.transactional.CartOrdersRes;


public interface CartOrdersService {
	
	public void saveCartOrders(CartOrdersReq req);
	
	public void updateCartOrders(CartOrdersReq req, String Id);
	
	public List<CartOrdersRes> getCartOrders();
	
	public CartOrdersRes getCartOrder(String id);
	
	public Boolean deleteCartOrders(String cartorderId);

}
