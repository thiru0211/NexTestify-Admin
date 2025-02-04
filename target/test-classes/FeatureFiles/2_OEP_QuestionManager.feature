Feature: QUESTION MANAGER

  Background: Create Question
    Given To Check Create Question is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Create Question Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@8870"
    And click the Signin button To Check Create Question
    Then Click take picture button in Create Question
    Then Click Create Question button

  @TC_01
  Scenario: Create Question:Search Check
    Given Enter valid question "What is Quantum Cryptography?" details in the searchbox
    When Check entered question "What is Quantum Cryptography?" details is displayed or not
    Then Close Create Question button

  @TC_02
  Scenario: Create Question:Search Check
    Given Enter valid answer "Various Cyber Security methods for encrypting and transmitting secure data." details in the searchbox
    When Check entered answer "Various Cyber Security methods for encrypting and transmitting secure data." details is displayed or not
    Then Close Create Question button

  #@TC_03(subject name checking should not able to check)
  #Scenario: Create Question:Search Check
    #Given Enter valid subject name "Artificial Intelligence" in the searchbox
    #When Check entered subject name "Artificial Intelligence" details is displayed or not
    #Then Close Create Question button

  @TC_04
  Scenario: Create Question:Status Check
    Given Select All option in status dropdown
    Then Close Create Question button

  @TC_05
  Scenario: Create Question:Status Check
    Given Select Active option in status dropdown
    When Click edit button in any question
    And Check question status "Active" is same as user selected
    Then Close Create Question button

  @TC_06
  Scenario: Create Question:Status Check
    Given Select Inactive option in status dropdown
    When Click edit button in any question
    And Check question status "Inactive" is same as user selected
    Then Close Create Question button

  @TC_07
  Scenario: Create Question:Subject Check
    Given Select All Subject option in subject dropdown
    Then Close Create Question button

  @TC_08
  Scenario: Create Question:Subject Check
    Given Select All Subject option in subject dropdown
    And Select Artificial Intelligence option in subject dropdown
    Then Check selected "Artificial Intelligence" option in subject dropdown
    And Select Business and Commerce option in subject dropdown
    Then Check selected "Business and Commerce" option in subject dropdown
    And Select Cryptography option in subject dropdown
    Then Check selected "Cryptography" option in subject dropdown
    And Select Cyber Security option in subject dropdown
    Then Check selected "Cyber Security" option in subject dropdown
    Then Close Create Question button

  @TC_09
  Scenario: Create Question:Level Check
    Given Select All Level option in level dropdown
    Then Close Create Question button

  @TC_10
  Scenario: Create Question:Level Check
    Given Select All Level option in level dropdown
    When Select Easy option in level dropdown
    And Click edit button in any question
    Then Check question level "Easy" is same as user selected
    And Click view questions button
    And Select Medium option in level dropdown
    And Click edit button in any question
    Then Check question level "Medium" is same as user selected
    And Click view questions button
    And Select Hard option in level dropdown
    And Click edit button in any question
    Then Check question level "Hard" is same as user selected
    Then Close Create Question button

  @TC_11
  Scenario: Create Question:Question Created By Check
    Given Click 3dots button
    And Check  question created user name and date & time details displayed or not
    Then Close Create Question button

  @TC_12
  Scenario: Create Question:Pagination Check
    Given Click last button in pagination in question manager
    When Click first button in pagination in question manager
    And Click next button in pagination in question manager
    Then Click previous button in pagination in question manager
    And Click the number button in pagination in question manager
    Then Close Create Question button

  @TC_13
  Scenario: Add Questions:Back Check
    Given Click add questions button
    And Click view questions button
    Then Check landing page in add question page
    Then Close Create Question button

  @TC_14
  Scenario: Add Questions:Mandatory Check
    Given Click add questions button
    And Click save button in add question page
    Then Check mandatory red border is displayed or not in add question page
    Then Close Create Question button

  @TC_15
  Scenario: Add Questions:Clear Check
    Given Click add questions button
    And Click save button in add question page
    Then Check mandatory red border is displayed or not in add question page
    And Click clear button in add questions page
    Then Check mandatory red border is removed or not in add question page
    Then Close Create Question button

  @TC_16
  Scenario: Add Subject:Close button Check
    Given Click add questions button
    And Click add button in subject tab
    And Click close button in add subject popup
    Then Close Create Question button

  @TC_17
  Scenario: Add Subject:Mandatory Check
    Given Click add questions button
    And Click add button in subject tab
    Then Click add button in add subject popup
    And Check mandatory red border is displayed or not in subject name
    Then Close Create Question button

  @TC_18
  Scenario: Add Subject:Valid Check
    Given Click add questions button
    And Click add button in subject tab
    Then Enter special characters in add subject popup
    And Clear the details in add subject popup
    Then Enter numerical characters in add subject popup
    And Clear the details in add subject popup
    Then Close Create Question button

  @TC_19
  Scenario: Add Subject:Existing Check
    Given Click add questions button
    And Click add button in subject tab
    Then Enter existing subject name in add subject popup
    And Click add button in add subject popup
    And Check alert message is displayed or not in add subject
    Then Close Create Question button

  #@TC_20
  # Scenario: Add Subject:Add button Check
  #  Given Click add questions button
  # And Click add button in subject tab
  # Then Enter valid subject name in add subject popup
  # And Click add button in add subject popup
  # And Check success message is displayed or not in add subject
  # Then Close Create Question button
  #@TC_21
  #Scenario: Edit Subject:Close button Check
  #Given Click add questions button
  #And Select any subject from the dropdown
  #Then Click edit button in subject tab
  #And Click Close button in edit subject popup
  #Then Close Create Question button
  #
  #@TC_22
  #Scenario: Edit Subject:Update button Check
  #Given Click add questions button
  #And Select any subject from the dropdown
  #Then Click edit button in subject tab
  #And Modify valid subject name in edit subject popup
  #Then Click update button in edit subject popup
  #And Check success message is displayed or not in edit subject
  #Then Close Create Question button
  #@TC_23
  #Scenario: Delete Subject:Close button Check
  #Given Click add questions button
  #And Select any subject from the dropdown
  #Then Click Delete button in subject tab
  #And Click Close button in Delete Subject popup
  #Then Close Create Question button
  #@TC_24
  #Scenario: Delete Subject: NO button Check
  #Given Click add questions button
  #And Select any subject from the dropdown
  #Then Click Delete button in subject tab
  #And Click NO button in Delete Subject popup
  #Then Close Create Question button
  #@TC_25
  #Scenario: Delete Subject: YES button Check
  #Given Click add questions button
  #And Select any subject from the dropdown
  #Then Click Delete button in subject tab
  #And Click YES button in Delete Subject popup
  #Then Check success message is displayed or not in Delete Subject
  #Then Close Create Question button
  @TC_26
  Scenario: Add Topic:Close button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Click add button in topic tab
    And Click close button in add topic popup
    Then Close Create Question button

  @TC_27
  Scenario: Add Topic:Mandatory Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Click add button in topic tab
    Then Click add button in add topic popup
    And Check mandatory red border is displayed or not in add topic popup
    Then Close Create Question button

  @TC_28
  Scenario: Add Topic:Add button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Click add button in topic tab
    Then Enter valid topic name in add topic popup
    And Click add button in add topic popup
    And Check success message is displayed or not in add topic popup
    Then Close Create Question button

  @TC_29
  Scenario: Edit Topic:Close button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Select any topic from the dropdown in create questions
    Then Click edit button in topic tab
    And Click Close button in edit topic popup
    Then Close Create Question button

  @TC_30
  Scenario: Edit Topic:Update button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Select any topic from the dropdown in create questions
    Then Click edit button in topic tab
    And Modify valid subject name in edit topic popup
    Then Click update button in edit topic popup
    And Check success message is displayed or not in edit topic
    Then Select any subject from the dropdown
    And Select any topic from dropdown in create questions
    Then Click edit button in topic tab
    And Modify valid subject name in edit topic
    Then Click update button in edit topic popup
    And Check success message is displayed or not in edit topic
    Then Close Create Question button

  @TC_31
  Scenario: Delete Topic:Close button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Select any topic from the dropdown in create questions
    Then Click Delete button in topic tab
    And Click Close button in Delete topic popup
    Then Close Create Question button

  @TC_32
  Scenario: Delete Topic: NO button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Select any topic from the dropdown in create questions
    Then Click Delete button in topic tab
    And Click NO button in Delete topic popup
    Then Close Create Question button

  @TC_33
  Scenario: Delete Topic: YES button Check
    Given Click add questions button
    Then Select any subject from the dropdown
    And Select any topic from the dropdown in create questions
    Then Click Delete button in topic tab
    And Click YES button in Delete topic popup
    Then Check success message is displayed or not in topic tab
    Then Close Create Question button

  @TC_34
  Scenario: Add Question Type:Close button Check
    Given Click add questions button
    And Click add button in Question Type tab
    And Click close button in add Question Type popup
    Then Close Create Question button

  @TC_35
  Scenario: Add Question Type:Mandatory Check
    Given Click add questions button
    And Click add button in Question Type tab
    Then Click add button in add Question Type popup
    And Check mandatory red border is displayed or not in add Question Type popup
    Then Close Create Question button

  @TC_36
  Scenario: Add Question Type:Add button Check
    Given Click add questions button
    And Click add button in Question Type tab
    Then Enter valid question type in add Question Type popup
    And Click add button in add Question Type popup
    And Check success message is displayed or not in add Question Type popup
    Then Close Create Question button

  @TC_37
  Scenario: Edit Question Type:Close button Check
    Given Click add questions button
    And Select any Question Type from the dropdown
    Then Click edit button in Question Type tab
    And Click Close button in edit Question Type popup
    Then Close Create Question button

  @TC_38
  Scenario: Edit Question Type:Update button Check
    Given Click add questions button
    And Select any Question Type from the dropdown
    Then Click edit button in Question Type tab
    And Modify valid subject name in edit Question Type popup
    Then Click update button in edit Question Type popup
    And Check success message is displayed or not in edit Question Type
    Then Close Create Question button

  @TC_39
  Scenario: Edit Question Type:Update button Check
    Given Click add questions button
    And Select any Question Type from dropdown
    Then Click edit button in Question Type tab
    And Modify valid subject name in edit Question Type
    Then Click update button in edit Question Type popup
    And Check success message is displayed or not in edit Question Type
    Then Close Create Question button

  @TC_40
  Scenario: Delete Question Type:Close button Check
    Given Click add questions button
    And Select any Question Type from the dropdown
    Then Click Delete button in Question Type tab
    And Click Close button in Delete Question Type popup
    Then Close Create Question button

  @TC_41
  Scenario: Delete Question Type: NO button Check
    Given Click add questions button
    And Select any Question Type from the dropdown
    Then Click Delete button in Question Type tab
    And Click NO button in Delete Question Type popup
    Then Close Create Question button

  @TC_42
  Scenario: Delete Question Type: YES button Check
    Given Click add questions button
    And Select any Question Type from the dropdown
    Then Click Delete button in Question Type tab
    And Click YES button in Delete Question Type popup
    Then Check success message is displayed or not in Question Type
    Then Close Create Question button

  @TC_43
  Scenario: Source Type:Image field Invalid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload invalid file format in image field
    Then Close Create Question button

  @TC_44
  Scenario: Source Type:Audio field Invalid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload invalid file format in audio field
    Then Close Create Question button
 
  @TC_45
  Scenario: Source Type:Video field Invalid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload invalid file format in video field
    Then Close Create Question button

  @TC_46
  Scenario: Source Type:Image field valid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in image field
    #And Check file is uploaded or not in image field
    Then Close Create Question button
