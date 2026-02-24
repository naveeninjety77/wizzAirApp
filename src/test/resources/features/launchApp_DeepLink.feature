Feature: User login

  Background:
    Given the app is launched

  @android @ios @deeplink
  Scenario: Launch app using deep link and handle permissions
    Given App is launched via deep link for flight "W6-1234"
#    When all system permissions are handled
#    Then the flight details screen for flight "W6-1234" should be displayed
