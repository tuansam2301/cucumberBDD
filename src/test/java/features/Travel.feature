Feature: Travel Insurance
  In order to have a good insurance for travel
  As a traveler
  I want to looking for good travel insurance plans

  Background: Access to UAT page
    Given I am on UAT page

  @Smoke
  Scenario: Looking for travel plans
    When I am looking for travel insurance
    Then I should see at least 3 cards are being displayed
    When I sort by "Promotion"
    And I set details as below
      | Field       | Value |
      | DESTINATION | Japan |
      | START_DATE  | today |
      | END_DATE    | today |
    And I set filter as below
      | Field    | Value         |
      | INSURERS | Pacific Cross |
    And I set trip termination range min equals max
    Then I should see 2 cards are being displayed
    And there should be "2 plans found" text in header