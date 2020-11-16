package com.SerializationWithRequestAndResponseSpecBuilder;

public class program9PayLoad 
{
	public static program9SeralizationRequestInputFULL createIssue()
	{
		//project -> key
		program9SeralizationRequestInputProject project = new program9SeralizationRequestInputProject();
		project.setKey("PROJ");
		
		//issuetype -> name
		program9SeralizationRequestInputIssueType issuetype = new program9SeralizationRequestInputIssueType();
		issuetype.setName("Bug");
		
		//Fields
		program9SeralizationRequestInputFields fields = new program9SeralizationRequestInputFields();
		fields.setProject(project);
		fields.setSummary("Setting this Summary via SERIALIZATION concept of RequestSpecBuilder and ResponseSpecBuilder");		
		fields.setDescription("Setting this Description via SERIALIZATION concept of RequestSpecBuilder and ResponseSpecBuilder");
		fields.setIssuetype(issuetype);
		
		//root pojo 
		program9SeralizationRequestInputFULL full = new program9SeralizationRequestInputFULL();
		full.setFields(fields);
		
		return full;
	}
	
	public static program9SeralizationRequestInputFULLPUT updateIssue(String keka)
	{
		//Fields
		program9SeralizationRequestInputFieldsPUT fields = new program9SeralizationRequestInputFieldsPUT();
		fields.setSummary("UPDATING this Summary of "+keka+" via SERIALIZATION concept of RequestSpecBuilder and ResponseSpecBuilder");
		fields.setDescription("UPDATING this Description of "+keka+" via SERIALIZATION concept of RequestSpecBuilder and ResponseSpecBuilder");
		
		//root pojo
		program9SeralizationRequestInputFULLPUT full = new program9SeralizationRequestInputFULLPUT();
		full.setFields(fields);
		
		return full;
		
	}
	

}

	

/* THE BELOW IS WHAT IS PASSED INTO THE ABOVE METHOD "createIssue()"
 * https://developer.atlassian.com/server/jira/platform/jira-rest-api-examples/
{
    "fields": {
       "project":
       {
          "key": "TEST"
       },
       "summary": "REST ye merry gentlemen.",
       "description": "Creating of an issue using project keys and issue type names using the REST API",
       "issuetype": {
          "name": "Bug"
       }
   }
}



 * THE BELOW IS WHAT IS PASSED INTO THE ABOVE METHOD "updateIssue()"
 * https://developer.atlassian.com/server/jira/platform/jira-rest-api-examples/
{
    "fields" : {
        "summary": "Summary",
        "description": "Description"
    }
}
*/