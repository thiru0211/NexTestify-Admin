Feature: SUBJECT

  Background: Subject
    Given To Check subject is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check subject Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check subject page
    Then Click take picture button in subject page
    Then Click subject button in setup module

  @TC_01
  Scenario: Subject:Search Check
    Given Enter valid subject name "Artificial Intelligence" in the searchbox in subject page
    When Check entered subject name "Artificial Intelligence" is displayed or not in subject page
    Then Close subject button

  @TC_02
  Scenario: Subject:Filter Check
    Given Select "All" option in the dropdown in subject page
    Then Close subject button

  @TC_03
  Scenario: Subject:Filter Check
    Given Select "Active" 2nd option in the dropdown in subject page
    #When Check selected 2nd option "Active" is displayed or not in subject page
    Then Close subject button

  @TC_04
  Scenario: Subject:Filter Check
    Given Select "Inactive" 3rd option in the dropdown in subject page
    #When Check selected 3rd option "Inactive" is displayed or not in subject page
    Then Close subject button

  @TC_05
  Scenario: ADD SUBJECT:Back button check
    Given Click add subject button in subject page
    When Click back button in subject page
    Then Check page navigates to previous page or not in subject page
    Then Close subject button

  @TC_06
  Scenario: ADD SUBJECT:Mandatory check
    Given Click add subject button in subject page
    When Click save button in subject page
    Then Check mandatory red border is displayed or not in add subject page
    Then Close subject button

  @TC_07
  Scenario: ADD SUBJECT:Price Details Invalid check
    Given Click add subject button in subject page
    When Enter alpha characters "ABCD" in price tab
    Then Check tab is empty or not in price tab
    Then Close subject button

  @TC_08
  Scenario: ADD SUBJECT:Price Details Invalid check
    Given Click add subject button in subject page
    When Enter special characters "!@#$" in price tab
    Then Check tab is empty or not in price tab
    Then Close subject button

  @TC_09
  Scenario: ADD SUBJECT:Price Details Valid check
    Given Click add subject button in subject page
    When Enter numerical characters "1234" in price tab
    Then Check entered text "$1234" is displayed or not in price tab
    Then Close subject button

  @TC_10
  Scenario: ADD SUBJECT:Price Details Invalid check
    Given Click add subject button in subject page
    When Enter numerical characters "123456" in price tab
    Then Check the tab has more or less than maximum digits in price tab
    Then Close subject button

  @TC_11
  Scenario: ADD SUBJECT:Discount check
    Given Click add subject button in subject page
    When Click apply discount toggle button in price tab
    Then Check Discount Unit dropdown is displayed or not
    Then Close subject button

  @TC_12
  Scenario: ADD SUBJECT:Price Value check
    Given Click add subject button in subject page
    When Enter valid price value "100" in price tab
    Then Check the total is displayed same like as entered total "$100.00" or not in price tab
    Then Close subject button

  @TC_13
  Scenario: ADD SUBJECT:Discount Price-Percentage check
    Given Click add subject button in subject page
    When Enter valid price value "100" in price tab
    Then Click apply discount toggle button in price tab
    And Select Percentage option in the dropdown in price tab
    Then Enter valid percentage value "5" in price tab
    And Check valid total value "$95.00" for percentage option is correct or not in price tab
    Then Close subject button

  @TC_14
  Scenario: ADD SUBJECT:Discount Price-Flat Amount check
    Given Click add subject button in subject page
    When Enter valid price value "100" in price tab
    Then Click apply discount toggle button in price tab
    And Select Flat Amount option in the dropdown in price tab
    Then Enter valid Flat Amount value "5" in price tab
    And Check valid total value "$95.00" for flat amount option is correct or not in price tab
    Then Close subject button

  @TC_15
  Scenario: ADD SUBJECT:File Upload Invalid check
    Given Click add subject button in subject page
    When Click file upload button in add subject
    Then Upload invalid file format in add subject
    And Check error message is displayed or not in add subject
    Then Close subject button

  @TC_16
  Scenario: ADD SUBJECT:File Upload Valid check
    Given Click add subject button in subject page
    When Click file upload button in add subject
    Then Upload valid file format in add subject
    #And Check success message is displayed or not in add subject
    Then Close subject button

  @TC_17
  Scenario: ADD SUBJECT:Subject Details check
    Given Click add subject button in subject page
    When Enter Special characters "!@#$" in the subject tab in add subject
    Then Clear the characters in the subject tab in add subject
    And Enter Numerical characters "1234" in the subject tab in add subject
    Then Clear the characters in the subject tab in add subject
    And Enter alpha characters "Sample" in the subject tab in add subject
    Then Clear the characters in the subject tab in add subject
    Then Close subject button

  @TC_18
  Scenario: ADD SUBJECT:Active Toggle check
    Given Click add subject button in subject page
    When Click the Active toggle button in add subject
    Then Close subject button

  @TC_19
  Scenario: ADD SUBJECT:Subject Details Valid check
    Given Click add subject button in subject page
    When Enter valid price value "100" in add subject
    Then Enter the valid subject name in add subject
    And Enter valid colour code "#0cd3ed" in add subject
    Then Enter valid description "Test Description" details in add subject
    And Enter the subject content "Test Content" details in add subject
    Then Click save button in add subject in subject page
    And Check success message is displayed or not in add subject in subject page
    Then Close subject button

  @TC_20
  Scenario: ADD SUBJECT:Subject Details Valid check
    Given Click add subject button in subject page
    When Enter valid price value "100" in add subject
    Then Click apply discount toggle button in price tab
    And Select Percentage option in the dropdown in price tab
    Then Enter percentage value "5" in add subject
    And Enter the valid subject name in add subject
    And Enter valid colour code "#0cd3ed" in add subject
    Then Enter valid description "Test Description" details in add subject
    And Enter the subject content "Test Content" details in add subject
    Then Click save button in add subject in subject page
    And Check success message is displayed or not in add subject in subject page
    Then Close subject button

  @TC_21
  Scenario: ADD SUBJECT:Subject Details Valid check
    Given Click add subject button in subject page
    When Enter valid price value "100" in add subject
    Then Click apply discount toggle button in price tab
    And Select Flat Amount option in the dropdown in price tab
    Then Enter valid Flat Amount value "10" in price tab
    And Enter the valid subject name in add subject
    And Enter valid colour code "#0cd3ed" in add subject
    Then Enter valid description "Test Description" details in add subject
    And Enter the subject content "Test Content" details in add subject
    Then Click save button in add subject in subject page
    And Check success message is displayed or not in add subject in subject page
    Then Close subject button

  @TC_22
  Scenario: Edit Subject:Back button Check
    Given Enter valid subject name "Artificial Intelligence" in the searchbox in subject page
    And Click the subject name
    When Click back button in subject page
    And Check page navigates to previous page or not in subject page
    Then Close subject button

  @TC_23
  Scenario: Edit Subject:Update Check
    Given Enter valid subject name "Artificial Intelligence" in the searchbox in subject page
    And Click the subject name
    Then Modify valid details in update subject
    And Click update button in update subject
    Then Check success message is displayed or not in update subject
    Then Close subject button
