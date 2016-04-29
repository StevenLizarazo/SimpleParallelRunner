/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author manager
 */
public class SerialParameterPool implements ParameterPool {
    
private ArrayList<ParallelParameter> params;

private Iterator it;
    @Override
    public Collection<ParallelParameter> getParams() {
return params;    }

    @Override
    public void setParams(Collection prs) { 
        this.params = new ArrayList<ParallelParameter>();
        for (Object o : prs) {
            ParallelParameter p = new ParallelParameter();
            p.setInput(o);
            p.setRunned(false);
            p.setAborted(false);

            this.params.add(p);
        }   
    it=params.listIterator();
    
    }

    @Override
    public ParallelParameter fetch() {
     synchronized(it){
       
         if(it.hasNext())return (ParallelParameter) it.next();
         else return null;
            }
    }
    
    
}
