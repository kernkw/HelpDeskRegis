package com.helpdesk.model.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.helpdesk.model.business.manager.HelpDeskManagerTest;

/**
 * @author Kyle Kern
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ HelpDeskManagerTest.class })
public class AllBusinessTests {

}
