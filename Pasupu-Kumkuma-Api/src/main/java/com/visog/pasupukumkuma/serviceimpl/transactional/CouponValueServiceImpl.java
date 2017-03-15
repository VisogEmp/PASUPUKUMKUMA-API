package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.CouponValueDao;
import com.visog.pasupukumkuma.model.master.CouponType;
import com.visog.pasupukumkuma.model.transactional.CouponValue;
import com.visog.pasupukumkuma.req.transactional.CouponValueReq;
import com.visog.pasupukumkuma.res.transactional.CouponValueRes;
import com.visog.pasupukumkuma.service.transactional.CouponValueService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CouponValueServiceImpl implements CouponValueService {

	private static final Logger logger=Logger.getLogger(CouponValueServiceImpl.class);
	

	
	@Inject
	private CouponValueDao dao;
	public void savecouponValue(CouponValueReq req) {
		CouponValue couponValue = new CouponValue();
		
		couponValue.setAmount(req.getAmount());
		
		CouponType couponType=new CouponType();
		couponType.setId(req.getCouponType());
		couponValue.setCouponType(couponType);
	
		
		DaoUtils.setEntityCreateAuditColumns(couponValue);
		
         dao.save(couponValue);

	}

	public void UpdatecouponValue(CouponValueReq req, String CouponValueId) {

		CouponValue couponValue =(CouponValue) dao.getByKey(CouponValue.class, CouponValueId);
		
		couponValue.setAmount(req.getAmount());
		
		CouponType couponType=new CouponType();
		couponType.setId(req.getCouponType());
		couponValue.setCouponType(couponType);
		
		dao.update(couponValue);
		
		logger.info("CouponValuet  updated succesfully"+couponValue.getId());

	}

	
	public List<CouponValueRes> getCouponValues() {
		
		List<CouponValue> couponValue = dao.getCouponValues();

		List<CouponValueRes> couponValueList = new ArrayList<>();
		CouponValueRes couponValueRes = null;

		
		for (CouponValue couponValues : couponValue) {
			
			couponValueRes = new CouponValueRes();
			
			couponValueRes.setId(couponValues.getId());
			couponValueRes.setAmount(couponValues.getAmount());
			couponValueRes.setCouponType(couponValues.getCouponType().getId());
			
			
			couponValueList.add(couponValueRes);
		}
		return couponValueList;
	}

	public CouponValueRes getcouponValues(String id) {
		
		

		CouponValue  couponValue =( CouponValue) dao.getByKey(CouponValue.class, id);
		CouponValueRes  couponValueRes= new  CouponValueRes();
		couponValueRes.setId(couponValue.getId());
		couponValueRes.setAmount(couponValue.getAmount());
		
		couponValueRes.setCouponType(couponValue.getCouponType().getId());
	     return couponValueRes;
	}

	public Boolean deletecouponValue(String CouponValueId) {
		

		return (dao.delete(CouponValue.class,CouponValueId )!=0);
	}
}
