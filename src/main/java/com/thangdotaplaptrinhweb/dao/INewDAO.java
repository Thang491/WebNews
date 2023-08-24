package com.thangdotaplaptrinhweb.dao;

import java.util.List;

import com.thangdotaplaptrinhweb.model.NewModel;
import com.thangdotaplaptrinhweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel>{
 List<NewModel> findByCategoryId(Long categoryId);
 
 Long save(NewModel newModel);
 void Delete(Long id);
 void Update(NewModel updateNew);
 NewModel findOne(Long id);
 List<NewModel> findAll(Pageble pageble);
 
 int getTotalItem();

 
}
