package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(Objects.requireNonNull(firstQueue.poll()));
        arrayDeque.add(Objects.requireNonNull(firstQueue.poll()));
        arrayDeque.add(Objects.requireNonNull(secondQueue.poll()));
        arrayDeque.add(Objects.requireNonNull(secondQueue.poll()));

        Queue<Integer> queue = firstQueue;
        boolean swap = false;

        while (!queue.isEmpty()){

            queue.add(arrayDeque.removeLast());

            Integer item = queue.poll();
            if(item == null) continue;
            arrayDeque.add(item);

            item = queue.poll();
            if(item == null) continue;
            arrayDeque.add(item);

            queue = swap ? firstQueue : secondQueue;
            swap = !swap;
        }

        return arrayDeque;
    }
}
