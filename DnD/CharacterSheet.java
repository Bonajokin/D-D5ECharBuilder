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
public class CharacterSheet {
    
    
    // Appearance and vitals
    private String name;
    private boolean isMale;
    private int height;
    private int weight;
    private int age;
    private int raceID;
    private String eyeColor;
    private String skinColor;
    private String hairColor;
    private String features;
    
 
    protected final AbilityScores abilities;
    protected final Hitpoints hitpoints;

    
    
    //Ability Scores 
    private int level;
    private String imgURL;
    private int expPoints;
    
    //Hitpoints
    private String className;
   
    
    
    
    

    public CharacterSheet() {
        this.name = "";
        this.isMale = true;
        this.height = 0;
        this.weight = 0;
        this.age = 0;
        this.eyeColor = "";
        this.skinColor = "";
        this.hairColor = "";
        this.features = "";
        this.level = 0;
        this.imgURL = "";
        this.expPoints = 0;
        this.raceID = 000;
        this.className = "";
        
        //Insert Background here
        
        //Insert Character Classes here later
      
       
       
        //Insert Hitpoints here later.
        this.abilities = new AbilityScores(this);
        this.hitpoints = new Hitpoints(this);
       
    }
    
    public String getClassName(){
        return className;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(int expPoints) {
        this.expPoints = expPoints;
    }


    
    
    

    
    public static void main(String[] args){
        CharacterSheet test = new CharacterSheet();
        test.setLevel(2);
        
       System.out.println(test.getLevel()); 
      //System.out.println(test.abilities.Standard(0, 0));
       
   
    
    
    
    
    }

    
    
    
    
}
