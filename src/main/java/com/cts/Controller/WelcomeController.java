package com.cts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.cts.service.AdminValidate;
import com.cts.service.EnquiryDaoImpl;
import com.cts.service.ManagerDaoImpl;
import com.cts.service.TransactionDetailsDaoImpl;
import com.cts.service.UserDaoImpl;
import com.cts.service.bookingDetailsDaoImpl;
import com.cts.service.packageListDaoImpl;

@Controller
@SessionAttributes({ "success", "transactionSuccess", "totalCost", "transactionFailure" })
//@SessionAttributes("transactionFailure")
public class WelcomeController {

	@Autowired
	UserDaoImpl userService;

	@Autowired
	AdminValidate service;

	@Autowired
	ManagerDaoImpl managerService;

	@Autowired
	packageListDaoImpl impl;

	@Autowired
	bookingDetailsDaoImpl bookingDetailsImpl;

	@Autowired
	TransactionDetailsDaoImpl transactionDetailsImpl;

	@Autowired
	EnquiryDaoImpl enquiryService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showloginPage(ModelMap model) {
		return "welcome";
	}
}