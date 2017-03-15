package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.CouponDetailsDao;
import com.visog.pasupukumkuma.model.master.CouponType;
import com.visog.pasupukumkuma.model.transactional.CouponDetails;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.CouponDetailsReq;
import com.visog.pasupukumkuma.res.transactional.CouponDetailsRes;
import com.visog.pasupukumkuma.service.transactional.CouponDetailsService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CouponDetailsServiceImpl implements CouponDetailsService  {

	
private static final Logger logger = Logger.getLogger(CouponDetailsServiceImpl.class);
	
	@Inject
	private CouponDetailsDao dao;
	
	
	public void saveCouponDetails(CouponDetailsReq req) {

		CouponDetails coupondetails  = new CouponDetails();
		
		CouponType coupontype = new CouponType();
		coupontype.setId(req.getCouponType());
		coupondetails.setCouponType(coupontype);
		
		Users users = new Users();
		users.setId(req.getUser());
		coupondetails.setUser(users);
		
		coupondetails.setCouponCode(req.getCouponCode());
		coupondetails.setAmount(req.getAmount());
			
		
		DaoUtils.setEntityUpdateAuditColumns(coupondetails);

		dao.save(coupondetails);
		
		logger.info("Coupon Details is created Successfully"+coupondetails.getId());
	}

	public void updateCouponDetail(CouponDetailsReq req, String couponId) {
		
		CouponDetails coupondetails =(CouponDetails) dao.getByKey(CouponDetails.class, couponId);
		
		CouponType coupontype = new CouponType();
		coupontype.setId(req.getCouponType());
		coupondetails.setCouponType(coupontype);
		
		Users users = new Users();
		users.setId(req.getUser());
		coupondetails.setUser(users);
		
		coupondetails.setCouponCode(req.getCouponCode());
		coupondetails.setAmount(req.getAmount());	
		
		dao.update(coupondetails);
		
		logger.info("Coupon Details updated succesfully"+coupondetails.getId());
		

	}

	public List<CouponDetailsRes> getCouponDetails() {
		
		List<CouponDetails> coupondetails = dao.getCouponDetails();
		List<CouponDetailsRes> coupondetailsreslist = new ArrayList<>();
		
		CouponDetailsRes coupondetailsres = null;

		for (CouponDetails coupondetail : coupondetails) {
			
			coupondetailsres = new CouponDetailsRes();
			
			coupondetailsres.setId(coupondetail.getId());
			coupondetailsres.setCouponType(coupondetail.getCouponType().getId());
			coupondetailsres.setUser(coupondetail.getUser().getId());
			coupondetailsres.setCouponCode(coupondetail.getCouponCode());
			coupondetailsres.setAmount(coupondetail.getAmount());
			
			
			coupondetailsreslist.add(coupondetailsres);
		}
		return coupondetailsreslist;
	}

	public CouponDetailsRes getCouponDetail(String id) {
		
		CouponDetails coupondetails =(CouponDetails) dao.getByKey(CouponDetails.class, id);
		
		CouponDetailsRes coupondetailsres= new CouponDetailsRes();
		coupondetailsres.setId(coupondetails.getId());
		coupondetailsres.setCouponType(coupondetails.getCouponType().getId());
		coupondetailsres.setUser(coupondetails.getUser().getId());
		coupondetailsres.setCouponCode(coupondetails.getCouponCode());
		coupondetailsres.setAmount(coupondetails.getAmount());
		
		return coupondetailsres;
	}

	public Boolean deleteCouponDetail(String couponId) {
		return (dao.delete(CouponDetails.class,couponId)!=0);
	}

}
