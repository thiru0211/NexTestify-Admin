Feature: CANDIDATE

  Background: Candidate
    Given To Check candidate is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check candidate Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check candidate page
    Then Click take picture button in candidate page
    Then Click candidate button in admin module

  @TC_01
  Scenario: Candidate:Search Check
    Given Enter valid username "Thirumaran" in the searchbox in candidate page
    When Check entered username "Thirumaran" is displayed or not in candidate page
    Then Close candidate button

  @TC_02
  Scenario: Candidate:Search Check
    Given Enter valid email id "thirumaran@yopmail.com" in the searchbox in candidate page
    When Check entered emailid "thirumaran@yopmail.com" is displayed or not in candidate page
    Then Close candidate button

  @TC_03
  Scenario: Candidate:Search Check
    Given Enter valid phone number "1234569870" in the searchbox in candidate page
    When Check entered phone number "+91-1234569870" is displayed or not in candidate page
    Then Close candidate button

  @TC_04
  Scenario: Candidate:Filter Check
    Given Select "All" option in the dropdown in candidate page
    Then Close candidate button

  @TC_05
  Scenario: Candidate:Filter Check
    Given Select "Paid" 2nd option in the dropdown in candidate page
    When Check selected 2nd option "Paid" is displayed or not in candidate page
    Then Close candidate button

  @TC_06
  Scenario: Candidate:Filter Check
    Given Select "Trial" 3rd option in the dropdown in candidate page
    When Check selected 3rd option "Trial" is displayed or not in candidate page
    Then Close candidate button

  @TC_07
  Scenario: Candidate:Pagination Check
    Given Click Last page button in below of the grid in candidate page
    When Click First page button in below of the grid in candidate page
    And Click next page button in below of the grid in candidate page
    Then Click previous page button in below of the grid in candidate page
    And Click the number button in below of the grid in candidate page
    Then Close candidate button

  @TC_08
  Scenario: Candidate:Back button check
    Given Enter valid username "Thirumaran" in the searchbox in candidate page
    When Click edit button in candidate page
    And Click back button in candidate page
    Then Check page navigates to previous page or not in candidate page
    Then Close candidate button

  @TC_09
  Scenario: Candidate:Two-level Authentication check
    Given Enter valid username "Thirumaran" in the searchbox in candidate page
    When Click edit button in candidate page
    And Click no radio button in Two FA tab in candidate page
    #Then Click update button in candidate page
   	#And Check success message is displayed or not in candidate page
    Then Close candidate button

  @TC_10
  Scenario: Candidate:Two-level Authentication check
    Given Enter valid username "Thirumaran" in the searchbox in candidate page
    When Click edit button in candidate page
    And Click yes radio button in Two FA tab in candidate page
    Then Click email radio button in Two FA tab in candidate page
    Then Click update button in candidate page
    And Check success message is displayed or not in candidate page
    Then Close candidate button

  @TC_11
  Scenario: Candidate:Two-level Authentication check
    Given Enter valid username "Thirumaran" in the searchbox in candidate page
    When Click edit button in candidate page
    And Click yes radio button in Two FA tab in candidate page
    Then Click sms radio button in Two FA tab in candidate page
    Then Click update button in candidate page
    And Check success message is displayed or not in candidate page
    Then Close candidate button

  @TC_12
  Scenario: Candidate:Invoice Details Download check
    Given Enter valid username "Dineshkumar" in the searchbox in candidate page
    When Click edit button in candidate page
    And Click invoice details button in candidate page
    Then Click download button in candidate page
    Then Close candidate button
