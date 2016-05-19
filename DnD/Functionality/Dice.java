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
package DnD.Functionality;

import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Bonajokin
 */


public class Dice {


   // Variables holding the number of dice needed to be rolled, how many sides the dice containts such as d4 etc, and finally a variable storing our roll results.
    int numDie;
    int numSides;
    int result;
    
    
    //Constructor which requires the number of dice needed to be rolled and how many sides the die contain.
    public Dice(int nDice, int nSides){
            
            numDie = nDice;
            numSides = nSides;
            result = 0;    

        
    }
    
    
    //Our method which rolls correct number and type of dice which is needed for said dice object. With roll protection included.
    private void roll(){
        
        if(numDie <= 1){
            
            result = ThreadLocalRandom.current().nextInt(1, numSides + 1);
            
        } else {
            
            result = 0;
                 
            for(int i=0;i<numDie;i++){
                result +=  result = ThreadLocalRandom.current().nextInt(1, numSides + 1);
            }
        
        }
        
        
    }
    
    //This method gets the results of the dice roll(s) and returns the total result to the caller.
    
    public int getResult(){

            roll();
            
            return result;

        
    }
    

   


    
    
    
}