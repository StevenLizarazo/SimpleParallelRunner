/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author manager
 */
public class SerialParameterPoolTest {
    
    public SerialParameterPoolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getParams method, of class SerialParameterPool.
     */
   
    
    @Test
    public void testGetParams() {
        System.out.println("getParams");
        SerialParameterPool instance = new SerialParameterPool();
        String vec[] ={"1","2"};
        instance.setParams(java.util.Arrays.asList(vec));
        Collection<ParallelParameter> result = instance.getParams();
        assertNotNull( result);
        assertEquals( result.size(),2);
        assertEquals(                (String)((ParallelParameter)result.toArray()[0]).getInput(),"1");
        assertEquals(                (String)((ParallelParameter)result.toArray()[1]).getInput(),"2");
        
    }


    /**
     * Test of fetch method, of class SerialParameterPool.
     */
    @Test
    public void testFetch() {
        SerialParameterPool instance = new SerialParameterPool();
        String vec[] ={"1","2"};
        instance.setParams(java.util.Arrays.asList(vec));
        Collection<ParallelParameter> result = instance.getParams();
        assertNotNull( result);
        assertEquals( result.size(),2);
        assertEquals(           instance.fetch().getInput(),"1");
        assertEquals(           instance.fetch().getInput(),"2");
    }
    
}
