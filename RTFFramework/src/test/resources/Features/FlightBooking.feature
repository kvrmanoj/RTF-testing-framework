
Feature: To test the flight booking

  @FlightBooking
  Scenario: Validate the flight booking
    Given Launch the Application <url>
    And Enter the <City> in from field using "id=ctl00_mainContent_ddl_originStation1_CTXT"
    
    Examples:
    |    url                   | City    |
    |"https://www.spicejet.com/"|"Chennai"|

