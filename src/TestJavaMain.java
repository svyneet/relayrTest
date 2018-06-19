import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;




public class TestJavaMain{

public static void main(String args[]) {

	TestNG testng = new TestNG();
	List<String> suites = Lists.newArrayList();
	suites.add("C:\\Users\\vineet\\workspace\\relayR\\testng.xml");//path to xml..
	testng.setTestSuites(suites);
	testng.run();
}
}