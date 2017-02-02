package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.CouponTypeDao;
import com.visog.pasupukumkuma.model.master.CouponType;
import com.visog.pasupukumkuma.model.master.PujaSamagri;
import com.visog.pasupukumkuma.req.CouponTypeReq;
import com.visog.pasupukumkuma.res.CouponTypeRes;
import com.visog.pasupukumkuma.res.PujaSamagriRes;
import com.visog.pasupukumkuma.service.master.CouponTypeService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class CouponTypeServiceImpl implements CouponTypeService {

	private static final Logger logger = Logger.getLogger(CouponTypeServiceImpl.class);

	@Inject
	CouponTypeDao dao;

	/**
	 * This method saves the Coupontype
	 */

	public void saveCouponType(CouponTypeReq req) {

		CouponType coupontype = new CouponType();
		coupontype.setName(req.getName());
		coupontype.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(coupontype);

		dao.save(coupontype);

		logger.info("CouponType created successfully : " + coupontype.getId());

	}

	/**
	 * This method updates the PujaSamagri
	 */

	public void updateCouponType(CouponTypeReq req, String coupontypeId) {

		CouponType coupontype = (CouponType) dao.getByKey(CouponType.class, coupontypeId);
		coupontype.setName(req.getName());
		coupontype.setDescription(req.getDescription());
		dao.update(coupontype);
		logger.info("CouponType updated successfully : " + coupontype.getId());

	}

	public List<CouponTypeRes> getCouponType() {
		List<CouponType> coupontype = dao.getCouponType();

		List<CouponTypeRes> coupontypeList = new ArrayList<>();
		CouponTypeRes coupontypeRes = null;

		for (CouponType coupontypes : coupontype) {
			coupontypeRes = new CouponTypeRes();
			coupontypeRes.setId(coupontypes.getId());
			coupontypeRes.setName(coupontypes.getName());
			coupontypeRes.setDescription(coupontypes.getDescription());

			coupontypeList.add(coupontypeRes);
		}

		return coupontypeList;
	}

	public CouponTypeRes getCouponType(String id) {
		CouponType coupontype = (CouponType) dao.getByKey(CouponType.class, id);
		CouponTypeRes coupontypeRes = new CouponTypeRes();
		coupontypeRes.setId(coupontype.getId());
		coupontypeRes.setName(coupontype.getName());
		coupontypeRes.setDescription(coupontype.getDescription());
		return coupontypeRes;

	}

	public Boolean deleteCouponType(String coupontypeId) {
		return (dao.delete(CouponType.class, coupontypeId) != 0);
	}

}
