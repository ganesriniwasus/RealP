package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportObject {
	public ExtentReports getExtentReport() {
		String path=System.getProperty("user.dir")+"\\extentreport\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Real Project Document");
		reporter.config().setReportName("Real Project Report");
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		return extentReport;
	}
	
}
