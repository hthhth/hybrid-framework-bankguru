set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%\libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%out\production\hybrid-framework-bankguru;%ProjectPath%libAllure\*;%ProjectPath%libExtentV4\*;%ProjectPath%libraries\*;%ProjectPath%libReportNG\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%out\production\hybrid-framework-bankguru\runNopCommerceUserTestcases.xml"
pause
allure serve ./allure-json/