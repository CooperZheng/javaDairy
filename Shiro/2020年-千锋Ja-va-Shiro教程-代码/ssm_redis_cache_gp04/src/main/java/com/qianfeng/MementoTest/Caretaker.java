package com.qianfeng.MementoTest;
//负责人角色类，负责人角色类负责保存备忘录对象，但是从不修改（甚至不查看）备忘录对象的内容。
public class Caretaker {
/*    private Memento memento;
   // 备忘录的取值方法
    public Memento retrieveMenento() {
        memento.setState("fff");
        return this.memento;
    }
   //备忘录的赋值方法
    public void saveMemento(Memento memento) {
        this.memento = memento;
    }*/
    private MementoIF memento;
   // 备忘录的取值方法
    public MementoIF retrieveMenento() {
        return this.memento;
    }
    //备忘录的赋值方法
    public void saveMemento(MementoIF memento) {
        this.memento = memento;
    }
}
