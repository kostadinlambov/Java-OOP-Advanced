package p04_Work_Force.repositories;


import p04_Work_Force.interfaces.Job;

import java.util.Map;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public interface Repository {

    void addJob(Job job);

    Map<String, Job> getJobs();

//
//    Hero getHeroByName(String heroName);
//

}
