package com.thangdotaplaptrinhweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thangdotaplaptrinhweb.model.NewModel;
import com.thangdotaplaptrinhweb.model.UserModel;
import com.thangdotaplaptrinhweb.service.INewService;
import com.thangdotaplaptrinhweb.utils.HttpUtil;
import com.thangdotaplaptrinhweb.utils.SessionUtil;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
	
	@Inject
	private INewService newService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        newModel = newService.save(newModel);        
        mapper.writeValue(response.getOutputStream(), newModel);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
        newService.Delete(newModel.getIds());
        
        mapper.writeValue(response.getOutputStream(), "{}");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel updateNew =  HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        updateNew = newService.Update(updateNew);
        mapper.writeValue(response.getOutputStream(), updateNew);

	}
}
