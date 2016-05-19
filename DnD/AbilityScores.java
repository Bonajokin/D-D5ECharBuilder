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

import DnD.Functionality.Dice;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bonajokin
 */
public class AbilityScores {
    
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    
    private int STRmod;
    private int DEXmod;
    private int CONmod;
    private int INTmod;
    private int WISmod;
    private int CHAmod;
    
    
    private final Map<Integer,Integer> asModMap;
    private final Map<Integer,Integer> LBMap;
    private final Map<Integer,String> abilities;
   
    private boolean racialsCalculated;
    
 

    private final Race race;
    
    private final int[] baseSTDScores;
    
    private final CharacterSheet characterSheet;
    
   
   
    
    private int rbStrength;
    private int rbDexterity;
    private int rbConstitution;
    private int rbIntelligence;
    private int rbWisdom;
    private int rbCharisma;
    
    private int srbStrength;
    private int srbDexterity;
    private int srbConstitution;
    private int srbIntelligence;
    private int srbWisdom;
    private int srbCharisma;
    
    
   
    
    //Point Buy Variables
    
    
    private int pbBaseStrength;
    private int pbBaseDexterity;
    private int pbBaseConstitution;
    private int pbBaseIntelligence;
    private int pbBaseWisdom;
    private int pbBaseCharisma;
    
    private final int pbBaseAbilityPoints = 8;
    private final int pbMaxAbility = 15;
    private final int pbBaseSpendingPoints = 27;
    private boolean isPBFirstRun;
    private boolean isPBNegative;
    private int pbSpendingPoints;
  
    private int pbSTRcostMod;
    private int pbDEXcostMod;
    private int pbCONcostMod;
    private int pbINTcostMod;
    private int pbWIScostMod;
    private int pbCHAcostMod;
   
    //Standard Variables
    private int[] stdAbilityScores;
    
    private boolean isSTDFirstRun;
    
    private int stdBaseStrength;
    private int stdBaseDexterity;
    private int stdBaseConstitution;
    private int stdBaseIntelligence;
    private int stdBaseWisdom;
    private int stdBaseCharisma;
    
