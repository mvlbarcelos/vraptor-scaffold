package br.com.vraptor;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests to {@link Scaffold}.
 */
public class ScaffoldTest {

	private String projectName;
	private String[] args;

	@Before
	public void before() {
		projectName = "home";
		args = new String[] { projectName };
	}

	@After
	public void after() throws IOException {
		FileUtils.deleteDirectory(new File(projectName));
		FileUtils.deleteDirectory(new File("src/main/java/app"));

	}

	@Test
	public void shouldCreateProjectFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists project folder.", new File(projectName).exists());
	}

	@Test
	public void shouldCreateJavaSourceFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists java source folder.", new File(projectName + "/src/main/java").exists());
	}

	@Test
	public void shouldCreateMainResourcesFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists main resource folder.", new File(projectName + "/src/main/resources").exists());
	}

	@Test
	public void shouldCreateJavaTestSourceFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists java test source folder.", new File(projectName + "/src/test/java").exists());
	}

	@Test
	public void shouldCreateTestResourcesFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists test resources folder.", new File(projectName
				+ "/src/test/resources").exists());
	}

	@Test
	public void shouldCreateWebXml() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists web.xml.", new File(projectName + "/src/main/webapp/WEB-INF/web.xml").exists());
	}

	@Test
	public void shouldCreateDecoratorsXml() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists decorators.xml.", new File(projectName + "/src/main/webapp/WEB-INF/decorators.xml").exists());
	}

	@Test
	public void shouldCreateDecorator() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists decorator.", new File(projectName + "/src/main/webapp/decorators/main.ftl").exists());
	}


	@Test
	public void shouldGeneratePomXml() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists pom.xml.", new File(projectName + "/pom.xml").exists());
	}

	@Test
	public void shouldCreateIndex() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists index.jsp.", new File(projectName + "/src/main/webapp/index.jsp").exists());
	}

	@Test
	public void shouldGenerateModel() throws Exception {
		args = new String[] { "scaffold", "product", "name:string", "value:double" };
		Scaffold.main(args);
		assertTrue("Should exists model for product.", new File("src/main/java/app/models/Product.java").exists());
	}
	
	@Test
	public void shouldGenerateController() throws Exception {
		args = new String[] { "scaffold", "product", "name:string", "value:double" };
		Scaffold.main(args);
		File productController = new File("src/main/java/app/controllers/ProductController.java");
		assertTrue("Should exists controller for product.", productController.exists());
	}

	@Test
	public void shouldCreateModelFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists model folder.", new File(projectName + "/src/main/java/app/models").exists());
	}

	@Test
	public void shouldCreateControllerFolder() throws Exception {
		Scaffold.main(args);
		assertTrue("Should exists controller folder.", new File(projectName + "/src/main/java/app/controllers").exists());
	}
}