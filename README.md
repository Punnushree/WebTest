--Project:
This is a Selenium automation framework Project . This is built for a local application called PetClinic for Saal 

--Type of framework:
The framework is a Maven project build on Pageobject model framework using testNg. Extent report is used along with listeners.

--Framework Structure:
a)	Base package – for initial setup and launching browser
b)	ExtentReporting package- for reporting with listeners and screenshot capture facility on failed testcases
c)	PageRepo package- having objects og different pages. Separate class is created for each page
d)	Utilities package -having common methods for different web objects and testdata storage
e)	Testcase package -having different testcodes.
f)	POM file with Maven dependencies
g)	testNg xml file for execution

--Execution:
Run from command line or through testNg


