package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.restassured.response.Response;

public class appointment_Pages extends StartupPage {

//	Please write the required Locators here

	private static final String BASE_URL = "https://healthapp.yaksha.com/api";

	String pageName = this.getClass().getSimpleName();

	public appointment_Pages(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Test1.1 Method: loginToHealthAppByGivenValidCredetial
	 * 
	 * @param expectedData A Map containing login credentials with keys "username"
	 *                     and "password"
	 * @description This method automates the login process by: - Waiting for the
	 *              username textbox and entering the provided username - Waiting
	 *              for the password textbox and entering the provided password -
	 *              Waiting for and clicking the Sign In button using JavaScript -
	 *              Verifying if the appointment module is displayed after login
	 * @return true if the appointment module is visible after login, false
	 *         otherwise
	 * @throws Exception if any step in the login process fails
	 * @author YAKSHA
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
//		Write your logic here
		return false;
	}

	/**
	 * @Test1.2
	 * 
	 * @param none
	 * @description Retrieves and returns the current page title.
	 * @return The title of the current web page as a String
	 * @throws Exception if unable to retrieve the title
	 * @author YAKSHA
	 */
	public String verifyTitleOfThePage() throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test1.3
	 * 
	 * @param none
	 * @description Waits for a few seconds, retrieves, and returns the current page
	 *              URL. Logs the URL to the console for verification.
	 * @return The current URL of the web page as a String
	 * @throws Exception if unable to retrieve the URL or if any error occurs during
	 *                   execution
	 * @author YAKSHA
	 */
	public String verifyURLOfThePage() throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test2
	 * 
	 * @param none
	 * @description Checks if the Appointment module is present and interacts with
	 *              it. If present, it clicks the module and verifies if the counter
	 *              title popup page is displayed. Returns the title of the popup
	 *              page.
	 * @return The text of the "Select Counter" title.
	 * @throws Exception if any element interaction fails during the process
	 * @author YAKSHA
	 */
	public String verifyAppointmentModuleIsPresent() throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test3
	 * 
	 * @param none
	 * @description Checks if the "Select Counter New One" link is present and
	 *              clicks it. Then waits for the "New Patient" button, clicks it,
	 *              and retrieves the title of the "Patient Information" section.
	 * @return The text from the "Patient Information" section if present, otherwise
	 *         an empty string
	 * @throws Exception if any element is not found or an interaction fails during
	 *                   execution
	 * @author YAKSHA
	 */
	public String verifyButtonAndTextIsPresent() throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test4
	 * 
	 * @param none
	 * @description Scrolls to the bottom of the page after ensuring the "Patient
	 *              Information" section is visible. Then waits for the "Care Of
	 *              Person Contact" textbox to be located, verifies its visibility,
	 *              clicks it, highlights the element, and confirms its presence.
	 * @return true if the "Care Of Person Contact" textbox is displayed and
	 *         highlighted successfully, false otherwise
	 * @throws Exception if any interaction with elements fails during execution
	 *                   author YAKSHA
	 */
	public Boolean scrollToBottomVerifyFieldAndHighlight() throws Exception {
//		Write your logic here		
		return false;
	}

