package com.thangdotaplaptrinhweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.thangdotaplaptrinhweb.dao.ICategoryDAO;
import com.thangdotaplaptrinhweb.model.CategoryModel;
import com.thangdotaplaptrinhweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
   @Inject
   private ICategoryDAO categoryDao;
   @Inject
  
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}
	
}
