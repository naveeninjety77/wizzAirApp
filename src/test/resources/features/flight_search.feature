
Feature: Flight Search with Infinite Scroll

  Background:
    Given the app is launched

  @search @android @ios
  Scenario: Search for a flight and verify it appears in results
    Given The user is on the flight search screen
    When The user searches for flights from "LON" to "BUD" on "2026-05-10"
    And The user scrolls through search results
    Then Validate the flight "W6-5678" should appear in the results list

