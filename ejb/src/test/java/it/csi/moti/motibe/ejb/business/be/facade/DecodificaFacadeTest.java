package it.csi.moti.motibe.ejb.business.be.facade;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.csi.moti.motibe.ejb.BaseTest;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Test class for DecodificaFacade.
 */
@RunWith(Arquillian.class)
public class DecodificaFacadeTest extends BaseTest {
	
	/**
	 * Arquillian entry point
	 * @return the Archive
	 */
	@Deployment
	public static EnterpriseArchive createDeployment() {
		return BaseTest.createDeployment();
	}
	
	@Inject private ConfigurationHelper configurationHelper;

	/**
	 * Test for {@link DecodificaFacade#getModalitaAffidamento()}
	 */
	@Test
	public void getModalitaAffidamento() {
//		GetModalitaAffidamentoRequest req = new GetModalitaAffidamentoRequest();
//		GetModalitaAffidamentoService service = new GetModalitaAffidamentoService(configurationHelper, decodificaDad);
//		GetModalitaAffidamentoResponse res = service.execute(req);
		
//		Assert.assertNotNull(res);
//		Assert.assertTrue(res.getApiErrors().isEmpty());
//		Assert.assertFalse(res.getModalitaAffidamentos().isEmpty());
	}
	
}
