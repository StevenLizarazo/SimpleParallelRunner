/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

/**
 *
 * @author slizarazo
 */
public class ParallelParameter {
    private Object input;
    private Object output;
    private boolean runned;
    private boolean aborted;
    private Exception error;
    private String message;
private int index ;
    /**
     * @return the input
     */
    public Object getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(Object input) {
        this.input = input;
    }

    /**
     * @return the output
     */
    public Object getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(Object output) {
        this.output = output;
    }

    /**
     * @return the runned
     */
    public boolean isRunned() {
        return runned;
    }

    /**
     * @param runned the runned to set
     */
    public void setRunned(boolean runned) {
        this.runned = runned;
    }

    /**
     * @return the aborted
     */
    public boolean isAborted() {
        return aborted;
    }

    /**
     * @param aborted the aborted to set
     */
    public void setAborted(boolean aborted) {
        this.aborted = aborted;
    }

    /**
     * @return the error
     */
    public Exception getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(Exception error) {
        this.error = error;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