    private int lbSpendingPoints;
    private boolean isLBNegative;
    private boolean isLBFirstRun;
    private int lbStrength;
    private int lbDexterity;
    private int lbConstitution;
    private int lbIntelligence;
    private int lbWisdom;
    private int lbCharisma;

    
    
    
   
    
    
    
    
    
 public AbilityScores(CharacterSheet sheet){
 
       
       this.characterSheet = sheet;
       
       
       this.strength = 0 ;
       this.dexterity = 0;
       this.constitution = 0;
       this.intelligence = 0;
       this.wisdom = 0;
       this.charisma = 0;
       
       this.STRmod = 0;
       this.DEXmod = 0;
       this.CONmod = 0;
       this.INTmod = 0;
       this.WISmod = 0;
       this.CHAmod = 0;
       
       this.rbStrength = 0 ;
       this.rbDexterity = 0;
       this.rbConstitution = 0;
       this.rbIntelligence = 0;
       this.rbWisdom = 0;
       this.rbCharisma = 0;
       
       this.srbStrength = 0 ;
       this.srbDexterity = 0;
       this.srbConstitution = 0;
       this.srbIntelligence = 0;
       this.srbWisdom = 0;
       this.srbCharisma = 0;
       
       
       this.racialsCalculated = false;
       
       this.asModMap = new HashMap<>();
       this.LBMap = new HashMap<>();
       this.abilities = new HashMap<>();
       this.buildLBMAp();
       this.buildASModMap();
       this.buildAbilityMap();
       this.race = new Race();
     
       
       //Point Buy Things
       this.pbBaseStrength = 0 ;
       this.pbBaseDexterity = 0;
       this.pbBaseConstitution = 0;
       this.pbBaseIntelligence = 0;
       this.pbBaseWisdom = 0;
       this.pbBaseCharisma = 0;
       this.isPBFirstRun = true;
       
       
       // Standard Things
       this.stdBaseStrength = 0 ;
       this.stdBaseDexterity = 0;
       this.stdBaseConstitution = 0;
       this.stdBaseIntelligence = 0;
       this.stdBaseWisdom = 0;
       this.stdBaseCharisma = 0;
       this.isSTDFirstRun = true;
       
       this.baseSTDScores = new int[6];
       this.baseSTDScores[0] = 15;
       this.baseSTDScores[1] = 14;
       this.baseSTDScores[2] = 13;
       this.baseSTDScores[3] = 12;
       this.baseSTDScores[4] = 10;
       this.baseSTDScores[5] = 8;
       
       this.stdAbilityScores = new int[6];
       
       
       //Level Bonus Stuff
       this.lbSpendingPoints = 0;
       this.lbStrength = 0 ;
       this.lbDexterity = 0;
       this.lbConstitution = 0;
       this.lbIntelligence = 0;
       this.lbWisdom = 0;
       this.lbCharisma =  0;
       
       this.isLBFirstRun = true;
       
       
       

      
       
      
   }

   
   //Point Buy System
   public void PointBuy(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma){
       
       // Sets the Default values needed for the point buy system to function
        this.initializePB();
        
        
        this.calcRacialBonuses(characterSheet.getRaceID());
       

        
        // Find the corresponding point whether it be negative -1 or +1 and do do the correct calculation based off that
          switch(findPoint("pb,",strength,dexterity,constitution,intelligence,wisdom,charisma)){
              
              
              // Cases are sperated by the six ability scores. Each case works the exact same way with the only thing changing is which stat 
              // is actually modified. Walking through the first case of strength as an example.
              
                case "Strength":
                    
                    // Calculate the cost modifier for the next strength point
                    calcPBCostMod("STR");
                    
                    
                    //If the point to be used is not negative
                    if(!this.isPBNegative){
                        
                        // If the current strength value isn't already at its max base ability score of 15 (before racial/class bonuses) and we have available points to spend 
                        if(this.pbBaseStrength < pbMaxAbility && this.pbSpendingPoints != 0){
                            
                            //Add one to the current value of strength
                            this.pbBaseStrength += 1;
                            
                            //Subtract the number of points we spent to add one to strength based off the Strength cost modifier we calcualted earlier.
                            this.pbSpendingPoints -= this.pbSTRcostMod;   
                            
                        }
                        
                        // If the point to be used happens to be negative.
                    }  else {
                        
                        // If the current strength value is greater than our lowest possible score of 8 and we're not trying to gain points that we don't have by going higher than the 
                        // maximum starting points value of pbBaseSpendingPoints(27)
                        if(this.pbBaseStrength > pbBaseAbilityPoints && this.pbSpendingPoints != pbBaseSpendingPoints){
                            
                            //Subtract 1 from the current value of strength
                            this.pbBaseStrength -= 1;
                            
                            // Add the number of points we gained from retrieving this point based off the current Strength cost modifier we calculated earlier.
                            this.pbSpendingPoints += this.pbSTRcostMod;
                        }
                    
                    }  
                    
                    break;
                  
                case "Dexterity":
                    
                    calcPBCostMod("DEX");
                    
                    if(!this.isPBNegative){
                        
                        if(this.pbBaseDexterity < pbMaxAbility && this.pbSpendingPoints != 0){
                            
                            this.pbBaseDexterity += 1;
                            this.pbSpendingPoints -= this.pbDEXcostMod; 
                            
                        }
                        
                    }  else {
                        
                        if(this.pbBaseDexterity > pbBaseAbilityPoints && this.pbSpendingPoints != pbBaseSpendingPoints){
                            
                            this.pbBaseDexterity -= 1;
                            this.pbSpendingPoints += this.pbDEXcostMod;
                        }
                    
                    }  
                    
                    break;
                  
                case "Constitution":
                    
                    calcPBCostMod("CON");
                    
                    if(!this.isPBNegative){
                        
                        if(this.pbBaseConstitution < pbMaxAbility && this.pbSpendingPoints != 0){
                            
                            this.pbBaseConstitution += 1;
                            this.pbSpendingPoints -= this.pbCONcostMod;   
                            
                        }
                        
                    }  else {
                        
                        if(this.pbBaseConstitution > pbBaseAbilityPoints && this.pbSpendingPoints != pbBaseSpendingPoints){
                            
                            this.pbBaseConstitution -= 1;
                            this.pbSpendingPoints += this.pbCONcostMod;
                        }
                    
                    }  
                  
                    break;
                  
                case "Intelligence":
                    
                    calcPBCostMod("INT");
                    
                    if(!this.isPBNegative){
                        
                        if(this.pbBaseIntelligence < pbMaxAbility && this.pbSpendingPoints != 0){
                            
                            this.pbBaseIntelligence += 1;
                            this.pbSpendingPoints -= this.pbINTcostMod;   
                            
                        }
                        
                    }  else {
                        
                        if(this.pbBaseIntelligence > pbBaseAbilityPoints && this.pbSpendingPoints != pbBaseSpendingPoints){
                            
                            this.pbBaseIntelligence -= 1;
                            this.pbSpendingPoints += this.pbINTcostMod;
                        }
                    
                    }  
                  
                    break;
                  
                case "Wisdom":
                    
                    calcPBCostMod("WIS");
                    
                    if(!this.isPBNegative){
                        
                        if(this.pbBaseWisdom < pbMaxAbility && this.pbSpendingPoints != 0){
                            
                            this.pbBaseWisdom += 1;
                            this.pbSpendingPoints -= this.pbWIScostMod;   
                            
                        }
                            
                        
                    }  else {
                        
                        if(this.pbBaseWisdom > pbBaseAbilityPoints && this.pbSpendingPoints != pbBaseSpendingPoints){
                            
                            this.pbBaseWisdom -= 1;
                            this.pbSpendingPoints += this.pbWIScostMod;
                        }
                    
                    }  
                  
                    break;
                  
                case "Charisma":
                    
                    calcPBCostMod("CHA");
                    
                    if(!this.isPBNegative){
                        
                        if(this.pbBaseCharisma < pbMaxAbility && this.pbSpendingPoints != 0){
                            
                            this.pbBaseCharisma += 1;
                            this.pbSpendingPoints -= this.pbCHAcostMod;   
                            
                        }
                        
                    }  else {
                        
                        if(this.pbBaseCharisma > pbBaseAbilityPoints && this.pbSpendingPoints != pbBaseSpendingPoints){
                            
                            this.pbBaseCharisma -= 1;
                            this.pbSpendingPoints += this.pbCHAcostMod;
                        }
                    
                    }  
                  
                    break;
                    
                case "":
                    totalAbilities(1);
                    break;
                    
                
          
          }
          
      
          this.totalAbilities(1);
          this.calcAbilityScoreMods();
      
      
      }
   
       
   private void initializePB(){
       /*
       Here we set the default values so the point buy system can function correctly.
       */
       
       // Checking to see if this is the first time the point buy system has been ran
         if(isPBFirstRun){
          
        // If it is the first time set all the ability scores to their base(8) stat
        
          this.pbBaseStrength = pbBaseAbilityPoints;
          this.pbBaseDexterity = pbBaseAbilityPoints;
          this.pbBaseConstitution = pbBaseAbilityPoints;
          this.pbBaseIntelligence = pbBaseAbilityPoints;
          this.pbBaseWisdom = pbBaseAbilityPoints;
          this.pbBaseCharisma = pbBaseAbilityPoints;
          
          
         this.strength = 0 ;
         this.dexterity = 0;
         this.constitution = 0;
         this.intelligence = 0;
         this.wisdom = 0;
         this.charisma = 0;

          // Set the current spending points to the base(27) starting stat of points.
          this.pbSpendingPoints = pbBaseSpendingPoints;
          
          
          //Set all ability cost modifiers to 1
          this.pbSTRcostMod = 1;
          this.pbDEXcostMod = 1;
          this.pbCONcostMod = 1;
          this.pbINTcostMod = 1;
          this.pbWIScostMod = 1;
          this.pbCHAcostMod = 1;
          
          //Set first run to false after everything has been initialized for the first time.
          this.isPBFirstRun = false;
          this.isSTDFirstRun = true;
      
      } 
   
   
   }
      
