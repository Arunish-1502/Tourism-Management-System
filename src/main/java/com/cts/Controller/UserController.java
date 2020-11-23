package com.cts.Controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.cts.exception.DatabaseException;
import com.cts.model.Complaints;
import com.cts.model.Enquiry;
import com.cts.model.Feedback;
import com.cts.model.TransactionDetails;
import com.cts.model.User;
import com.cts.model.bookingDetails;
import com.cts.model.packageDetails;

@Controller
@SessionAttributes({ "success", "transactionSuccess", "totalCost", "transactionFailure" })
//@SessionAttributes("transactionFailure")
public class UserController {

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

	@RequestMapping(value = "/user_login1", method = RequestMethod.GET)
	public String showUserLoginPage(ModelMap model, SessionStatus status) {
		model.addAttribute("success", (String) model.get("success"));
		status.setComplete();
		model.addAttribute("user", new User());
		return "user_login";
	}

	@RequestMapping(value = "/user_register1", method = RequestMethod.GET)
	public String showUserRegisterPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "user_register";
	}

	@RequestMapping(value = "/user_register1", method = RequestMethod.POST)
	public String implementRegisterUser(@Valid @ModelAttribute("user") User user,  BindingResult result, ModelMap model) {
		if (result.hasErrors())
			return "user_register";
		if(userService.validateEmail(user))
		{
		if(userService.save(user)==1)
		{
			model.put("success","Your details are submitted successfully.");
			return "redirect:/user_login1";
		}
		else
			return "user_register";
		}
		else
		{
			model.put("error", "Email Id Already Registered!");
			return "user_register";
		}
	}

	@RequestMapping(value = "/user_login1", method = RequestMethod.POST)
	public String validateUserLoginPage(@Valid @ModelAttribute("user") User user, BindingResult result,
			ModelMap model) {
		if (result.hasErrors())
			return "user_login";
		boolean b = userService.validate(user);
		if (b) {
			return "redirect:/showHome";
		} else {
			model.put("error", "Incorrect Username/Password");
			return "user_login";
		}
	}

	@RequestMapping(value = "/showHome", method = RequestMethod.GET)
	public String showloginHomePageUser(ModelMap model, SessionStatus status1) throws SQLException {
		model.addAttribute("transactionSuccess", (String) model.get("transactionSuccess"));
		status1.setComplete();
		// packageListDaoImpl impl=new packageListDaoImpl();
		List<packageDetails> list = impl.extractPackages();
		model.put("packageDetails", list);
		return "userPage";
	}

	@RequestMapping(value = "/bookingDetails", method = RequestMethod.GET)
	public String showBookingDetails(@RequestParam int id, ModelMap model) throws SQLException {
		model.addAttribute("bookingDetails", new bookingDetails());
		packageDetails packageDetails = impl.retrievePackage(id);
		model.put("packageDetails", packageDetails);
		List<String> transportList = Arrays.asList("Airways", "Railways", "Roadways");
		model.put("transportList", transportList);
		return "bookingDetails";
	}

	@RequestMapping(value = "/bookingDetails", method = RequestMethod.POST)
	public String implementBookingDetails(@Valid @ModelAttribute("bookingDetails") bookingDetails bookingDetails,
			BindingResult result, ModelMap model) throws SQLException {
		if (result.hasErrors())
			return "bookingDetails";
		if (bookingDetailsImpl.addBookingDetails(bookingDetails) > 0) {
			model.put("success", "Your details are submitted successfully.");
			int totalCost = transactionDetailsImpl.getTotalCost(bookingDetails);
			model.put("totalCost", totalCost);
			return "BetweenTransaction";
		} else
			return "bookingDetails";
	}

	@RequestMapping(value = "/BetweenTransaction", method = RequestMethod.GET)
	public String showBetweenTransactionDetails(ModelMap model) throws SQLException {
		List<packageDetails> list = impl.extractPackages();
		model.put("packageDetails", list);
		List<bookingDetails> bookingDetails = bookingDetailsImpl.extractBookingPackages();
		model.put("bookingDetails", bookingDetails);
		// List<String> cardList=Arrays.asList("Credit Card", "Debit Card");
		// model.put("cardList", cardList);
		return "TransactionDetails";
	}

	@RequestMapping(value = "/TransactionDetails", method = RequestMethod.GET)
	public String showTransactionDetails(ModelMap model, SessionStatus status2) throws SQLException {
		model.addAttribute("transactionFailure", (String) model.get("transactionFailure"));
		status2.setComplete();
		model.addAttribute("TransactionDetails", new TransactionDetails());
		List<bookingDetails> bookingDetails = bookingDetailsImpl.extractBookingPackages();
		model.put("bookingDetails", bookingDetails);
		List<String> cardList = Arrays.asList("Credit Card", "Debit Card");
		model.put("cardList", cardList);
		return "TransactionDetails";
	}

	@RequestMapping(value = "/TransactionDetails", method = RequestMethod.POST)
	public String validateTransactionDetails(
			@Valid @ModelAttribute("TransactionDetails") TransactionDetails TransactionDetails, BindingResult result,
			ModelMap model) throws SQLException {
		if (result.hasErrors()) {
			return "redirect:/TransactionDetails";
		}
		boolean check = transactionDetailsImpl.extractTransactionDetails(TransactionDetails);
		if (check) {
			model.put("transactionSuccess", "Payment Completed!");
			return "redirect:/showHome";
		} else {
			model.put("transactionFailure", "Your Transaction has been failed!...Invalid Payment Details");
			return "redirect:/TransactionDetails";
		}
	}

	// EnquiryControllers
	@RequestMapping(value = "/userEnquiry1", method = RequestMethod.GET)
	public String showUserEnquiry(ModelMap model) {
		model.addAttribute("enquiry", new Enquiry());
		return "userEnquiry";
	}

	@RequestMapping(value = "/userEnquiry1", method = RequestMethod.POST)
	public String postUserEnquiry(@ModelAttribute("enquiry") Enquiry enquiry, BindingResult result, ModelMap model) {
		long addEnquiry = enquiryService.addEnquiry(enquiry);
		if (addEnquiry > 0) {
			model.put("success", "Your Enquiry has been posted.");
			return "redirect:/userEnquiry1";
		}
		return "userViewQuery";
	}

	@RequestMapping(value = "/userViewQuery", method = RequestMethod.GET)
	public String viewUserQuery(ModelMap model) throws SQLException {
		List<Enquiry> list = enquiryService.extractEnquiryManager();
		model.put("list", list);
		return "userViewQuery";
	}
	
	@RequestMapping(value="/bookedUser_verification1" ,method= RequestMethod.GET)
    public String showVerificationPage(ModelMap map,SessionStatus status) {
		
		map.addAttribute("bookingDetails", new bookingDetails());
		status.setComplete();
        return "bookedUser_verification";
    }
	
	
	@RequestMapping(value = "/bookedUser_verification1", method = RequestMethod.POST)
	public String validateBookedUser(@ModelAttribute("bookingDetails") bookingDetails bookingDetails ,BindingResult result, ModelMap model) throws SQLException {
		boolean b = bookingDetailsImpl.validate(bookingDetails);
		if (b)
			return "redirect:/user_complaints1";
		else
		{
			model.put("error", "Incorrect Booking Id");
			return "bookedUser_verification";
		}	
			
		
	}
	
	@RequestMapping(value = "/user_complaints1", method = RequestMethod.GET)
	public String showUserComplaintsPage(ModelMap model,SessionStatus status) {
		model.addAttribute("Complaints", new Complaints());
		status.setComplete();
		return "user_complaints";
	}
	
	@RequestMapping(value = "/user_complaints1", method = RequestMethod.POST)
	public String implementUserComplaints(@ModelAttribute("Complaints") Complaints Complaints,  BindingResult result, ModelMap model) throws SQLException{
		long x=comp.save(Complaints);
		if(x!=0)
		{
			model.put("success","Your complaint is submitted successfully.Your complaint Number is "+x);
			return "user_complaints";
		}
		else
			return "user_complaints";
	}
	
	@RequestMapping(value = "/ViewReplies", method = RequestMethod.GET)
	public String showReplies(ModelMap model, SessionStatus status1) throws SQLException {
		status1.setComplete();
		List<Complaints> list= comp.extractComplaints();
		model.put("Complaints", list);
		return "ViewReplies";
	}

	//User Feedback Controllers
	
		@RequestMapping(value = "/give_feedback",method=RequestMethod.GET)
		public String chooseFeedback(ModelMap model)
		{
			List<String> options=feedbackService.getFeedabckNames();
			model.put("options", options);
			return "choose_feedback";
		}
		
		@RequestMapping(value = "/give_feedback",method=RequestMethod.POST)
		public String toFeedback(@RequestParam("options") String option,@ModelAttribute("feedback") Feedback feedback,ModelMap model)
		{
			Feedback feedback1=feedbackService.getAllQuestions(option);
			model.put("feedback1", feedback1);
			return "give_feedback";
		}
		
		@RequestMapping(value = "/feedback",method=RequestMethod.POST)
		public String storeFeedback(@ModelAttribute("feedback") Feedback feedback,ModelMap model)
		{
			long save = feedbackService.saveAns(feedback);
			if(save!=0) {
				model.put("success","You have successfully submitted your feedback.");
				return "redirect:/give_feedback";
				}
			else
				return "give_feedback";
		}
	@ExceptionHandler(DatabaseException.class)
	public String handleResourceNotFoundException() {
		return "error";

	}

	// @RequestMapping(value="/login" method= RequestMethod.POST)
	// public String showWelcomePage
}
