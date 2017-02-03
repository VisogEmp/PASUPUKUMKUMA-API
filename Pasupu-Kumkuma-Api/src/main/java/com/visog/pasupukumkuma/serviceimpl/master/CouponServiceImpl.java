package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.CouponDao;
import com.visog.pasupukumkuma.model.master.Coupon;
import com.visog.pasupukumkuma.req.CouponReq;
import com.visog.pasupukumkuma.res.CouponRes;
import com.visog.pasupukumkuma.service.master.CouponService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CouponServiceImpl implements CouponService {
	private static final Logger logger = Logger.getLogger(CouponServiceImpl.class);

	@Inject
	CouponDao dao;

	/**
	 * This method saves the Coupon
	 */
	public void saveCoupon(CouponReq req) {
		Coupon coupon = new Coupon();
		coupon.setName(req.getName());
		coupon.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(coupon);
		
		dao.save(coupon);

		logger.info("Coupon created successfully : " + coupon.getId());
		
	}

	/**
	 * This method updates the Coupon
	 */
	public void updateCoupon(CouponReq req, String couponId) {
		Coupon coupon = (Coupon) dao.getByKey(Coupon.class, couponId);
		coupon.setName(req.getName());
		coupon.setDescription(req.getDescription());
		dao.update(coupon);
		logger.info("Coupon updated successfully : " + coupon.getId());
		
	}

	/**
	 * This method returns all the coupons
	 */
	public List<CouponRes> getCoupons() {
		List<Coupon> coupon = dao.getCoupon();

		List<CouponRes> couponList = new ArrayList<>();
		CouponRes couponRes = null;

		for (Coupon coupons : coupon) {
			couponRes = new CouponRes();
			couponRes.setId(coupons.getId());
			couponRes.setName(coupons.getName());
			couponRes.setDescription(coupons.getDescription());
			couponList.add(couponRes);
		}

		return couponList;
	}

	/**
	 * This method returns Coupon Details for the given coupon id  
	 */
	public CouponRes getcoupon(String id) {
		Coupon coupon = (Coupon) dao.getByKey(Coupon.class, id);
		CouponRes couponRes = new CouponRes();
		couponRes.setId(coupon.getId());
		couponRes.setName(coupon.getName());
		couponRes.setDescription(coupon.getDescription());
		return couponRes;
	}

	/**
	 * This method deletes the given coupon  
	 */
	public Boolean deletecoupon(String couponId) {
		return (dao.delete(Coupon.class, couponId) != 0);
	}

}
