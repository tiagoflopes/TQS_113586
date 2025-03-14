Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.

  Scenario: Search by author
    Given I have a list of books
      | Title | Author | Date |
      | The Pragmatic Programmer | Andrew Hunt, David Thomas | 2019-09-13-15:50+00 |
      | Code Complete | Steve McConnell | 2004-06-09-15:50+00 |
      | The Mythical Man-Month | Frederick P. Brooks Jr. | 1995-08-12-15:50+00 |
      | Structure and Interpretation of Computer Programs | Harold Abelson, Gerald Jay Sussman | 1996-07-25-15:50+00 |
    When I search for books by author "Steve McConnell"
    Then I should find 1 book

  Scenario: Search by title
    Given I have a list of books
      | Title | Author | Date |
      | The Pragmatic Programmer | Andrew Hunt, David Thomas | 2019-09-13-15:50+00 |
      | Code Complete | Steve McConnell | 2004-06-09-15:50+00 |
      | The Mythical Man-Month | Frederick P. Brooks Jr. | 1995-08-12-15:50+00 |
      | Structure and Interpretation of Computer Programs | Harold Abelson, Gerald Jay Sussman | 1996-07-25-15:50+00 |
    When I search for books by title "Program"
    Then I should find 2 books

  Scenario: Search by date
    Given I have a list of books
      | Title | Author | Date |
      | The Pragmatic Programmer | Andrew Hunt, David Thomas | 2019-09-13-15:50+00 |
      | Code Complete | Steve McConnell | 2004-06-09-15:50+00 |
      | The Mythical Man-Month | Frederick P. Brooks Jr. | 1995-08-12-15:50+00 |
      | Structure and Interpretation of Computer Programs | Harold Abelson, Gerald Jay Sussman | 1996-07-25-15:50+00 |
    When I search for books by the date "1995-01-1-00:00+00" to "2005-12-31-23:59+99"
    Then I should find 3 books