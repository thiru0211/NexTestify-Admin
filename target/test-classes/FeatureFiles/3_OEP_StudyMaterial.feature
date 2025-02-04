Feature: STUDY MATERIAL

  Background: Study Material
    Given To Check Study Material is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Study Material Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Study Material
    Then Click take picture button in Study Material
    Then Click Study Material button

  @TC_01
  Scenario: Study Material:Back Check
    Given Click any subject name
    When Click back button in study material page
    Then Check landing page in study material page
    Then Close Study Material button
    
    @TC_02
  Scenario: Study Material:Topic Check
    Given Click any subject name
    When Click any topic button
    Then Close Study Material button

    @TC_03
  Scenario: Study Material:Add Material
    Given Click any subject name
    When Click add material button
    And Click view material button
    Then Check page navigates to view material page or not
    Then Close Study Material button

    @TC_04
  Scenario: Add Material:Mandatory Check
    Given Click any subject name
    When Click add material button
    And Click save button in add material
    Then Check mandatory red border is displayed or not in add material page
    Then Close Study Material button
    
    @TC_05
  Scenario: Add Material:Mandatory Clear Check
    Given Click any subject name
    When Click add material button
    And Click save button in add material
    And Click clear button in add material
    Then Check mandatory red border is displayed or not in add material
    Then Close Study Material button

    @TC_06
  Scenario: Add Material:Clear Check
    Given Click any subject name
    When Click add material button
    And Select valid subject name in create material
    Then Select valid topic name in create material
    And Enter valid chapter name
    Then Enter valid synopsis
    And Click clear button in add material
    Then Check details are cleared or not in add material
    Then Close Study Material button

    @TC_07
  Scenario: Add Material:Valid Check
    Given Click any subject name
    When Click add material button
    Then Enter valid synopsis
   # And Check all features are working or not in the text box
    Then Close Study Material button

    @TC_08
  Scenario: Add Subject:Close button Check
    Given Click any subject name
    When Click add material button
    And Click add button in the subject tab
    Then Click close button in add subject
    Then Close Study Material button

    @TC_09
  Scenario: Add Subject:Mandatory Check
    Given Click any subject name
    When Click add material button
    And Click add button in the subject tab
    Then Click save button in add subject
    Then Check mandatory red border is displayed or not in add subject
    Then Close Study Material button
    
     @TC_10
  Scenario: Add Subject:Add button Check
    Given Click any subject name
    When Click add material button
    And Click add button in the subject tab
    Then Enter existing subject name in add subject
    Then Click save button in add subject
    Then Check alert message is displayed or not in add subject in create material
    Then Close Study Material button
    
    #@TC_11
  #Scenario: Add Subject:Add button Check
    #Given Click any subject name
    #When Click add material button
    #And Click add button in the subject tab
    #Then Enter valid subject name in add subject
    #Then Click save button in add subject
    #Then Check success message is displayed or not in add subject
    #Then Close Study Material button
    
    @TC_12
  Scenario: Edit Subject:Close button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click edit button of the subject tab
    Then Click Close button in edit subject
    Then Close Study Material button
    
     @TC_13
  Scenario: Edit Subject:Update button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click edit button of the subject tab
    Then Modify valid subject name in edit subject
    And Click Update button in edit subject
    Then Check success message is displayed or not in edit subject in create material
    Then Close Study Material button
    
    @TC_14
  Scenario: Delete Subject:Close button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click delete button of the subject tab
    Then Click close button in delete popup
    Then Close Study Material button
    
    @TC_15
  Scenario: Delete Subject:No button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click delete button of the subject tab
    Then Click No button in the delete subject popup
    Then Close Study Material button
    
    #@TC_16
  #Scenario: Delete Subject:Yes button Check
    #Given Click any subject name
    #When Click add material button
    #And Select any subject from the dropdown in the subject tab
    #Then Click delete button of the subject tab
    #Then Click Yes button in the delete subject popup
    #Then Close Study Material button

     @TC_17
  Scenario: Add Topic:Close button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click add button in topic tab in create material page
    Then Click Close button in topic tab
    Then Close Study Material button

    @TC_18
  Scenario: Add Topic:Mandatory Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click add button in topic tab in create material page
    Then Click add button in add topic tab
    And Check mandatory message is displayed or not in topic tab
    Then Close Study Material button

    @TC_19
  Scenario: Add Topic:Add button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Click add button in topic tab in create material page
 #   And Select valid subject name in add topic pop up in add material page
    And Enter valid topic name in add topic tab
    Then Click add button in add topic tab
    And Check success message is displayed or not in add material page
    Then Close Study Material button

     @TC_20
  Scenario: Edit Topic:Close button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in topic tab
    And Click edit button in topic tab in create material page
    Then Click close button in edit topic tab
    Then Close Study Material button
    
    @TC_21
  Scenario: Edit Topic:Update button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in topic tab
    And Click edit button in topic tab in create material page
    Then Modify valid topic details in edit topic tab
    And Click update button in edit topic tab
    Then Check success message is displayed or not in edit topic popup
    Then Close Study Material button
    
    @TC_21a
  Scenario: Edit Topic:Update button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in topic
    And Click edit button in topic tab in create material page
    Then Modify valid topic details in edit topic
    And Click update button in edit topic tab
    Then Check success message is displayed or not in edit topic popup
    Then Close Study Material button

    @TC_22
  Scenario: Delete Topic:Close button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in topic tab
    And Click delete button in topic tab
    Then Click close button in delete topic
    Then Close Study Material button

    @TC_23
  Scenario: Delete Topic:No button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in topic tab
    And Click delete button in topic tab
    Then Click no button in delete topic
    Then Close Study Material button
    
    @TC_24
  Scenario: Delete Topic:Yes button Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in topic tab
    And Click delete button in topic tab
   # Then Click yes button in delete topic
    Then Close Study Material button

    @TC_25
  Scenario: Add Material:Valid Check
    Given Click any subject name
    When Click add material button
    And Select any subject from the dropdown in the subject tab
    Then Select any topic name from the dropdown in the topic tab
    And Enter valid chapter name
    Then Click raw content radio button
    And Enter valid details in the Synopsis box
    Then Upload valid files in appendices tab
    And Click save button in add material
    #Then Check success message is displayed or not in add material
    Then Close Study Material button
    
     @TC_26
  Scenario: Edit Material:Clear check
    Given Click any subject name
    When Click any question and answer details
    And Click clear button in edit material page
    Then Check details gets cleared or not in edit material page
    Then Close Study Material button
    
    @TC_27
  Scenario: Edit Material:Delete check
    Given Click any subject name
    When Click any question and answer details
    And Click delete button in edit material page
    Then Upload any material in edit material page
    Then Close Study Material button
    
    @TC_28
  Scenario: Edit Material:Modify check
    Given Click any subject name
    When Click any question and answer details
    And Modify any details in edit material page
    Then Click update button in edit material page
    Then Check success message is displayed or not in edit material page
    Then Close Study Material button
    
    @TC_29
  Scenario: Exercise:Back check
    Given Click any subject name
    When Click the exercise button
    And Click view material button in exercise
    Then Check page navigates to view material page or not
    Then Close Study Material button

    @TC_30
  Scenario: Exercise:Back check
    Given Click any subject name
    When Click the exercise button
    And Click add material button in exercise
    Then Check page navigates to add material page or not
    Then Close Study Material button

    @TC_31
  Scenario: Exercise:Back check
    Given Click any subject name
    When Click the exercise button
    And Click edit button of any exercise question
    Then Click clear button in edit question
    And Check details are cleared or not in edit question
    Then Close Study Material button

    @TC_32
  Scenario: Exercise:Mandatory Check
    Given Click any subject name
    When Click the exercise button
    And Click edit button of any exercise question
    Then Click clear button in edit question
    And Click update button in edit question
    And Check mandatory error message is displayed or not in edit question page
    Then Close Study Material button

    @TC_33
  Scenario: Exercise:Features Check
    Given Click any subject name
    When Click the exercise button
    And Click edit button of any exercise question
    #And Check all features are working or not in questions tab
    Then Close Study Material button
    
    @TC_34
  Scenario: Exercise:Features Check
    Given Click any subject name
    When Click the exercise button
    And Click edit button of any exercise question
  #  And Check all features are working or not in answers 1st option tab
    Then Close Study Material button
    
    @TC_35
  Scenario: Exercise:Update Check
    Given Click any subject name
    When Click the exercise button
    And Click edit button of any exercise question
    Then Modify valid details in edit question page
   	And Click update button in edit question
    And Check success message is displayed or not in edit question
    Then Close Study Material button   
    