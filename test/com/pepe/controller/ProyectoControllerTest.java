/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.sesions.ProyectoFacade;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADSI-DESAROLLO
 */
public class ProyectoControllerTest {
    
    public ProyectoControllerTest() {
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
     * Test of getProyectoFacade method, of class ProyectoController.
     */
    @Test
    public void testGetProyectoFacade() {
        System.out.println("getProyectoFacade");
        ProyectoController instance = new ProyectoController();
        ProyectoFacade expResult = null;
        ProyectoFacade result = instance.getProyectoFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProyectoFacade method, of class ProyectoController.
     */
    @Test
    public void testSetProyectoFacade() {
        System.out.println("setProyectoFacade");
        ProyectoFacade proyectoFacade = null;
        ProyectoController instance = new ProyectoController();
        instance.setProyectoFacade(proyectoFacade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProyectoActual method, of class ProyectoController.
     */
    @Test
    public void testGetProyectoActual() {
        System.out.println("getProyectoActual");
        ProyectoController instance = new ProyectoController();
        Proyecto expResult = null;
        Proyecto result = instance.getProyectoActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProyectoActual method, of class ProyectoController.
     */
    @Test
    public void testSetProyectoActual() {
        System.out.println("setProyectoActual");
        Proyecto proyectoActual = null;
        ProyectoController instance = new ProyectoController();
        instance.setProyectoActual(proyectoActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaProyecto method, of class ProyectoController.
     */
    @Test
    public void testGetListaProyecto() {
        System.out.println("getListaProyecto");
        ProyectoController instance = new ProyectoController();
        List<Proyecto> expResult = null;
        List<Proyecto> result = instance.getListaProyecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaProyecto method, of class ProyectoController.
     */
    @Test
    public void testSetListaProyecto() {
        System.out.println("setListaProyecto");
        List<Proyecto> listaProyecto = null;
        ProyectoController instance = new ProyectoController();
        instance.setListaProyecto(listaProyecto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProyecto method, of class ProyectoController.
     */
    @Test
    public void testGetProyecto() {
        System.out.println("getProyecto");
        Integer id = null;
        ProyectoController instance = new ProyectoController();
        Proyecto expResult = null;
        Proyecto result = instance.getProyecto(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareCreate method, of class ProyectoController.
     */
    @Test
    public void testPrepareCreate() {
        System.out.println("prepareCreate");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.prepareCreate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEdit method, of class ProyectoController.
     */
    @Test
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.prepareEdit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareView method, of class ProyectoController.
     */
    @Test
    public void testPrepareView() {
        System.out.println("prepareView");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.prepareView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareList method, of class ProyectoController.
     */
    @Test
    public void testPrepareList() {
        System.out.println("prepareList");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.prepareList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of xd method, of class ProyectoController.
     */
    @Test
    public void testXd() {
        System.out.println("xd");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.xd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProyecto method, of class ProyectoController.
     */
    @Test
    public void testAddProyecto() {
        System.out.println("addProyecto");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.addProyecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProyecto method, of class ProyectoController.
     */
    @Test
    public void testUpdateProyecto() {
        System.out.println("updateProyecto");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.updateProyecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProyecto method, of class ProyectoController.
     */
    @Test
    public void testDeleteProyecto() {
        System.out.println("deleteProyecto");
        ProyectoController instance = new ProyectoController();
        String expResult = "";
        String result = instance.deleteProyecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
