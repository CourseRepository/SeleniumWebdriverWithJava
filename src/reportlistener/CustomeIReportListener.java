package reportlistener;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.testng.*;
import org.testng.xml.XmlSuite;

public class CustomeIReportListener implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite,
			String outputDir) {
		
		System.out.println("***********Custome Repoter************");
		System.out.println("Output Dir : " + outputDir);
		ISuite suite = iSuite.get(0);
		System.out.println("Suite Name : " + suite.getName());
		Map<String, ISuiteResult> result = suite.getResults();
		Collection<ISuiteResult> test = result.values();
		ISuiteResult testresult = test.iterator().next();
		
	}

}
