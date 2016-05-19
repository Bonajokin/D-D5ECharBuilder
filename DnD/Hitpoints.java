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
public class Hitpoints {
    
    private int hitDieSides;
    private final int base;
    private int conBonus;
    private int racialBonus;
    private int maxHP;
    CharacterSheet characterSheet;
    
    public Hitpoints(CharacterSheet obj){
        this.characterSheet = obj;
        this.hitDieSides = 0;
        this.base = 0;
        this.conBonus = 0;
        this.racialBonus = 0;
    }

    public int getHitDieSides() {
        return hitDieSides;
    }

    public void setHitDieSides(int hitDieSides) {
        this.hitDieSides = hitDieSides;
    }

    public int getConBonus() {
        return conBonus;
    }

    public void setConBonus(int conBonus) {
        this.conBonus = conBonus;
    }

    public int getRacialBonus() {
        return racialBonus;
    }

    public void setRacialBonus(int racialBonus) {
        this.racialBonus = racialBonus;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    

    
    
}
