import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

class CommandStack {
  private Diagram _diagram;
  private Vector _undo = new Vector();
  private Vector _redo = new Vector();
  private java.awt.List _list;


  public CommandStack(Diagram d, java.awt.List list) {
    this._diagram = d;
    this._list = list;
  }

  public void clearStack() {
    this.clearUndo();
    this.clearRedo();
    this.printStack();

  }

  public void clearUndo() {
    this._undo.clear();
  }

  public void clearRedo() {
    this._redo.clear();
  }

  public void undo() {
    if (this._undo != null && this._undo.size() > 0) {
      Object undoObject = this._undo.lastElement();
      this._undo.remove(undoObject);
      if (undoObject instanceof Shape) {
      	System.out.println("undo shape");
        this._redo.add(undoObject);
        this._diagram.remove((Shape) undoObject);
      } else if (undoObject instanceof Memento) {
      	System.out.println("undo memento");
        this.rememberRedo(((Memento) undoObject).getShape());
        ((Memento) undoObject).restore();
      }
    } else {

    }

    this.printStack();
  }

  public void redo() {
    if (this._redo != null && this._redo.size() > 0) {
      Object redoObject = this._redo.lastElement();
      this._redo.remove(redoObject);
      if (redoObject instanceof Shape) {
        this.createShape(redoObject, false);
        this._diagram.add((Shape) redoObject);
      } else if (redoObject instanceof Memento) {
        this.remember(((Memento) redoObject).getShape(), false);
        ((Memento) redoObject).restore();
      }
    }

    this.printStack();
  }

  public void remember(Shape object, boolean clearRedo) {
    this._undo.addElement(new Memento(object));
    if (clearRedo)
      this.clearRedo();
    this.printStack();

  }

  public void rememberRedo(Shape object) {
    this._redo.addElement(new Memento(object));
    this.printStack();
  }

  public void createShape(Object object, boolean clearRedo) {
    this._undo.addElement(object);
    if (clearRedo)
      this.clearRedo();
    this.printStack();

  }

  public void printStack() {
    if (this._list != null) {
      this._list.removeAll();
      this._list.add("Undo: ");
      Enumeration enUndo = this._undo.elements();
      while (enUndo.hasMoreElements()) {
        this._list.add(enUndo.nextElement().toString());
      }

      this._list.add("Redo: ");
      Enumeration enRedo = this._redo.elements();
      while (enRedo.hasMoreElements()) {
        this._list.add(enRedo.nextElement().toString());
      }

    } else {
      System.out.println("Undo: ");
      Enumeration enUndo = this._undo.elements();
      while (enUndo.hasMoreElements()) {
        System.out.println(enUndo.nextElement().toString());
      }

      System.out.println("Redo: ");
      Enumeration enRedo = this._redo.elements();
      while (enRedo.hasMoreElements()) {
        System.out.println(enRedo.nextElement().toString());
      }
    }
  }
}