   private String findPoint(String user, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma){
      /*
       Here we find the corresponding ability score in which we want to modify.
       We're accepting parameters from the point buy method which only tells us where to add or subtract 1.
       
       
       */
       
       
      // Declare a new Array of 6 elements to represent the six ability score stats.
       int[] point = new int[6];
       
       //Set the elements to their corresponding incoming values to find which stat we need to modify.
       point[0] = strength;
       point[1] = dexterity;
       point[2] = constitution;
       point[3] = intelligence;
       point[4] = wisdom;
       point[5] = charisma;
       
       switch(user){
           case "pb":
               
                            // Loop through the array 
                    for(int i=0;i<6;i++){

                        //Once the stat to modify is found we need to know whether it was an addition or subtraction 
                        // Indicated by a 1 and an -1 to let us know how to modify that stat.


                        //If the ability found was positive
                        if(point[i] == 1){

                            // We let our point buy system know the next incoming stat is +1
                            this.isPBNegative = false;

                            //Finally we use our index of where the ability score was modified as a key in our HashMap to get the 
                            //String name of the corresponding stat we want to modify and return it so it can be used in our switch inside the point buy system
                            return abilities.get(i);

                        }

                        // IF the ability found was negative
                        if(point[i] == -1){

                           // We again let our point buy system know the next incoming stat is -1
                           this.isPBNegative = true;

                           // We again use our index as a key in the HashMap to determine the name of the stat we need to modify.
                           return abilities.get(i);


                        }

                    }
               
               
               
               break;
               
           case "lb":
                // Loop through the array 
       for(int i=0;i<6;i++){
           
                    //Once the stat to modify is found we need to know whether it was an addition or subtraction 
                    // Indicated by a 1 and an -1 to let us know how to modify that stat.


                    //If the ability found was positive
                    if(point[i] == 1){

                        // We let our point buy system know the next incoming stat is +1
                        this.isLBNegative = false;

                        //Finally we use our index of where the ability score was modified as a key in our HashMap to get the 
                        //String name of the corresponding stat we want to modify and return it so it can be used in our switch inside the point buy system
                        return abilities.get(i);

                    }

                    // IF the ability found was negative
                    if(point[i] == -1){

                       // We again let our point buy system know the next incoming stat is -1
                       this.isLBNegative = true;

                       // We again use our index as a key in the HashMap to determine the name of the stat we need to modify.
                       return abilities.get(i);


                    }

                }
               
               
               
               
               break;
                      
           
           
       }
       
       
       
 
       
       // We should never hit this return .
      return "";
   }
   