	/**
	 * @Test5
	 * 
	 * @param none
	 * @description Waits for the "Care Of Person" textbox to be located and
	 *              verifies its visibility. Clicks on the textbox and retrieves the
	 *              value of its "placeholder" attribute.
	 * @return The placeholder text of the "Care Of Person" textbox if available,
	 *         otherwise an empty string
	 * @throws Exception if the element is not found or any interaction fails during
	 *                   execution
	 * @author YAKSHA
	 */
	public String verifyPlaceholderNameOfTexbox() throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test6
	 * 
	 * @param none
	 * @description Clicks on the "Print Invoice" and "Confirm" buttons, then waits
	 *              for and retrieves the error message displayed for the "Last
	 *              Name" textbox.
	 * @return The error message text if present, otherwise an empty string
	 * @throws Exception if any element interaction or retrieval fails during
	 *                   execution author YAKSHA
	 */
	public String verifyErrorMessage() throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test7 about this method verifyTexboxIsPresentAndValidateEnteredValue()
	 * @param : null
	 * @description : verify text box , then send value to that text box and
	 *              validate the entered value
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyTexboxIsPresentAndValidateEnteredValue(Map<String, String> expectedData) throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test8 about this method verifyCheckboxIsSelectedAndDatePickerIsPresent()
	 * @param : null
	 * @description : click on check box and verify that the check box is selected
	 *              or not
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean verifyCheckboxIsSelectedAndDatePickerIsPresent() throws Exception {
//		Write your logic here		
		return false;
	}

	/**
	 * @Test9 about this method verifySuccessNotificationPopupMessage()
	 * @param : null
	 * @description : handle the notification pop up
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifySuccessNotificationPopupMessage(Map<String, String> expectedData) throws Exception {
//		Write your logic here		
		return null;
	}

	/**
	 * @Test10 This method selects a value from a dropdown based on expected data
	 *         from a JSON file
	 * 
	 * @param expectedData Map<String, String> - contains expected dropdown option
	 *                     with key "relationWithPatientDropdownOption"
	 * @return String - the actual selected option text from the dropdown
	 * 
	 * @description 1. Scrolls to the bottom of the page 2. Waits for the dropdown
	 *              element to be located 3. Selects an option from the dropdown
	 *              using visible text provided in the JSON input 4. Retrieves and
	 *              returns the first selected option from the dropdown
	 * 
	 * @author YAKSHA
	 */
	public String verifyOptionIsSelectedFromDropdown(Map<String, String> expectedData) throws Exception {

//		Write your logic here		
		return null;

	}

	/**
	 * @Test11 This method verifies the functionality of radio button selection and
	 *         de-selection on the appointment booking UI.
	 * 
	 * @param None
	 * @return Boolean - returns true if the month radio button is deselected after
	 *         selecting the days radio button; false otherwise
	 * 
	 * @description 1. Scrolls to the top of the page 2. Navigates to the "Book
	 *              Appointment" submodule 3. Clicks the "New Patient" button 4.
	 *              Selects the "Month" radio button and verifies it's selected 5.
	 *              Then selects the "Days" radio button and confirms that "Month"
	 *              is deselected
	 * 
	 * @author YAKSHA
	 */

	public Boolean verifyRadioButton() throws Exception {

		// Write your logic here
		return false;
	}

	/**
	 * @Test12 This method performs JavaScript-based operations to interact with the
	 *         "Book Appointment" form.
	 * 
	 * @param expectedData Map<String, String> - contains form input values: -
	 *                     "firstNameValue": value for the First Name textbox -
	 *                     "middleNameValue": value for the Middle Name textbox -
	 *                     "lastNameValue": value for the Last Name textbox
	 * 
	 * @return String - returns the value entered in the Last Name textbox if
	 *         JavaScript interactions succeed; otherwise, an empty string
	 * 
	 * @description 1. Waits for the "Add Appointment" button and the input fields
	 *              to load 2. Enters First Name, Middle Name, and Last Name using
	 *              JavaScript execution 3. Retrieves the value entered in the Last
	 *              Name field using JavaScript 4. Clicks the "Male" gender option
	 *              via JavaScript 5. Returns the last name value if gender option
	 *              is successfully selected
	 * 
	 * @author YAKSHA
	 */
	public String performJavaScriptOperation(Map<String, String> expectedData) throws Exception {

		//Write your logic here		
		return null;

	}

