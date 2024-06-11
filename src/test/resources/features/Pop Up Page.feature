Feature: Pop up sub menu feature 

    Background: User goes to select the pop-ups 
     Given Pop up sub menu is clicked
     And Pop up options are displayed
     
      @popup	@sanity1
     Scenario:To validate that user can see quickaction menu item          
     When  user selects quickaction menu option
     Then Billa menu item is displayed

         @popup	@sanity
     Scenario:To validate that user can see PopUp menu item       
     When  user selects PopUp menu option
     Then Music player items are displayed
      