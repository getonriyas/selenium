import java.util.HashMap;

public class projectDetailsPage {
    public <T extends BaseData> boolean addProjectSiteMap(T obj, HashMap<String, String> projectData, HashMap<String, String>[] siteTestData) {
        openProject(projectData);
        return physicalMapsPage.addSite(obj,siteTestData);
    }
}
