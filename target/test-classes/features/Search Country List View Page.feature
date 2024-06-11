Feature: List View sub menu feature 
 
      @listView	@sanity
     Scenario Outline:To validate that user can search a country from the list
     When List view sub menu page is displayed
     Then User can search the county "<country>" in the list

     Examples:
          |country |
          | India  |
          | Canada12 |
         