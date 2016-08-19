/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hascode.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "TABELA3")
@SequenceGenerator(allocationSize = 1,initialValue = 1,name = "seq_tabela3", sequenceName = "seq_tabela3")
public class Tabela3 implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "VALOR")
    private String valor;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "seq_tabela3", strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "ID_TABELA_2", referencedColumnName = "ID")
    @ManyToOne
    private Tabela2 tabela2;

    public Tabela3() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Tabela2 getTabela2() {
        return tabela2;
    }

    public void setTabela2(Tabela2 tabela2) {
        this.tabela2 = tabela2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabela3)) {
            return false;
        }
        Tabela3 other = (Tabela3) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hascode.entity.Tabela3[ id=" + id + " ]";
    }
    
}
