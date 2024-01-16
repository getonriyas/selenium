import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectsRegression {
    @Test(groups = "Test Add Project Site", dependsOnMethods = {"testAddExistingProject"}, retryAnalyzer = RetryAnalyser.class,  enabled=true)
    @Parameters
    public void testAddProjectSiteMap() {
        Assert.assertTrue(projectDetailsPage.addProjectSiteMap(physicalMapsData, existingData.createExistingProjectData[0],physicalMapsData.addSiteTestData));

    }
}