   private void totalAbilities(int switchCase){
       
            switch(switchCase){
                
                case 1:    
                    //Point Buy + Racial Bonuses + SubRacials + Level Bonus
                    this.strength = this.pbBaseStrength + this.rbStrength + this.srbStrength + this.lbStrength;
                    this.dexterity = this.pbBaseDexterity + this.rbDexterity + this.srbDexterity + this.lbDexterity;
                    this.constitution = this.pbBaseConstitution + this.rbConstitution + this.srbConstitution + this.lbConstitution;
                    this.intelligence = this.pbBaseIntelligence + this.rbIntelligence + this.srbIntelligence + this.lbIntelligence;
                    this.wisdom = this.pbBaseWisdom + this.rbWisdom + this.srbWisdom + this.lbWisdom;
                    this.charisma = this.pbBaseCharisma + this.rbCharisma + this.srbCharisma + this.lbCharisma;
                    break;
            
                case 2:
                    
                    this.stdBaseStrength = this.stdAbilityScores[0];
                    this.stdBaseDexterity = this.stdAbilityScores[1];
                    this.stdBaseConstitution = this.stdAbilityScores[2];
                    this.stdBaseIntelligence = this.stdAbilityScores[3];
                    this.stdBaseWisdom = this.stdAbilityScores[4];
                    this.stdBaseCharisma = this.stdAbilityScores[5];
                   
                    //Standard + Racial Bonuses + SubRacials + Level Bonus
                    this.strength = this.stdBaseStrength + this.rbStrength + this.srbStrength + this.lbStrength;
                    this.dexterity = this.stdBaseDexterity + this.rbDexterity + this.srbDexterity + this.lbDexterity;
                    this.constitution = this.stdBaseConstitution + this.rbConstitution + this.srbConstitution + this.lbConstitution;
                    this.intelligence = this.stdBaseIntelligence + this.rbIntelligence + this.srbIntelligence + this.lbIntelligence;
                    this.wisdom = this.stdBaseWisdom + this.rbWisdom + this.srbWisdom + this.lbWisdom;
                    this.charisma = this.stdBaseCharisma + this.rbCharisma + this.srbCharisma + this.lbCharisma;
                    break;
                    
                    
                 
            }
        
   }
   
