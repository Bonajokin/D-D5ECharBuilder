/*
 * Copyright (C) 2016 Bonajokin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package DnD;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Bonajokin
 */
public class Class {
    
    private String className;
    private String description;
    private int hitDieSides;
    private List<String> SavThrProf;
    private List<String> ArmWepProf;
   
    
    public Class(){
        this.className = "";
        this.description = "";
        this.hitDieSides = 0;
        this.SavThrProf = new LinkedList();
        this.ArmWepProf = new LinkedList();
       
    }
    
     public Class(String className, String description, int hitDieSides){
        this.className = className;
        this.description = description;
        this.hitDieSides = hitDieSides;
        this.SavThrProf = new LinkedList();
        this.ArmWepProf = new LinkedList();
       
    }
    
     public Class(Class object){
        this.className = object.className;
        this.description = object.description;
        this.hitDieSides = object.hitDieSides;
        this.SavThrProf = object.SavThrProf;
        this.ArmWepProf = object.ArmWepProf;
    }

     
    
     
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public int getHitDieSides() {
        return hitDieSides;
    }

    public void setHitDieSides(int hitDieSides) {
        this.hitDieSides = hitDieSides;
    }

    
    


    public void addSavingThrow(String name){
        this.SavThrProf.add(name);
    }
    
    public void addWeaponProf(String name){
        this.ArmWepProf.add(name);
    }
    
    
    
    
    public Iterator<String> getSavingThrows(){
        return this.SavThrProf.iterator();
    }
    
    public Iterator<String> getWeaponProfs(){
        return this.ArmWepProf.iterator();
    }
    

    
    
    
    
    
    
    
}
