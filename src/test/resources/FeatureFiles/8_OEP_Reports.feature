Feature: REPORTS

  Background: Reports
    Given To Check Reports is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Reports Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Reports page
    Then Click take picture button in Reports page
    Then Click Reports button

  @TC_01
  Scenario: Test Results:Calendar Check
    Given Click Test Results button
    When Select valid from date "02/01/2025" in test results page
    Then Select valid to date "02/28/2025" in test results page
    #And Check details are displayed or not in test results page
    Then Close Reports page

  @TC_02
  Scenario: Test Results:Subject Filter Check
    Given Click Test Results button
    When Select valid from date "02/01/2025" in test results page
    And Select valid to date "02/28/2025" in test results page
    Then Select valid subject name "Artificial Intelligence" in the dropdown in test results page
    #And Check subject name details are displayed or not in test results page
    Then Close Reports page

  @TC_03
  Scenario: Test Results:Level Check
    Given Click Test Results button
    When Select valid from date "02/01/2025" in test results page
    And Select valid to date "02/28/2025" in test results page
    Then Select valid level "Easy" in the dropdown in test results page
    #And Check level details are displayed or not in test results page
    Then Close Reports page

  @TC_04
  Scenario: Test Results:Test Details Check
    Given Click Test Results button
    When Select valid from date "02/01/2025" in test results page
    Then Select valid to date "02/28/2025" in test results page
    And Select valid subject name "Artificial Intelligence" in the dropdown in test results page
    Then Select valid level "Easy" in the dropdown in test results page
   # And Click any test name in test results page
   # Then Check test name details are displayed or not in test results page
    Then Close Reports page

  @TC_05
  Scenario: Event Log:Calendar Check
    Given Click Event Log button
    When Select valid from date "02/01/2025" in Event Log page
    Then Select valid to date "02/28/2025" in Event Log page
    And Check details are displayed or not in Event Log page
    Then Close Reports page

  @TC_06
  Scenario: Event Log:Search Check
    Given Click Event Log button
    When Enter valid username "Thirumaran R" in event log page
    Then Check username "Thirumaran R" details are displayed or not in Event Log page
    Then Close Reports page

  @TC_07
  Scenario: Event Log:Search Check
    Given Click Event Log button
    When Enter valid IpAddress "115.97.66.2" in event log page
    And Check IpAddress "115.97.66.2" details are displayed or not in Event Log page
    Then Close Reports page

  @TC_08
  Scenario: Event Log:Pagination Check
    Given Click Event Log button
    When Click last button in pagination in Event Log page
    And Click first button in pagination in Event Log page
    And Click next button in pagination in Event Log page
    Then Click previous button in pagination in Event Log page
    And Click the number button in pagination in Event Log page
    Then Close Reports page

  @TC_09
  Scenario: Event Log:Back button Check
    Given Click Event Log button
    When Select valid from date "02/01/2025" in Event Log page
    Then Select valid to date "02/28/2025" in Event Log page
    And Click edit button in Event Log page
    Then Click back button in Event Log page
    And Check landing page in Event Log page
    Then Close Reports page