@Test
  @TC_47
  Scenario: Source Type:Audio field valid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in audio field
    And Check file is uploaded or not in audio field
    Then Close Create Question button

  @TC_48
  Scenario: Source Type:Video field valid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in video field
    #And Check file is uploaded or not in video field
    Then Close Create Question button

  @TC_49
  Scenario: Source Type:Delete Image Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in image field
    And Click delete button in image field
    Then Check file is removed or not in image field
    Then Close Create Question button

  @TC_50
  Scenario: Source Type:Delete Audio Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in audio field
    And Click delete button in audio field
    Then Check file is removed or not in audio field
    Then Close Create Question button

  @TC_51
  Scenario: Source Type:Delete Video Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select any option in question type
    Then Click and Upload valid file format in video field
    And Click delete button in video field
    Then Check file is removed or not in video field
    Then Close Create Question button

  @TC_52
  Scenario: Add Questions:Textbox Features Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter valid details in question text box
   #And Perform and check all features in the question text box
    Then Close Create Question button

  @TC_53
  Scenario: Add Questions:Textbox Features Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter valid details in answers text box
   # And Perform and check all features in the answers text box
    Then Close Create Question button

  @TC_54
  Scenario: Add Questions:Textbox Features Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter valid details in remarks text box in add questions
  #  And Perform and check all features in the remarks text box
    Then Close Create Question button

  @TC_55
  Scenario: Add Questions:Textbox Features Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter valid details in Explanation text box
    #And Perform and check all features in the Explanation text box
    Then Close Create Question button

  @TC_56
  Scenario: Add Questions:Points Invalid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter alpha characters in points for answer field
    And Check tab is empty of not in points for answer field
    Then Enter special characters in points for answer field
    And Check tab is empty of not in points for answer field
    Then Close Create Question button

  @TC_57
  Scenario: Add Questions:Time Invalid Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter alpha characters in Time field
    And Check tab is empty of not in Time field
    Then Enter special characters in Time field
    And Check tab is empty of not in Time field
    Then Close Create Question button

  @TC_58
  Scenario: Essay Type:Clear Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for essay type
    Then Enter valid answer details for essay type
    And Enter valid remarks details for essay type
    Then Enter valid points for answer for essay type
    And Enter valid time for essay type
    Then Click clear button for essay type
    And Check tab is cleared or not for essay type
    Then Close Create Question button

  @TC_59
  Scenario: Essay Type:Save Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for essay type
    Then Enter valid answer details for essay type
    And Enter valid details in Explanation text box
    Then Enter valid points for answer for essay type
    And Enter valid time for essay type
    Then Click save button for essay type
    And Check success message is displayed or not for essay type
    Then Close Create Question button

  @TC_60
  Scenario: Fill in the blanks Type:Clear Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select fill in the blanks option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for fill in the blanks type
    Then Enter valid answer details for fill in the blanks type
    And Enter valid explanation details for fill in the blanks type
    And Enter valid remarks details for fill in the blanks type
    Then Enter valid points for answer for fill in the blanks type
    And Enter valid time for fill in the blanks type
    Then Click clear button for fill in the blanks type
    And Check tab is cleared or not for fill in the blanks type
    Then Close Create Question button
