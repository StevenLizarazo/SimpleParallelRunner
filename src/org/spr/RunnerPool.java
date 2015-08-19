/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author slizarazo
 */
public class RunnerPool {
 private Collection<ParallelParameter> params;
 private Runner runner;
 private Collection<Object> instances;
 private ArrayList<InstanceThread> pool;

 public static <T> ArrayList<T[]> chunks(ArrayList<T> bigList,int n){
    ArrayList chunks = new ArrayList();
int part=bigList.size()/n;

if(part==0||bigList.size()==n)part=1;
    int limi=0;
    for (int i = 0; i < n; i++) {
        if(i==n-1&&limi + part<bigList.size()){
        List chunk = bigList.subList(limi, bigList.size() );
        chunks.add(chunk);
        }
        else {
        List chunk = bigList.subList(limi, Math.min( bigList.size() , limi + part));
        chunks.add(chunk);
        }
        limi=limi+part;
//        if(i==n-1)part++;
        
    }

    return chunks;
}
 private void startPool(){
        setPool((ArrayList<InstanceThread>) new ArrayList());
  
if(getInstances().size()>=getParams().size()){

   ArrayList ninst=new ArrayList();
   int i=0;
   for(Object o:getInstances()){
   if(i>=getParams().size() )break;
   ninst.add(o);
       i++;
   }
   
setInstances(ninst);
   }
        
 ArrayList pa;
/* if(getParams().size()>0&&getInstances().size()==getParams().size())
     
     
pa =chunks((ArrayList) getParams(),1);       
 
 else*/ 
 if(getParams().size()>0){

    pa =chunks((ArrayList) getParams(), getInstances().size());       

 }
 else
 {
 pa=new ArrayList();
 pa.add(getParams());
 }
 int pos=0;
      for(Object inst:getInstances()){
          
     InstanceThread tr=new InstanceThread();

     tr.setInput((Collection)pa.get(pos));
     pos++;
     tr.setInstance(inst);
     tr.setRunner(getRunner());
     tr.setRunning(true);
     tr.start();
     getPool().add(tr);
     
      }
}
 private void endPool(){
     for(InstanceThread inst:getPool()){
     inst.stop();

     }
          setPool(null);
 }
 
 boolean isFinished(){
     for(InstanceThread inst:getPool()){
 if(inst.isRunning())return false;
     }
     return true;
 }
 
 public void runPool()throws Exception{
 
     startPool();
     boolean done=false;
     
     while(!done){
     
     
     Thread.sleep(1);
     done=isFinished();
     }
     endPool();
     
 
 }

    /**
     * @return the params
     */
    public Collection<ParallelParameter> getParams() {
        return params;
    }

    
    /**
     * @param params the params to set
     */
    public void setParams(Collection prs) {
        this.params=new ArrayList<ParallelParameter>();
        for(Object o:prs){
        ParallelParameter p=new ParallelParameter();
        p.setInput(o);
        p.setRunned(false);
        p.setAborted(false);
        
       this.params.add(p);
        }

    }

    /**
     * @return the runner
     */
    public Runner getRunner() {
        return runner;
    }

    /**
     * @param runner the runner to set
     */
    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    /**
     * @return the instances
     */
    public Collection<Object> getInstances() {
        return instances;
    }

    /**
     * @param instances the instances to set
     */
    public void setInstances(Collection<Object> instances) {
        this.instances = instances;
    }

    /**
     * @return the pool
     */
    private ArrayList<InstanceThread> getPool() {
        return pool;
    }

    /**
     * @param pool the pool to set
     */
    private void setPool(ArrayList<InstanceThread> pool) {
        this.pool = pool;
    }
    
    
}
