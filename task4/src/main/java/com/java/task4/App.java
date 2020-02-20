package com.java.task4;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

class Demo implements java.io.Serializable 
{ 
	private static final long serialVersionUID = 1L;
	public double pr; 
    public double t; 
    public double rate; 
    // Default constructor 
    public Demo(double pr, double t, double rate) 
    { 
        this.pr = pr; 
        this.t = t; 
        this.rate=rate;
        
    } 
  
}


public class App 
{
	public static void SimpleInterestCompoundInterest(double pr,double rate,double t) {
		
		double sim = 0,com;
	   sim=(pr * t * rate)/100;
	    com=pr * Math.pow(1.0+rate/100.0,t) - pr;
	    
	    PrintStream myout =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        myout.print("Simple Interest="+sim);
        myout.print("\nCompound Interest="+com+"\n");
	}
    public static void main( String[] args )
    {
    	PrintStream myout =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        
    	Demo object = new Demo(1000,2,5); 
        String filename = "file.ser"; 
          
        //Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            //serialization of object 
            out.writeObject(object); 
              
            out.close(); 
            file.close(); 
            myout.print("Object has been serialized\n");  
  
        } 
          
        catch(IOException ex) 
        { 
        	myout.print("IOException is caught\n");  
          
        } 
         
        Demo object1 = null; 
        // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            //deserialization of object 
            object1 = (Demo)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
                      
            SimpleInterestCompoundInterest(object1.pr,object1.rate,object1.t);
            
            myout.print("Object has been deserialized\n");  
                    
        } 
          
        catch(IOException ex) 
        { 
        	myout.print("IOException is caught\n");  
        } 
          
        catch(ClassNotFoundException ex) 
        { 
        	myout.print("ClassNotFoundException is caught\n"); 
         
        } 
  
    }
}

        
