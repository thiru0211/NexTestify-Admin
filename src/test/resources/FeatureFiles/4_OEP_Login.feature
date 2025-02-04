Feature: LOGIN PAGE

  @TC_01
  Scenario: Login:Valid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_02
  Scenario: Login:Sign Out Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Login
    Then Click take picture button
    Then Click User logo button in Top right corner
    #And Click SignOut button
    #Then Check login page is displayed or not using assert
    Then close the Login Page

  @TC_03
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and valid password are "thirumaran1@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_04
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter valid username and Invalid password are "0211thiru@gmail.com" and "Thirumaran12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_05
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and Invalid password are "0211thiru@gmailss.com" and "Thirumaran12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_06
  Scenario: Login:Without Password Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username only "thirumaran@sankarasoftware.com"
    And click the Signin button To Check Login
    Then Check alert toast message is displayed in password tab or not
    Then close the Login Page

  @TC_07
  Scenario: Login:Without Mail Id Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter password only "Thirumaran@8870"
    And click the Signin button To Check Login
    Then Check alert toast message is displayed in email tab or not
    Then close the Login Page

  @TC_08
  Scenario: Login:Forget Password Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When Without enter email id click Forget password button
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_09
  Scenario: Login:Forget Password Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter email id "0211thiru@gmail.com"
    And click Forget password button
    Then Click Ok button
    And Check landing page after click ok button
    Then close the Login Page

  @TC_10
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "test@yopmail.com" and "Thirumaran@8870"
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
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "test@yopmail.com" and "Thirumaran@123"
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_12
  Scenario: Login:Lock Account
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@yopmail.com" and "Thirumaran@8870"
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

  @TC_13
  Scenario: Login:Lock Account
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@yopmail.com" and "Thirumaran@8870"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page
@Test
  #@TC_14
  #Scenario: Login:Unlock Account
    #Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    #When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    #And click the Signin button To Check Login
    #Then Click admin button to unlock the account
    #And Search valid username "thirumaran@yopmail.com" in the searchbox to unlock the account
    #Then Click edit button to unlock the account
    #And Click unlock button to unlock the account
    #Then Click yes button in the unlock tab
    #Then close the Login Page

  @TC_15
  Scenario: Login:Enter button check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and valid password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And Click ENTER button
    Then close the Login Page

  @TC_16
  Scenario: Login:2FA Enabled User Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and valid password are "twofauser123@yopmail.com" and "Thirumaran@111"
    And click the Signin button To Check Login
    Then Check the landing page using assert function
    Then close the Login Page

  @TC_17
  Scenario: Login:With Inactive User Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter inactive username and valid password are "inactiveuser@yopmail.com" and "Thirumaran@8870"
    And click Forget password button
    Then Check alert message is displayed or not in Login Page
    Then close the Login Page

  @TC_18
  Scenario: Login:With Inactive User Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter inactive username and valid password are "inactiveuser@yopmail.com" and "Thirumaran@8870"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page
