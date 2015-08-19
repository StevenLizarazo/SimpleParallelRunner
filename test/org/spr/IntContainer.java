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
public class IntContainer {

    private int sum = 0;

    public void add(int val) {
        synchronized (this) {
            sum += val;
        }
    }

    /**
     * @return the sum
     */
    public int getSum() {
        synchronized (this) {
            return sum;
        }
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(int sum) {
        synchronized (this) {
            this.sum = sum;
        }
    }
}
