/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bstbasansordenetimserviceclient;



import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import servicehandler.HeaderHandlerResolver;
import path.Path;
/**
 *
 * @author Lenovo
 */
public class Test {
       public static void main(String[] args) {
       try {
             File currentDirFile = new File("");
String helper = currentDirFile.getAbsolutePath();
String currentDir;
currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());

           StringBuilder path=new StringBuilder();
           path.append(Path.instance.getPath()).append("/keystore.jks");
             String sslStoreProp = "javax.net.ssl.trustStore";
         System.setProperty(sslStoreProp, helper+"/src/keystore/keystore.jks");
          System.setProperty("javax.net.ssl.keyStorePassword","changeit");
          
            BstbAsansorDenetimServis service=new BstbAsansorDenetimServis();
            service.setHandlerResolver(new HeaderHandlerResolver());
            IBstbAsansorDenetimServis
             port=service.getBasicHttpBindingIBstbAsansorDenetimServis();
          
        ServisSonucOfArrayOfIl8Zb117HL servisSonuc=   port.tumIlleriSorgulama();
        ArrayOfIl il=servisSonuc.getSonuc().getValue();
        for (Il i:il.getIl()){
            System.out.println(i.getAd());
        }
        } catch (IBstbAsansorDenetimServisTumIlleriSorgulamaServiceExceptionFaultFaultMessage ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

