@Egor
Feature: Test login page

  Scenario: Verify that message can move to Spam section
    Given user login in mailBox
    When user clicks on mail checkbox
    And user clicks on spam button
  #  And user confirm add massage to spam
    Then user can see message that mail was added in spam section


  Scenario: Verify that message can move from Spam section
    Given user login in mailBox
    # When user clicks on span section button
    # And user clicks on mail checkbox in spam section
    #And user clicks on nospam button
    When user extracts mail from spam section
    Then user can see message that mail was extracted from spam section


  Scenario: Verify that user can marks three checkboxes
    Given user login in mailBox
    When user clicks on inbox mail button
    And user clicks on three checkboxes
    Then user can see all three checkboxes are marked


  Scenario: Verify that user can unmarks three checkboxes
    Given user login in mailBox
    When user clicks on unselect all button
    Then user can see all checkboxes are unmarked
  @Egor
  Scenario: Verify that user can sends mail for some people
    Given user login in mailBox
    When user clicks on button Write mail
    And user fills form To Whom:
    And user writes the text of mail
    And user clicks on button Send
    Then user can see the message that mail was sended
