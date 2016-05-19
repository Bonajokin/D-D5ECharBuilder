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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bonajokin
 */
public class Hitpoints {
    
    private int hitDieSides;
    private final int base;
    private int conBonus;
    private int racialBonus;
    private int maxHP;
    CharacterSheet characterSheet;
    private final Map<String,Integer> hitDieMap;
    
    public Hitpoints(CharacterSheet sheet){
        this.hitDieMap = new HashMap<>();
        this.buildHitDieDB();
        
        this.characterSheet = sheet;
        this.hitDieSides = 0;
        this.base = 0;
        this.conBonus = sheet.abilities.getConBonus();
        
        if(sheet.getRaceID() == 2){
            this.racialBonus = sheet.getLevel();
        } else {
            this.racialBonus = 0;
        }
        
     
            
    }
    
    public void hitPoints(){
    
         
    
    
    
    
    
    
    }
    
    private void buildHitDieDB(){
        
        this.hitDieMap.put("Barbarian", 12);
        this.hitDieMap.put("Bard", 8);
        this.hitDieMap.put("Cleric", 8);
        this.hitDieMap.put("Druid", 8);
        this.hitDieMap.put("Fighter", 10);
        this.hitDieMap.put("Monk", 8);
        this.hitDieMap.put("Paladin", 10);
        this.hitDieMap.put("Ranger", 10);
        this.hitDieMap.put("Rogue", 8);
        this.hitDieMap.put("Sorceror", 6);
        this.hitDieMap.put("Warlock", 8);
        this.hitDieMap.put("Wizard", 6);
    
    
    
    
    
    }
    
    
        
        

    

    
    
}