	/**
	 * @Test13 This method creates a new appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent.
	 * @param body     - A JSON string containing the appointment details.
	 * @description This method sends a POST request to the specified endpoint with
	 *              the authorization header and the provided JSON payload, and
	 *              returns the response.
	 * @return CustomResponse - The API response includes HTTP status code, status
	 *         message, and appointment details (AppointmentId, etc.).
	 */
	public CustomResponse createAppointmentWithAuth(String endpoint, String body) {
		Response response = null;

		// Extract required data from the response
		int statusCode = 0;
		String status = "";
		Integer appointmentId = 0;

		// Return a CustomResponse object
		return new CustomResponse(response, statusCode, status, appointmentId);
	}

	/**
	 * @Test14 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent for canceling
	 *                 the appointment.
	 * @param body     - An optional object representing the request body. This
	 *                 parameter can be null since the cancelation does not require
	 *                 a body payload.
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request without a body.
	 * @return CustomResponse - The response from the API after attempting to cancel
	 *         the appointment, including status and result details.
	 */
	public CustomResponse cancelAppointmentWithAuth(String endpoint, Object body) {
		Response response = null;

		// Extract the necessary details from the response
		int statusCode = 0;
		String status = "";
		String resultMessage = "";

		// Return a CustomResponse object
		return new CustomResponse(response, statusCode, status, resultMessage);
	}

	/**
	 * @Test15 This method searches for a patient using specified query parameters.
	 *
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @description This method sends a GET request to the specified endpoint with
	 *              the necessary authorization header and query parameters to
	 *              search for a patient in the system. The API returns details of
	 *              patients matching the search criteria, including fields like
	 *              `PatientId`, `ShortName`, `FirstName`, `LastName`, `Age`, and
	 *              others.
	 *
	 * @return CustomResponse - The API's response after attempting to search for
	 *         patients, which includes the HTTP status code, status message, and
	 *         the list of matching patients in the "Results" field.
	 */
	public CustomResponse searchPatientWithAuth(String endpoint, Object body) {
		Response response = null;

		// Extract the necessary details from the response
		int statusCode = 0;
		String status = "";
		List<Map<String, Object>> results = null;

		// Return a CustomResponse object with the necessary information
		return new CustomResponse(response, statusCode, status, results);
	}

	/**
	 * @Test16 This method retrieves a list of appointments for a specified
	 *         performer within a given date range.
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @description This method sends a GET request to retrieve all appointments for
	 *              a specified performer between `FromDate` and `ToDate`. The
	 *              request includes query parameters for date range and performer
	 *              ID, with necessary authorization headers. The API returns
	 *              details of matching appointments, including fields like
	 *              `AppointmentId`, `PatientId`, `FullName`, `AppointmentDate`,
	 *              `AppointmentTime`, `AppointmentStatus`, and other relevant
	 *              details.
	 *
	 * @return CustomResponse - The API's response, which includes the HTTP status
	 *         code, a status message, and a list of appointments in the "Results"
	 *         field, each containing appointment and patient details.
	 */
	public CustomResponse bookingListWithAuthInRange(String endpoint, Object body) {
		Response response = null;

		// Extract necessary details from the response
		int statusCode = 0;
		String status = "";
		List<Map<String, Object>> results = null;

		// Return a CustomResponse object with the necessary information
		return new CustomResponse(response, statusCode, status, results);
	}

	/**
	 * @Test17 This method retrieves details of the main store in the pharmacy
	 *         settings.
	 *
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @description This method sends a GET request to the specified endpoint with
	 *              the necessary authorization header to fetch details of the main
	 *              store in the pharmacy settings. The API response provides store
	 *              details, including `Name`, `StoreDescription`, and `StoreId`.
	 *
	 *              The method validates that: 1. The API response status code is
	 *              200 (OK). 2. Essential fields `Name`, `StoreDescription`, and
	 *              `StoreId` are not null, ensuring the store details are
	 *              populated. 3. The `Status` field in the response is "OK",
	 *              confirming a successful response.
	 *
	 * @return CustomResponse - The API's response after attempting to retrieve main
	 *         store details, including status and store details in the "Results"
	 *         field.
	 */
	public CustomResponse MainStoreDetailsWithAuth(String endpoint, Object body) {
		Response response = null;

		// Extract necessary details from the response
		int statusCode = 0;
		String status = "";
		Map<String, Object> results = null;

		// Return a CustomResponse object with the necessary information
		return new CustomResponse(response, statusCode, status, results);
	}

