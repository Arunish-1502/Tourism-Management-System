package com.cts.ControllerTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.Controller.AdminController;
import com.cts.Controller.ManagerController;
import com.cts.Controller.UserController;
import com.cts.Controller.WelcomeController;
import com.cts.dao.FeedbackDao;
import com.cts.dao.ManagerDao;
import com.cts.dao.UserDao;
import com.cts.model.Feedback;
import com.cts.model.Manager;
import com.cts.model.User;
import com.cts.service.FeedbackDaoImpl;
import com.cts.service.ManagerDaoImpl;
import com.cts.service.UserDaoImpl;


public class ControllerTest {
 
	private FeedbackDaoImpl feedbackDaoImpl;
	private ManagerDaoImpl managerDaoImpl;
	private UserDaoImpl userDaoImpl;
	private UserDao userDaomock = mock(UserDao.class);
	private ManagerDao managerDaomock=mock(ManagerDao.class);
	private FeedbackDao feedbackDaomock=mock(FeedbackDao.class);
	
	
	
	private MockMvc mockMvcWelcome;
	private MockMvc mockMvcUser;
	private MockMvc mockMvcManager;
	private MockMvc mockMvcAdmin;
	private MockMvc mockMvcLogout;
	
	
	@BeforeEach
	public void setup() {
		this.mockMvcUser = MockMvcBuilders.standaloneSetup(new UserController()).build();
		this.mockMvcManager=MockMvcBuilders.standaloneSetup(new ManagerController()).build();
		this.mockMvcWelcome=MockMvcBuilders.standaloneSetup(new WelcomeController()).build();
		this.mockMvcAdmin=MockMvcBuilders.standaloneSetup(new AdminController()).build();
	}
	
	// Test Welcome Page
			@Test
			public void testWelcomePage() throws Exception {
				this.mockMvcWelcome.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("welcome"))
						.andDo(MockMvcResultHandlers.print()).andReturn();
			}
	
	// Test User Login Page
		@Test
		public void testUserLoginPage() throws Exception {
			this.mockMvcUser.perform(get("/user_login1")).andExpect(status().isOk()).andExpect(view().name("user_login"))
					.andDo(MockMvcResultHandlers.print()).andReturn();
		}
	
		// Test User Register  Page
				@Test
				public void testUserRegisterPage() throws Exception {
					this.mockMvcUser.perform(get("/user_register1")).andExpect(status().isOk()).andExpect(view().name("user_register"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
				
				// Test User Enquiry  Page
				@Test
				public void testUserEnquiryPage() throws Exception {
					this.mockMvcUser.perform(get("/userEnquiry1")).andExpect(status().isOk()).andExpect(view().name("userEnquiry"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
				
				// Test User Booking Verification  Page
				@Test
				public void testUserBookingVerificationPage() throws Exception {
					this.mockMvcUser.perform(get("/bookedUser_verification1")).andExpect(status().isOk()).andExpect(view().name("bookedUser_verification"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
				// Test User Complaints  Page
				@Test
				public void testUserComplaintsPage() throws Exception {
					this.mockMvcUser.perform(get("/user_complaints1")).andExpect(status().isOk()).andExpect(view().name("user_complaints"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}	
			
				// Test Manager Register Page
				@Test
				public void testManagerRegisterPage() throws Exception {
					this.mockMvcManager.perform(get("/manager_register1")).andExpect(status().isOk()).andExpect(view().name("manager_register"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
				
				// Test Manager Login  Page
				@Test
				public void testManagerLoginPage() throws Exception {
					this.mockMvcManager.perform(get("/manager_login1")).andExpect(status().isOk()).andExpect(view().name("manager_login"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
				
				// Test Create Feedback Page
				@Test
				public void testCreateFeedbackPage() throws Exception {
					this.mockMvcManager.perform(get("/create_feedback_manager1")).andExpect(status().isOk()).andExpect(view().name("create_feedback_manager"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
			
				// Test Manager Generate Report Page
				@Test
				public void testGenerateManagerReportPage() throws Exception {
					this.mockMvcManager.perform(get("/managerGenerateReport1")).andExpect(status().isOk()).andExpect(view().name("managerGenerateReport"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
			
				
				// Test Admin AddPackage Page
				@Test
				public void testAdminAddPackagePage() throws Exception {
					this.mockMvcAdmin.perform(get("/addPackage1")).andExpect(status().isOk()).andExpect(view().name("addPackage"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}		
				
				// Test Admin Generate Report Page
				@Test
				public void testAdminGenerateReportPage() throws Exception {
					this.mockMvcAdmin.perform(get("/generate_report1")).andExpect(status().isOk()).andExpect(view().name("generate_report"))
							.andDo(MockMvcResultHandlers.print()).andReturn();
				}
				
				// Test the addition of user records into database - US2
			//	@Test
				//public void testUserInsertIntoDb() throws Exception {
					//LocalDate local 
		            //= LocalDate.parse( 
		             //   "1998-12-06"); 
					//User user = new User();
					//user.setFirstName("Amit");
					//user.setLastName("Sharma");
					//user.setContactNo("7999382635");
					//user.setEmail("amit13@gmail.com");
					//user.setPassword("Abc@1345");
					//user.setDob(local);
					//when(userDaomock.save(user)).thenReturn(1);
					//assertEquals(1, 1);
				//}
				
				//@Test
				//public void testManagerInsertIntoDb() throws Exception {
					//LocalDate local 
		            //= LocalDate.parse( 
		             //   "1998-12-07");
					//String[] skills={"Technical","HR"};
					//Manager user = new Manager();
					//user.setFirstName("Arjun");
					//user.setLastName("Sharma");
					//user.setContactNo("7889662635");
					//user.setEmail("arjun1513@gmail.com");
					//user.setPassword("Abc@1345");
					//user.setDob(local);
					//user.setSkills(skills);
					//when(managerDaomock.save(user)).thenReturn(1);
					//assertEquals(1, 1);
				//}
				
				//@Test
				//public void testFeedbackInsertIntoDb() throws Exception { 
					//Feedback fe = new Feedback();
					//fe.setName("Argya");
					//fe.setQuestion1("What");
					//fe.setQuestion2("Who");
					//fe.setQuestion3("Why");
					//fe.setQuestion4("When");
					//fe.setQuestion5("How");
					//assertEquals(1, 1);
				//}
		
				// User Login Credentials Validation - US6
				

		
}