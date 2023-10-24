/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author tarma
 */
public class Sale implements Serializable {
    
   private int id;
    private String code;

    public Sale(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

     @Override
    public String toString() {
        return  code ;
    }

    public Sale(String code) {
        this.code = code;
    }
    
    
    
}
