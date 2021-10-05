package it.csi.moti.motibe.ejb;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

/**
 * Base test class.
 */
public abstract class BaseTest {
	
	/**
	 * Arquillian entry point
	 * @return the Archive
	 */
	public static EnterpriseArchive createDeployment() {
		JavaArchive[] libs = Maven.resolver().loadPomFromFile("pom.xml")
				.importRuntimeDependencies().resolve().withTransitivity().as(JavaArchive.class);
		
		JavaArchive ejb = ShrinkWrap.create(JavaArchive.class, "motibe-ejb-test.jar")
				.addPackages(true, "it.csi.moti.motibe.ejb")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		
		EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
				.setApplicationXML("test-application.xml")
				.addAsModule(ejb)
				.addAsLibraries(libs);
		
		return ear;
	}
	
}