   private void calcPBCostMod(String mod){
       
       /*
       Here we calculate the cost modifier of spending or gaining one point in the point buy system
       The chart:
       
       Ability Score Point Cost
       Score    Cost   
       8        0
       9        1
       10       2
       11       3
       12       4
       13       5
       14       7
       15       9
       
       Every case below works on the same logic for each individual ability score.
       
       */
       
       // We switch based on which modifier we are trying to calculate walking through the first case as an example
       switch(mod){
           
           // For our strength modifier
           case "STR":
               
               // If the current strength value is greater than or equal to 13 (the point where abilities start costing two points instead of 1) and the strength cost modifier is currently
               // set to 1
                if(this.pbBaseStrength >= 13 && this.pbSTRcostMod == 1){
                    
                    // Add on to the strength cost modifier
                     pbSTRcostMod += 1;
                }
                
                
                //If the current strength value is less than 13 (every point under 13 costs +- 1) and the strength cost modifier is currently at 2
                if(this.pbBaseStrength < 13 && this.pbSTRcostMod == 2){
                    
                    // Subtract 1 from our strength cost modifier 
                    pbSTRcostMod -= 1;
                }
                
                break;
                
                
           case "DEX":
               
                if(this.pbBaseDexterity >= 13 && this.pbDEXcostMod == 1){
                    pbDEXcostMod += 1;
                }
               
                if(this.pbBaseDexterity < 13 && this.pbDEXcostMod == 2){
                    pbDEXcostMod -= 1;
                }
                
               break;
               
           case "CON":  
               
                if(this.pbBaseConstitution >= 13 && this.pbCONcostMod == 1){
                    pbCONcostMod += 1;
                }
                
                if(this.pbBaseConstitution < 13 && this.pbCONcostMod == 2){
                    pbCONcostMod -= 1;
                }
                break;
          
           case "INT":
               
                if(this.pbBaseIntelligence >= 13 && this.pbINTcostMod == 1){
                    pbINTcostMod += 1;
                }
                
                if(this.pbBaseIntelligence < 13 && this.pbINTcostMod == 2){
                    pbINTcostMod -= 1;
                }
                 
               break;
               
           case "WIS":
               
                 if(this.pbBaseWisdom >= 13 && this.pbWIScostMod == 1){
                     pbWIScostMod += 1;
                 }
                 
                if(this.pbBaseWisdom < 13 && this.pbWIScostMod == 2){
                    pbWIScostMod -= 1;
                }
                 break;
                 
           case "CHA":
               
                if(this.pbBaseCharisma >= 13 && this.pbCHAcostMod == 1){
                    pbCHAcostMod += 1;
                }
                
                if(this.pbBaseCharisma < 13 && this.pbCHAcostMod == 2){
                    pbCHAcostMod -= 1;
                }
                
                break;
                
       }
       
       
       
       
   }
   
   
   //Standard and Random System
   public void Standard(int position, int direction){
       /*
        Directions 1 = up
                  -1 = down
                  
        Position = Stat location in the array
       
        Stat location reference:
        0 = Strength
        1 = Dexterity
        2 = Constitution
        3 = Intelligence
        4 = Wisdom
        5 = Charisma
       
       */
       
       int tempPosition;

       
       this.initializeStandard();
       this.calcRacialBonuses(this.characterSheet.getRaceID());
       
       switch(direction){
           
           case 1:
               
               if(position != 0){
                   
                  tempPosition = this.stdAbilityScores[position-1];
                  this.stdAbilityScores[position-1] = this.stdAbilityScores[position];
                  this.stdAbilityScores[position] = tempPosition;
                  
               } else {
                   
                  tempPosition = this.stdAbilityScores[5];
                  this.stdAbilityScores[5] = this.stdAbilityScores[0];
                  this.stdAbilityScores[0] = tempPosition;
               
               
               }
               
               break;
               
           case -1:
               
               if(position != 5){
                   
                  tempPosition = this.stdAbilityScores[position+1];
                  this.stdAbilityScores[position+1] = this.stdAbilityScores[position];
                  this.stdAbilityScores[position] = tempPosition;
                  
               } else {
                   
                  tempPosition = this.stdAbilityScores[0];
                  this.stdAbilityScores[0] = this.stdAbilityScores[5];
                  this.stdAbilityScores[5] = tempPosition;
               
               
               }
               break;
                   
           case 0:
               
               break;
       
       
       }
       
       this.totalAbilities(2);
       this.calcAbilityScoreMods();
   
   
   }
   
