/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public   class CardFactory {
   public static ArrayList<Card> cards=new ArrayList();
    
      
  public static void AddCard(Card Card){
      int y =75*(cards.size()+1);
 Card.setY(y);
 
  cards.add(Card);
      
  }
      
  
 
    
}
