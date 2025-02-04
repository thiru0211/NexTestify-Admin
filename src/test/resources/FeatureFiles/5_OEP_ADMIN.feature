Feature: ADMIN

  Background: Admin
    Given To Check Admin is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Admin Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Admin
    Then Click take picture button in admin
    Then Click admin button

  @TC_01
  Scenario: Admin:Search Check
    Given Enter valid username "Thirumaran R" in the searchbox
    When Check entered username "Thirumaran R" is displayed or not in create admin page
    And Enter valid email id "thirumaran@sankarasoftware.com" in the searchbox
    Then Check entered emailid "thirumaran@sankarasoftware.com" is displayed or not in create admin page
    And Enter valid phone number "+91-7305118794" in the searchbox
    Then Check entered phone number "+91-7305118794" is displayed or not in create admin page
    Then Close Admin button

  @TC_02
  Scenario: Admin:Filter Check
    Given Select "All" 1st Option in status dropdown
    When Select "Active" 2nd Option in status dropdown
    Then Check Selected "Active" status is displayed or not
    And Select "Inactive" 3rd Option in status dropdown
    Then Check Selected "Inactive" status is displayed or not
    Then Close Admin button

  @TC_03
  Scenario: Admin:User Type Check
    Given Select "All Admins" 1st Option in user type dropdown
    When Select "Super Admin" 2nd Option in user type dropdown
    Then Check Selected "Super Admin" user type is displayed or not
    And Select "Proctor" 3rd Option in user type dropdown
    Then Check Selected "Proctor" user type is displayed or not
    And Select "Question Manager" 4th Option in user type dropdown
    Then Check Selected "Question Manager" user type is displayed or not
    Then Close Admin button

  @TC_04
  Scenario: Admin:Pagination Check
    Given Click Last page button in below of the grid
    When Click First page button in below of the grid
    And Click next page button in below of the grid
    Then Click previous page button in below of the grid
    And Click the number button in below of the grid
    Then Close Admin button

  @TC_05
  Scenario: ADD USER:Back button Check
    Given Click Add User button in create admin page
    And Click back button in create admin page
    Then Check page navigates to create admin page or not
    Then Close Admin button

  @TC_06
  Scenario: ADD USER:Save button Check
    Given Click Add User button in create admin page
    And Click save button in create admin page
    Then Check mandatory red border is displayed or not in mandatory tabs
    Then Close Admin button

  @TC_07
  Scenario: ADD USER:First Name Tab Check
    Given Click Add User button in create admin page
    And Enter numerical characters "12345" in first name tab
    Then Check tab is empty or not in first name tab
    And Enter special characters "!@#$%^" in first name tab
    Then Check tab is empty or not in first name tab
    Then Close Admin button

  @TC_08
  Scenario: ADD USER:First Name Tab Check
    Given Click Add User button in create admin page
    And Enter alphabetical characters "Testname" in first name tab
    Then Check tab is empty or not in first name
    Then Close Admin button

  @TC_09
  Scenario: ADD USER:Last Name Tab Check
    Given Click Add User button in create admin page
    And Enter numerical characters "12345" in last name tab
    Then Check tab is empty or not in last name tab
    Then Close Admin button

  @TC_10
  Scenario: ADD USER:Last Name Tab Check
    Given Click Add User button in create admin page
    And Enter special characters "!@#$%^" in last name tab
    Then Check tab is empty or not in last name tab
    Then Close Admin button

  @TC_11
  Scenario: ADD USER:Last Name Tab Check
    Given Click Add User button in create admin page
    And Enter alphabetical characters "Testname" in last name tab
    Then Check tab is empty or not in last name
    Then Close Admin button

  @TC_12
  Scenario: ADD USER:Email Tab Check
    Given Click Add User button in create admin page
    And Enter valid email id "sankara@yopmail.com" in email tab
    Then Check tab is empty or not in email tab
    Then Close Admin button

  @TC_13
  Scenario: ADD USER:Email Tab Check
    Given Click Add User button in create admin page
    And Enter valid email id "sankarayopmail.com" in email tab
    Then Click save button in create admin page
    And Check alert message is displayed or not in email tab
    Then Close Admin button

  @TC_14
  Scenario: ADD USER:Email Tab Check
    Given Click Add User button in create admin page
    And Enter valid email id "sankara@yopmailcom" in email tab
    Then Check tab is empty or not in email tab
    Then Close Admin button

  @TC_15
  Scenario: ADD USER:Email Tab Check
    Given Click Add User button in create admin page
    And Enter valid email id "sankara@yopmail" in email tab
    Then Check tab is empty or not in email tab
    Then Close Admin button

  @TC_16
  Scenario: ADD USER:Email Tab Check
    Given Click Add User button in create admin page
    And Enter valid email id "sankara@yopmail.com" in email tab
    Then Check tab is empty or not in email tab
    Then Close Admin button

  @TC_17
  Scenario: ADD USER:User Type Check
    Given Click Add User button in create admin page
    And Enter valid user type "Super Admin" in the dropdown
    Then Check entered user type "Super Admin" is displayed or not in create admin
    Then Close Admin button

  @TC_18
  Scenario: ADD USER:User Type Check
    Given Click Add User button in create admin page
    And Select valid user type "Super Admin" in the dropdown
    Then Check entered user type "Super Admin" is displayed or not in create admin
    Then Close Admin button

  @TC_19
  Scenario: ADD USER:Phone Number Check
    Given Click Add User button in create admin page
    And Enter alphabetical characters "phone" in phone number tab
    Then Check tab is empty or not in phone number tab
    Then Close Admin button

  @TC_20
  Scenario: ADD USER:Phone Number Check
    Given Click Add User button in create admin page
    And Enter special characters "!@#$%^" in phone number tab
    Then Check tab is empty or not in phone number tab
    Then Close Admin button

  @TC_21
  Scenario: ADD USER:Phone Number Check
    Given Click Add User button in create admin page
    And Enter numerical "1234567890" characters in phone number tab
    Then Check entered phone number "1234567890" is displayed or not in phone number tab in create admin
    Then Close Admin button

  @TC_22
  Scenario: ADD USER:Phone Number Check
    Given Click Add User button in create admin page
    Then Select valid country code "+91"
    And Enter valid phone number "1234567890"
    Then Check entered phone number "1234567890" is displayed or not in phone number tab in create admin
    Then Close Admin button

  @TC_23
  Scenario: ADD USER:Status Check
    Given Click Add User button in create admin page
    Then Click the toggle button
    And Check the status changed to No-option in the toggle button
    Then Close Admin button

  @TC_24
  Scenario: ADD USER:Status Check
    Given Click Add User button in create admin page
    Then Click the toggle button
    And Check the status changed to No-option in the toggle button
    And Click the toggle button
    And Check the status changed to Yes-option in the toggle button
    Then Close Admin button

  @TC_25
  Scenario: ADD USER:Address1 Check
    Given Click Add User button in create admin page
    And Enter valid "Test Street @ 1" in address1 tab
    Then Check entered details "Test Street @ 1" are displayed or not in address1 tab
    Then Close Admin button

  @TC_26
  Scenario: ADD USER:Address2 Check
    Given Click Add User button in create admin page
    And Enter valid "Test Street @ 2" in address2 tab
    Then Check entered details "Test Street @ 2" are displayed or not in address2 tab
    Then Close Admin button

  @TC_27
  Scenario: ADD USER:City Check
    Given Click Add User button in create admin page
    And Enter numerical characters "1234567" in city tab
    Then Check tab is empty or not in city tab
    Then Close Admin button

  @TC_28
  Scenario: ADD USER:City Check
    Given Click Add User button in create admin page
    And Enter special characters "!@#$%^" in city tab
    Then Check tab is empty or not in city tab
    Then Close Admin button

  @TC_29
  Scenario: ADD USER:City Check
    Given Click Add User button in create admin page
    And Enter alphabetical characters "Test City" in city tab
    Then Check tab is empty or not in city
    Then Close Admin button

  @TC_30
  Scenario: ADD USER:Country Check
    Given Click Add User button in create admin page
    And Enter country name "India" in country tab
    Then Check entered country name "India" is displayed or not in country tab
    Then Close Admin button

  @TC_31
  Scenario: ADD USER:Country Check
    Given Click Add User button in create admin page
    And Select country name "India" in country tab
    Then Check entered country name "India" is displayed or not in country tab
    Then Close Admin button

  @TC_32
  Scenario: ADD USER:State Check
    Given Click Add User button in create admin page
    And Enter state name "Tamil Nadu" in state tab
    Then Check entered state name "Tamil Nadu" is displayed or not in country tab
    Then Close Admin button

  @TC_33
  Scenario: ADD USER:State Check
    Given Click Add User button in create admin page
    And Select state name "Tamil Nadu" in state tab
    Then Check entered state name "Tamil Nadu" is displayed or not in country tab
    Then Close Admin button

  @TC_34
  Scenario: ADD USER:Time Zone Check
    Given Click Add User button in create admin page
    And Enter Time Zone name "Asia/Kolkata" in Time Zone tab
    Then Check entered Time Zone name "Asia/Kolkata" is displayed or not in Time Zone tab
    Then Close Admin button

  @TC_35
  Scenario: ADD USER:Time Zone Check
    Given Click Add User button in create admin page
    And Select valid "Asia/Kolkata" in timezone tab
    Then Check entered Time Zone name "Asia/Kolkata" is displayed or not in Time Zone tab
    Then Close Admin button

  @TC_36
  Scenario: ADD USER:Zip Code Check
    Given Click Add User button in create admin page
    And Enter alphabetical characters "test" in Zip Code tab
    Then Check tab is empty or not in Zip Code tab
    Then Close Admin button

  @TC_37
  Scenario: ADD USER:Zip Code Check
    Given Click Add User button in create admin page
    And Enter special characters "!@#$%^" in Zip Code tab
    Then Check tab is empty or not in Zip Code tab
    Then Close Admin button

  @TC_38
  Scenario: ADD USER:Zip Code Check
    Given Click Add User button in create admin page
    And Enter valid characters "123456" in Zip Code tab
    Then Check tab is empty or not in Zip Code
    Then Close Admin button

  #@TC_39
  #Scenario: ADD USER:User Profile Check
  #Given Click Add User button in create admin page
  #And Upload invalid file in profile upload tab
  #Then Check error message is displayed or not for invalid file upload
  #Then Close Admin button
  #@TC_40
  #Scenario: ADD USER:User Profile Check
  #Given Click Add User button in create admin page
  #And Upload valid file in profile upload tab
  #Then Close Admin button
  @TC_41
  Scenario: ADD USER:2FA Check
    Given Click Add User button in create admin page
    Then Click No radio button in 2FA Details tab
    And Click Yes radio button in 2FA Details tab
    Then Close Admin button

  @TC_42
  Scenario: ADD USER:2FA Check
    Given Click Add User button in create admin page
    And Click Yes radio button in 2FA Details tab
    Then Click Email radio button in 2FA Details tab
    And Click SMS radio button in 2FA Details tab
    Then Close Admin button

  @TC_43
  Scenario: Admin:Invalid Check
    Given Click Add User button in create admin page
    When Enter valid first name in create admin page
    Then Enter valid last name in create admin page
    And Enter valid email id in create admin page
    Then Select valid user type "Super Admin" in create admin page
    And Select valid country code "+91" in create admin page
    Then Enter valid phone number "98765432" in create admin page
    And Enter valid address1 details "Test Address1"
    Then Enter valid address2 details "Test Address2"
    And Enter valid city details "Test city"
    Then Select valid country "United States of America" in the dropdown
    And Select valid state "New York" in the dropdown
    Then Select valid timezone "America/Chicago" in the dropdown
    And Enter valid zipcode "654321"
    # Then Upload valid file in the profile upload page
    And Select No option in the 2FA tab
    Then Click save button in create admin page
    And Check error message is displayed or not
    Then Close Admin button

  @TC_44
  Scenario: Admin:Valid Check
    Given Click Add User button in create admin page
    When Enter valid first name in create admin page
    Then Enter valid last name in create admin page
    And Enter valid email id in create admin page
    Then Select valid user type "Super Admin" in create admin page
    And Select valid country code "+91" in create admin page
    Then Enter valid phone number "9876543210" in create admin page
    And Enter valid address1 details "Test Address1"
    Then Enter valid address2 details "Test Address2"
    And Enter valid city details "Test city"
    Then Select valid country "United States of America" in the dropdown
    And Select valid state "New York" in the dropdown
    Then Select valid timezone "America/Chicago" in the dropdown
    And Enter valid zipcode "654321"
    #  Then Upload valid file in the profile upload page
    And Select No option in the 2FA tab
    Then Click save button in create admin page
    Then Check admin user created success message is displayed or not
    Then Close Admin button

  @TC_45
  Scenario: Update Admin:Valid Check
    Given Enter user name "twofauser@yopmail.com" in the Search box
    When Click Edit button
    Then Modify valid details in edit admin page
    And Click update button in edit admin page
    Then Check admin user updated success message is displayed or not
    Then Close Admin button

  @TC_46
  Scenario: Update Admin:Valid Check
    Given Enter user name "Thiru maran" in the Search box
    When Click Edit button
    Then Change the status to inactive mode
    And Click update button in edit admin page
    Then Check admin user updated success message is displayed or not
    Then Enter user name "Thiru maran" in the Search box
    And Select "All" Option in status dropdown
    And Check the status is inactive or not in the grid of the same username
    Then Close Admin button

  @TC_47
  Scenario: Update Admin:Valid Check
    Given Enter user name "Thiru maran" in the Search box
    When Select "All" Option in status dropdown
    And Click Edit button
    Then Change the status to active mode
    And Click update button in edit admin page
    Then Enter user name "Thiru maran" in the Search box
    And Select "All" Option in status dropdown
    Then Check the status is active or not in the grid of the same username
    Then Close Admin button

  @TC_48
  Scenario: Update Admin:Valid Check
    Given Enter user name "testuser@guerrillamail.info" in the Search box
    When Click Edit button
    Then Click change email button
    And Click close button of the pop up
    Then Close Admin button

  @TC_49
  Scenario: Update Admin:Valid Check
    Given Enter user name "testuser@guerrillamail.info" in the Search box
    When Click Edit button
    Then Click change email button
    And Enter existing "0211thiru@gmail.com" email id
    Then Click verify email button
    And Check alert message is displayed or not in change email tab
    Then Close Admin button

  @TC_50
  Scenario: Update Admin:Valid Check
    Given Enter user name "testuser@guerrillamail.info" in the Search box
    When Click Edit button
    Then Click change email button
    And Enter valid email id
    Then Click verify email button
    And Check success message is displayed or not in verify email
    Then Close Admin button
  #@TC_53
  #Scenario: Update Admin:Valid Check
    #Given Enter user name "twofauser@yopmail.com" in the Search box
    #When Click Edit button
    #Then Click unlock button
    #And Click yes button in the pop up
    #Then Check success message is displayed or not for user unlock
    #Then Close Admin button
