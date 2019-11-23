@permissions
Feature:  User as Group - Custom Permissions
  As a user who is set up as a member of a group
  I want my custom access permissions to be as configured
  So I can have the correct access to Resources

  Background:
    Given 'User3' is in the group 'User as Group' only

  Scenario: Custom Folder Permissions
    Given 'User3' has 'No' General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following folder actions:
      | Folder | Add File | Delete | Create Sub Folder | Change Settings |
      | C1     | Yes      | Yes    | Yes               | Yes             |
      | C2     | Yes      | No     | No                | No              |
      | C3     | No       | No     | No                | No              |
      | C4     | No       | No     | No                | No              |
      | C5     | Hidden   | Hidden | Hidden            | Hidden          |


  Scenario: Custom File Permissions
    Given 'User3' has 'No' General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following file actions:
      | Filenames | Preview | Download | Delete | Read Info |
      | C1.1      | Yes     | Yes      | Yes    | Yes       |
      | C2.1      | Yes     | Yes      | Yes    | Yes       |
      | C3.1      | Yes     | Yes      | No     | Yes       |
      | C4.1      | Yes     | No       | No     | Yes       |
      | C5.1      | Hidden  | Hidden   | Hidden | Hidden    |