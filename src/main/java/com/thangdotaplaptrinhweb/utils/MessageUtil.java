package com.thangdotaplaptrinhweb.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insert_success")) {
				messageResponse = "Insert success";
				alert = "success";
			} else if (message.equals("update_success")) {
				messageResponse = "Update success";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete success";
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = "Error system";
				alert = "danger";
			}else if(message.equals("password_not_same")) {
				messageResponse = "Confirm password not same";
				alert = "danger";
			}else if(message.equals("username_already")) {
				messageResponse = "User Name Already";
				alert = "danger";
			}else if(message.equals("create_account_success")) {
				messageResponse = "Create account success";
				alert = "success";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}
