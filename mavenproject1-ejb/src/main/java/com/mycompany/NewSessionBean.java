/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.hascode.entity.Tabela1;
import com.hascode.entity.Tabela2;
import com.hascode.entity.Tabela3;
import com.mycompany.maven.jar.Utilitaria;
import com.rits.cloning.Cloner;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diogo
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tabela1 testar() {

            Query query = entityManager.createQuery("select t from Tabela1 t where t.id = :id ", Tabela1.class);
            query.setParameter("id", 28);
            List<Tabela1> list = query.getResultList();
            
            for (Tabela1 tab : list) {
                System.out.println(" i = " + tab.getId());
            }
            
            Tabela1 tabela1 = list.get(0);
            /*
            Tabela2 tabela2Original = tabela1.getTabela2List().get(0);
            entityManager.detach(tabela1);

            
            List<Class<?>> listClass = new ArrayList<Class<?>>();
                
            List<String> listaPacotes = new ArrayList<String>();
            listaPacotes.add("org.eclipse.persistence.internal.sessions");
            listaPacotes.add("org.eclipse.persistence.expressions");
            listaPacotes.add("org.eclipse.persistence.sessions");
            listaPacotes.add("org.eclipse.persistence.internal.queries");
            listaPacotes.add("org.eclipse.persistence.descriptors");
            listaPacotes.add("weblogic.utils.collections");
            listaPacotes.add("weblogic.jndi.internal");
            listaPacotes.add("java.util.Hashtable");
            listaPacotes.add("org.eclipse.persistence.internal.helper");
            listaPacotes.add("org.eclipse.persistence.queries");
            listaPacotes.add("org.eclipse.persistence.mappings");
            listaPacotes.add("org.eclipse.persistence.internal.descriptors");
            listaPacotes.add("javax.management"); 
            listaPacotes.add("weblogic.servlet.internal");
            listaPacotes.add("java.io");
            listaPacotes.add("weblogic.servlet.utils");
            listaPacotes.add("org.eclipse.persistence.internal.identitymaps");
            listaPacotes.add("org.eclipse.persistence.mappings");
            listaPacotes.add("org.eclipse.persistence.internal.descriptors");
            listaPacotes.add("org.eclipse.persistence.internal.identitymaps");
            listaPacotes.add("org.eclipse.persistence.internal.descriptors.changetracking");
            listaPacotes.add("java.lang.ref");
                                    

            for (String pacote : listaPacotes) {
                try{
                    listClass.addAll(ClassFinder.find(pacote));                      
                }catch(Exception ex){
                    System.out.println("################ erro "+pacote);
                }
  
            }
            try{


            }catch(Exception ex){
                System.out.println("################ erro ");
            }
            
            /*
            for (Class classeListar : listClass) {
                System.out.println("\"" + classeListar + "\"");
            }*/

            /*
            Class[] arrayClasses = new Class[listClass.size()];
            listClass.toArray(arrayClasses);
            Cloner cloner  = new Cloner();
            cloner.dontClone(arrayClasses);   
            
            Tabela1 tabela1Clone = cloner.deepClone(tabela1);
            
            
            
            //em.detach(tabela1);
            //Tabela2 tabela2 = new Tabela2();
            //tabela2.setIdTabela1(tabela1);
            //tabela2.setValor("tabela 2");
            //tabela1.addTabela2(tabela2);  
            
            //tabela1.setId(null);
            
            //Cloner cloner = new Cloner();
            
            //PersistenceCloner persistenceCloner = new PersistenceCloner<Tabela1>(tabela1);
            //Tabela1 tabela1Nova = (Tabela1) persistenceCloner.generateCopyToPersist();
            
            //Tabela1 tabela1Nova = cloner.shallowClone(tabela1);
            //tabela1Nova.setValor("tabela1 N");
            
           // Tabela2 tabela2Nova = tabela1Nova.getTabela2List().get(0);
            //tabela2Nova = new Cloner().shallowClone(tabela2Nova);
            //tabela2Nova.setValor("AAA1 p");
            //tabela1Nova.getTabela2List().set(0, tabela2Nova);
            
            //Tabela3 tabela3Nova = tabela2Nova.getTabela3List().get(0);
            //tabela3Nova = new Cloner().shallowClone(tabela3Nova);
            //tabela3Nova.setValor("aww p");
            //tabela2Nova.getTabela3List().set(0, tabela3Nova);            
            */
            
            Utilitaria.teste();
            
            entityManager.merge(tabela1);  
            return tabela1;
        
    }
    
}