@Test
  @TC_61
  Scenario: Fill in the blanks Type:Save Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select fill in the blanks option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for fill in the blanks type
    Then Enter valid answer details for fill in the blanks type
    And Enter valid explanation details for fill in the blanks type
    And Enter valid remarks details for fill in the blanks type
    Then Enter valid points for answer for fill in the blanks type
    And Enter valid time for fill in the blanks type
    Then Click save button for fill in the blanks type
    And Check success message is displayed or not for fill in the blanks type
    Then Close Create Question button

  @TC_62
  Scenario: Multiple Choice Type:Clear Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select Multiple Choice option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for Multiple Choice type
    Then Enter valid answer details for Multiple Choice type
    And Select any valid checkbox in answers field for Multiple Choice type
    And Enter valid explanation details for Multiple Choice type
    And Enter valid remarks details for Multiple Choice type
    Then Enter valid points for answer for Multiple Choice type
    And Enter valid time for Multiple Choice type
    Then Click clear button for Multiple Choice type
    And Check tab is cleared or not for Multiple Choice type
    Then Close Create Question button
@Test
  @TC_63
  Scenario: Multiple Choice Type:Save Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select Multiple Choice option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for Multiple Choice type
    Then Enter valid answer details for Multiple Choice type
    And Select any valid checkbox in answers field for Multiple Choice type
    And Enter valid explanation details for Multiple Choice type
    And Enter valid remarks details for Multiple Choice type
    Then Enter valid points for answer for Multiple Choice type
    And Enter valid time for Multiple Choice type
    Then Click save button for Multiple Choice type
    And Check success message is displayed or not for Multiple Choice type
    Then Close Create Question button
