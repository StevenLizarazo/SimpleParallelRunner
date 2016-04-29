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
public interface ParameterPool {
public    Collection<ParallelParameter> getParams();
public    void setParams(Collection prs);
public ParallelParameter fetch();  
}
