package listeners;

import deflogger.TestsLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.TestRailsConnector;

public class CustomListener implements ITestListener{
    private String testRailsPage = "";
    private String testRailsPassword = "";
    private String testRailsUser = "";
    private String testRunId = "";

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test started\n");
        TestsLogger.logTestCaseStart("TC " + iTestResult.getMethod().getDescription());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        TestsLogger.info("--------------------Test passed--------------------------");
        int resultId = 1;
        String comment = "TEST " + iTestResult.getMethod().getDescription()+ " PASSED BY VLASENKO";
        long durationSeconds = (iTestResult.getEndMillis() - iTestResult.getStartMillis())/1000;
        String caseId = iTestResult.getMethod().getDescription();
        sendTestResult(caseId, resultId, comment, durationSeconds);

        TestsLogger.info("TC " + iTestResult.getMethod().getDescription());
        TestsLogger.logTestCaseEnd("TC " + iTestResult.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult iTestResult) {
        TestsLogger.error("Test failed");
        int resultId = 5;
        String comment = "TEST " + iTestResult.getMethod().getDescription()+ " FAILED BY VLASENKO";
        long durationSeconds = (iTestResult.getEndMillis() - iTestResult.getStartMillis())/1000;
        String caseId = iTestResult.getMethod().getDescription();

        //Adding stack trace to test result
        Throwable throwable = iTestResult.getThrowable();
        String testErrors = "";
        if (throwable!=null){
            testErrors = throwable.getMessage();
        }

        sendTestResult(caseId, resultId, comment + "\n" + testErrors, durationSeconds);

        TestsLogger.info("TC " + iTestResult.getMethod().getDescription());
        TestsLogger.logTestCaseEnd("TC " + iTestResult.getMethod().getDescription());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        TestsLogger.info("Test skipped!");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    public void sendTestResult(String caseId, int resultId, String comment, Long durationSeconds){
        TestRailsConnector testRailsConnector = new TestRailsConnector(testRailsPage, testRailsUser, testRailsPassword);
        testRailsConnector.sendTestResult(caseId, resultId, comment, durationSeconds, testRunId);
    }
}