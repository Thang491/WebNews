package com.thangdotaplaptrinhweb.mapper;

import java.sql.ResultSet;

import com.thangdotaplaptrinhweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		try {
			CategoryModel category = new CategoryModel();
        	category.setId(resultSet.getLong("id"));
        	category.setCode(resultSet.getString("code"));
        	category.setName(resultSet.getString("name"));
        	return category;
		} catch (Exception e) {
			return null;
		}
		
	}

}
