package com.javatraining.test;

import com.javatraining.service.AddressBookImpl;
import com.javatraining.service.IAddressBook;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Testing the IAddressBook interfaceMethod
 */
public class AddressTest {

    private static IAddressBook iAddressBook;

    /**
     * init Method
     */
    @BeforeClass
    public static void init(){
        System.out.println("init Method");
        iAddressBook = new AddressBookImpl();
    }

    /**
     * destroy Method
     */
    @AfterClass
    public static void destroy(){
        System.out.println("destroy Method");
        iAddressBook= null;
    }

    public void testAddress(){

    }

}
