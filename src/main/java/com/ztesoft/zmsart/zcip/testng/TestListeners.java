package com.ztesoft.zmsart.zcip.testng;

import java.io.File;
import java.io.FileInputStream;

import org.jacoco.core.tools.ExecDumpClient;
import org.jacoco.core.tools.ExecFileLoader;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("success: " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
		downloadThreadingTestData(result);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("fail: " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
		downloadThreadingTestData(result);
	}

	
	
	
	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
	}

	
	public void downloadThreadingTestData(ITestResult result) {
		try {
            
            String junitCoverDir = null;
            int jacocoPort = 0;
            String jacocoAddress = null;
            String mavenTargetDir = null;
            junitCoverDir = System.getProperty("junitCoverDir");
            jacocoAddress = System.getProperty("jacocoAddress");
            mavenTargetDir = System.getProperty("mavenTargetDir");
            
            if (System.getProperty("jacocoPort") != null) {
                jacocoPort = Integer.valueOf(System.getProperty("jacocoPort").trim());
            }
            
            System.out.println("junitCoverDir: " + junitCoverDir);
            System.out.println("jacocoPort: " + jacocoPort);
            System.out.println("jacocoAddress: " + jacocoAddress);
            
            if (junitCoverDir != null) {
	            System.out.println("jacoco_" + result.getTestClass().getName() + "-" + result.getMethod().getMethodName() + ".exec");
	            ExecDumpClient execdump = new ExecDumpClient();
	            execdump.setReset(true);
	            System.out.println("Begin dump exec data....");
	            ExecFileLoader fileloader = execdump.dump(jacocoAddress != null ? jacocoAddress : "localhost", jacocoPort != 0 ? jacocoPort : 6300);
	            System.out.println("End dump exec data....");
	            File file = new File(junitCoverDir);
	            if (!file.exists()) {
	                file.mkdirs();
	            }
	            File fileCase = new File(junitCoverDir + "/jacoco_" + result.getTestClass().getName() + "-" + result.getMethod().getMethodName() + ".exec");
	            fileloader.save(fileCase, false);
	            
	            
	            if (mavenTargetDir!= null && mavenTargetDir.trim().length() > 0) {
	                try {
	                    String mavenJacocoExecFile = mavenTargetDir + "/jacoco.exec" ;
	                    
	                    ExecFileLoader loader = new ExecFileLoader();
	                    loader.load(new FileInputStream(fileCase));
	                    loader.save(new File(mavenJacocoExecFile), true);
	                }
	                catch (Exception e) {
	                    System.out.println("Merge file fail");
	                }
	                
	            }
                
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
