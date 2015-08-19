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
public class IntWorker implements Runner {

    @Override
    public Object run(Object instance, ParallelParameter p) throws Exception {
        IntContainer worker = (IntContainer) instance;
        Integer i = (Integer) p.getInput();
        worker.add(i);
        return null;

    }

}
