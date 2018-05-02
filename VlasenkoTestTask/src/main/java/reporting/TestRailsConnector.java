package reporting;

import com.google.gson.JsonObject;
import testrail.APIClient;
import testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailsConnector {
    private JsonObject r;
    private APIClient client;
    private Map testResultData = new HashMap();


    public TestRailsConnector(String testRailsPage, String testRailsUser, String testRailsPassword) {
        setClient(testRailsPage);
        setTestRailsUser(testRailsUser);
        setTestRailsPassword(testRailsPassword);
    }

    private void setClient (String testRailsPage){
        client = new APIClient(testRailsPage);
    }

    private void setTestRailsUser (String testRailsUser){
        client.setUser(testRailsUser);
    }

    private void setTestRailsPassword (String testRailsPassword){
        client.setPassword(testRailsPassword);
    }

    public void sendTestResult(String testCaseId, int statusId, String comment, long elapsedTime, String testRailsRunId){
        testResultData.put("status_id", statusId);
        testResultData.put("comment", comment);

        if (elapsedTime > 0){
            testResultData.put("elapsed", Long.toString(elapsedTime));
        }
        try {
            r = (JsonObject) client.sendPost("add_result_for_case/" + testRailsRunId + "/" + testCaseId, testResultData );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            System.out.println("Failed to send result to Test Rail!!!! See trace below");
            e.printStackTrace();
        }

    }
}
