/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import java.util.Collection;

/**
 *
 * @author manager
 */
public interface RunnerPool {

    /**
     * @return the instances
     */
public    Collection<Object> getInstances();

    /**
     * @return the params
     */
public    Collection<ParallelParameter> getParams();

    /**
     * @return the runner
     */
public    Runner getRunner();

public    void runPool() throws Exception;

    /**
     * @param instances the instances to set
     */
public    void setInstances(Collection<Object> instances);

    /**
     * @param params the params to set
     */
public    void setParams(Collection prs);

    /**
     * @param runner the runner to set
     */
    void setRunner(Runner runner);
    
}