	/**
	 * @Test18 This method retrieves a list of pharmacy stores and verifies the
	 *         details of each store.
	 *
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @description This method sends a GET request to the specified endpoint with
	 *              the necessary authorization header to retrieve details of
	 *              various pharmacy stores. The API response provides details such
	 *              as `StoreId` and `Name` for each store.
	 *
	 *              The method performs the following validations: 1. Confirms that
	 *              the API response status code is 200 (OK). 2. Iterates through
	 *              each store in the "Results" field to ensure that both `StoreId`
	 *              and `Name` are present and not null, verifying that each store
	 *              entry is valid. 3. Asserts that the `Status` field in the
	 *              response is "OK" to confirm a successful response.
	 *
	 * @return CustomResponse - The API's response after attempting to retrieve the
	 *         list of pharmacy stores, which includes the HTTP status code, status
	 *         message, and store details within the "Results" field.
	 */
	public CustomResponse PharmacyStoresWithAuth(String endpoint, Object body) {
		Response response = null;

		// Extract necessary details from the response
		int statusCode = 0;
		String status = "";
		List<Map<String, Object>> results = null;

		// Return a CustomResponse object with the necessary information
		return new CustomResponse(response, statusCode, status, results);
	}

	/**
	 * @Test19 This method activates a pharmacy counter using counter details from
	 *         an Excel sheet.
	 *
	 * @description This method retrieves counter information (ID and name), sends a
	 *              PUT request to activate the specified pharmacy counter, and
	 *              validates the response. The API endpoint includes query
	 *              parameters for `counterId` and `counterName`, and returns
	 *              details on the activated counter.
	 *
	 *              The method performs the following validations: 1. Asserts that
	 *              the API response status code is 200 (OK). 2. Checks the
	 *              `Results` field to confirm that `CounterName` and `CounterId`
	 *              are not null, ensuring the counter details are returned as
	 *              expected. 3. Verifies that the `Status` field is "OK" to confirm
	 *              a successful activation.
	 *
	 * @return CustomResponse - The API's response, which includes the HTTP status
	 *         code, status message, and details of the activated counter in the
	 *         "Results" field.
	 */
	public CustomResponse ActivatePharmCount(String endpoint, Object body) {
		Response response = null;

		// Extract necessary details from the response
		int statusCode = 0;
		String status = "";
		Map<String, Object> results = null;

		// Return a CustomResponse object with the necessary information
		return new CustomResponse(response, statusCode, status, results);
	}

	/**
	 * @Test20 This method deactivates a pharmacy counter.
	 * @description This method sends a request to deactivate a pharmacy counter and
	 *              verifies the API response. The endpoint does not require query
	 *              parameters, and the response provides details of the
	 *              deactivation result, including a `StatusCode` and `Status`
	 *              field.
	 *
	 *              The method performs the following validations: 1. Asserts that
	 *              the API response status code is 200 (OK). 2. Checks the
	 *              `Results` field to confirm that `StatusCode` is "200", verifying
	 *              successful deactivation. 3. Verifies that the `Status` field is
	 *              "OK" to confirm the operation's success.
	 *
	 * @return CustomResponse - The API's response, which includes the HTTP status
	 *         code, status message, and deactivation details in the "Results"
	 *         field.
	 */
	public CustomResponse DeactivatePharmCount(String endpoint, Object body) {
		Response response = null;

		// Extract necessary details from the response
		int statusCode = 0;
		String status = "";
		Map<String, Object> results = null;

		// Return a CustomResponse object with the necessary information
		return new CustomResponse(response, statusCode, status, results);
	}

}
