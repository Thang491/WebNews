package com.thangdotaplaptrinhweb.service;

import java.util.List;

import com.thangdotaplaptrinhweb.model.NewModel;
import com.thangdotaplaptrinhweb.paging.Pageble;

public interface INewService {
	
  List<NewModel> findByCategoryId(Long categoryId);
  NewModel save(NewModel newModel);
  NewModel Update(NewModel updateNew);
  void Delete(Long[] ids);
  List<NewModel> findAll(Pageble pageble);
  int getTotalItem();
  NewModel findOne(Long Id);
  
  
}
