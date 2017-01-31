package com.visog.pasupukumkuma.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.visog.pasupukumkuma.rest.controller.AdminController;
import com.visog.pasupukumkuma.rest.controller.SuperAdminController;
import com.visog.pasupukumkuma.rest.controller.master.CountryController;
import com.visog.pasupukumkuma.rest.controller.master.PujaController;
import com.visog.pasupukumkuma.rest.controller.master.PujaSamagriController;
import com.visog.pasupukumkuma.rest.controller.master.RolesController;



public class PasupuKumkumaRestApplication extends Application {
	
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public PasupuKumkumaRestApplication() {
		classes.add(AdminController.class);
		classes.add(SuperAdminController.class);
		classes.add(RolesController.class);
		classes.add(CountryController.class);
		classes.add(PujaController.class);
		classes.add(PujaSamagriController.class);
	}

	public Set<Object> getSingletons() {
		return singletons;
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class<?>> classes) {
		this.classes = classes;
	}
}