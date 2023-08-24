package com.thangdotaplaptrinhweb.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thangdotaplaptrinhweb.constant.SystemConstant;
import com.thangdotaplaptrinhweb.model.CategoryModel;
import com.thangdotaplaptrinhweb.model.NewModel;
import com.thangdotaplaptrinhweb.model.UserModel;
import com.thangdotaplaptrinhweb.paging.PageRequest;
import com.thangdotaplaptrinhweb.paging.Pageble;
import com.thangdotaplaptrinhweb.service.ICategoryService;
import com.thangdotaplaptrinhweb.service.INewService;
import com.thangdotaplaptrinhweb.service.IUserService;
import com.thangdotaplaptrinhweb.service.impl.UserService;
import com.thangdotaplaptrinhweb.utils.FormUtil;
import com.thangdotaplaptrinhweb.utils.MessageUtil;
import com.thangdotaplaptrinhweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat","/dang-ky" })
public class HomeController extends HttpServlet {
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IUserService userService;
	@Inject
	private INewService newService;

	private static final long serialVersionUID = 1L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			rd.forward(request, response);
		}else if (action != null && action.equals("register")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
				}
			RequestDispatcher rd = request.getRequestDispatcher("views/register.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else if (action != null && action.equals(SystemConstant.DETAIL)) {
			NewModel newModel = FormUtil.toModel(NewModel.class, request);
			if (newModel.getId() != null) {
				Pageble pageble = new PageRequest(null, null, null);
				newModel = newService.findOne(newModel.getId());
				request.setAttribute(SystemConstant.DETAIL, newModel);
				request.setAttribute(SystemConstant.MODEL, newService.findAll(pageble));
				RequestDispatcher rd = request.getRequestDispatcher("views/web/newDetail.jsp");
				rd.forward(request, response);
			}

		}else {
			Pageble pageble = new PageRequest(null, null, null);
			CategoryModel category = FormUtil.toModel(CategoryModel.class, request);			
			if(category.getId() == null) {
			    request.setAttribute(SystemConstant.MODEL, newService.findAll(pageble));
			    request.setAttribute("categories", categoryService.findAll());
			}else {
				List<NewModel> newmodel = newService.findByCategoryId(category.getId());
				request.setAttribute(SystemConstant.MODEL, newmodel);
				request.setAttribute("categories", categoryService.findAll());
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel usermodel = FormUtil.toModel(UserModel.class, request);
			usermodel = userService.findUserNameAndPasswordAndStatus(usermodel.getUserName(), usermodel.getPassword(),
					1);
			if (usermodel != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", usermodel);
				if (usermodel.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				} else if (usermodel.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				} else {

				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}else if(action != null && action.equals("register")) {
			
			UserModel usermodel = FormUtil.toModel(UserModel.class, request);		    
            boolean checkName = userService.checkUserName(usermodel.getUserName());            
            if(checkName == false) {
            	if(usermodel.getFullName() != null && usermodel.getFullName() != "") {
            		if(usermodel.getPassword().equals(usermodel.getConfirm_password())) {
               		 Long userId	 = userService.addnewUser(usermodel.getUserName(), usermodel.getPassword(), usermodel.getFullName(), 1, 2L);
                     	if(userId != null) {
                     		response.sendRedirect(request.getContextPath() + "/dang-ky?action=register&message=create_account_success&alert=success");
                     	}                    	
                    }else {
                   	 response.sendRedirect(request.getContextPath() + "/dang-ky?action=register&message=password_not_same&alert=danger");            	
                    }
            	}else {
            		 response.sendRedirect(request.getContextPath() + "/dang-ky?action=register&message=null_full_name&alert=danger");    
            	}
            	 
                }else {        
                	response.sendRedirect(request.getContextPath() + "/dang-ky?action=register&message=username_already&alert=danger");
                }    
            }

		}
}
	

