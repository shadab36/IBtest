
# Automated Testing of the IntelligenceBank platform


## Getting Started

1) Set Credentials for your configuration as environment variables (See "Credentials" below)
2) Create your own TestNG config
3) From the command line run the following:

mvn test -DsuiteXmlFile=configs/config-default.xml -Dcucumber.options='--tags "@UserManagement"'

mvn test -DsuiteXmlFile=configs/config-default.xml -Dcucumber.options='--tags "(@smoke) and not @ignore and not @manual"'

mvn test -DsuiteXmlFile=configs/config-default.xml -Dcucumber.options='--tags "(@smoke or @sanity or @overnight) and not @ignore and not @manual"'


### Selfish shortcut for myself :-)

mvn test -DsuiteXmlFile=configs/config-stephans-mac.xml -Dcucumber.options='--tags "(@UserManagement)"'

mvn test -DsuiteXmlFile=configs/config-stephans-mac.xml -Dcucumber.options='--tags "(@smoke) and not @ignore and not @manual"'

mvn test -DsuiteXmlFile=configs/config-stephans-mac.xml -Dcucumber.options='--tags "(@smoke or @sanity or @overnight) and not @ignore and not @manual"'

mvn test -DsuiteXmlFile=configs/config-stephans-mac.xml -Dcucumber.options='--tags "(@api)"'


## Automated Test Suites

@smoke
  Duration: +/- 5 minutes
  Environment: Run on developer machines before checking in any changes and after deployments to each environment (incl production).
  Purpose: Validate that the changes are not stopping other dev work
  Scope: Touching all major integration points
  
@sanity
  Duration: < 30 minutes
  Environment: Run on the gitlab agent upon committing to the gitlab GIT repo.
  Purpose: Validate that the changes are not breaking customers major use cases
  Scope: smoke + All postive scenarios, regularely encountered negative scenarios

@overnight
  Duration: < 4 Hours
  Environment: Run on the gitlab agent, scheduled to run overnight
  Purpose: Validate that the changes are not breaking customers most common use cases
  Scope: sanity + all known edge cases except for long running tests and very unlikely scenarios

@regression 
  Duration: No limit, expected to run between 4 and 24 hours.
  Environment: Run on the gitlab agent, scheduled to run over the weekend
  Purpose: Validate that the changes are not breaking customers most common use cases
  Scope: quick-regression + all known edge cases

@manual
  Duration: N/A
  Environment: Dev/Test machine
  Purpose: test that can only be run manually
  Scope: Failover tests, Misconfigured Databases, etc

@ignore
  Duration: N/A
  Environment: N/A
  Purpose: USE ONLY IF NEEDED !    Temporarely disable a test. There is significant risk in forgetting to re-enable to test, so only use in very rare scenarios.
  Scope: 


## Credentials

Credentials used while testing will be stored as environment variable setting in Gitlab.
They will have to be configured on the machine where the Cucumber tests are running and the values on the target environment. 

For example, for running the tests against the pre-production environment, the following env vars are needed:
ib-autotest-preprod-creds-admin-username
ib-autotest-preprod-creds-admin-password

For staging however:
ib-autotest-staging-creds-admin-username
ib-autotest-staging-creds-admin-password

The full list of required credential environment variables:
ib-autotest-{{ENV}}-creds-default-username
ib-autotest-{{ENV}}-creds-default-password
ib-autotest-{{ENV}}-creds-admin-username
ib-autotest-{{ENV}}-creds-admin-password
ib-autotest-{{ENV}}-creds-nonexisting-username
ib-autotest-{{ENV}}-creds-invalid-username
ib-autotest-{{ENV}}-creds-invalid-password

Where {{ENV}} is one of the following environments:
prestaging
prestaging2
prestaging3
staging
preprod
production-au
production-us
production-eu

Note: Customer specific environments are not supported (for now). Examples are DPC, Deloite, etc

### Scripts to permanently add credentials

#### MAC

echo 'export ib_autotest_{{ENV}}_creds_default_username=XXXXXXXXXXXXXXX' >> ~/.bash_profile
echo 'export ib_autotest_{{ENV}}_creds_default_password=XXXXXXXXXXXXXXX' >> ~/.bash_profile

#### Windows

How to Set Environment Variables in Windows - YouTube
https://www.youtube.com/watch?v=bEroNNzqlF4

Example:
setx ib-autotest-staging-creds-default-username "some.username@intelligencebank.com"
setx ib-autotest-staging-creds-default-password "Pa$$word1983***"
setx ib-autotest-staging-creds-admin-username "some.username@intelligencebank.com"
setx ib-autotest-staging-creds-admin-password "Pa$$word1983***"

#### Linux


