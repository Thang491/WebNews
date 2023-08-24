package com.thangdotaplaptrinhweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.thangdotaplaptrinhweb.dao.ICategoryDAO;
import com.thangdotaplaptrinhweb.dao.INewDAO;
import com.thangdotaplaptrinhweb.model.CategoryModel;
import com.thangdotaplaptrinhweb.model.NewModel;
import com.thangdotaplaptrinhweb.paging.Pageble;
import com.thangdotaplaptrinhweb.service.INewService;

public class NewService implements INewService {
    @Inject
    private INewDAO newDao;
    @Inject ICategoryDAO categoryDao;
    
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			
		CategoryModel categorymodel = categoryDao.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(categorymodel.getId());
		Long newId = newDao.save(newModel);		
		return newDao.findOne(newId);
	}

	@Override
	public void Delete(Long[] ids) {
		for(Long id : ids) {
			//delete cmt khóa ngoại
			//delete news
			newDao.Delete(id);
		}
		
				
	}

	@Override
	public NewModel Update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
		CategoryModel categorymodel = categoryDao.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(categorymodel.getId());
		newDao.Update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {	
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(Long Id) {
		NewModel newModel = newDao.findOne(Id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}

}
