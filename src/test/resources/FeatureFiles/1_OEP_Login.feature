Feature: LOGIN PAGE

  @TC_01
  Scenario: Login:Valid Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_02
  Scenario: Login:Sign Out Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And click the Signin button To Check Login
    Then Click User logo button in Top right corner
    And Click SignOut button
    Then Check login page is displayed or not using assert
    Then close the Login Page

  @TC_03
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter Invalid username and valid password are "thirumaran1@sankarasoftware.com" and "Thirumaran@123"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_04
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter valid username and Invalid password are "thirumaran1@sankarasoftware.com" and "Thirumaran12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_05
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter Invalid username and Invalid password are "0211thiru@gmailss.com" and "Thirumaraan12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_06
  Scenario: Login:Without Password Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username only "thirumaran@sankarasoftware.com"
    And click the Signin button To Check Login
    Then Check alert toast message is displayed in password tab or not
    Then close the Login Page

  @TC_07
  Scenario: Login:Without Mail Id Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter password only "Thirumaran@123"
    And click the Signin button To Check Login
    Then Check alert toast message is displayed in email tab or not
    Then close the Login Page

  @TC_08
  Scenario: Login:Forget Password Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When Without enter email id click Forget password button
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_09
  Scenario: Login:Forget Password Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter email id "0211thiru@gmail.com"
    And click Forget password button
    Then Click Ok button
    And Check landing page after click ok button
    Then close the Login Page

  @TC_10
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username and password are "test@yopmail.com" and "Thirumaran@001"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_11
  Scenario: Login:Lock Account
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username and password are "itteamsankara@gmail.com" and "Thirumaran@001"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_12
  Scenario: Login:Lock Account
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username and password are "itteamsankara@gmail.com" and "Thirumaran@001"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_13
  Scenario: Login:Unlock Account
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And click the Signin button To Check Login
    Then Click admin button to unlock the account
    And Search valid username "itteamsankara@gmail.com" in the searchbox to unlock the account
    Then Click edit button to unlock the account
    And Click unlock button to unlock the account
    Then Click yes button in the unlock tab
    Then close the Login Page

  @TC_14
  Scenario: Login:Enter button check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter Invalid username and valid password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And Click ENTER button
    Then close the Login Page

  @TC_15
  Scenario: Login:With Inactive User Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter inactive username and valid password are "vigneshmurugankumutha@gmail.com" and "Thirumaran@123"
    And click Forget password button
    Then Check alert message is displayed or not in Login Page
    Then close the Login Page

  @TC_16
  Scenario: Login:With Inactive User Check
    Given To Check Login is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Login Enter inactive username and valid password are "vigneshmurugankumutha@gmail.com" and "Thirumaran@123"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page
