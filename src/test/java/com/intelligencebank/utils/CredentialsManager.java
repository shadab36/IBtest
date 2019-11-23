package com.intelligencebank.utils;

public class CredentialsManager {

    private String environmentName;

    public CredentialsManager(TestNGParameters parameters) {
        environmentName = parameters.EnvironmentName;
    }

    private String readEnvVariable(String pattern) {
        String envSetting = pattern.replace("{{ENV}}", environmentName);
        String result = System.getenv(envSetting);

        return result;
    }

    public String getDefaultUsername() {
        String pattern = "ib_autotest_{{ENV}}_creds_default_username";
        return readEnvVariable(pattern);
    }

    public String getAdminUsername() {
        String pattern = "ib_autotest_{{ENV}}_creds_admin_username";
        return readEnvVariable(pattern);
    }

    public String getDefaultPassword() {
        String pattern = "ib_autotest_{{ENV}}_creds_default_password";
        return readEnvVariable(pattern);
    }

    public String getAdminPassword() {
        String pattern = "ib_autotest_{{ENV}}_creds_admin_password";
        return readEnvVariable(pattern);
    }

    public String getGroupPermissionsPassword(String uname) {
        String pattern = String.format("ib_autotest_{{ENV}}_creds_%s_password", uname.toLowerCase());
        return readEnvVariable(pattern);
    }

}

