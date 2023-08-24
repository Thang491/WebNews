package com.thangdotaplaptrinhweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thangdotaplaptrinhweb.constant.SystemConstant;
import com.thangdotaplaptrinhweb.model.NewModel;
import com.thangdotaplaptrinhweb.paging.PageRequest;
import com.thangdotaplaptrinhweb.paging.Pageble;
import com.thangdotaplaptrinhweb.service.ICategoryService;
import com.thangdotaplaptrinhweb.service.INewService;
import com.thangdotaplaptrinhweb.sort.Sorter;
import com.thangdotaplaptrinhweb.utils.FormUtil;
import com.thangdotaplaptrinhweb.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends  HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private INewService newService;
	@Inject
	private ICategoryService categoryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel newModel = FormUtil.toModel(NewModel.class, request);	
		
		String view ="";
		if (newModel.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(newModel.getPage(), newModel.getMaxPageItem(), new Sorter(newModel.getSortName(), newModel.getSortBy()));
			newModel.setListResult(newService.findAll(pageble));
			newModel.setTotalItem(newService.getTotalItem());
			newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
			
			view = "views/admin/new/list.jsp";
		}else if(newModel.getType().equals(SystemConstant.EDIT)) {			
			if (newModel.getId() != null) {
				newModel = newService.findOne(newModel.getId());
				
			}else {
				
			}			
			request.setAttribute("categories", categoryService.findAll());
			view = "views/admin/new/edit.jsp";			
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
