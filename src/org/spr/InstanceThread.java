/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import org.spr.ParallelParameter;
import org.spr.Runner;
import java.util.Collection;

/**
 *
 * @author slizarazo
 */
public class InstanceThread extends Thread implements Runnable{
private Object instance;
private Collection<ParallelParameter> input;

private Runner runner;
private boolean running;
/*public Parameter fetchAndSet(Collection<Parameter> params){
synchronized(params){
    int pos=0; 
    //System.out.println("Sp");

    for(Parameter p:input ){
     pos++;
 if(!p.isRunned()){  
  p.setRunned(true);
  
if(pos%1000==0)
  System.out.println("Found item at pos"+pos +" "+p);
 return p;
 }
 
    }
 
}
return null;
}
*/
public void run(){

//  System.out.println("Start thread, input "+input.size());
//Parameter p=fetchAndSet(input);
//this.setRunning(true);
for(ParallelParameter par: input){
try{
par.setOutput(runner.run(getInstance(),par));
par.setAborted(false);
}catch(Exception e){
par.setAborted(true);
par.setMessage(e.getMessage());
par.setError(e);
e.printStackTrace();
//this.setRunning(false);
}

 //p=fetchAndSet(input);

}


this.setRunning(false);
 // System.out.println("End thread");

}

    /**
     * @return the instance
     */
    public Object getInstance() {
        return instance;
    }

    /**
     * @param instance the instance to set
     */
    public void setInstance(Object instance) {
        this.instance = instance;
    }

    /**
     * @return the input
     */
    public Collection getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(Collection input) {
        this.input = input;
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
    public void setRunning(boolean runner) {
        this.running = runner;
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }
    
    
    
}