   public void RandomizeStandard(){
       
       /*
        Handbook states to randomize stats that you take roll 4d6 and keep the highest three rolls
       add them together and write that number next to an ability, doing this 6 total times for one number
       next to each ability.
       
       */
       
       
       int[] tempHigh = new int[4];
       int temp = 0;
       
  
     
      Dice dice = new Dice(1,6);

      
      //Rolling and keeping for each stat 
      for(int k=0;k<6;k++) {
         
          
          // Roll 4 times
            for(int i=0;i<4;i++){

    
                
                tempHigh[i] = dice.getResult();
              
               
                }
            
            // Ensure we're only keeping the top 3 rolls
            for(int j=0;j<4;j++){

                if(j != 3){

                  if(tempHigh[j] < tempHigh[j+1]){

                      temp = tempHigh[j+1];

                      tempHigh[j+1] = tempHigh[j];
                      tempHigh[j] = temp;
                  }
                }
              }

            
            // Add the rolls together and then assign the result to an ability
            this.stdAbilityScores[k] = tempHigh[0] + tempHigh[1] + tempHigh[2];
            
            
            //Erase the rolls.
            for(int l=0;l<4;l++){
                tempHigh[l] = 0;
            }
   

      }
       
   
   
   
   }
   
   private void initializeStandard(){
       
        if(this.isSTDFirstRun){
            
          this.stdAbilityScores = this.baseSTDScores.clone();  
          
          this.stdBaseStrength = this.stdAbilityScores[0];
          this.stdBaseDexterity = this.stdAbilityScores[1];
          this.stdBaseConstitution = this.stdAbilityScores[2];
          this.stdBaseIntelligence = this.stdAbilityScores[3];
          this.stdBaseWisdom = this.stdAbilityScores[4];
          this.stdBaseCharisma = this.stdAbilityScores[5];
          
         this.strength = 0 ;
         this.dexterity = 0;
         this.constitution = 0;
         this.intelligence = 0;
         this.wisdom = 0;
         this.charisma = 0;
          
       
          
          //Set first run to false after everything has been initialized for the first time.
          this.isSTDFirstRun = false;
          this.isPBFirstRun = true;
      
      } 
   
   
   
   
   }
   
