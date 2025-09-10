Feature: QUESTION MANAGER

  Background: Create Question
    Given To Check Create Question is navigating to OEP URL is "https://hedgeonline.in/OEPADMIN/Login"
    When To Check Create Question Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@123"
    And click the Signin button To Check Create Question
    Then Click Create Question button

  @TC_01
  Scenario: Create Question:Search Check
    Given Enter valid question "What is the difference between a sole proprietorship and a partnership?" details in the searchbox
    When Check entered question "What is the difference between a sole proprietorship and a partnership?" details is displayed or not
    Then Close Create Question button

  @TC_02
  Scenario: Create Question:Search Check
    Given Enter valid answer "Solving complex mathematical problems" details in the searchbox
    When Check entered answer "Solving complex mathematical problems" details is displayed or not
    Then Close Create Question button

  @TC_04
  Scenario: Create Question:Search Check
    Given Select "All Set" option in question set filter dropdown
    Then Select "Single Question" option in question set filter dropdown
    And Select "Grouped Question" option in question set filter dropdown
    Then Select "Scenario-based Question" option in question set filter dropdown
    Then Close Create Question button

  @TC_05
  Scenario: Create Question:Status Check
    Given Select All option in status dropdown
    Then Close Create Question button

  @TC_06
  Scenario: Create Question:Status Check
    Given Select Active option in status dropdown
    When Enter valid question "How is AI transforming the Block chain industry?" details in the searchbox
    And Click edit button in any question
    And Check question status "Active" is same as user selected
    Then Close Create Question button

  @TC_07
  Scenario: Create Question:Status Check
    Given Select Inactive option in status dropdown
    When Enter valid question "Test Inactive Questions" details in the searchbox
    Then Click edit button in any question
    And Check question status "Inactive" is same as user selected
    Then Close Create Question button

  @TC_08
  Scenario: Create Question:Subject Check
    Given Select All Subject option in subject dropdown
    Then Close Create Question button

  @TC_09
  Scenario: Create Question:Subject Check
    Given Select All Subject option in subject dropdown
    And Select "Artificial Intelligence" option in subject dropdown
    Then Check selected "Artificial Intelligence" option in subject dropdown
    And Select "Business and Commerce" option in subject dropdown
    Then Check selected "Business and Commerce" option in subject dropdown
    And Select "Cryptography" option in subject dropdown
    Then Check selected "Cryptography" option in subject dropdown
    Then Close Create Question button

  @TC_10
  Scenario: Create Question:Subject Check
    Given Enter valid question "Test Question" details in the searchbox
    When Select "Automation Testing using Selenium" option in subject dropdown
    And Select "Selenium" option in the topic dropdown
    Then Click edit button in any question
    And Check "Selenium" option is displayed or not in the topic dropdown
    Then Close Create Question button

  @TC_11
  Scenario: Create Question:Level Check
    Given Select "All Subject" option in subject dropdown
    When Select "All Level" option in level dropdown
    Then Close Create Question button

  @TC_12
  Scenario: Create Question:Level Check
    Given Enter valid question "Test Automation Question-1" details in the searchbox
    When Select "Artificial Intelligence" option in subject dropdown
    And Select "Machine Learning" option in the topic dropdown
    Then Select "All Level" option in level dropdown
    When Select "Easy" option in level dropdown
    And Click edit button in any question
    Then Check question level "Easy" is same as user selected
    And Click view questions button
    Then Enter valid question "Test Automation Question-2" details in the searchbox
    And Select "Medium" option in level dropdown
    And Click edit button in any question
    Then Check question level "Medium" is same as user selected
    And Click view questions button
    Then Enter valid question "Test Automation Question-3" details in the searchbox
    And Select "Hard" option in level dropdown
    And Click edit button in any question
    Then Check question level "Hard" is same as user selected
    Then Close Create Question button

  @TC_13
  Scenario: Create Question:Question Created By Check
    Given Check 3dots button
    And Check  question created user name and date & time details displayed or not
    Then Close Create Question button

  @TC_14
  Scenario: Create Question:Pagination Check
    Given Click last button in pagination in question manager
    When Click first button in pagination in question manager
    And Click next button in pagination in question manager
    Then Click previous button in pagination in question manager
    And Click the number button in pagination in question manager
    Then Close Create Question button

  @TC_15
  Scenario: Add Questions:Back Check
    Given Click actions button
    When Click add questions button
    And Click view questions button
    Then Check landing page in add question page
    Then Close Create Question button

  @TC_16
  Scenario: Add Questions:Mandatory Check
    Given Click actions button
    When Click add questions button
    And Click save button in add question page
    Then Check mandatory red border is displayed or not in add question page
    Then Close Create Question button

  @TC_17
  Scenario: Add Questions:Clear Check
    Given Click actions button
    When Click add questions button
    And Click save button in add question page
    Then Check mandatory red border is displayed or not in add question page
    And Click clear button in add questions page
    Then Check mandatory red border is removed or not in add question page
    Then Close Create Question button

  @TC_18
  Scenario: Add Subject:Close button Check
    Given Click actions button
    When Click add questions button
    And Click add button in subject tab
    And Click close button in add subject popup
    Then Close Create Question button

  @TC_19
  Scenario: Add Subject:Mandatory Check
    Given Click actions button
    When Click add questions button
    And Click add button in subject tab
    Then Click add button in add subject popup
    And Check mandatory red border is displayed or not in subject name
    Then Close Create Question button

  @TC_20
  Scenario: Add Subject:Valid Check
    Given Click actions button
    When Click add questions button
    And Click add button in subject tab
    Then Enter special characters in add subject popup
    And Clear the details in add subject popup
    Then Enter numerical characters in add subject popup
    And Clear the details in add subject popup
    Then Close Create Question button

  @TC_21
  Scenario: Add Subject:Existing Check
    Given Click actions button
    When Click add questions button
    And Click add button in subject tab
    Then Enter existing subject name in add subject popup
    And Click add button in add subject popup
    And Check alert message is displayed or not in add subject
    Then Close Create Question button

  @TC_22
  Scenario: Add Subject:Add button Check
    Given Click actions button
    When Click add questions button
    And Click add button in subject tab
    Then Enter valid subject name in add subject popup
    And Click add button in add subject popup
    And Check success message is displayed or not in add subject
    Then Close Create Question button

  @TC_23
  Scenario: Edit Subject:Close button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Subject" subject from the dropdown
    Then Click edit button in subject tab
    And Click Close button in edit subject popup
    Then Close Create Question button

  @TC_24
  Scenario: Edit Subject:Update button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Subject" subject from the dropdown
    Then Click edit button in subject tab
    And Modify valid subject name in edit subject popup
    Then Click update button in edit subject popup
    And Check success message is displayed or not in edit subject
    Then Close Create Question button

  @TC_25
  Scenario: Delete Subject:Close button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Subject" subject from the dropdown
    Then Click Delete button in subject tab
    And Click Close button in Delete Subject popup
    Then Close Create Question button

  @TC_26
  Scenario: Delete Subject: NO button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Subject" subject from the dropdown
    Then Click Delete button in subject tab
    And Click NO button in Delete Subject popup
    Then Close Create Question button

  #@TC_27
  #Scenario: Delete Subject: YES button Check
  #Given Click actions button
  #  When Click add questions button
  #And Select "Test Subject" subject from the dropdown
  #Then Click Delete button in subject tab
  #And Click YES button in Delete Subject popup
  #Then Check success message is displayed or not in Delete Subject
  #Then Close Create Question button
  @TC_28
  Scenario: Add Topic:Close button Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Click add button in topic tab
    And Click close button in add topic popup
    Then Close Create Question button

  @TC_29
  Scenario: Add Topic:Mandatory Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Click add button in topic tab
    Then Click add button in add topic popup
    And Check mandatory red border is displayed or not in add topic popup
    Then Close Create Question button

  @TC_30
  Scenario: Add Topic:Add button Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Click add button in topic tab
    Then Enter valid topic name in add topic popup
    And Click add button in add topic popup
    And Check success message is displayed or not in add topic popup
    Then Close Create Question button

  @TC_31
  Scenario: Edit Topic:Close button Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Select "Test Topic" topic from the dropdown in create questions
    Then Click edit button in topic tab
    And Click Close button in edit topic popup
    Then Close Create Question button

  @TC_32
  Scenario: Edit Topic:Update button Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Select "Test Topic" topic from the dropdown in create questions
    Then Click edit button in topic tab
    And Modify valid topic name in edit topic popup
    Then Click update button in edit topic popup
    And Check success message is displayed or not in edit topic

  @TC_33
  Scenario: Delete Topic:Close button Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Select "Test Topic" topic from the dropdown in create questions
    Then Click Delete button in topic tab
    And Click Close button in Delete topic popup
    Then Close Create Question button

  @TC_34
  Scenario: Delete Topic: NO button Check
    Given Click actions button
    When Click add questions button
    Then Select "Test Subject" subject from the dropdown
    And Select "Test Topic" topic from the dropdown in create questions
    Then Click Delete button in topic tab
    And Click NO button in Delete topic popup
    Then Close Create Question button

  #@TC_35
  #Scenario: Delete Topic: YES button Check
  #Given Click actions button
  #When Click add questions button
  #Then Select "Test Subject" subject from the dropdown
  #And Select "Test Topic" topic from the dropdown in create questions
  #Then Click Delete button in topic tab
  #And Click YES button in Delete topic popup
  #Then Check success message is displayed or not in topic tab
  #Then Close Create Question button
  @TC_36
  Scenario: Add Question Type:Close button Check
    Given Click actions button
    When Click add questions button
    And Click add button in Question Type tab
    And Click close button in add Question Type popup
    Then Close Create Question button

  @TC_37
  Scenario: Add Question Type:Mandatory Check
    Given Click actions button
    When Click add questions button
    And Click add button in Question Type tab
    Then Click add button in add Question Type popup
    And Check mandatory red border is displayed or not in add Question Type popup
    Then Close Create Question button

  @TC_38
  Scenario: Add Question Type:Add button Check
    Given Click actions button
    When Click add questions button
    And Click add button in Question Type tab
    Then Enter "Test Type" question type in add Question Type popup
    And Click add button in add Question Type popup
    And Check success message is displayed or not in add Question Type popup
    Then Close Create Question button

  @TC_39
  Scenario: Edit Question Type:Close button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Type" Question Type from the dropdown
    Then Click edit button in Question Type tab
    And Click Close button in edit Question Type popup
    Then Close Create Question button

  @TC_40
  Scenario: Edit Question Type:Update button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Type" Question Type from the dropdown
    Then Click edit button in Question Type tab
    And Modify Question Type name into "Test Types" in edit Question Type popup
    Then Click update button in edit Question Type popup
    And Check success message is displayed or not in edit Question Type
    Then Close Create Question button

  @TC_41
  Scenario: Edit Question Type:Previous Type change
    Given Click actions button
    When Click add questions button
    And Select "Test Types" Question Type from the dropdown
    Then Click edit button in Question Type tab
    And Modify Question Type name into "Test Type" in edit Question Type popup
    Then Click update button in edit Question Type popup
    And Check success message is displayed or not in edit Question Type
    Then Close Create Question button

  @TC_42
  Scenario: Delete Question Type:Close button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Type" Question Type from the dropdown
    Then Click Delete button in Question Type tab
    And Click Close button in Delete Question Type popup
    Then Close Create Question button

  @TC_43
  Scenario: Delete Question Type: NO button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Type" Question Type from the dropdown
    Then Click Delete button in Question Type tab
    And Click NO button in Delete Question Type popup
    Then Close Create Question button

  @TC_44
  Scenario: Delete Question Type: YES button Check
    Given Click actions button
    When Click add questions button
    And Select "Test Type" Question Type from the dropdown
    Then Click Delete button in Question Type tab
    And Click YES button in Delete Question Type popup
    Then Check success message is displayed or not in Question Type
    Then Close Create Question button

  @TC_45
  Scenario: Source Type:Image field Invalid Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload invalid file format in image field
    Then Check alert message is displayed or not in source type
    Then Close Create Question button

  @TC_46
  Scenario: Source Type:Audio field Invalid Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload invalid file format in audio field
    Then Close Create Question button

  @TC_47
  Scenario: Source Type:Video field Invalid Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload invalid file format in video field
    Then Close Create Question button

  @TC_48
  Scenario: Source Type:Image field valid Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in image field
    And Check file is uploaded or not in image field
    Then Close Create Question button

  @TC_49
  Scenario: Source Type:Audio field valid Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in audio field
    And Check file is uploaded or not in audio field
    Then Close Create Question button

  @TC_50
  Scenario: Source Type:Video field valid Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in video field
    And Check file is uploaded or not in video field
    Then Close Create Question button

  @TC_51
  Scenario: Source Type:Delete Image Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in image field
    And Click delete button in image field
    Then Click No button in the delete confirmation popup
    Then Close Create Question button

  @TC_52
  Scenario: Source Type:Delete Image Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in image field
    And Click delete button in image field
    Then Click Yes button in the delete confirmation popup
    And Check file is removed or not in image field
    Then Close Create Question button

  @TC_53
  Scenario: Source Type:Delete Audio Check
    Given Click actions button
    When Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in audio field
    And Click delete button in audio field
    Then Click Yes button in the delete confirmation popup
    #Then Check file is removed or not in audio field
    Then Close Create Question button

  @TC_54
  Scenario: Source Type:Delete Video Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select any option in question type
    Then Click and Upload valid file format in video field
    And Click delete button in video field
    Then Click Yes button in the delete confirmation popup
    #Then Check file is removed or not in video field
    Then Close Create Question button

  @TC_55
  Scenario: Add Questions:Textbox Features Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Enter "Test Question" details in question text box
    And Check entered question details "Test Question" is displayed or not in the question text box
    Then Close Create Question button

  @TC_56
  Scenario: Add Questions:Textbox Features Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Enter "Test Answer" details in answers text box
    And Check entered answers details "Test Answer" is displayed or not in the answers text box
    Then Close Create Question button

  @TC_57
  Scenario: Add Questions:Textbox Features Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Enter "Test Remarks" details in remarks text box in add questions
    And Check entered answers details "Test Remarks" is displayed or not in the remarks text box
    Then Close Create Question button

  @TC_58
  Scenario: Add Questions:Textbox Features Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Enter "Test Explanation" details in Explanation text box
    And Check entered answers details "Test Explanation" is displayed or not in the Explanation text box
    Then Close Create Question button

  @TC_59
  Scenario: Add Questions:Points Invalid Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Enter alpha characters in points for answer field
    And Check tab is empty of not in points for answer field
    Then Enter special characters in points for answer field
    And Check tab is empty of not in points for answer field
    Then Close Create Question button

  @TC_60
  Scenario: Add Questions:Time Invalid Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Enter alpha characters in Time field
    And Check tab is empty of not in Time field
    Then Enter special characters in Time field
    And Check tab is empty of not in Time field
    Then Close Create Question button

  @TC_61
  Scenario: Essay Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    # Then Upload valid image file
    # And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Question" details in question text box
    Then Enter "Test Answer" details in answers text box
    And Enter "Test Explanation" details in Explanation text box
    Then Enter "Test Remarks" details in remarks text box in add questions
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for essay type
    And Check tab is cleared or not for essay type
    Then Close Create Question button

  @TC_62
  Scenario: Essay Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Question" details in question text box
    Then Enter "Test Answer" details in answers text box
    And Enter "Test Explanation" details in Explanation text box
    Then Enter "Test Remarks" details in remarks text box in add questions
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for essay type
    And Check success message is displayed or not for essay type
    Then Close Create Question button

  @TC_63
  Scenario: Fill in the blanks Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Fill in the Blanks" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions & ______" question details for fill in the blanks type
    Then Enter "Answer" answer details for fill in the blanks type
    And Enter "Test Explanation" explanation details for fill in the blanks type
    And Enter "Test Remarks" remarks details for fill in the blanks type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for fill in the blanks type
    And Check tab is cleared or not for fill in the blanks type
    Then Close Create Question button

  @TC_64
  Scenario: Fill in the blanks Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Fill in the Blanks" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions & ______" question details for fill in the blanks type
    Then Enter "Answer" answer details for fill in the blanks type
    And Enter "Test Explanation" explanation details for fill in the blanks type
    And Enter "Test Remarks" remarks details for fill in the blanks type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for fill in the blanks type
    And Check success message is displayed or not for fill in the blanks type
    Then Close Create Question button

  @TC_65
  Scenario: Multiple Choice Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Multiple Choice" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Multiple Choice type
    Then Enter "Answer-1" first answer details for Multiple Choice type
    And Enter "Answer-2" second answer details for Multiple Choice type
    Then Enter "Answer-3" third answer details for Multiple Choice type
    And Enter "Test Explanation" explanation details for Multiple Choice type
    And Enter "Test Remarks" remarks details for Multiple Choice type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for Multiple Choice type
    And Check tab is cleared or not for Multiple Choice type
    Then Close Create Question button

  @TC_66
  Scenario: Multiple Choice Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Multiple Choice" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Multiple Choice type
    Then Enter "Answer-1" first answer details for Multiple Choice type
    And Enter "Answer-2" second answer details for Multiple Choice type
    Then Enter "Answer-3" third answer details for Multiple Choice type
    And Select checkbox no "1" in answers field for Multiple Choice type
    And Enter "Test Explanation" explanation details for Multiple Choice type
    And Enter "Test Remarks" remarks details for Multiple Choice type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for Multiple Choice type
    And Check success message is displayed or not for Multiple Choice type
    Then Close Create Question button

  @TC_67
  Scenario: Short Answer Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Short Answer" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Short Answer type
    Then Enter "Answer" answer details for Short Answer type
    And Enter "Test Explanation" explanation details for Short Answer type
    And Enter "Test Remarks" remarks details for Short Answer type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for Short Answer type
    And Check tab is cleared or not for Short Answer type
    Then Close Create Question button

  @TC_68
  Scenario: Short Answer Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Short Answer" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Short Answer type
    Then Enter "Answer" answer details for Short Answer type
    And Enter "Test Explanation" explanation details for Short Answer type
    And Enter "Test Remarks" remarks details for Short Answer type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for Short Answer type
    And Check success message is displayed or not for Short Answer type
    Then Close Create Question button

  @TC_69
  Scenario: Single Choice Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Single Choice" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Single Choice type
    Then Enter "Answer-1" first answer details for Single Choice type
    And Enter "Answer-2" second answer details for Single Choice type
    Then Enter "Answer-3" third answer details for Single Choice type
    And Enter "Test Explanation" explanation details for Single Choice type
    And Enter "Test Remarks" remarks details for Single Choice type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for Single Choice type
    And Check tab is cleared or not for Single Choice type
    Then Close Create Question button

  @TC_70
  Scenario: Single Choice Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Single Choice" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Single Choice type
    Then Enter "Answer-1" first answer details for Single Choice type
    And Enter "Answer-2" second answer details for Single Choice type
    Then Enter "Answer-3" third answer details for Single Choice type
    And Select radio button "1" in answers field for Single Choice type
    And Enter "Test Explanation" explanation details for Single Choice type
    And Enter "Test Remarks" remarks details for Single Choice type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for Single Choice type
    And Check success message is displayed or not for Single Choice type
    Then Close Create Question button

  @TC_71
  Scenario: True or False Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "True/False" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for True or False type
    And Enter "Test Explanation" explanation details for True or False type
    And Enter "Test Remarks" remarks details for True or False type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for True or False type
    And Check tab is cleared or not for True or False type
    Then Close Create Question button

  @TC_72
  Scenario: True or False Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "True/False" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions-1" question details for True or False type
    And Select True radio in answers field for True or False type
    And Enter "Test Explanation" explanation details for True or False type
    And Enter "Test Remarks" remarks details for True or False type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for True or False type
    And Check success message is displayed or not for True or False type
    Then Close Create Question button

  @TC_73
  Scenario: True or False Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "True/False" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions-2" question details for True or False type
    And Select False radio in answers field for True or False type
    And Enter "Test Explanation" explanation details for True or False type
    And Enter "Test Remarks" remarks details for True or False type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for True or False type
    And Check success message is displayed or not for True or False type
    Then Close Create Question button

  @TC_74
  Scenario: Match The Following Type:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Match The Following" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Match The Following type
    And Enter "Question-1" in first coloumn-A for Match The Following type
    And Enter "Answer-1" in first coloumn-B for Match The Following type
    And Enter "Question-2" in second coloumn-A for Match The Following type
    And Enter "Answer-2" in second coloumn-B for Match The Following type
    Then Click add options button in answers tab
    Then Click add options button in answers tab
    And Enter "Question-3" in third coloumn-A for Match The Following type
    And Enter "Answer-3" in third coloumn-B for Match The Following type
    And Enter "Question-4" in fourth coloumn-A for Match The Following type
    And Enter "Answer-4" in fourth coloumn-B for Match The Following type
    And Enter "Test Explanation" explanation details for Match The Following type
    And Enter "Test Remarks" remarks details for Match The Following type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click clear button for Match The Following type
    And Check tab is cleared or not for Match The Following type
    Then Close Create Question button

  @TC_75
  Scenario: Match The Following Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Match The Following" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    #Then Upload valid image file
    #And Upload valid audio file
    #Then Upload valid video file
    And Enter "Test Questions" question details for Match The Following type
    And Enter "Question-1" in first coloumn-A for Match The Following type
    And Enter "Answer-1" in first coloumn-B for Match The Following type
    And Enter "Question-2" in second coloumn-A for Match The Following type
    And Enter "Answer-2" in second coloumn-B for Match The Following type
    Then Click add options button in answers tab
    Then Click add options button in answers tab
    And Enter "Question-3" in third coloumn-A for Match The Following type
    And Enter "Answer-3" in third coloumn-B for Match The Following type
    And Enter "Question-4" in fourth coloumn-A for Match The Following type
    And Enter "Answer-4" in fourth coloumn-B for Match The Following type
    And Enter "Test Explanation" explanation details for Match The Following type
    And Enter "Test Remarks" remarks details for Match The Following type
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    Then Click save button for Match The Following type
    And Check success message is displayed or not for Match The Following type
    Then Close Create Question button

  @TC_76
  Scenario: Add Subject:Question Type Change Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    And Enter "Test Question" details in question text box
    Then Enter "Test Answer" details in answers text box
    And Enter "Test Explanation" details in Explanation text box
    Then Enter "Test Remarks" details in remarks text box in add questions
    And Change the question type in any other type
    Then Check entered details are cleared or not
    Then Close Create Question button

  @TC_77
  Scenario: Essay Type:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Select "Essay" Question Type from the dropdown
    Then Select valid option in question level
    And Select valid option in question status
    And Enter "Test Question" details in question text box
    Then Enter "Test Answer" details in answers text box
    And Enter "Test Explanation" details in Explanation text box
    Then Enter "Test Remarks" details in remarks text box in add questions
    Then Enter "2" points in add questions
    And Enter "2" time in add questions
    And Click Approve button in create question page
    Then Enter valid approval details in create question page
    Then Click save button for essay type
    And Check success message is displayed or not for essay type
    Then Close Create Question button

  @TC_78
  Scenario: Edit Question:Back Check
    Given Search "Test Question" question name in search field
    When Click edit button in create question page
    Then Click view questions button in edit question page
    And Check landing page in add question page
    Then Close Create Question button

  @TC_79
  Scenario: Edit Question:Clear Check
    Given Search "Test Question" question name in search field
    And Click edit button in create question page
    Then Click clear button in edit question page
    And Check details are cleared or not in edit question page
    Then Close Create Question button

  #@TC_80
  #Scenario: Edit Question:Update Check
  #Given Search "Test Question" question name in search field
  #And Click edit button in create question page
  #Then Modify valid details in any tab
  #And Click update button in edit question page
  #Then Check success message is displayed or not in edit question page
  #Then Close Create Question button
  @TC_81
  Scenario: Group Question:Mandatory Check
    Given Click actions button
    When Click add questions button
    And Click Group question radio button in create question
    Then Click save button in add question page
    And Check mandatory red border is displayed or not for group question
    Then Close Create Question button

  @TC_82
  Scenario: Group Question:Count Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "5" question in question count tab
    And Check "5" question tab is displayed or not in group question
    Then Close Create Question button

  @TC_83
  Scenario: Group Question:Count Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "5" question in question count tab
    And Check "5" question tab is displayed or not in group question
    Then Close Create Question button

  @TC_84
  Scenario: Group Question:Mandatory Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "5" question in question count tab
    And Click save button in add question page
    Then Check alert message is displayed or not in add subject page
    And Check mandatory red border is displayed or not question type
    Then Close Create Question button

  @TC_85
  Scenario: Group Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    And Click save button in add question page
    Then Check alert message is displayed or not to check question level in add subject page
    Then Close Create Question button

  @TC_86
  Scenario: Group Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Click save button in add question page
    Then Check alert message is displayed or not to check question required in add subject page
    Then Close Create Question button

  @TC_87
  Scenario: Group Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    And Click save button in add question page
    Then Check alert message is displayed or not to check answer required in add subject page
    Then Close Create Question button

  @TC_88
  Scenario: Group Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Click save button in add question page
    Then Check alert message is displayed or not to check explanation required in add subject page
    Then Close Create Question button

   @TC_89
  Scenario: Group Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_90
  Scenario: Group Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    And Click clear button in add question page
    Then Check details is cleared or not in add question page
    Then Close Create Question button

  @TC_91
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_92
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "2" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in question tab in question2
    Then Enter "Test answer-2" detail in answer tab in question2
    And Enter "Test explanation-2" detail in explanation tab in question2
    Then Enter "Test remarks-2" detail in remarks tab in question2
    Then Close Create Question button

  @TC_93
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "3" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in question tab in question2
    Then Enter "Test answer-2" detail in answer tab in question2
    And Enter "Test explanation-2" detail in explanation tab in question2
    Then Enter "Test remarks-2" detail in remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in question tab in question3
    Then Enter "Test answer-3" detail in answer tab in question3
    And Enter "Test explanation-3" detail in explanation tab in question3
    Then Enter "Test remarks-3" detail in remarks tab in question3
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_94
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "4" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in question tab in question2
    Then Enter "Test answer-2" detail in answer tab in question2
    And Enter "Test explanation-2" detail in explanation tab in question2
    Then Enter "Test remarks-2" detail in remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in question tab in question3
    Then Enter "Test answer-3" detail in answer tab in question3
    And Enter "Test explanation-3" detail in explanation tab in question3
    Then Enter "Test remarks-3" detail in remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in question tab in question4
    Then Enter "Test answer-1" detail in option1 in answer tab in question4
    And Enter "Test answer-2" detail in option2 in answer tab in question4
    Then Enter "Test answer-3" detail in option3 in answer tab in question4
    And Enter "Test explanation-4" detail in explanation tab in question4
    Then Enter "Test remarks-4" detail in remarks tab in question4
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_95
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "5" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in question tab in question2
    Then Enter "Test answer-2" detail in answer tab in question2
    And Enter "Test explanation-2" detail in explanation tab in question2
    Then Enter "Test remarks-2" detail in remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in question tab in question3
    Then Enter "Test answer-3" detail in answer tab in question3
    And Enter "Test explanation-3" detail in explanation tab in question3
    Then Enter "Test remarks-3" detail in remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in question tab in question4
    Then Enter "Test answer-1" detail in option1 in answer tab in question4
    And Enter "Test answer-2" detail in option2 in answer tab in question4
    Then Enter "Test answer-3" detail in option3 in answer tab in question4
    And Enter "Test explanation-4" detail in explanation tab in question4
    Then Enter "Test remarks-4" detail in remarks tab in question4
    Then Click "Question - 5" button in add question page
    And Select "Single Choice" option in question type in question5
    Then Select "Easy" option in question level in question5
    And Enter "Test question-5" detail in question tab in question5
    Then Enter "Test answer-1" detail in option1 in answer tab in question5
    And Enter "Test answer-2" detail in option2 in answer tab in question5
    Then Enter "Test answer-3" detail in option3 in answer tab in question5
    And Enter "Test explanation-5" detail in explanation tab in question5
    Then Enter "Test remarks-5" detail in remarks tab in question5
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_96
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "6" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in question tab in question2
    Then Enter "Test answer-2" detail in answer tab in question2
    And Enter "Test explanation-2" detail in explanation tab in question2
    Then Enter "Test remarks-2" detail in remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in question tab in question3
    Then Enter "Test answer-3" detail in answer tab in question3
    And Enter "Test explanation-3" detail in explanation tab in question3
    Then Enter "Test remarks-3" detail in remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in question tab in question4
    Then Enter "Test answer-1" detail in option1 in answer tab in question4
    And Enter "Test answer-2" detail in option2 in answer tab in question4
    Then Enter "Test answer-3" detail in option3 in answer tab in question4
    And Enter "Test explanation-4" detail in explanation tab in question4
    Then Enter "Test remarks-4" detail in remarks tab in question4
    Then Click "Question - 5" button in add question page
    And Select "Single Choice" option in question type in question5
    Then Select "Easy" option in question level in question5
    And Enter "Test question-5" detail in question tab in question5
    Then Enter "Test answer-1" detail in option1 in answer tab in question5
    And Enter "Test answer-2" detail in option2 in answer tab in question5
    Then Enter "Test answer-3" detail in option3 in answer tab in question5
    And Enter "Test explanation-5" detail in explanation tab in question5
    Then Enter "Test remarks-5" detail in remarks tab in question5
    Then Click "Question - 6" button in add question page
    And Select "True/False" option in question type in question6
    Then Select "Easy" option in question level in question6
    And Enter "Test question-6" detail in question tab in question6
    And Enter "Test explanation-6" detail in explanation tab in question6
    Then Enter "Test remarks-6" detail in remarks tab in question6
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

   @TC_97
  Scenario: Group Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Group question radio button in create question
    Then Enter "7" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in question tab in question2
    Then Enter "Test answer-2" detail in answer tab in question2
    And Enter "Test explanation-2" detail in explanation tab in question2
    Then Enter "Test remarks-2" detail in remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in question tab in question3
    Then Enter "Test answer-3" detail in answer tab in question3
    And Enter "Test explanation-3" detail in explanation tab in question3
    Then Enter "Test remarks-3" detail in remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in question tab in question4
    Then Enter "Test answer-1" detail in option1 in answer tab in question4
    And Enter "Test answer-2" detail in option2 in answer tab in question4
    Then Enter "Test answer-3" detail in option3 in answer tab in question4
    And Enter "Test explanation-4" detail in explanation tab in question4
    Then Enter "Test remarks-4" detail in remarks tab in question4
    Then Click "Question - 5" button in add question page
    And Select "Single Choice" option in question type in question5
    Then Select "Easy" option in question level in question5
    And Enter "Test question-5" detail in question tab in question5
    Then Enter "Test answer-1" detail in option1 in answer tab in question5
    And Enter "Test answer-2" detail in option2 in answer tab in question5
    Then Enter "Test answer-3" detail in option3 in answer tab in question5
    And Enter "Test explanation-5" detail in explanation tab in question5
    Then Enter "Test remarks-5" detail in remarks tab in question5
    Then Click "Question - 6" button in add question page
    And Select "True/False" option in question type in question6
    Then Select "Easy" option in question level in question6
    And Enter "Test question-6" detail in question tab in question6
    And Enter "Test explanation-6" detail in explanation tab in question6
    Then Enter "Test remarks-6" detail in remarks tab in question6
    Then Click "Question - 7" button in add question page
    And Select "Match The Following" option in question type in question7
    Then Select "Easy" option in question level in question7
    And Enter "Test question-5" detail in question tab in question7
    Then Enter "Left-1" detail in left1 in answer tab in question7
    And Enter "Right-1" detail in right1 in answer tab in question7
    Then Enter "Left-2" detail in left2 in answer tab in question7
    And Enter "Right-2" detail in right2 in answer tab in question7
    And Enter "Test explanation-7" detail in explanation tab in question7
    Then Enter "Test remarks-7" detail in remarks tab in question7
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

   @TC_98
  Scenario: Group Question:Mandatory Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "2" question in question count tab
    And Click save button in add question page
    Then Check alert message is displayed or not in scenario required in add subject
    Then Close Create Question button

   @TC_99
  Scenario: Scenario-Based Question:Clear Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    And Click clear button in add question page
    Then Check details is cleared or not in add question page
    Then Close Create Question button

  @TC_100
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "1" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_101
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "2" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in scenario question tab in question2
    Then Enter "Test answer-2" detail in scenario answer tab in question2
    And Enter "Test explanation-2" detail in scenario explanation tab in question2
    Then Enter "Test remarks-2" detail in scenario remarks tab in question2
    Then Close Create Question button

  @TC_102
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "3" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in scenario question tab in question2
    Then Enter "Test answer-2" detail in scenario answer tab in question2
    And Enter "Test explanation-2" detail in scenario explanation tab in question2
    Then Enter "Test remarks-2" detail in scenario remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in scenario question tab in question3
    Then Enter "Test answer-3" detail in scenario answer tab in question3
    And Enter "Test explanation-3" detail in scenario explanation tab in question3
    Then Enter "Test remarks-3" detail in scenario remarks tab in question3
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_103
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "4" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in scenario question tab in question2
    Then Enter "Test answer-2" detail in scenario answer tab in question2
    And Enter "Test explanation-2" detail in scenario explanation tab in question2
    Then Enter "Test remarks-2" detail in scenario remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in scenario question tab in question3
    Then Enter "Test answer-3" detail in scenario answer tab in question3
    And Enter "Test explanation-3" detail in scenario explanation tab in question3
    Then Enter "Test remarks-3" detail in scenario remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in scenario question tab in question4
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question4
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question4
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question4
    And Enter "Test explanation-4" detail in scenario explanation tab in question4
    Then Enter "Test remarks-4" detail in scenario remarks tab in question4
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

   @TC_104
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "5" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in scenario question tab in question2
    Then Enter "Test answer-2" detail in scenario answer tab in question2
    And Enter "Test explanation-2" detail in scenario explanation tab in question2
    Then Enter "Test remarks-2" detail in scenario remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in scenario question tab in question3
    Then Enter "Test answer-3" detail in scenario answer tab in question3
    And Enter "Test explanation-3" detail in scenario explanation tab in question3
    Then Enter "Test remarks-3" detail in scenario remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in scenario question tab in question4
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question4
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question4
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question4
    And Enter "Test explanation-4" detail in scenario explanation tab in question4
    Then Enter "Test remarks-4" detail in scenario remarks tab in question4
    Then Click "Question - 5" button in add question page
    And Select "Single Choice" option in question type in question5
    Then Select "Easy" option in question level in question5
    And Enter "Test question-5" detail in scenario question tab in question5
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question5
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question5
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question5
    And Enter "Test explanation-5" detail in scenario explanation tab in question5
    Then Enter "Test remarks-5" detail in scenario remarks tab in question5
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

   @TC_105
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "6" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in scenario question tab in question2
    Then Enter "Test answer-2" detail in scenario answer tab in question2
    And Enter "Test explanation-2" detail in scenario explanation tab in question2
    Then Enter "Test remarks-2" detail in scenario remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in scenario question tab in question3
    Then Enter "Test answer-3" detail in scenario answer tab in question3
    And Enter "Test explanation-3" detail in scenario explanation tab in question3
    Then Enter "Test remarks-3" detail in scenario remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in scenario question tab in question4
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question4
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question4
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question4
    And Enter "Test explanation-4" detail in scenario explanation tab in question4
    Then Enter "Test remarks-4" detail in scenario remarks tab in question4
    Then Click "Question - 5" button in add question page
    And Select "Single Choice" option in question type in question5
    Then Select "Easy" option in question level in question5
    And Enter "Test question-5" detail in scenario question tab in question5
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question5
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question5
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question5
    And Enter "Test explanation-5" detail in scenario explanation tab in question5
    Then Enter "Test remarks-5" detail in scenario remarks tab in question5
    Then Click "Question - 6" button in add question page
    And Select "True/False" option in question type in question6
    Then Select "Easy" option in question level in question6
    And Enter "Test question-6" detail in scenario question tab in question6
    And Enter "Test explanation-6" detail in scenario explanation tab in question6
    Then Enter "Test remarks-6" detail in scenario remarks tab in question6
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button

  @TC_106
  Scenario: Scenario-Based Question:Save Check
    Given Click actions button
    When Click add questions button
    And Select "Automation Testing using Selenium" option in subject dropdown
    Then Select "Selenium" option in topic dropdown
    And Click Scenario-Based question radio button in create question
    Then Enter "7" question in question count tab
    And Select "Essay" option in question type in question1
    Then Select "Easy" option in question level in question1
    And Enter "Test scenario-1" detail in scenario in question tab
    And Enter "Test question-1" detail in question tab in question1
    Then Enter "Test answer-1" detail in answer tab in question1
    And Enter "Test explanation-1" detail in explanation tab in question1
    Then Enter "Test remarks-1" detail in remarks tab in question1
    Then Click "Question - 2" button in add question page
    And Select "Fill in the Blanks" option in question type in question2
    Then Select "Easy" option in question level in question2
    And Enter "Test question-2" detail in scenario question tab in question2
    Then Enter "Test answer-2" detail in scenario answer tab in question2
    And Enter "Test explanation-2" detail in scenario explanation tab in question2
    Then Enter "Test remarks-2" detail in scenario remarks tab in question2
    Then Click "Question - 3" button in add question page
    And Select "Short Answer" option in question type in question3
    Then Select "Easy" option in question level in question3
    And Enter "Test question-3" detail in scenario question tab in question3
    Then Enter "Test answer-3" detail in scenario answer tab in question3
    And Enter "Test explanation-3" detail in scenario explanation tab in question3
    Then Enter "Test remarks-3" detail in scenario remarks tab in question3
    Then Click "Question - 4" button in add question page
    And Select "Multiple Choice" option in question type in question4
    Then Select "Easy" option in question level in question4
    And Enter "Test question-4" detail in scenario question tab in question4
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question4
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question4
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question4
    And Enter "Test explanation-4" detail in scenario explanation tab in question4
    Then Enter "Test remarks-4" detail in scenario remarks tab in question4
    Then Click "Question - 5" button in add question page
    And Select "Single Choice" option in question type in question5
    Then Select "Easy" option in question level in question5
    And Enter "Test question-5" detail in scenario question tab in question5
    Then Enter "Test answer-1" detail in option1 in scenario answer tab in question5
    And Enter "Test answer-2" detail in option2 in scenario answer tab in question5
    Then Enter "Test answer-3" detail in option3 in scenario answer tab in question5
    And Enter "Test explanation-5" detail in scenario explanation tab in question5
    Then Enter "Test remarks-5" detail in scenario remarks tab in question5
    Then Click "Question - 6" button in add question page
    And Select "True/False" option in question type in question6
    Then Select "Easy" option in question level in question6
    And Enter "Test question-6" detail in scenario question tab in question6
    And Enter "Test explanation-6" detail in scenario explanation tab in question6
    Then Enter "Test remarks-6" detail in scenario remarks tab in question6
    Then Click "Question - 7" button in add question page
    And Select "Match The Following" option in question type in question7
    Then Select "Easy" option in question level in question7
    And Enter "Test question-5" detail in scenario question tab in question7
    Then Enter "Left-1" detail in left1 in scenario answer tab in question7
    And Enter "Right-1" detail in right1 in scenario answer tab in question7
    Then Enter "Left-2" detail in left2 in scenario answer tab in question7
    And Enter "Right-2" detail in right2 in scenario answer tab in question7
    And Enter "Test explanation-7" detail in scenario explanation tab in question7
    Then Enter "Test remarks-7" detail in scenario remarks tab in question7
    And Click save button in add question page
    Then Check success message is displayed or not question save in add subject
    Then Close Create Question button
