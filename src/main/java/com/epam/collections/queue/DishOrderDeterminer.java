package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>(numberOfDishes);

        int counter = 0;
        int index = -1;

        while (list.size() < numberOfDishes){
            counter++;
            index++;

            if(index == queue.size()){
                index = 0;
            }

            if(counter == everyDishNumberToEat){
                list.add(queue.get(index));
                queue.remove(index);
                counter = 0;
                index--;
            }
        }

        return list;
    }
}