   //Level Bonus
    private void LevelBonus(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma){
       
        this.initializeLB();
        
        
          switch(findPoint("lb",strength,dexterity,constitution,intelligence,wisdom,charisma)){
              
            
              
                case "Strength":
                    
               
                    if(!this.isLBNegative){
                        
                        
                        if(this.lbSpendingPoints != 0){
                            
                         
                            this.lbStrength++;
                            
                        
                            this.lbSpendingPoints--;
                            
                        }
                        
                      
                    }  else {
                        
                        
                       
                      if(this.lbSpendingPoints < this.LBMap.get(characterSheet.getLevel()) && this.lbStrength > 0){
                         // if(this.lbSpendingPoints < 2 && this.lbStrength > 0){
                            
                           
                            this.lbStrength--;
                            
                       
                            this.lbSpendingPoints++;
                        }
                    
                    }  
                    
                    
                    
                    break;
                  
                case "Dexterity":
                    
                      if(!this.isLBNegative){
                        
                        
                        if(this.lbSpendingPoints != 0){
                            
                         
                            this.lbDexterity++;
                            
                        
                            this.lbSpendingPoints--;
                            
                        }
                        
                      
                    }  else {
                        
                        
                       
                        if(this.lbSpendingPoints < this.LBMap.get(characterSheet.getLevel()) && this.lbDexterity > 0){
                      //    if(this.lbSpendingPoints < 2 && this.lbDexterity > 0){
                            
                           
                            this.lbDexterity--;
                            
                       
                            this.lbSpendingPoints++;
                        }
                    
                    }  
                    
                   
                    break;
                  
                case "Constitution":
                    
                     if(!this.isLBNegative){
                        
                        
                        if(this.lbSpendingPoints != 0){
                            
                         
                            this.lbConstitution++;
                            
                        
                            this.lbSpendingPoints--;
                            
                        }
                        
                      
                    }  else {
                        
                        
                       
                     if(this.lbSpendingPoints < this.LBMap.get(characterSheet.getLevel()) && this.lbConstitution > 0){
                        //  if(this.lbSpendingPoints < 2 && this.lbConstitution > 0){
                            
                           
                            this.lbConstitution--;
                            
                       
                            this.lbSpendingPoints++;
                        }
                    
                    }  
                    
                  
                    break;
                  
                case "Intelligence":
                    
                     if(!this.isLBNegative){
                        
                        
                        if(this.lbSpendingPoints != 0){
                            
                         
                            this.lbIntelligence++;
                            
                        
                            this.lbSpendingPoints--;
                            
                        }
                        
                      
                    }  else {
                        
                        
                       
                        if(this.lbSpendingPoints < this.LBMap.get(characterSheet.getLevel()) && this.intelligence > 0){
                        //  if(this.lbSpendingPoints < 2 && this.lbIntelligence > 0){
                            
                           
                            this.lbIntelligence--;
                            
                       
                            this.lbSpendingPoints++;
                        }
                    
                    }  
                    
                  
                    break;
                  
                case "Wisdom":
                    
                     if(!this.isLBNegative){
                        
                        
                        if(this.lbSpendingPoints != 0){
                            
                         
                            this.lbWisdom++;
                            
                        
                            this.lbSpendingPoints--;
                            
                        }
                        
                      
                    }  else {
                        
                        
                       
                        if(this.lbSpendingPoints < this.LBMap.get(characterSheet.getLevel()) && this.lbStrength > 0){
                          //if(this.lbSpendingPoints < 2 && this.lbWisdom > 0){
                            
                           
                            this.lbWisdom--;
                            
                       
                            this.lbSpendingPoints++;
                        }
                    
                    }  
                    
                  
                    break;
                  
                case "Charisma":
                    
                    if(!this.isLBNegative){
                        
                        
                        if(this.lbSpendingPoints != 0){
                            
                         
                            this.lbCharisma++;
                            
                        
                            this.lbSpendingPoints--;
                            
                        }
                        
                      
                    }  else {
                        
                        
                       
                        if(this.lbSpendingPoints < this.LBMap.get(characterSheet.getLevel()) && this.lbStrength > 0){
//                          if(this.lbSpendingPoints < 2 && this.lbCharisma > 0){
                            
                           
                            this.lbCharisma--;
                            
                       
                            this.lbSpendingPoints++;
                        }
                    
                    } 
                   
                  
                    break;
                    
                case "":
                    
                    break;
                    
                
          
          }
          
      
         
      
      
      }
    
    
    private void initializeLB(){
        
       if(isLBFirstRun){
        this.lbSpendingPoints = LBMap.get(this.characterSheet.getLevel());


        this.lbStrength = 0 ;
        this.lbDexterity = 0;
        this.lbConstitution = 0;
        this.lbIntelligence = 0;
        this.lbWisdom = 0;
        this.lbCharisma = 0;
        
        this.isLBFirstRun = false;
       }
       
    }
   

