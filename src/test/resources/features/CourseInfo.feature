Feature: Verify Course Info API for a particular course
  Scenario: Calling API /api/course-info with valid id
    Given User have access to API on url "https://pragra.io/api/course-info/{id}"
    When user calls api with id "5f0b1d8216b5b97e87391483"
    Then API should return status code 200
    And course code should match with "DATA-SCIENCE"
