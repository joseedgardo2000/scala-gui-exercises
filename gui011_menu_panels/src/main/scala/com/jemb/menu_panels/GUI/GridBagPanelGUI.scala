package com.jemb.menu_panels.GUI

import scala.swing.{Action, Button, CheckBox, Dialog, GridBagPanel, Label, ScrollPane, Swing, TextArea, TextField, ToggleButton}

class GridBagPanelGUI extends Dialog{
  title = "GridBagPanel GUI"
  modal = true
  contents = new GridBagPanel{
    def constraints(x:Int, y:Int,      //ubicación dentro del grid
                    gridWidth:Int = 1, gridHeight:Int = 1,      //span
                    weightX:Double = 0.0, weightY:Double = 0.0, //resize
                    fill:GridBagPanel.Fill.Value = GridBagPanel.Fill.None
                   ): Constraints = {
      val c = new Constraints
      c.gridx = x
      c.gridy = y
      c.gridwidth = gridWidth
      c.gridheight = gridHeight
      c.weightx = weightX
      c.weighty = weightY
      c.fill = fill
      c
    }
    add(new Label("Label @ (0,0)") {border=Swing.EtchedBorder(Swing.Lowered) },
      constraints(0, 0, gridHeight=2, fill=GridBagPanel.Fill.Both))
    add(new ToggleButton("Button @ (2,0)"),
      constraints(2, 0))
    add(new Button("Button @ (2,1)"),
      constraints(2, 1))
    add(new Button("Button @ (2,2)"),
      constraints(2, 2))
    add(new CheckBox("Checkbox"),
      constraints(0, 2))
    add(new TextField { columns = 32 },
      constraints(1, 0, weightX=1.0, fill=GridBagPanel.Fill.Horizontal))
    add(new ScrollPane(new TextArea),
      constraints(1, 1, gridHeight=3, weightY = 1.0, fill=GridBagPanel.Fill.Both))
    add(new Button(Action("Cerrar") { dispose() }),
      constraints(0, 4, gridWidth=3, fill=GridBagPanel.Fill.Horizontal))
  }
  //--------- Metodos ----------

}