   private void calcRacialBonuses(int id){
       
       if(!racialsCalculated){
       
            Race racialBonuses = this.race.getRace(id);
            String switchCase;
            int bonus;

            for(int i=0;i<6;i++){
                
                if(racialBonuses.subRacialASBonuses != null && racialBonuses.subRacialASBonuses[i] > 0){

                    switchCase = abilities.get(i);
                    bonus = racialBonuses.subRacialASBonuses[i];


                    switch(switchCase){


                        case "Strength":
                            this.srbStrength = bonus;
                            break;

                        case "Dexterity":
                            this.srbDexterity = bonus;
                            break;

                        case "Constitution":
                            this.srbConstitution = bonus;
                            break;

                        case "Intelligence":
                            this.srbIntelligence = bonus;
                            break;

                        case "Wisdom":
                            this.srbWisdom = bonus;
                            break;

                        case "Charisma":
                            this.srbCharisma = bonus;
                            break;


                    }


                }


            

                if(racialBonuses.racialASBonuses[i] > 0){

                    switchCase = abilities.get(i);
                    bonus = racialBonuses.racialASBonuses[i];


                    switch(switchCase){


                        case "Strength":
                            this.rbStrength = bonus;
                            break;

                        case "Dexterity":
                            this.rbDexterity = bonus;
                            break;

                        case "Constitution":
                            this.rbConstitution = bonus;
                            break;

                        case "Intelligence":
                            this.rbIntelligence = bonus;
                            break;

                        case "Wisdom":
                            this.rbWisdom = bonus;
                            break;

                        case "Charisma":
                            this.rbCharisma = bonus;
                            break;


                    }


                }


            }
            
            racialsCalculated = true;

           }

   
   
   
   }
   
   private void calcAbilityScoreMods(){
       
       //This method does the calculations needed to set the ability score modifier based on the current ability score.
     
   
      this.STRmod = this.asModMap.get(this.strength);
      this.DEXmod = this.asModMap.get(this.dexterity);
      this.CONmod = this.asModMap.get(this.constitution);
      this.INTmod = this.asModMap.get(this.intelligence);
      this.WISmod = this.asModMap.get(this.wisdom);
      this.CHAmod = this.asModMap.get(this.charisma);
       
   
   
   }
   
   private void buildASModMap(){
    /*
       Ability Score Mod Chart:
       
       1        -5
       2-3      -4
       4-5      -3
       6-7      -2
       8-9      -1
       10-11    +0
       12-13    +1
       14-15    +2
       16-17    +3
       18-19    +4
       20-21    +5
       22-23    +6
       24-25    +7
       26-27    +8
       28-29    +9
       30       +10
       
       
       This method builds this ability score modifier chart into a hash map so we have easy access to finding out what the current
       ability score modifier should be
       
       */
    
       int currMod = -5;
       
       
       
       for(int i=1;i<30;i++){
           
           this.asModMap.put(i, currMod);
            if(i % 2 == 1){
               currMod += 1;
           } 
       
       }
       
       this.asModMap.put(30, 10);
   
   
   
   }
   
   private void buildLBMAp(){
   /*
        Every 4 levels you get 2 points to spend 
        */
        int modCount = 0;
        int quarter = 0;
       
        for(int i=1;i<21;i++){
            if(i % 2 == 0){
                modCount++;
            }
            if(modCount == 2){
                quarter +=2;
                modCount = 0;
            }
             this.LBMap.put(i, quarter);
        
        
        }
   }
        
        
    private void buildAbilityMap(){
        
        

        abilities.put(0, "Strength");
        abilities.put(1, "Dexterity");
        abilities.put(2, "Constitution");
        abilities.put(3, "Intelligence");
        abilities.put(4, "Wisdom");
        abilities.put(5, "Charisma");
    
       
    }
       
    public int getConBonus(){
        return this.CONmod;
   }

}


   
   
   
   
   

   
 
   
   
   
                