@Test
  @TC_64
  Scenario: Short Answer Type:Clear Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select Short Answer option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for Short Answer type
    Then Enter valid answer details for Short Answer type
    And Enter valid explanation details for Short Answer type
    And Enter valid remarks details for Short Answer type
    Then Enter valid points for answer for Short Answer type
    And Enter valid time for Short Answer type
    Then Click clear button for Short Answer type
    And Check tab is cleared or not for Short Answer type
    Then Close Create Question button

  @TC_65
  Scenario: Short Answer Type:Save Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select Short Answer option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for Short Answer type
    Then Enter valid answer details for Short Answer type
    And Enter valid explanation details for Short Answer type
    And Enter valid remarks details for Short Answer type
    Then Enter valid points for answer for Short Answer type
    And Enter valid time for Short Answer type
    Then Click save button for Short Answer type
    And Check success message is displayed or not for Short Answer type
    Then Close Create Question button

  @TC_66
  Scenario: Single Choice Type:Clear Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select Single Choice option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for Single Choice type
    Then Enter valid answer details for Single Choice type
    And Select any valid radio in answers field for Single Choice type
    And Enter valid explanation details for Single Choice type
    And Enter valid remarks details for Single Choice type
    Then Enter valid points for answer for Single Choice type
    And Enter valid time for Single Choice type
    Then Click clear button for Single Choice type
    And Check tab is cleared or not for Single Choice type
    Then Close Create Question button

  @TC_67
  Scenario: Single Choice Type:Save Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select Single Choice option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for Single Choice type
    Then Enter valid answer details for Single Choice type
    And Select any valid radio in answers field for Single Choice type
    And Enter valid explanation details for Single Choice type
    And Enter valid remarks details for Single Choice type
    Then Enter valid points for answer for Single Choice type
    And Enter valid time for Single Choice type
    Then Click save button for Single Choice type
    And Check success message is displayed or not for Single Choice type
    Then Close Create Question button

  @TC_68
  Scenario: True or False Type:Clear Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select True or False option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for True or False type
    Then Enter valid answer details for True or False type
    And Select any valid radio in answers field for True or False type
    And Enter valid explanation details for True or False type
    And Enter valid remarks details for True or False type
    Then Enter valid points for answer for True or False type
    And Enter valid time for True or False type
    Then Click clear button for True or False type
    And Check tab is cleared or not for True or False type
    Then Close Create Question button

  @TC_69
  Scenario: True or False Type:Save Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select True or False option in question type
    Then Select valid option in question level
    And Select valid option in question status
    Then Upload valid image file
    And Upload valid audio file
    Then Upload valid video file
    And Enter valid question details for True or False type
    Then Enter valid answer details for True or False type
    And Select any valid radio in answers field for True or False type
    And Enter valid explanation details for True or False type
    And Enter valid remarks details for True or False type
    Then Enter valid points for answer for True or False type
    And Enter valid time for True or False type
    Then Click save button for True or False type
    And Check success message is displayed or not for True or False type
    Then Close Create Question button

  @TC_70
  Scenario: Add Subject:Question Type Change Check
    Given Click add questions button
    And Select any option in subject
    Then Select any option in topic
    And Select ESSAY option in question type
    Then Enter valid details in question tab
    And Enter valid details in answers tab
    Then Enter valid details in remarks tab
    And Change the question type in any other type
    Then Check entered details are cleared or not
    Then Close Create Question button

  @TC_71
  Scenario: Edit Question:Back Check
    Given Search valid question name in search field
    And Select All option in status dropdown
    Then Select All Subject option in status dropdown
    And Click edit button in create question page
    Then Click view questions button in edit question page
    And Check landing page in add question page
    Then Close Create Question button

  @TC_72
  Scenario: Edit Question:Clear Check
    Given Search valid question name in search field
    And Select All option in status dropdown
    Then Select All Subject option in status dropdown
    And Click edit button in create question page
    Then Click clear button in edit question page
    And Check details are cleared or not in edit question page
    Then Close Create Question button
