/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hascode.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "TABELA1")
@SequenceGenerator(allocationSize = 1,initialValue = 1,name = "seq_tabela1", sequenceName = "seq_tabela1")
public class Tabela1 implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "seq_tabela1", strategy = GenerationType.SEQUENCE)
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALOR")
    private String valor;
    @OneToMany(mappedBy = "idTabela1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tabela2> tabela2List;

    public Tabela1() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<Tabela2> getTabela2List() {
        return tabela2List;
    }

    public void setTabela2List(List<Tabela2> tabela2List) {
        this.tabela2List = tabela2List;
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
        if (!(object instanceof Tabela1)) {
            return false;
        }
        Tabela1 other = (Tabela1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hascode.entity.Tabela1[ id=" + id + " ]";
    }
    
    public void addTabela2(Tabela2 tabela2){
        if (tabela2List == null) {
            tabela2List = new ArrayList<Tabela2>();
        }
        tabela2List.add(tabela2);
    }
    
}
