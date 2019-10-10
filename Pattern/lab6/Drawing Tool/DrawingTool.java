/*
Author: Dr. Clarence Lau (swlau@vtc.edu.hk)
This program contains copyright materials.
This program should be used by students of the CMM3332 Object-oriented technology module.

All rights reserved.
*/

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.io.*;

public class DrawingTool extends JFrame {
  Diagram _diagram = new Diagram();
  java.awt.List _stackList = new java.awt.List();
  CommandStack _commandStack = new CommandStack(_diagram, _stackList);
  JToolBar _toolbar = new JToolBar();
  JButton _clearButton = new JButton("Clear");
  JButton _reloadButton = new JButton("Reload Config");
  //ShapeButton _shapeButton = new ShapeButton("CREATE Shape", "CreateShapeControl", _commandStack, _diagram);
  //ShapeButton _lineButton = new ShapeButton("CREATE PolyLine", "CreateLineControl", _commandStack, _diagram);
  JButton _undoButton = new JButton("Undo");
  JButton _redoButton = new JButton("Redo");
  Vector _shapeButton = new Vector();

  DrawingPanel _panel = new DrawingPanel(_diagram, _commandStack, _stackList);

  //PanelControl _createShapeControl = new CreateShapeControl(_commandStack, _diagram);
  //PanelControl _createLineControl = new CreateLineControl(_commandStack, _diagram);

  public DrawingTool() {

    this._clearButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        _diagram.clear();
        _commandStack.clearStack();
        _panel.repaint();
      }
    });

    this._reloadButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        loadConfig();
      }
    });

    //this._shapeButton.addActionListener(al);
    //this._lineButton.addActionListener(al);

    this._undoButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        _commandStack.undo();
        _panel.repaint();
      }
    });

    this._redoButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        _commandStack.redo();
        _panel.repaint();
      }
    });

    loadConfig();


    this.getContentPane().setLayout(new java.awt.BorderLayout());
    this.getContentPane().add(java.awt.BorderLayout.NORTH, _toolbar);
    this.getContentPane().add(java.awt.BorderLayout.CENTER, _panel);
    this.getContentPane().add(java.awt.BorderLayout.EAST, this._stackList);
    this.setBounds(0, 0, 400, 400);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new DrawingTool();
  }

  public void loadConfig()
  {
    _toolbar.removeAll();
    _shapeButton.clear();
    FileInputStream fis;
    StreamTokenizer str;
    try {
      fis = new FileInputStream("config.txt");
      str = new StreamTokenizer(fis);
      while (str.nextToken() != str.TT_EOF) {
        String label = str.sval;
        str.nextToken();
        String controlClassName  = str.sval;
        _shapeButton.add(new ShapeButton(label, controlClassName, _commandStack, _diagram));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    ActionListener al = new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        _panel.setControl(((ShapeButton) e.getSource()).getControl());
      }
    };

    for (int i = 0; i < _shapeButton.size(); i++)
    {
      ((ShapeButton) _shapeButton.elementAt(i)).addActionListener(al);
    }

        _toolbar.add(this._clearButton);
    //_toolbar.add(this._shapeButton);
    for (int i = 0; i < _shapeButton.size(); i++)
      _toolbar.add((ShapeButton) _shapeButton.elementAt(i));
    //_toolbar.add(this._lineButton);
    _toolbar.add(this._undoButton);
    _toolbar.add(this._redoButton);
    _toolbar.add(this._reloadButton);
  }
}