@Test
  @TC_73
  Scenario: Edit Question:Source Type:Delete Check
    Given Search valid question name in search field
    And Select All option in status dropdown
    Then Select All Subject option in status dropdown
    And Click edit button in create question page
    Then Click delete button in image field
    Then Check file is removed or not in image field
    Then Click delete button in audio field
    Then Check file is removed or not in audio field
    And Click delete button in video field
    Then Check file is removed or not in video field
    Then Close Create Question button

  @TC_74
  Scenario: Edit Question:Source Type:New Upload Check
    Given Search valid question name in search field
    And Select All option in status dropdown
    Then Select All Subject option in status dropdown
    And Click edit button in create question page
    Then Click delete button in image field
    And Check file is removed or not in image field
    Then Click and Upload valid file format in image field
    And Click delete button in audio field
    Then Check file is removed or not in audio field
    And Click and Upload valid file format in audio field
    And Click delete button in video field
    Then Check file is removed or not in video field
    And Click and Upload valid file format in video field
    Then Close Create Question button

  @TC_75
  Scenario: Edit Question:Source Type:Update Check
    Given Search valid question name in search field
    And Select All option in status dropdown
    Then Select All Subject option in status dropdown
    And Click edit button in create question page
    Then Modify valid details in any tab
    And Click update button in edit question page
    Then Check success message is displayed or not in edit question page
    Then Close Create Question button