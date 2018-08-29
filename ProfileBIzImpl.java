package cn.java.mydoc.bizimpl;

import java.util.List;

import cn.java.mydoc.bean.Profile;
import cn.java.mydoc.biz.ProfileBiz;
import cn.java.mydoc.bean.*;
import cn.java.mydoc.dao.*;
import cn.java.mydoc.daoimpl.*;
public class ProfileBIzImpl implements ProfileBiz {
    ProflieDao profiledao=null;
    
	public ProfileBIzImpl() {
		this.profiledao=new ProfileDaoImpl(); 
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return profiledao.getAll();
	}

	@Override
	public Profile getProfile(int id) {
		// TODO Auto-generated method stub
		return profiledao.getById(id);
	}

	@Override
	public boolean UpdateProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profiledao.updateProfile(profile)>0;
	}

}
