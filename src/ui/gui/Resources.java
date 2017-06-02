/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import java.net.URL;

public class Resources {
	
	public static final URL getResourceFile(String name){
		// opens a file with path relative to location of the Resources class
		URL url=Resources.class.getResource(name);
		return url; 
	}

}