package com.cts.Controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.support.SessionStatus;

import com.cts.service.AdminValidate;
import com.cts.service.ComplaintsDaoImpl;
import com.cts.service.EnquiryDaoImpl;
import com.cts.service.FeedbackDaoImpl;
import com.cts.service.ManagerDaoImpl;
import com.cts.service.TransactionDetailsDaoImpl;
import com.cts.service.UserDaoImpl;
import com.cts.service.bookingDetailsDaoImpl;
import com.cts.service.packageListDaoImpl;
import com.cts.model.Complaints;
import com.cts.model.Enquiry;
import com.cts.model.Feedback;
import com.cts.model.Manager;
import com.cts.model.bookingDetails;

@Controller
@SessionAttributes({ "success", "transactionSuccess", "totalCost", "transactionFailure","replyPosted" })
//@SessionAttributes("transactionFailure")
public class ManagerController {

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
	
	@Autowired
	ComplaintsDaoImpl comp;
	
	@Autowired
	FeedbackDaoImpl feedbackService;

	@RequestMapping(value = "/manager_register1", method = RequestMethod.GET)
	public String showManagerRegisterPage(ModelMap model) {
		model.addAttribute("manager", new Manager());
		return "manager_register";
	}

	@RequestMapping(value = "/manager_login1", method = RequestMethod.GET)
	public String showManagerLoginPage(ModelMap model, SessionStatus status) {
		model.addAttribute("success", (String) model.get("success"));
		status.setComplete();
		model.addAttribute("manager", new Manager());
		return "manager_login";
	}

	@RequestMapping(value = "/manager_register1", method = RequestMethod.POST)
	public String implementRegisterManager(@Valid @ModelAttribute("manager") Manager manager, BindingResult result,
			ModelMap model) {
		if (result.hasErrors())
			return "manager_register";
		if(managerService.validateEmail(manager)) {
		if (managerService.save(manager) == 1) {
			model.put("success", "Your details are submitted successfully.");
			return "redirect:/manager_login1";
		} else
			return "manager_register";
		}
		else {
			model.put("error", "Email ID already registered!");
			return "manager_register";
		}
	}

	@RequestMapping(value = "/manager_login1", method = RequestMethod.POST)
	public String validateManagerLoginPage(@Valid @ModelAttribute("manager") Manager manager, BindingResult result,
			ModelMap model) {
		if (result.hasErrors())
			return "manager_login";
		boolean b = managerService.validate(manager);
		if (b)
			return "redirect:/managerHome";
		else {
			model.put("error", "Incorrect Username/Password");
			return "manager_login";
		}
	}

	// Manager Home
	@RequestMapping(value = "/managerHome", method = RequestMethod.GET)
	public String showloginHomePageManager(ModelMap model) throws SQLException {
		List<Enquiry> list = enquiryService.extractEnquiryManager();
		model.put("list", list);
		return "managerHome";
	}

	@RequestMapping(value = "/managerEnquiryReply", method = RequestMethod.GET)
	public String showManagerReplyPage(@RequestParam int id, ModelMap model, SessionStatus status3) throws SQLException {
		model.addAttribute("replyPosted", (String) model.get("replyPosted"));
		status3.setComplete();
		Enquiry enq = enquiryService.retrieveEnquiry(id);
		// model.put("enq", enq);
		model.addAttribute("enq", enq);
		return "managerEnquiryReply";
	}

	@RequestMapping(value = "/managerEnquiryReply", method = RequestMethod.POST)
	public String submitManagerReplyPage(@ModelAttribute("enquiry") Enquiry enquiry, BindingResult result,
			ModelMap model) throws SQLException {
		if (result.hasErrors()) {
			return "redirect:/managerHome";
		} else {
			enquiryService.updateManagerEnquiry(enquiry);
			model.put("replyPosted", "Your Reply has been Posted");
			return "redirect:/managerHome";
		}
	}
	
	@RequestMapping(value = "/ViewComplaints", method = RequestMethod.GET)
	public String showUserComplaints(ModelMap model, SessionStatus status1) throws SQLException {
		status1.setComplete();
		List<Complaints> list= comp.extractComplaints();
		model.put("Complaints", list);
		return "ViewComplaints";
	}
	
	@RequestMapping(value="/ManagerComplaintReply" ,method= RequestMethod.GET)
    public String showManagerReply(@RequestParam int id, ModelMap model) throws SQLException {
		Complaints complaints=comp.retrieveComplaint(id);
		//model.put("enq", enq);
		model.addAttribute("complaints", complaints);
        return "ManagerComplaintReply";
    }
	
	@RequestMapping(value="/ManagerComplaintReply" ,method= RequestMethod.POST)
    public String submitManagerReply(@ModelAttribute("complaints") Complaints complaints, BindingResult result, ModelMap model) throws SQLException {
			comp.updateReply(complaints);
			return "redirect:/ViewComplaints";
    }
	
	@RequestMapping(value="/create_feedback_manager1", method = RequestMethod.GET)
	public String createFeedback(ModelMap model){
		model.addAttribute("feedback", new Feedback());
		return "create_feedback_manager";
	}
	
	@RequestMapping(value="/create_feedback_manager1",method=RequestMethod.POST)
	public String addFeedbackQuestions(@ModelAttribute("feedback") Feedback feedback,ModelMap model)
	{
		long save = feedbackService.save(feedback);
		if(save!=0) {
			model.put("success", "Feedback Created");
			return "redirect:/create_feedback_manager1";
		}
		else
			return "create_feedback_manager";
	}
	
	// Report Controllers
			@RequestMapping(value = "/managerGenerateReport1", method = RequestMethod.GET)
			public String showManagerGenerateReport(ModelMap model) {
				return "managerGenerateReport";
			}

			@RequestMapping(value = "/userReport", method = RequestMethod.POST)
			public String showReport(@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
					@RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate, ModelMap model)
					throws SQLException {
				List<Feedback> bookingDetails  = feedbackService.extractUserFeedback(startDate, endDate);
				model.put("bookingDetails", bookingDetails);
				return "userReport";
			}
}
