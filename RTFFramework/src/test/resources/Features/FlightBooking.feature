
Feature: To test the flight booking

  @FlightBooking
  Scenario: Validate the flight booking
    Given Launch the Application <url>
    And Enter the <City> in from field using "id=ctl00_mainContent_ddl_originStation1_CTXT"
    
    Examples:
    |    url                   | City    |
    |"https://www.spicejet.com/"|"Chennai"|

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      
      
    
