import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.helpdesk.model.business.AllBusinessTests;
import com.helpdesk.model.domain.AllDomainTests;
import com.helpdesk.model.services.AllServicesTests;

/**
 * @author Kyle Kern
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AllBusinessTests.class, AllServicesTests.class,
		AllDomainTests.class })
public class ApplicationTestSuite {

}
