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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "TABELA2")
@SequenceGenerator(allocationSize = 1,initialValue = 1,name = "seq_tabela2", sequenceName = "seq_tabela2")
public class Tabela2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "seq_tabela2", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "VALOR")
    private String valor;
    @JoinColumn(name = "ID_TABELA1", referencedColumnName = "ID")
    @ManyToOne
    private Tabela1 idTabela1;
    
    @OneToMany(mappedBy = "tabela2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tabela3> tabela3List;

    public Tabela2() {
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

    public Tabela1 getIdTabela1() {
        return idTabela1;
    }

    public void setIdTabela1(Tabela1 idTabela1) {
        this.idTabela1 = idTabela1;
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
        if (!(object instanceof Tabela2)) {
            return false;
        }
        Tabela2 other = (Tabela2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hascode.entity.Tabela2[ id=" + id + " ]";
    }

    public List<Tabela3> getTabela3List() {
        return tabela3List;
    }

    public void setTabela3List(List<Tabela3> tabela3List) {
        this.tabela3List = tabela3List;
    }
    

    
    public void addTabela3(Tabela3 tabela3){
        if (tabela3List == null) {
            tabela3List = new ArrayList<Tabela3>();
        }
        tabela3List.add(tabela3);
    } 
    
}
