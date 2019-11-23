package com.intelligencebank.utils;

import com.intelligencebank.pageObjects.admin.AdminEditUserPage;
import com.intelligencebank.pageObjects.admin.groups.EditGroupsPage;
import com.intelligencebank.pageObjects.admin.groups.GroupsPage;
import com.intelligencebank.pageObjects.admin.groups.UsersAsGroupPage;
import com.intelligencebank.pageObjects.resources.*;
import org.openqa.selenium.WebDriver;

import com.intelligencebank.pageObjects.admin.AddNewWorkflowPage;
import com.intelligencebank.pageObjects.AgendaPage;
import com.intelligencebank.pageObjects.HomePage;
import com.intelligencebank.pageObjects.LoginPage;
import com.intelligencebank.pageObjects.RegistrationPage;
import com.intelligencebank.pageObjects.admin.AdminUsersPage;
import com.intelligencebank.pageObjects.admin.AdminWorkflowsPage;

public class PageObjectManager {

       public static WebDriver driver;

	private AdminWorkflowsPage adminWorkflowsPage;
    private AddNewWorkflowPage addNewWorkflowPage;
	private HomePage homePage;
	private AgendaPage agendaPage;
	private LoginPage loginPage;
	private RegistrationPage registrationPage;
	private ResourcesBasePage resourcesBasePage;
	private AddNewResourcePage addNewResourcePage;
	private AddFolderPage addFolderPage;
	private ResourceFoldersPage resourceFoldersPage;
	private ResourceFilePage resourceFilePage;
	private CloneStructurePage cloneStructurePage;
	private DeleteFolderDialog deleteFolderDialog;

	private GroupsPage groupsPage;
	private EditGroupsPage editGroupsPage;
	private UsersAsGroupPage usersAsGroupPage;
	private AdminUsersPage adminUsersPage;
	private AdminEditUserPage adminEditUserPage;
  private TransformationAdvancedOptionsPage transformationAdvancedOptionsPage;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public AgendaPage agendaPage(){
		return (agendaPage == null) ? agendaPage = new AgendaPage(driver) : agendaPage;
	}	

	public AdminWorkflowsPage adminWorkflowsPage() {
		return (adminWorkflowsPage == null) ? adminWorkflowsPage = new AdminWorkflowsPage(driver) : adminWorkflowsPage;
	}

	public AddNewWorkflowPage addNewWorkflowPage() {
		return (addNewWorkflowPage == null) ? addNewWorkflowPage = new AddNewWorkflowPage(driver) : addNewWorkflowPage;
	}

	public HomePage homePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public LoginPage loginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public RegistrationPage registrationPage() {
		return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
	}

	public ResourcesBasePage resourcesPage() {
		return (resourcesBasePage == null) ? resourcesBasePage = new ResourcesBasePage(driver) : resourcesBasePage;
	}

	public AddFolderPage addFolderPage() {
		return (addFolderPage == null) ? addFolderPage = new AddFolderPage(driver) : addFolderPage;
	}

	public AddNewResourcePage addNewResourcePage() {
		return (addNewResourcePage == null) ? addNewResourcePage = new AddNewResourcePage(driver) : addNewResourcePage;
	}

	public ResourceFoldersPage resourceFoldersPage() {
		return (resourceFoldersPage == null) ? resourceFoldersPage = new ResourceFoldersPage(driver) : resourceFoldersPage;
	}

	public ResourceFilePage resourceFilePage() {
		return (resourceFilePage == null) ? resourceFilePage = new ResourceFilePage(driver) : resourceFilePage;
	}

	public CloneStructurePage cloneStructurePage() {
		return (cloneStructurePage == null) ? cloneStructurePage = new CloneStructurePage(driver) : cloneStructurePage;
	}

	public DeleteFolderDialog deleteFolderDialog() {
		return (deleteFolderDialog == null) ? deleteFolderDialog = new DeleteFolderDialog(driver) : deleteFolderDialog;
	}

	public GroupsPage groupsPage() {
		return (groupsPage == null) ? groupsPage = new GroupsPage(driver) : groupsPage;
	}

	public EditGroupsPage editGroupsPage() {
		return (editGroupsPage == null) ? editGroupsPage = new EditGroupsPage(driver) : editGroupsPage;
	}

	public UsersAsGroupPage usersAsGroupPage() {
		return (usersAsGroupPage == null) ? usersAsGroupPage = new UsersAsGroupPage(driver) : usersAsGroupPage;
	}

	public AdminUsersPage adminUsersPage() {
		return (adminUsersPage == null) ? adminUsersPage = new AdminUsersPage(driver) : adminUsersPage;
	}

	public AdminEditUserPage adminEditUserPage() {
		return (adminEditUserPage == null) ? adminEditUserPage = new AdminEditUserPage(driver) : adminEditUserPage;
	}
	
	
	public  TransformationAdvancedOptionsPage  transformationAdvancedOptionsPage() {
		return (transformationAdvancedOptionsPage == null) ? transformationAdvancedOptionsPage = new TransformationAdvancedOptionsPage(driver) : transformationAdvancedOptionsPage;
	}
}