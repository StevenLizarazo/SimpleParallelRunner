/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spr;

import org.spr.RunnerPool;
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
public class RunnerPoolTest {

    public RunnerPoolTest() {
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

        for (int max = 0; max <= 1000; max++) {
            RunnerPool instance = new RunnerPool();
            ArrayList<Integer> input = new ArrayList<Integer>();
            for (int i = 1; i <= max; i++) {
                input.add(1);
            }
            System.out.println("Testing " + max);

            ArrayList workers = new ArrayList();
            workers.add(new IntContainer());
            workers.add(new IntContainer());
            workers.add(new IntContainer());
            workers.add(new IntContainer());
            workers.add(new IntContainer());
            workers.add(new IntContainer());
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
        }
    }
}
