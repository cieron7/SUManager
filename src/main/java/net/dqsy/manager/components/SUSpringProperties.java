package net.dqsy.manager.components;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;

public class SUSpringProperties extends PropertyPlaceholderConfigurer {

    @Override
    public void setLocations(Resource... locations) {
        // Using List.toArray() method will throws java.lang.ClassCastException
        Resource[] resources = new Resource[locations.length];
        for (int i = 0; i < locations.length; i++) {
            String filename = locations[i].getFilename();
            File file = new File(System.getProperty("catalina.home") + "/conf/" + filename);
            if (file.exists()) {
                String fileAbsolutePath = file.getAbsolutePath();
                // From file system, not classpath!
                Resource resource = new FileSystemResource(fileAbsolutePath);
                resources[i] = resource;
            } else {
                resources[i] = locations[i];
            }
        }
        super.setLocations(resources);
    }
}
