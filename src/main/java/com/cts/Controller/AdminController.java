package com.cts.Controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.cts.service.AdminValidate;
import com.cts.service.EnquiryDaoImpl;
import com.cts.service.ManagerDaoImpl;
import com.cts.service.TransactionDetailsDaoImpl;
import com.cts.service.UserDaoImpl;
import com.cts.service.bookingDetailsDaoImpl;
import com.cts.service.packageListDaoImpl;
import com.cts.model.bookingDetails;
import com.cts.model.packageDetails;

@Controller
@SessionAttributes({ "success", "transactionSuccess", "totalCost", "transactionFailure" })
//@SessionAttributes("transactionFailure")
public class AdminController {

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

	@RequestMapping(value = "/admin_login", method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
		return "admin_login";
	}

	@RequestMapping(value = "/admin_login", method = RequestMethod.POST)
	public String validateAdminLoginPage(ModelMap model, @RequestParam String userId, @RequestParam String password) {
		boolean b = service.validate(userId, password);
		if (b)
			return "redirect:/showAdminPortal";
		else {
			model.put("error", "Incorrect Username/Password");
			return "admin_login";
		}
	}

	@RequestMapping(value = "/showAdminPortal", method = RequestMethod.GET)
	public String showAdminPortalHomePageUser(ModelMap model) throws SQLException {
		// packageListDaoImpl impl=new packageListDaoImpl();
		List<packageDetails> list = impl.extractPackages();
		model.put("packageDetails", list);
		return "adminPackageList";
	}

	@RequestMapping(value = "/deletePackage", method = RequestMethod.GET)
	public String deletePackage(@RequestParam int id) throws SQLException {
		impl.deletePackage(id);
		return "redirect:/showAdminPortal";
	}

	@RequestMapping(value = "/addPackage1", method = RequestMethod.GET)
	public String showAddAdminPackage(ModelMap map) {
		map.addAttribute("packageDetails", new packageDetails());
		return "addPackage";
	}

	@RequestMapping(value = "/addPackage1", method = RequestMethod.POST)
	public String addAdminPackage(@ModelAttribute("packageDetails") packageDetails packageDetails, BindingResult result,
			ModelMap map) throws SQLException {
		if (result.hasErrors())
			return "addPackage";
		if (impl.addPackage(packageDetails) > 0)
			return "redirect:/showAdminPortal";
		else
			return "addPackage";
	}

	@RequestMapping(value = "/updatePackage", method = RequestMethod.GET)
	public String updateAdminPackage(@RequestParam int id, ModelMap model) throws SQLException {
		packageDetails packageDetails = impl.retrievePackage(id);
		model.put("packageDetails", packageDetails);
		return "updatePackage";
	}

	@RequestMapping(value = "/updatePackage", method = RequestMethod.POST)
	public String updateShowAdminPackage(@ModelAttribute("packageDetails") packageDetails packageDetails,
			BindingResult result, ModelMap map) throws SQLException {
		if (result.hasErrors())
			return "updatePackage";
		else {
			impl.updatePackage(packageDetails);
			return "redirect:/showAdminPortal";
		}
	}
	
	// Report Controllers
		@RequestMapping(value = "/generate_report1", method = RequestMethod.GET)
		public String showGenerateReport(ModelMap model) {
			return "generate_report";
		}

		@RequestMapping(value = "/show_report", method = RequestMethod.POST)
		public String showReport(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
				@RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate, ModelMap model)
				throws SQLException {
			List<bookingDetails> bookingDetails = bookingDetailsImpl.extractBookingPackages(startDate, endDate);
			model.put("bookingDetails", bookingDetails);
			return "show_report";
		}
}
