package com.visog.pasupukumkuma.service.transactional;

import java.util.List;

import com.visog.pasupukumkuma.req.transactional.RefferalDetailsReq;
import com.visog.pasupukumkuma.res.transactional.RefferalDetailsRes;

public interface RefferalDetailsService {
	
	public void saveRefferalDetails(RefferalDetailsReq req);
	
	public void updateRefferalDetails(RefferalDetailsReq req, String Id);
	
	public List<RefferalDetailsRes> getRefferalDetails();
	
	public RefferalDetailsRes getRefferalDetail(String id);
	
	public Boolean deleteRefferalDetail(String refferalId);

}
