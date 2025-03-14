Feature: Finding Harry Potter

  Background: A webpage
    Given I'm on the bookStore webpage

  Scenario: Search
    When I type 'Harry Potter' on the search bar
    And I click the search button
    Then I'm redirected to a page which url includes "query='harry potter'"
    And the page contains card titled 'Harry Potter' with author 'J.K. Rowling'
