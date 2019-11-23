@permissions
Feature: General Permissions Testing - Group Permissions
  As a user who is set up as a member of a group
  I want my access permissions to be as configured
  So I can have the correct access to Resources

  Background:
    Given 'User1' is in the group 'UserGroup1' only

  Scenario: Preview only folder permissions
    Given 'UserGroup1' has 'Preview' group General Permissions
    When 'User1' has navigated to 'Resources'
    Then 'User1' cannot perform the following folder actions:
      | Folder | Add File | Delete | Create Sub Folder | Change Settings |
      | G1     | No       | No     | No                | No              |
      | G2     | No       | No     | No                | No              |

  Scenario: Preview only file permissions
    Given 'UserGroup1' has 'Preview' group General Permissions
    When 'User1' has navigated to 'Resources'
    Then 'User1' can perform the following file actions:
      | Filenames | Preview | Download | Delete | Read Info |
      | G1.1      | Yes     | No       | No     | Yes       |
      | G2.1      | Yes     | No       | No     | Yes       |
