package com.visog.pasupukumkuma.serviceimpl.transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.transactional.RefferalDetailsDao;
import com.visog.pasupukumkuma.model.transactional.RefferalDetails;
import com.visog.pasupukumkuma.model.transactional.Users;
import com.visog.pasupukumkuma.req.transactional.RefferalDetailsReq;
import com.visog.pasupukumkuma.res.transactional.RefferalDetailsRes;
import com.visog.pasupukumkuma.service.transactional.RefferalDetailsService;
import com.visog.pasupukumkuma.utils.DaoUtils;

public class RefferalDetailsServiceImpl implements RefferalDetailsService {
	
	private static final Logger logger = Logger.getLogger(RefferalDetailsServiceImpl.class);

	@Inject
	RefferalDetailsDao dao;

	
	public void saveRefferalDetails(RefferalDetailsReq req) {
		
		
		RefferalDetails refferaldetails = new RefferalDetails();		
		
		Users users = new Users();
		users.setId(req.getReferredBy());
		refferaldetails.setReferredBy(users);
		
		refferaldetails.setCouponCode(req.getCouponCode());
		refferaldetails.setReferalStateId(req.getReferalStateId());
		refferaldetails.setReferredToEmail(req.getReferredToEmail());
		
		DaoUtils.setEntityCreateAuditColumns(refferaldetails);
		
		dao.save(refferaldetails);

		logger.info("refferaldetails created successfully : " + refferaldetails.getId());
	}


	public void updateRefferalDetails(RefferalDetailsReq req, String Id) {
		RefferalDetails refferaldetails = (RefferalDetails) dao.getByKey(RefferalDetails.class, Id);
	
		
		Users users = new Users();
		users.setId(req.getReferredBy());
		refferaldetails.setReferredBy(users);
		
		
		refferaldetails.setCouponCode(req.getCouponCode());
		refferaldetails.setReferalStateId(req.getReferalStateId());
		refferaldetails.setReferredToEmail(req.getReferredToEmail());
		
		
	
		dao.update(refferaldetails);
		logger.info("refferaldetails updated successfully : " + refferaldetails.getId());
	}

	
	public List<RefferalDetailsRes> getRefferalDetails() {

		List<RefferalDetails> refferaldetails  = dao.getRefferalDetails();

		List<RefferalDetailsRes> refferalorderList = new ArrayList<>();
		RefferalDetailsRes refferaldetailsRes = null;

		for (RefferalDetails refferaldetail : refferaldetails) {
			refferaldetailsRes = new RefferalDetailsRes();
			refferaldetailsRes.setId(refferaldetail.getId());
			refferaldetailsRes.setReferredBy(refferaldetail.getReferredBy().getId());
			refferaldetailsRes.setCouponCode(refferaldetail.getId());
			refferaldetailsRes.setReferalStateId(refferaldetail.getReferalStateId());
			refferaldetailsRes.setReferredToEmail(refferaldetail.getReferredToEmail());
			refferalorderList.add(refferaldetailsRes);
		}

		return refferalorderList;
	}

	
	public RefferalDetailsRes getRefferalDetail(String id) {
		
		RefferalDetails refferaldetails = (RefferalDetails) dao.getByKey(RefferalDetails.class, id);
		RefferalDetailsRes refferaldetailres = new RefferalDetailsRes();
		refferaldetailres.setId(refferaldetails.getId());
		refferaldetailres.setReferredBy(refferaldetails.getReferredBy().getId());
		refferaldetailres.setCouponCode(refferaldetails.getCouponCode());
		refferaldetailres.setReferalStateId(refferaldetails.getReferalStateId());
		refferaldetailres.setReferredToEmail(refferaldetails.getReferredToEmail());
		return refferaldetailres;
	}

	
	public Boolean deleteRefferalDetail(String refferalId) {
		return (dao.delete(RefferalDetails.class, refferalId) != 0);
		
	}

	

}
