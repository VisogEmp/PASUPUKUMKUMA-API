package com.visog.pasupukumkuma.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.visog.pasupukumkuma.rest.controller.AdminController;
import com.visog.pasupukumkuma.rest.controller.SuperAdminController;
import com.visog.pasupukumkuma.rest.controller.master.CityController;
import com.visog.pasupukumkuma.rest.controller.master.CountryController;
import com.visog.pasupukumkuma.rest.controller.master.CouponTypeController;
import com.visog.pasupukumkuma.rest.controller.master.GenderController;
import com.visog.pasupukumkuma.rest.controller.master.NakshatramController;
import com.visog.pasupukumkuma.rest.controller.master.RaasiController;
import com.visog.pasupukumkuma.rest.controller.master.PujaController;
import com.visog.pasupukumkuma.rest.controller.master.PujaSamagriController;


//github.com/VisogEmp/PASUPUKUMKUMA-API.git
import com.visog.pasupukumkuma.rest.controller.master.RolesController;
import com.visog.pasupukumkuma.rest.controller.master.StateController;
import com.visog.pasupukumkuma.rest.controller.master.StatusController;
import com.visog.pasupukumkuma.rest.controller.transactional.AddressController;
import com.visog.pasupukumkuma.rest.controller.transactional.ContactController;
import com.visog.pasupukumkuma.rest.controller.transactional.CouponValueController;
import com.visog.pasupukumkuma.rest.controller.transactional.UserRequestController;
import com.visog.pasupukumkuma.rest.controller.transactional.UsersController;

public class PasupuKumkumaRestApplication extends Application {
	
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public PasupuKumkumaRestApplication() {
		classes.add(AdminController.class);
		classes.add(SuperAdminController.class);
		classes.add(RolesController.class);
		classes.add(CouponTypeController.class);
		classes.add(CountryController.class);
		classes.add(GenderController.class);
		classes.add(NakshatramController.class);
		classes.add(RaasiController.class);
		classes.add(StateController.class);
		classes.add(CityController.class);
		classes.add(PujaController.class);
		classes.add(StatusController.class);
		classes.add(PujaSamagriController.class);
		
		
		classes.add(UsersController.class);
		classes.add(AddressController.class);
		classes.add(UserRequestController.class);
		classes.add(CouponValueController.class);
		classes.add(ContactController.class);
		
		
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
