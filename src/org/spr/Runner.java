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
public  interface Runner {
    
    public Object run(Object instance,ParallelParameter p)throws Exception;
    
}
