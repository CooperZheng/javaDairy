package com.qianfeng.MementoTest;
//发起人角色类，发起人角色利用一个新创建的备忘录对象将自己的内部状态存储起来。
public class Originator {
/*    private String state;
    //工厂方法，返回一个新的备忘录对象
    public Memento createMemento() {
        return new Memento(state);
    }
   // 将发起人的状态恢复到备忘录对象所记录的状态
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }*/

    private String state;
   //将发起人的状态恢复到备忘录对象所记录的状态
    public void restoreMemento(MementoIF memento) {
        this.state = ((Memento)memento).getState();
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }
   // 工厂方法，返回一个新的备忘录对象
    public MementoIF createMemento() {
        return new Memento(this.state);
    }

    private class Memento implements MementoIF {
        private String state;
        //构造方法
        private Memento(String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
    }
}
