# RomanNumeralsKata
RomanNumerals Kata (details on http://agilekatas.co.uk/katas/romannumerals-kata)

Build/Test instructions:

* Kindly import to your eclipse IDE (minimum version: Kepler). Make sure eclipse IDE has gradle support libraries. If not installed then kindly review URLs & follow steps: 
http://www.vogella.com/tutorials/EclipseGradle/article.html
https://projects.eclipse.org/projects/tools.buildship/downloads - reference for which gradle buildship to use based on eclipse version
* The JRE is 1.7. Please test using this version.
* The only dependency is using JUnit, as shown in build.gradle (for reference, you don't have to do anything if your eclipse IDE is at a minimum Kepler version) :
dependencies {
    // Use JUnit test framework
    testCompile 'junit:junit:4.12'
}

* Once project is imported, run by going to Package Exploere, then to folder RomanNumeralsKata/src/test/java. Expand package feature1. 
* Then right click on ArabicToRomanConvertorTest.java file and choose menu "Run As" -> "JUnit Test"
* follow the steps to create run configurations. You dont need to make any manual steps. Just complete the one-time dialog process 

* Junit tests should run & all tests will pass.

