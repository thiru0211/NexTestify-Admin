Feature: TEST SETUP

  Background: Test Setup
    Given To Check Test Setup is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Test Setup Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Test Setup
    Then Click take picture button in test setup
    Then Click Test Setup button

  @TC_01
  Scenario: Test Setup:Search Check
    Given Enter valid test name "Sample Test-Main Test" in the searchbox
    When Check entered "Sample Test-Main Test" test name details is displayed or not in the test setup page
    And Enter valid date "Jan 29, 2025, 09:51 PM" in the searchbox
    Then Check entered "Jan 29, 2025, 09:51 PM" date details is displayed or not in the test setup page
    And Enter valid description "Sample Main test created for automation testing" in the searchbox
    Then Check entered "Sample Main test created for automation testing" description details is displayed or not in the test setup page
    Then Close Test Setup button

  @TC_02
  Scenario: Test Setup:Filter Check
    Given Select "All Status" 1st Option in the dropdown
    When Select "In Progress" 2nd Option in the dropdown
    Then Check In Progress details displayed or not
    And Select "Completed" 3rd Option in the dropdown
    Then Check Completed details displayed or not
    And Select "Frozen" 4th Option in the dropdown
    Then Check Frozen details displayed or not
    Then Close Test Setup button

  @TC_03
  Scenario: Test Setup:Test Type Check
    Given Select "All Test" 1st Option in dropdown
    When Select "Practice Test" 2nd Option in dropdown
    Then Check selected "Practice Test" option is displayed or not
    And Select "Main Test" 3rd Option in dropdown
    Then Check selected "Main Test" option is displayed or not
    Then Close Test Setup button

  @TC_04
  Scenario: Test Setup:Subject Check
    Given Select "All Subject" 1st Option in the dropdown
    Then Close Test Setup button

  @TC_05
  Scenario: New Test:Back Check
    Given Click new test button
    Then Click back button
    And Check the landing page
    Then Close Test Setup button

  @TC_06
  Scenario: Basic Settings:Mandatory Check
    Given Click new test button
    Then Click save button
    And Check mandatory red border is displayed or not
    Then Close Test Setup button

  @TC_07
  Scenario: Basic Settings:Invalid Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter alpha "Test" characters in Proctoring Capacity tab
    Then Check tab is empty or not in Proctoring Capacity tab
    And Enter special "!@#$%" characters in Proctoring Capacity tab
    Then Check tab is empty or not in Proctoring Capacity tab
    Then Close Test Setup button

  @TC_08
  Scenario: Basic Settings:Invalid Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter more than max characters "1234" in Proctoring Capacity tab
    Then Check the tab contains more than maximum character or not
    Then Close Test Setup button

  @TC_09
  Scenario: Basic Settings:Clear Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    Then Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click clear button
    Then Check all tabs are cleared or not
    Then Close Test Setup button

  @TC_10
  Scenario: Basic Settings:Clear Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    And Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click clear button
    Then Check all tabs are cleared or not in main test
    Then Close Test Setup button

  @TC_11
  Scenario: Basic Settings:Save Check
    Given Click new test button
    Then Click Practice Test radio button
    And Enter valid test name
    Then Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in Basic Settings tab
    Then Close Test Setup button

  @TC_12
  Scenario: Basic Settings:Save Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    And Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in test portal page
    Then Close Test Setup button

  @TC_13
  Scenario: Question Manager:Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    And Enter alpha characters in Overall Questions
    Then Check tab is empty or not in Overall Questions
    And Enter special characters in Overall Questions
    Then Check tab is empty or not in Overall Questions
    Then Close Test Setup button

  @TC_14
  Scenario: Question Manager:Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    And Enter alpha characters in Overall Points
    Then Check tab is empty or not
    And Enter special characters in Overall Points
    Then Check tab is empty or not
    Then Close Test Setup button

  @TC_15
  Scenario: Question Manager:Mandatory Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    Then Click clear button in question manager
    And Select any topic from the dropdown
    Then Click add button
    And Check red border is displayed or not in the mandatory tab
    Then Close Test Setup button

  @TC_16
  Scenario: Question Manager:Delete NO Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    Then Enter valid overall question
    And Enter valid overall points
    Then Select valid topic
    And Click add button
    Then Click delete button
    And Click No button in the pop up
    Then Check topic is removed or not
    Then Close Test Setup button

  @TC_17
  Scenario: Question Manager:Delete YES Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    Then Enter valid overall question
    And Enter valid overall points
    Then Select valid topic
    And Click add button
    Then Click delete button
    And Click Yes button in the pop up
    Then Check success message for deleted topic is displayed or not in question manager tab
    Then Close Test Setup button

  @TC_17a
  Scenario: Question Manager:Delete YES Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    Then Enter valid overall question
    And Enter valid overall points
    Then Select valid topic
    And Click add button
    And Enter valid value in questions tab
    Then Enter valid value in points tab
    And Enter valid in Time tab based on proper format
    Then Click update button
    Then Check success message is displayed or not in Question Manager tab
    Then Close Test Setup button

  @TC_18
  Scenario: Question Manager:Topic Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    And Enter alpha characters in Questions tab
    Then Check tab is empty or not in Questions tab
    And Enter special characters in Questions tab
    Then Check tab is empty or not in Questions tab
    Then Close Test Setup button

  @TC_19
  Scenario: Question Manager:Topic Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    And Enter alpha characters in points tab
    Then Check tab is empty or not in points tab
    And Enter special characters in points tab
    Then Check tab is empty or not in points tab
    Then Close Test Setup button

  @TC_20
  Scenario: Question Manager:Topic Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    And Enter alpha characters in Time tab
    Then Check tab is empty or not in Time tab
    And Enter special characters in Time tab
    Then Check tab is empty or not in Time tab
    Then Close Test Setup button

  @TC_21
  Scenario: Question Manager:Topic Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    Then Enter the value in questions tab more than overall questions tab
    And Enter the value in questions tab more than overall points tab
    Then Enter  valid in Time tab
    And Click save button in question manager
    Then check error message is displayed or not in question manager tab
    Then Close Test Setup button

  @TC_22
  Scenario: Question Manager:Clear Check
    Given Search any valid main test name
    Then Click the test name
    And Click question manager tab
    Then Click clear button in question manager
    And Check all tabs are cleared or not in question manager
    Then Close Test Setup button

  @TC_23
  Scenario: Question Manager:Save Check
    Given Click new test button
    Then Click Practice Test radio button
    And Enter valid test name
    Then Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in Basic Settings tab
    And Click question manager tab
    And Enter valid overall question values
    Then Enter valid overall points values
    And Select valid topic
    Then Click add button
    And Enter valid value in questions tab in Question Manager
    Then Enter valid value in points tab in Question Manager
    And Enter valid in Time tab based on proper format in Question Manager
    Then Click save button in question manager
    And Check success message is displayed or not in Question Manager
    Then Close Test Setup button

  @TC_24
  Scenario: Time Setup:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click time setup tab
    Then Click question manager button
    And Check landing page
    Then Close Test Setup button

  @TC_25
  Scenario: Basic Settings:Save Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    And Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in Basic Settings tab
    And Click question manager tab
    And Enter valid overall question values
    Then Enter valid overall points values
    And Select valid topic
    Then Click add button
    And Enter valid value in questions tab in Question Manager
    Then Enter valid value in points tab in Question Manager
    And Enter valid in Time tab based on proper format in Question Manager
    Then Click save button in question manager
    And Check success message is displayed or not in Question Manager
    And Click time setup tab
    Then Enter invalid "January 17, 2030 3:30 PM" Test activation Date and Time in time setup tab
    And Enter invalid "January 17, 2030 3:30 PM" Last Registration Date and Time in time setup tab
    Then Click save button in time setup
    And Check error message is displayed or not in time setup tab
    Then Close Test Setup button

  @TC_26
  Scenario: Time Setup:Valid Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    And Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in Basic Settings tab
    And Click question manager tab
    And Enter valid overall question values
    Then Enter valid overall points values
    And Select valid topic
    Then Click add button
    And Enter valid value in questions tab in Question Manager
    Then Enter valid value in points tab in Question Manager
    And Enter valid in Time tab based on proper format in Question Manager
    Then Click save button in question manager
    And Check success message is displayed or not in Question Manager
    And Click time setup tab
    Then Enter valid "December 17, 2030 3:30 PM" Test activation Date and Time in time setup tab
    And Enter valid "December 15, 2030 3:30 PM" Last Registration Date and Time in time setup tab
    Then Click save button in time setup
    And Check success message is displayed or not in time setup tab
    Then Close Test Setup button

  @TC_27
  Scenario: Grading Setup:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    Then Check all features are working or not in the all respondents text box
    And Clear the text present in the all respondents text box
    Then Enter valid message in the all respondents text box
    Then Close Test Setup button

  @TC_28
  Scenario: Grading Setup:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    Then Check all features are working or not in the all passed text box
    And Clear the text present in the all passed text box
    Then Enter valid message in the all passed text box
    Then Close Test Setup button

  @TC_29
  Scenario: Grading Setup:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    # Then Check all features are working or not in the all failed text box
    And Clear the text present in the all failed text box
    Then Enter valid message in the all failed text box
    Then Close Test Setup button

  @TC_30
  Scenario: Grading Setup:Pass Mark Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    Then Enter alpha characters "Test" in Pass Mark tab
    And Check tab is empty or not in Pass Mark tab
    Then Enter special characters "!@#$%" in Pass Mark tab
    And Check tab is empty or not in Pass Mark tab
    Then Close Test Setup button

  @TC_31
  Scenario: Grading Setup:Add Range Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    Then Click add range button
    And Check new row is added or not
    Then Close Test Setup button

  @TC_32
  Scenario: Grading Setup:Clear Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    Then Click clear button
    And Check all tab is cleared or not in grading setup
    Then Close Test Setup button

  @TC_33
  Scenario: Grading Setup:Mandatory Alert Check
    Given Search any valid main test name
    Then Click the test name
    And Click Grading setup tab
    Then Click clear button
    And Click save button in grading setup
    And Check error message is displayed or not in grading setup page
    Then Close Test Setup button

  @TC_34
  Scenario: Grading Setup:Valid Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    And Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in Basic Settings tab
    And Click question manager tab
    And Enter valid overall question values
    Then Enter valid overall points values
    And Select valid topic
    Then Click add button
    And Enter valid value in questions tab in Question Manager
    Then Enter valid value in points tab in Question Manager
    And Enter valid in Time tab based on proper format in Question Manager
    Then Click save button in question manager
    And Check success message is displayed or not in Question Manager
    And Click time setup tab
    Then Enter valid "December 17, 2025 3:30 PM" Test activation Date and Time in time setup tab
    And Enter valid "December 15, 2025 3:30 PM" Last Registration Date and Time in time setup tab
    Then Click save button in time setup
    And Check success message is displayed or not in time setup tab
    And Click Grading setup tab
    Then Click clear button
    And Enter valid test end message details
    Then Enter valid passed message details
    And Enter valid failed message details
    Then Enter valid pass mark value details
    And Select "%" 2nd option in unit dropdown
    Then Select "%" 2nd option in ranges unit
    And Enter valid from range value in range 1st tab
    Then Enter valid to range value in range 1st tab
    And Enter valid grade "A" in range 1st tab
    And Enter valid from range value in range 2nd tab
    Then Enter valid to range value in range 2nd tab
    And Enter valid grade "s" in range 2nd tab
    Then Click save button in grading setup
    And Check success message is displayed or not in grading setup
    Then Close Test Setup button

  @TC_35
  Scenario: Grading Setup:Valid Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name
    Then Enter valid Proctoring Capacity count
    And Select valid subject name
    And Select valid level
    Then Enter valid description details
    And Click save button
    Then Check success message is displayed or not in Basic Settings tab
    And Click question manager tab
    And Enter valid overall question values
    Then Enter valid overall points values
    And Select valid topic
    Then Click add button
    And Enter valid value in questions tab in Question Manager
    Then Enter valid value in points tab in Question Manager
    And Enter valid in Time tab based on proper format in Question Manager
    Then Click save button in question manager
    And Check success message is displayed or not in Question Manager
    And Click time setup tab
    Then Enter valid "December 17, 2025 3:30 PM" Test activation Date and Time in time setup tab
    And Enter valid "December 15, 2025 3:30 PM" Last Registration Date and Time in time setup tab
    Then Click save button in time setup
    And Check success message is displayed or not in time setup tab
    And Click Grading setup tab
    Then Click clear button
    And Enter valid test end message details
    Then Enter valid passed message details
    And Enter valid failed message details
    Then Enter valid pass mark value details
    And Select "P" 1st option in unit dropdown
    Then Select "P" 1st option in ranges unit
    And Enter valid from range value in range 1st tab
    Then Enter valid to range value in range 1st tab
    And Enter valid grade "A" in range 1st tab
    And Enter valid from range value in range 2nd tab
    Then Enter valid to range value in range 2nd tab
    And Enter valid grade "s" in range 2nd tab
    Then Click save button in grading setup
    And Check success message is displayed or not in grading setup
    Then Close Test Setup button

  @TC_36
  Scenario: Certificate Template:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Certificate Template tab
    Then Unselect the selected checkbox in all tabs
    And Check checkbox is unselected or not
    Then Close Test Setup button

  @TC_37
  Scenario: Certificate Template:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Certificate Template tab
    Then Select the unselected checkbox in all tabs
    And Check checkbox is selected or not
    Then Close Test Setup button

  @TC_38
  Scenario: Test Access:Invalid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Test Access tab
    Then Unselect the checkbox
    And Click save button in test access
    Then Check error message is displayed or not in test access
    Then Close Test Setup button

  @TC_39
  Scenario: Test Access:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Test Access tab
    Then Select the single checkbox
    And Click save button in test access
    Then Check success message is displayed or not in test access
    Then Close Test Setup button

  @TC_40
  Scenario: Test Access:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Test Access tab
    Then Select the all checkbox
    And Click save button in test access
    Then Check success message is displayed or not in test access
    Then Close Test Setup button

  @TC_41
  Scenario: Test Access:Valid Check
    Given Search any valid main test name
    Then Click the test name
    And Click Test Access tab
    Then Select any proctor from the dropdown
    Then Select the single checkbox
    And Click save button in test access
    Then Check success message is displayed or not in test access
    Then Close Test Setup button

  #@TC_41a(Due to if we Finalize the test, test change to completed status thats why i skip the test method)
  #Scenario: Finalize Test:Valid Check
  #Given Search any valid main test name
  #Then Click the test name
  #And Click Finalize Test tab
  #Then Click Finalize button
  #Then Close Test Setup button
  @TC_42
  Scenario: Practice Test:Valid Check
    Given Click new test button
    Then Click Practice Test radio button
    And Enter valid test name
    Then Select valid subject name
    And Select valid test level
    Then Enter valid test description
    And Click save button in practice test
    Then Check success message is displayed or not in Basic Settings tab
    And Enter valid overall questions value
    Then Enter valid overall points value
    And Select valid topic in add topics
    Then Click add button in add topics
    And Enter valid questions value in questions tab
    Then Enter valid points value in points tab
    And Enter valid time value in time tab
    Then Click save button in question manager
    And Check success message is displayed or not in Question Manager
    Then Click save button in time setup page
    And Check success message is displayed or not in time setup tab
    Then Enter valid pass mark in grading setup
    And Enter valid from range mark tab in 1st range tab in grading setup
    Then Enter valid to range mark tab in 1st range tab in grading setups
    And Enter valid grade mark tab in 1st range tab in grading setup
    Then Enter valid from range mark tab in 2st range tab in grading setup
    And Enter valid to range mark tab in 2st range tab in grading setups
    Then Enter valid grade mark tab in 2st range tab in grading setup
    And Click save button in grading setup
    Then Check success message is displayed or not in grading setup
    And Click finalize button in Finalize test page
    Then Check success message is displayed or not in Finalize Test tab
    Then Close Test Setup button

  @TC_43
  Scenario: Main Test:Valid Check
    Given Click new test button
    Then Click Main Test radio button
    And Enter valid test name in main test
    And Enter valid proctoring capacity in main test
    Then Select valid subject name in main test
    And Select valid test level in main test
    Then Enter valid test description in main test
    And Click save button in main test
    Then Check success message is displayed or not in test portal page
    And Enter valid overall questions value
    Then Enter valid overall points value
    And Select valid topic in add topics
    Then Click add button in add topics
    And Enter valid questions value in questions tab
    Then Enter valid points value in points tab
    And Enter valid time value in time tab
    Then Click save button in question manager
    And Check success message is displayed or not in test portal page
    Then Enter valid test activation date and time
    And Enter valid last registration date and time
    Then Click save button in time setup page
    And Check success message is displayed or not in test portal page
    Then Enter valid pass mark in grading setup
    And Enter valid from range mark tab in 1st range tab in grading setup
    Then Enter valid to range mark tab in 1st range tab in grading setups
    And Enter valid grade mark tab in 1st range tab in grading setup
    Then Enter valid from range mark tab in 2st range tab in grading setup
    And Enter valid to range mark tab in 2st range tab in grading setups
    Then Enter valid grade mark tab in 2st range tab in grading setup
    And Click save button in grading setup
    Then Check success message is displayed or not in test portal page
    And Click save button in certificate template page
    Then Check success message is displayed or not in certificate template page
    Then Close Test Setup button

  @TC_44
  Scenario: Edit Test:Basic Settings
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click clear button
    Then Check all tabs are cleared or not
    Then Close Test Setup button

  @TC_45
  Scenario: Edit Test:Basic Settings
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Modify the details in basic settings
    Then Click update button
    And Check success message is displayed or not in basic settings
    Then Close Test Setup button

  @TC_46
  Scenario: Edit Test:Question Manager
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click question manager tab
    And Click clear button
    Then Check all tabs are cleared or not in question manager
    Then Close Test Setup button

  @TC_47
  Scenario: Edit Test:Question Manager
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click question manager tab
    And Modify the details in Question Manager
    Then Click update button
    And Check success message is displayed or not in Question Manager
    Then Close Test Setup button

  @TC_48
  Scenario: Edit Test:Test Access
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click Test Access tab
    Then Select the single checkbox
    And Click save button in test access
    Then Check success message is displayed or not in test access
    Then Close Test Setup button

  @TC_49
  Scenario: Edit Test:Grading Setup
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click Grading setup tab
    Then Click clear button
    And Check all tab is cleared or not in grading setup
    Then Close Test Setup button

  @TC_50
  Scenario: Edit Test:Grading Setup
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click Grading setup tab
    Then Modify the details in Grading Setup
    And Click update button in Grading Setup
    Then Check success message is displayed or not in grading setup tab
    Then Close Test Setup button

  @TC_51
  Scenario: Edit Test:Certificate Template
    Given Search any valid main test name
    And Select "In Progress" 2nd Option in the dropdown
    Then Click the test name
    And Click Certificate Template tab
    Then Unselect the selected checkbox in all tabs
    And Select the unselected checkbox in all tabs
    And Check checkbox is selected or not
    Then Close Test Setup button
