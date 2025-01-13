package com.estudosjava.exercicios.Library;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<ItemLibrary> items = new ArrayList<>();

    public void addNewItem(ItemLibrary newItem) throws ItemJaExisteException {
        for(ItemLibrary item : items){
            if(item.getId().equals(newItem.getId()))
                    throw new ItemJaExisteException("Ja existe um item com esse id");        }
        items.add(newItem);
    }

    public void removeItem(ItemLibrary itemToRemove) throws ItemNaoExisteException {
        if(!items.contains(itemToRemove))
            throw new ItemNaoExisteException("Item nao existente");
        items.remove(itemToRemove);
    }

    public void showItensLibrary(){
        for(ItemLibrary item : items){
            System.out.println(item);
        }
    }
}
