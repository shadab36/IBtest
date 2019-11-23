Feature: Create Agenda
  As an admin user
  I want to be able to create agendas
  so the I can create an online agenda for Board Meetings.

Background: 
  Given I am logged in as an Admin
     And I open the "Agenda" page
     And the "AUTO-TESTING Agenda Folder Name" resource folder exist

@overnight @agenda @ignore
Scenario Outline: Add an Agenda
   When I click on the "Add Agenda" button
      And I set "<Name>" into "Agenda Name" field
      And I select "<Type>" from the "Agenda Type" dropdown list
      And I select the "AUTO-TESTING Agenda Folder Name" resource folder
   When I click on the "Add Folder" button
   Then I expect the "AUTO-TESTING Agenda Folder Name" folder to be an item on the agenda
   When I click on the "Save" button
   Then I expected the "Success" message on the Agenda page
      And I expect the agenda "<Name>" to exist

   Examples:
   | Type     | Name          | FolderName |
   | Custom   | CustomAgenda  | TestFolder |
   | Sync     | SyncAgenda    | TestFolder |

@overnight @agenda @ignore   
Scenario Outline: Copy an Agenda
   Given the agenda with unique name "<Name>" of type "<Type>" exists
   When I select "Copy Agenda" from the agenda toolbar dropdown list
   Then I expect to be on the "Copy Agenda" page
      And I expect the "Agenda Type" to be "<Type>"
      And I expect the "AUTO-TESTING Agenda Folder Name" to be on the copied agenda
   When I set "<Name Copy>" into "Agenda Name" field
      And I click on the "Save" button
   Then I expect the agenda "<Name Copy>" to exist

   Examples:
   | Type     | Name Copy             |
   | Custom   | CopyCustomAgenda      |
   | Sync     | CopySyncAgenda        |

