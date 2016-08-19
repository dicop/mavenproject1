/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.hascode.entity.Tabela1;
import javax.ejb.Local;

/**
 *
 * @author Diogo
 */
@Local
public interface NewSessionBeanLocal {
    
    public Tabela1 testar();
    
}
