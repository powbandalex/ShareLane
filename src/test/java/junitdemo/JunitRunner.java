package junitdemo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({JunitDemoClass.class})
public class JunitRunner {
}
