package com.intelligencebank.stepDefinitions.permissions;

import com.intelligencebank.stepDefinitions.CommonSteps;
import cucumber.api.java.en.Given;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Given("^'(.*)' is in the group '(.*)' only$")
    public void is_only(String uname, String groupname) throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("Home");
        Pages().loginPage().loginAdmin(cucumberTestContext);
        Pages().adminUsersPage().navigateToUser(uname);
        
        if (groupname.toLowerCase().equals("user as group")) {
            Pages().adminEditUserPage().setUserAsGroupCheckboxChecked();
            Pages().adminEditUserPage().clickSave();
        } else {
            Pages().adminEditUserPage().unsetUserAsGroupCheckbox();
            Pages().adminEditUserPage().setGroup(groupname);
            Pages().adminEditUserPage().clickSave();
        }
    }

    @Given("^'(.*)' has '(.*)' (?:|only )General Permissions$")
    public void has_only_General_Permissions(String uname, String permissionLevel) throws InterruptedException {
        Pages().groupsPage().clickGroupsTab();
        Pages().usersAsGroupPage().waitAndClickUsersAsGroupTab();
        Pages().usersAsGroupPage().useSearch(uname);
        Pages().usersAsGroupPage().selectEditUserSingleRecord();
        Pages().usersAsGroupPage().selectPermissionsTab();
        Pages().usersAsGroupPage().setAccessSwitchOn();
        Pages().usersAsGroupPage().deleteAllResourcesPermissions();
        switch (permissionLevel) {
            case "No":
                break;
            default:
                Pages().usersAsGroupPage().clickAddDefaultPermissionsRuleButton();
                Pages().usersAsGroupPage().selectDefaultPermissionAndSave(permissionLevel);
                break;
        }
        Pages().usersAsGroupPage().switchOutOfIframe();
    }

    @Given("^'(.*)' has '(.*)' group General Permissions$")
    public void has_group_General_Permissions(String userGroup, String permissionLevel) throws InterruptedException {
        Pages().groupsPage().clickGroupsTab();
        Pages().groupsPage().editGroup(userGroup);
        Pages().editGroupsPage().selectPermissionsTab();
        Pages().editGroupsPage().switchToGroupsIframe();
        Pages().editGroupsPage().setAccessSwitchOn();
        Pages().editGroupsPage().deleteAllResourcesPermissions();
        switch (permissionLevel) {
            case "No":
                break;
            default:
                Pages().editGroupsPage().clickAddDefaultPermissionsRuleButton();
                Pages().editGroupsPage().selectDefaultPermissionAndSave(permissionLevel);
                break;
        }
        Pages().editGroupsPage().switchOutOfIframe();
    }
    
}
