@permissions
Feature: General Permissions Testing - User as a Group
  As a user set up as User as Group
  I want my access permissions to be as configured
  So I can have the correct access to Resources

  Background:
    Given 'User3' is in the group 'User as Group' only

  Scenario: Preview only folder permissions
    Given 'User3' has 'Preview' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' cannot perform the following folder actions:
      | Folder | Add File | Delete | Create Sub Folder | Change Settings |
      | G1     | No       | No     | No                | No              |
      | G2     | No       | No     | No                | No              |

  Scenario: Preview only file permissions
    Given 'User3' has 'Preview' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following file actions:
      | Filenames | Preview | Download | Delete | Read Info |
      | G1.1      | Yes     | No       | No     | Yes       |
      | G2.1      | Yes     | No       | No     | Yes       |

  Scenario: Access only folder permissions
    Given 'User3' has 'Access' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' cannot perform the following folder actions:
      | Folder | Add File | Delete | Create Sub Folder | Change Settings |
      | G1     | No       | No     | No                | No              |
      | G2     | No       | No     | No                | No              |

  Scenario: Access only file permissions
    Given 'User3' has 'Access' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following file actions:
      | Filenames | Preview | Download | Delete | Read Info |
      | G1.1      | Yes     | Yes      | No     | Yes       |
      | G2.1      | Yes     | Yes      | No     | Yes       |

  Scenario: Publish folder permissions
    Given 'User3' has 'Publish' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following folder actions:
      | Folder | Add File | Delete | Create Sub Folder | Change Settings |
      | G1     | Yes      | No     | No                | No              |
      | G2     | Yes      | No     | No                | No              |

  Scenario: Publish file permissions
    Given 'User3' has 'Publish' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following file actions:
      | Filenames | Preview | Download | Delete | Read Info |
      | G1.1      | Yes     | Yes      | Yes    | Yes       |
      | G2.1      | Yes     | Yes      | Yes    | Yes       |

  Scenario: Admin folder permissions
    Given 'User3' has 'Admin' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following folder actions:
      | Folder | Add File | Delete | Create Sub Folder | Change Settings |
      | G1     | Yes      | Yes    | Yes               | Yes             |
      | G2     | Yes      | Yes    | Yes               | Yes             |

  Scenario: Admin file permissions
    Given 'User3' has 'Admin' only General Permissions
    When 'User3' has navigated to 'Resources'
    Then 'User3' can perform the following file actions:
      | Filenames | Preview | Download | Delete | Read Info |
      | G1.1      | Yes     | Yes      | Yes    | Yes       |
      | G2.1      | Yes     | Yes      | Yes    | Yes       |