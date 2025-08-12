package testcases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.CustomResponse;
import pages.StartupPage;
import pages.appointment_Pages;
import testBase.AppTestBase;
import testdata.LocatorsFactory;

public class appointment_testcase extends AppTestBase {
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath + "expected_data.xlsx";
	String loginFilePath = loginDataFilePath + "Login.xlsx";
	StartupPage startupPage;
	private final String EXCEL_FILE_PATH = "src/main/resources/config.xlsx"; // Path to the Excel file
	private final String FILEPATH = "src/main/java/pages/appointment_Pages.java";
	FileOperations fileOperations = new FileOperations();
	public static int appointmentId;
	appointment_Pages appointment_PagesInstance;
	LocatorsFactory locatorsFactoryInstance;

	@Parameters({ "browser", "environment" })
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		configData = new FileOperations().readExcelPOI(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);

		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		Assert.assertTrue(isValidUrl,
				configData.get("url") + " might be Server down at this moment. Please try after sometime.");
		initialize(configData);
		startupPage = new StartupPage(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, description = "* Navigate to the URL.\r\n"
			+ "* Retrieve Title and URL of the current page.\r\n"
			+ "* Verify Title & URL: Check if the title  & URL matches the expected title.")
	public void verifyTitleAndURLOfTheHomePage() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Map<String, String> loginData = new FileOperations().readExcelPOI(loginFilePath, "credentials");
		Assert.assertTrue(appointment_PagesInstance.loginToHealthAppByGivenValidCredetial(loginData),
				"Login failed, Invalid credentials ! Please check manually");
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "healthApp");
		Assert.assertEquals(appointment_PagesInstance.verifyTitleOfThePage(), expectedData.get("dasboardTitle"));
		Assert.assertEquals(appointment_PagesInstance.verifyURLOfThePage(), expectedData.get("homePageUrl"));
		Assert.assertTrue(locatorsFactoryInstance.verifyAppointmentModuleIsPresent(driver).isDisplayed(),
				"Appointment Module is not present in the current page, Please check manually");
	}

	@Test(priority = 2, groups = { "sanity" }, description = "* Verify that Appointment module is present or not ?\r\n"
			+ "* While trying to navigate to the Appointment Module,\r\n" + "it popups the \"Select Counter\" Page \r\n"
			+ "* Verify the \"Select Counter\" Page Name")
	public void verifyAppointmentModuleIsPresent() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyAppointmentModuleIsPresent(),
				expectedData.get("selectCounterTitle"), "select Counter Title is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifySelectCounterPopupsIsPresent(driver).isDisplayed(),
				"select counter popups is not present in the current page, Please check manually");
	}

	@Test(priority = 3, groups = { "sanity" }, description = "On the Appointment module's \"New Visit\" Page,\r\n"
			+ "Verify the  \"New Patient\" Button is present or not ?\r\n"
			+ "If \"New Patient\" button is present, \r\n" + "then click on it.\r\n"
			+ "If it clicking on \"New Patient\" button,\r\n"
			+ "then verify the \"Patient Information\" text is present or not ?")
	public void verifyButtonAndTextIsPresent() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyButtonAndTextIsPresent(),
				expectedData.get("patientInformationTitle"),
				"patient Information Title is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyPatientInformationTextIsPresent(driver).isDisplayed(),
				"Patient Information Text is not present in the current page, Please check manually");
	}

	@Test(priority = 4, groups = { "sanity" }, description = "On the Appointment module's New Visit Page,\r\n"
			+ "scroll to the buttom of the page.\r\n"
			+ "Then highlight the \"Care of Person Contact\" textbox as Blue color")
	public void scrollToBottomVerifyFieldAndHighlight() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(appointment_PagesInstance.scrollToBottomVerifyFieldAndHighlight(),
				"care of person contact textbox is not present, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyPrintInvoiceButtonIsPresent(driver).isDisplayed(),
				"print invoice button is not present in the current page, Please check manually");
	}

	@Test(priority = 5, groups = { "sanity" }, description = "On the Appointment module's New Visit Page,\r\n"
			+ "user must be on buttom of the page.\r\n" + "Then click on  \"Care of Person\" textbox and\r\n"
			+ "get the placeholder name of the \"Care of Person\" textbox.\r\n"
			+ "Then Verify the placeholder name is \"Care Taker Person\"")
	public void verifyPlaceholderNameOfTexboxIfTextboxIsEnabled() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");
		Assert.assertEquals(appointment_PagesInstance.verifyPlaceholderNameOfTexbox(),
				expectedData.get("careOfPersonTextboxPlaceHolderName"));
		Assert.assertTrue(locatorsFactoryInstance.verifyCareOfPersonTextboxIsPresent(driver).isDisplayed(),
				"Care Of Person" + "Textbox is not present in the current page, Please check manually");
	}

	@Test(priority = 6, groups = { "sanity" }, description = "On the Appointment module's \"New Visit\" page,\r\n"
			+ "validate the error message in \"Patient Information\" form's  lastname textfield\r\n"
			+ "after clicking on \"Print Invoice\" Button\r\n" + "without filling any information in the form.")
	public void verifyErrorMessage() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");
		Assert.assertEquals(appointment_PagesInstance.verifyErrorMessage(),
				expectedData.get("errorMessageOfLastNameTextbox"));
		Assert.assertTrue(locatorsFactoryInstance.verifyErrorMessageOfLastNameTextbox(driver).isDisplayed(),
				"Error Message is not present in the current page, Please check manually");
	}

	@Test(priority = 7, groups = { "sanity" }, description = "On the Appointment module's \"New Visit\" page,\r\n"
			+ "Fill all given textfields which are present inside the Patient Information form.\r\n"
			+ "Validate the entered values.\r\n" + "Following textboxes are :\r\n" + "First Name textbox\r\n"
			+ "Middle Name textbox\r\n" + "Last Name textbox.\r\n" + "Age textbox.\r\n" + "Phone No. textbox.")
	public void verifyEnteredDataIsPresentInTextbox() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyTexboxIsPresentAndValidateEnteredValue(expectedData),
				expectedData.get("phoneNumberValue"), "something wroung in page class, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyValueIsPresentInPhoneNumberTextbox(),
				expectedData.get("phoneNumberValue"), "something wroung in locators class, please check manually");
	}

	@Test(priority = 8, groups = {
			"sanity" }, description = "On the New Visit\" page's \"Patient Information\" form,\r\n"
					+ "click on \"Have DOB ?\" checkbox\r\n"
					+ "and verify that the  \"Have DOB ?\" is selected or not.\r\n"
					+ "After validation verify that the \"Datepicker\" field  is coming\r\n"
					+ "after click on \"  \"Have DOB ?\" checkbox")
	public void verifyCheckboxIsSelectedAndDatePickerIsPresent() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Assert.assertTrue(appointment_PagesInstance.verifyCheckboxIsSelectedAndDatePickerIsPresent(),
				"check box didn't click in page class, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyDatePickerElementIsPresent(driver).isDisplayed(),
				"datePicker is not present in the Locators page, Please check manually");
	}

	@Test(priority = 9, groups = {
			"sanity" }, description = "On  the \"Booking OT Schedule | New Patient\" form's, \r\n"
					+ "External? Checkbox must be selected.\r\n"
					+ "Click on \"+\" icon to popup the Add External Referral form\r\n"
					+ "then fill all the details (get the data from excel),\r\n"
					+ "click on all checkbox and then click on \"Add\" button\r\n"
					+ "then verify the success notifications message.")
	public void verifySuccessNotificationPopupMessage() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath,
				"addExternalReferralPageInfo");

		Assert.assertEquals(appointment_PagesInstance.verifySuccessNotificationPopupMessage(expectedData),
				expectedData.get("successNotificationPopupMessage"));
		Assert.assertEquals(locatorsFactoryInstance.verifySuccessNotificationPopupMessageIsPresent(),
				expectedData.get("successNotificationPopupMessage"));
	}

	@Test(priority = 10, groups = {
			"sanity" }, description = "On the New Visit\" page's \"Patient Information\" form,\r\n"
					+ "scroll to the  \"Relation With Patient\" dropdown\r\n"
					+ "and then select \"Son\" from the \"Relation With Patient\" dropdown.\r\n"
					+ "validate \"Son\" is  properly selected or not.")
	public void verifyOptionIsSelectedFromDropdown() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.verifyOptionIsSelectedFromDropdown(expectedData),
				expectedData.get("relationWithPatientDropdownOption"),
				"selected option is not matching with expected in page class, please check manually!");
		Assert.assertEquals(locatorsFactoryInstance.verifyRelationWithPatientOptionIsSelected(),
				expectedData.get("relationWithPatientDropdownOption"),
				"selected option is not matching with expected(Locators Factory), please check manually!");
	}

	@Test(priority = 11, groups = { "sanity" }, description = "On the \"Appointment\" module's,\r\n"
			+ "click on \"Book Appointment\" Sub module.\r\n" + "(Expand Appointment module, if not)\r\n"
			+ "On the \"Book Appointment\" page,\r\n" + "select the \"Month\" radio button\r\n"
			+ "and verify that the \"Month\" radio button is selected or not.\r\n"
			+ "After the validation deselect the \"Month\" radio button.")
	public void verifyRadioButton() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);

		Assert.assertTrue(appointment_PagesInstance.verifyRadioButton(),
				"something went wroung in pages class, please check manually");
		Assert.assertTrue(locatorsFactoryInstance.verifyDaysRadioButtonIsSelected(),
				"element not present in the current page ((Locators Factory), Please check manually");
	}

	@Test(priority = 12, groups = {
			"sanity" }, description = "On the \"Appointment\" module's \"Book Appointment\" page,\r\n"
					+ "send the value to the below  textbox using javascript.\r\n" + "Following Textbox are:\r\n"
					+ "1. FirstName Text box\r\n" + "2. Middle Name Text Box\r\n" + "3. Last Name Text box\r\n"
					+ "and then click on \"Male\" radio button using java script")
	public void performJavaScriptOperation() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);
		locatorsFactoryInstance = new LocatorsFactory(driver);
		Map<String, String> expectedData = new FileOperations().readExcelPOI(expectedDataFilePath, "appointmentModule");

		Assert.assertEquals(appointment_PagesInstance.performJavaScriptOperation(expectedData),
				expectedData.get("lastNameValue"), "something wroung in page class, please check manually");
		Assert.assertEquals(locatorsFactoryInstance.verifyLastnameTextboxValueIsPresent(),
				expectedData.get("lastNameValue"), "something wroung in locators class, please check manually");
	}

	@Test(priority = 13, groups = { "sanity" }, description = "Precondition: Create an appointment via the API\n"
			+ "1. Send POST request to create a new appointment with provided data\n"
			+ "2. Verify the response status code is 200 OK\n" + "3. Validate the response contains 'Status' as 'OK'\n"
			+ "4. Retrieve and validate the Appointment ID from the response")
	public void createAppointmentTest() throws Exception {
		String SHEET_NAME = "AddAppointmentData"; // Sheet name in the Excel file
		Map<String, String> postData = fileOperations.readExcelPOI(EXCEL_FILE_PATH, SHEET_NAME);

		// Construct the JSON payload as a string
		String requestBody = "{ " + "\"FirstName\": \"" + postData.get("FirstName") + "\", " + "\"LastName\": \""
				+ postData.get("LastName") + "\", " + "\"Gender\": \"" + postData.get("Gender") + "\", " + "\"Age\": \""
				+ postData.get("Age") + "\", " + "\"ContactNumber\": \"" + postData.get("ContactNumber") + "\", "
				+ "\"AppointmentDate\": \"" + postData.get("AppointmentDate") + "\", " + "\"AppointmentTime\": \""
				+ postData.get("AppointmentTime") + "\", " + "\"PerformerName\": \"" + postData.get("PerformerName")
				+ "\", " + "\"AppointmentType\": \"" + postData.get("AppointmentType") + "\", " + "\"DepartmentId\": "
				+ postData.get("DepartmentId") + " }";

		appointment_PagesInstance = new appointment_Pages(driver);
		CustomResponse customResponse = appointment_PagesInstance
				.createAppointmentWithAuth("/Appointment/AddAppointment", requestBody);

		// Validate the method's source code
		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"createAppointmentWithAuth", List.of("given", "then", "extract", "response"));
		Assert.assertTrue(isValidationSuccessful,
				"createAppointmentWithAuth must be implemented using Rest Assured methods only.");

		// Validate response structure
		Assert.assertTrue(TestCodeValidator.validateResponseFields("createAppointmentWithAuth", customResponse),
				"Must have all required fields in the response.");

		// Validate the status code
		Assert.assertEquals(customResponse.getStatusCode(), 200, "Status code should be 200.");

		// Validate the top-level status field
		String status = customResponse.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// Validate the AppointmentId field
		Integer appointmentIdd = customResponse.getAppointmentId();
		appointmentId = appointmentIdd;
		Assert.assertNotNull(appointmentIdd, "Appointment ID should not be null.");

		// Print the full response body for debugging
		System.out.println("Create Appointment Response:");
		customResponse.getResponse().prettyPrint();
	}

	@Test(priority = 14, groups = {
			"sanity" }, dependsOnMethods = "createAppointmentTest", description = "Precondition: An appointment must be created successfully.\n"
					+ "1. Validate that the appointment ID is not null.\n"
					+ "2. Send a PUT request to cancel the appointment using the appointment ID.\n"
					+ "3. Verify the response status code is 200.\n"
					+ "4. Validate the response indicates successful cancellation.")
	public void cancelAppointmentTest() throws IOException {
		appointment_PagesInstance = new appointment_Pages(driver);

		// Ensure the appointment ID is set by the createAppointmentTest
		Assert.assertNotNull(appointmentId, "Appointment ID should be set by the createAppointmentTest.");

		// Call cancelAppointmentWithAuth to cancel the appointment
		CustomResponse cancelResponse = appointment_PagesInstance.cancelAppointmentWithAuth(
				"/Appointment/AppointmentStatus?appointmentId=" + appointmentId + "&status=cancelled", null);

		// Validate method implementation (like Rest Assured methods used)
		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"cancelAppointmentWithAuth", List.of("given", "then", "extract", "response"));
		Assert.assertTrue(isValidationSuccessful,
				"cancelAppointmentWithAuth must be implemented using Rest Assured methods only.");

		// Validate response status code
		Assert.assertEquals(cancelResponse.getStatusCode(), 200, "Status code should be 200 OK.");

		// Validate the top-level status field
		String status = cancelResponse.getStatus();
		System.out.println(cancelResponse.getStatus());
		System.out.println("cancelResponse.getStatus()--------------------");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// Validate the Results field for success message
		String resultMessage = cancelResponse.getResultMessage();
		Assert.assertEquals(resultMessage, "Appointment information updated successfully.",
				"Message should confirm the update.");

		// Print the full response for debugging
		System.out.println("Cancelled Appointment Response:");
		cancelResponse.getResponse().prettyPrint();
	}

	@Test(priority = 15, groups = {
			"sanity" }, description = "Precondition: Patients and Doctor must be created successfully.\n"
					+ "1. Send a GET request to fetch whether an appointment for the same time is created for the same doctor.\n"
					+ "2. Verify the response status code is 200.\n"
					+ "3. Validate the response indicates successful display of all the users that contain the string in their name.")
	public void searchPatientTest() throws Exception {
		appointment_PagesInstance = new appointment_Pages(driver);

		// Send request and get response
		CustomResponse searchedResponse = appointment_PagesInstance
				.searchPatientWithAuth("/Patient/SearchRegisteredPatient?search=Test", null);

		// Validate response status code
		Assert.assertEquals(searchedResponse.getStatusCode(), 200, "Status code should be 200 OK.");

		// Extract 'FirstName' and 'ShortName' from the first item in 'Results'
		String firstName = searchedResponse.getResponse().jsonPath().getString("Results[0].FirstName");
		String shortName = searchedResponse.getResponse().jsonPath().getString("Results[0].ShortName");
		String lastName = searchedResponse.getResponse().jsonPath().getString("Results[0].LastName");

		// Print the values to verify
		System.out.println("FirstName: " + firstName);
		System.out.println("ShortName: " + shortName);
		System.out.println("LastName: " + lastName);

		// Validate that 'firstName' and 'shortName' contain "Test"
		Assert.assertTrue(firstName.contains("test"), "FirstName does not contain 'test'");
		Assert.assertTrue(shortName.contains("test"), "ShortName does not contain 'test'");

		// Validate the 'Status' field
		String status = searchedResponse.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// Print the full response for further verification if needed
		System.out.println("Searched Patient Response:");
		searchedResponse.getResponse().prettyPrint();
	}

	@Test(priority = 16, groups = {
			"sanity" }, description = "Precondition: Appointments must be made between current date and 5 days before the current date.\n"
					+ "1. Send a GET request to fetch whether an appointment for the same time is created for the same doctor.\n"
					+ "2. Verify the response status code is 200.\n"
					+ "3. Validate the response indicates successful display of appointments along with patient Id and Appointment time.")
	public void BookingListTest() throws Exception {
		String SHEET_NAME = "AddAppointmentData"; // Sheet name in the Excel file
		Map<String, String> searchResult = fileOperations.readExcelPOI(EXCEL_FILE_PATH, SHEET_NAME);
		appointment_PagesInstance = new appointment_Pages(driver);

		// Set date range
		LocalDate currentDate = LocalDate.now();
		LocalDate dateFiveDaysBefore = currentDate.minusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Format dates as strings
		String currentDateStr = currentDate.format(formatter);
		String dateFiveDaysBeforeStr = dateFiveDaysBefore.format(formatter);
		String performerId = searchResult.get("performerId");

		// Send request and get response
		CustomResponse updateResponse = appointment_PagesInstance
				.bookingListWithAuthInRange("/Appointment/Appointments?FromDate=" + dateFiveDaysBeforeStr + "&ToDate="
						+ currentDateStr + "&performerId=" + performerId + "&status=new", null);

		// Assert that the status code is 200 OK
		Assert.assertEquals(updateResponse.getStatusCode(), 200, "Status code should be 200 OK.");

		// Extract and print the 'Results' list and appointment dates
		List<Map<String, Object>> results = updateResponse.getListResults();
		System.out.println("Results: " + results);

		// Iterate over each result to print and verify the 'AppointmentDate'
		for (Map<String, Object> result : results) {
			String appointmentDateStr = result.get("AppointmentDate").toString().substring(0, 10); // Extract date
																									// portion only
			System.out.println("Appointment Date: " + appointmentDateStr);

			// Parse the 'AppointmentDate' to LocalDate for comparison
			LocalDate appointmentDate = LocalDate.parse(appointmentDateStr);

			// Assert that 'AppointmentDate' is within the specified range
			Assert.assertTrue(!appointmentDate.isBefore(dateFiveDaysBefore) && !appointmentDate.isAfter(currentDate),
					"AppointmentDate " + appointmentDate + " is not within the expected range: " + dateFiveDaysBeforeStr
							+ " to " + currentDateStr);
		}

		// Validate the 'Status' field
		String status = updateResponse.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// Print the full response for further verification if needed
		System.out.println("Searched appointment Response Within a Range:");
		updateResponse.getResponse().prettyPrint();
	}

	@Test(priority = 17, groups = {
			"sanity" }, description = "1. Send a GET request to fetch Main Store from the Pharmacy Settings.\n"
					+ "2. Verify the response status code is 200.\n"
					+ "3. Validate the response has an Id corresponding to the store along with the name and store description.")
	public void MainStoreTest() {
		appointment_PagesInstance = new appointment_Pages(driver);

		// Send request and get response
		CustomResponse stockDetails = appointment_PagesInstance.MainStoreDetailsWithAuth("/PharmacySettings/MainStore",
				null);

		// Assert that the status code is 200 OK
		Assert.assertEquals(stockDetails.getStatusCode(), 200, "Status code should be 200 OK.");

		// Extract 'Results' from the response
		Map<String, Object> results = stockDetails.getMapResults();
		System.out.println("Results: " + results);

		// Extract 'Name', 'StoreDescription', and 'StoreId'
		String Name = (String) results.get("Name");
		String storeDesc = (String) results.get("StoreDescription");
		Integer StoreId = (Integer) results.get("StoreId");

		// Assert that 'name', 'store description' and 'store Id' are not null
		Assert.assertNotNull(Name, "The Name is null and the store doesn't exist.");
		Assert.assertNotNull(storeDesc, "The store description is null and the store doesn't exist.");
		Assert.assertNotNull(StoreId, "The StoreId is null and the store doesn't exist.");

		// Validate the 'Status' field
		String status = stockDetails.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// Print the full response for further verification if needed
		System.out.println("Fetched Main Store from the Pharmacy Settings:");
		stockDetails.getResponse().prettyPrint();
	}

	@Test(priority = 18, groups = {
			"sanity" }, description = "Precondition: Some Pharmacy Stores must be created already. \n"
					+ "1. Send a GET request to fetch whether we are able to fetch the pharmacy stores or not.\n"
					+ "2. Verify the response status code is 200.\n"
					+ "3. Validate the response indicates successful display of name of the store along with Store Id.")
	public void PharmacyStoreTest() {
		appointment_PagesInstance = new appointment_Pages(driver);

		// Send request and get response
		CustomResponse pharmacyStoreResponse = appointment_PagesInstance
				.PharmacyStoresWithAuth("/Dispensary/PharmacyStores", null);

		// Assert that the status code is 200 OK
		Assert.assertEquals(pharmacyStoreResponse.getStatusCode(), 200, "Status code should be 200 OK.");

		// Extract and print the 'Results' list
		List<Map<String, Object>> results = pharmacyStoreResponse.getListResults();
		System.out.println("Results: " + results);

		// Iterate over each result to print and verify the 'StoreId' and 'Name'
		for (Map<String, Object> result : results) {
			Integer storeId = (Integer) result.get("StoreId");
			String name = (String) result.get("Name");

			System.out.println("StoreId: " + storeId);
			System.out.println("Name: " + name);

			// Assert that 'StoreId' and 'Name' are not null
			Assert.assertNotNull(storeId, "The Store Id is null and the store doesn't exist.");
			Assert.assertNotNull(name, "The Name is null and the store doesn't exist.");
		}

		// Validate the 'Status' field
		String status = pharmacyStoreResponse.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// Print the full response for further verification if needed
		System.out.println("The following are the Pharmacy Stores:");
		pharmacyStoreResponse.getResponse().prettyPrint();
	}

	@Test(priority = 19, groups = {
			"sanity" }, description = "Pre-conditions: Will require the counter Id and counterName to enter as a query parameter in the API. \n"
					+ "1. Send a PUT request to see whether we are able to activate the pharmacy counter.\n"
					+ "2. Verify the response status code is 200.\n"
					+ "3. Validate the response indicates successful display of counter Id and counterName.")
	public void ActivatePharmacyCountTest() throws Exception {
		String SHEET_NAME = "AddAppointmentData"; // Sheet name in the Excel file

//		apiUtil = new ApiUtil();
		appointment_PagesInstance = new appointment_Pages(driver);

		Map<String, String> searchResult = fileOperations.readExcelPOI(EXCEL_FILE_PATH, SHEET_NAME);
		String counterId = searchResult.get("CounterId");
		String counterName = searchResult.get("CounterName");

		System.out.println("The counter id from the sheet is: " + counterId);
		System.out.println("The counter name from the sheet is: " + counterName);

// Send request and get response
		CustomResponse activationResponse = appointment_PagesInstance.ActivatePharmCount(
				"/Security/ActivatePharmacyCounter?counterId=" + counterId + "&counterName=" + counterName, null);

// Assert that the status code is 200 OK
		Assert.assertEquals(activationResponse.getStatusCode(), 200, "Status code should be 200 OK.");

// Extract 'Results' from the response
		Map<String, Object> results = activationResponse.getMapResults();
		System.out.println("Results: " + results);

// Extract 'CounterName' and 'CounterId'
		String counterNameResult = (String) results.get("CounterName");
		Integer counterIdResult = (Integer) results.get("CounterId");

// Assert that 'CounterName' and 'CounterId' are not null
		Assert.assertNotNull(counterNameResult, "The Counter Name is null and the counter doesn't exist.");
		Assert.assertNotNull(counterIdResult, "The Counter Id is null and the counter doesn't exist.");

// Validate the 'Status' field
		String status = activationResponse.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

// Print the full response for further verification if needed
		System.out.println("Activated the pharmacy counter, Response :");
		activationResponse.getResponse().prettyPrint();
	}

	@Test(priority = 20, groups = {
			"sanity" }, description = "1. Send a PUT request to fetch whether we are able to deactivate the pharmacy counter.\n"
					+ "2. Verify the response status code is 200.\n"
					+ "3. Validate the response indicates successful display of status code as 200.")
	public void DeactivatePharmCountTest() throws Exception {
//		apiUtil = new ApiUtil();

		appointment_PagesInstance = new appointment_Pages(driver);
// Send request and get response
		CustomResponse consumptionResponse = appointment_PagesInstance
				.DeactivatePharmCount("/Security/DeactivatePharmacyCounter", null);

// Assert that the status code is 200 OK
		Assert.assertEquals(consumptionResponse.getStatusCode(), 200, "Status code should be 200 OK.");

// Extract 'Results' from the response
		Map<String, Object> results = consumptionResponse.getMapResults();
		System.out.println("Results: " + results);

// Extract 'StatusCode' from 'Results'
		Integer statusCode = (Integer) results.get("StatusCode");
		System.out.println("statusCode");
		System.out.println(statusCode);

// Assert that 'StatusCode' is 200
		Assert.assertEquals(statusCode, 200, "The status code is not 200, rather " + statusCode);

// Validate the 'Status' field
		String status = consumptionResponse.getStatus();
		Assert.assertEquals(status, "OK", "Status should be OK.");

// Print the full response for further verification if needed
		System.out.println("Deactivated pharmacy counter: Response");
		consumptionResponse.getResponse().prettyPrint();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}

	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}
}
