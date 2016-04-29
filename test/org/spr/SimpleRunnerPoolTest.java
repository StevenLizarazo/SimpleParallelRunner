/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import org.spr.SimpleRunnerPool;
import org.spr.Runner;
import org.spr.ParallelParameter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author slizarazo
 */
public class SimpleRunnerPoolTest {

    public SimpleRunnerPoolTest() {
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
     * Test of isFinished method, of class RunnerPool.
     */
    @Test
    public void testIsFinished() {
    }

    /**
     * Test of runPool method, of class RunnerPool.
     */
    @Test
    public void testRunPool() throws Exception {
        System.out.println("runPool");
double tmin=-1;
double tmax=0;
String smin="";
String smax="";
        for (int max = 0; max <= 1000; max++) {
long start= System.currentTimeMillis();
            SimpleRunnerPool instance = new SimpleRunnerPool();
            ArrayList<Integer> input = new ArrayList<Integer>();
            for (int i = 1; i <= max; i++) {
                input.add(1);
            }
            int wr=max%200+1;
            System.out.println("Testing " + max+ " items, workers "+wr );

            ArrayList workers = new ArrayList();

            for(int w=1;w<=wr;w++)
             workers.add(new IntContainer());

            instance.setInstances(workers);

            instance.setParams(input);

            for (ParallelParameter p : instance.getParams()) {
                //   System.out.println("Assert param "+p);
                assertFalse(p.isRunned());
            }

            instance.setRunner(new IntWorker());

            instance.runPool();
            int c = 0;
            for (Object o : instance.getInstances()) {
                IntContainer w = (IntContainer) o;
                c += w.getSum();

            }
            assertEquals(max, c);
            
long end= System.currentTimeMillis();

double ttime=(double)(end-start);
double cur=(ttime)/(max+1);

          System.out.println("Tested " + max+ ", workers "+wr +", time per item "+cur+",total time "+(ttime)+" ms");

          
          if(ttime/(max+1)<tmin||tmin<0){
          tmin=(ttime)/(max+1);
          smin= "Min time items: " + max+ ", workers "+wr +" time per item "+cur+" total time "+(ttime)+" ms";
  
          }
          if(ttime/(max+1)>tmax){
          tmax=(ttime)/(max+1);
          smax= "Max time items: " + max+ ", workers "+wr +" time per item "+cur+" total time "+(ttime)+" ms";
  
          }

        }
                  System.out.println(smin);
                  System.out.println(smax);

    }
}
