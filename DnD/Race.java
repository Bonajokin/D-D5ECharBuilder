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

/**
 *
 * @author Bonajokin
 */
public class Race {
    
    private final int id;
    private String name;
    public int[] racialASBonuses;
    public int[] subRacialASBonuses;
    
    private Race[] race;
    private int[] racialBonus;
    private int[] subRacialBonus;
    
    
    public Race(){
        this.id = -1;
        this.buildDefaultRacialDB();
    
    
    }
    
    public Race(int id, String name,int[] racials, int[] subracials){
        this.id = id;
        this.name = name;
        this.racialASBonuses = racials;
        this.subRacialASBonuses = subracials;
    }
    
    public Race(int id, String name,int[] racials){
        this.id = id;
        this.name = name;
        this.racialASBonuses = racials;
    }
    
    public Race(int id,Race o){
        this.id = id;
        this.name = o.name;
        this.racialASBonuses = o.racialASBonuses;
        this.subRacialASBonuses = o.subRacialASBonuses;
    
    
    }
   
    
    public Race getRace(int id){
        return race[id];
    }
    
     private void buildDefaultRacialDB(){
      
      /*
         Ability IDs:
         0, "Strength"
         1, "Dexterity"
         2, "Constitution"
         3, "Intelligence"
         4, "Wisdom"
         5, "Charisma"
         
         Race IDs:
         0 Dwarf
         1 Mountain Dwarf
         2 Hill Dwarf
         3 Elf
         4 High Elf
         5 Drow
         6 Wood Elf
         7 Halfling
         8 Stout Halfling
         9 Lightfoot Halfling
         10 Human
         11 Dragonborn
         12 Gnome
         13 Forest Gnome
         14 Rock Gnome
         15 Half-Elf
         16 Half-0rc
         17 Tiefling
         
         
         Generally whats going on below is theres an array consisting of the 18 possible races known to play
         by default in the players handbook. We go through each race and give it a concrete position in the array
         that will allow us to access it later and also provide the racial and subracial bonuses to these classes
         so we can use for our ability score system.
         
         
      */
  
       race = new Race[18];
       
       racialBonus = new int[6];
       for(int i=0;i<6;i++){
           racialBonus[i] = 0;
       }
       
       subRacialBonus = new int[6];
       for(int i=0;i<6;i++){
           subRacialBonus[i] = 0;
       }
       
       racialBonus[2] += 2;
       
       race[0] = new Race(0,"Dwarf",racialBonus);
       
       
       subRacialBonus[0] += 2;
       race[1] = new Race(1,"Mountain Dwarf",racialBonus.clone(),subRacialBonus.clone());
       
       
       this.clearRacialStats(2);
       subRacialBonus[4] +=1;
       
       race[2] = new Race(2,"Hill Dwarf",racialBonus.clone(),subRacialBonus.clone());
      
       this.clearRacialStats(3);
       
       racialBonus[1] = 2;
       race[3] = new Race(3,"Elf",racialBonus.clone());
       
       subRacialBonus[3] = 1;
       race[4] = new Race(4,"High Elf",racialBonus.clone(),subRacialBonus.clone());
       
       this.clearRacialStats(2);
       
       subRacialBonus[4] = 1;
       
       race[5] = new Race(5,"Wood Elf",racialBonus.clone(),subRacialBonus.clone());
       
       this.clearRacialStats(2);
       
       subRacialBonus[5] = 1;
       
       race[6] = new Race(6, "Drow", racialBonus.clone(),subRacialBonus.clone());
       
       this.clearRacialStats(3);
       
       racialBonus[1] = 2;
       race[7] = new Race(7, "Halfling", racialBonus.clone());
       
       subRacialBonus[2] = 1;
       race[8] = new Race(8,"Stout Halfling", racialBonus.clone(), subRacialBonus.clone());
       
       this.clearRacialStats(2);
       
       subRacialBonus[5] = 1;
       race[9] = new Race(9,"Lightfoot Halfling",racialBonus.clone(), subRacialBonus.clone());
       
       this.clearRacialStats(3);
       
       for(int i=0;i<6;i++){
           racialBonus[i] = 1;
       }
       
       race[10] = new Race(10,"Human",racialBonus.clone());
       
       clearRacialStats(3);
       
       racialBonus[0] = 2;
       racialBonus[5] = 1;
       
       race[11] = new Race(11,"Dragonborn",racialBonus.clone());
       
       this.clearRacialStats(3);
       
       racialBonus[3] = 2;
       race[12] = new Race(12,"Gnome",racialBonus.clone());
       
       subRacialBonus[1] = 1;
       race[13] = new Race(13,"Forest Gnome",racialBonus.clone(),subRacialBonus);
       
       this.clearRacialStats(2);
       
       subRacialBonus[2] = 1;
       race[14] = new Race(14,"Rock Gnome",racialBonus.clone(),subRacialBonus);
       
       this.clearRacialStats(3);
       
       racialBonus[5] = 2;
       race[15] = new Race(15,"Half-Elf",racialBonus.clone());
       
       this.clearRacialStats(3);
       
       racialBonus[0] = 2;
       racialBonus[2] = 1;
       race[16] = new Race(16,"Half-Orc",racialBonus.clone());
       
       this.clearRacialStats(3);
       
       racialBonus[5] = 2;
       racialBonus[3] = 1;
       race[17] = new Race(17,"Tiefling",racialBonus.clone());
       
       this.clearRacialStats(3);
       
       
       
       
       
  
  }
  
  private void clearRacialStats(int s){
      
      // A general method used to make clearing the arrays of the racial and subracial bonus stats easy;
      
      
      switch(s){
          case 1:
                for(int i=0;i<6;i++){
                     racialBonus[i] = 0;
                 }
                 break;
                 
          case 2:
                for(int i=0;i<6;i++){
                     subRacialBonus[i] = 0;
                }
                break;
          
          case 3:
                for(int i=0;i<6;i++){
                     racialBonus[i] = 0;
                 }

                for(int i=0;i<6;i++){
                     subRacialBonus[i] = 0;         
                }
                break;
  
    }
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRacialASBonuses(int[] racialASBonuses) {
        this.racialASBonuses = racialASBonuses;
    }

    public void setSubRacialASBonuses(int[] subRacialASBonuses) {
        this.subRacialASBonuses = subRacialASBonuses;
    }
    
   

    
}
