package StackImplementation;

import java.util.ArrayList;
import java.util.List;

//
//push, pop, count, isempty
//        o(1)

public class StackImplementation<T> {

    List<T> stackList = new ArrayList<T>();

    public void push(T object) {
        this.stackList.add(object);
    }

    public T pop() {
        T temp = this.stackList.get(this.stackList.size()-1);
        this.stackList.remove(this.stackList.size()-1);
        return temp;
    }

    public int count() {
        return this.stackList.size();
    }

    public boolean isempty() {
        if (this.stackList.size()!=0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StackImplementation<Integer> stack = new StackImplementation<Integer>();
        stack.push(1);
        Integer a =stack.pop();
        System.out.println("value popped = "+a);
        System.out.println("is the stack empty ="+stack.isempty());
        stack.push(2);
        stack.push(3);
        System.out.println("value popped = "+stack.pop());
        System.out.println("value popped = "+stack.pop());
        System.out.println("is the stack empty ="+stack.isempty());
    }



}
