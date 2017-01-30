package com.visog.pasupukumkuma.utils;

import java.util.Date;
import java.util.UUID;

import com.visog.pasupukumkuma.model.AbstractModel;

public class DaoUtils {

	public static void setEntityCreateAuditColumns(AbstractModel model) {

		model.setId(getUUID());
		model.setCreatedBy("18ae947b-4114-4110-a275-5135a50c39c4");
		model.setCreatedOn(new Date());
	}

	public static void setEntityUpdateAuditColumns(AbstractModel model) {

		model.setUpdatedBy("3ba00b3c-8a9c-417d-8ac6-b02153a68dd8");
		model.setUpdatedOn(new Date());
	}

	private static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
