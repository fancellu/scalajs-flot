package com.felstar.scalajs.flot

import scala.scalajs.js

import js.annotation.JSName

@js.native
private object jQuery extends js.Object {
  def plot(el:js.Any,data: js.Any,options:js.Dynamic):Plot = js.native
}

@js.native
   class Item extends js.Object {
     def datapoint:js.Array[Double] =js.native // has 3 elements: x,y, and 0 (for some reason)
     def dataIndex:Int =js.native
     def series:js.Dynamic =js.native
     def seriesIndex:Int =js.native
     def pageX:Int =js.native
     def pageY:Int =js.native
   }

@js.native
   class Pos extends js.Object {
     def x:Double =js.native
     def y:Double =js.native     
     def pageX:Int =js.native
     def pageY:Int =js.native
   }

@js.native
   class FlotEvent extends js.Object {
     def `type`:String =js.native
     def timeStamp:Long =js.native     
     def isTrigger:Int =js.native     
   }

@js.native
   class Plot extends js.Object {
     def highlight(series:Int,datapoint:js.Array[Double]):Unit =js.native
     def highlight(series:js.Dynamic,datapoint:js.Array[Double]):Unit =js.native
     def highlight(series:Int,datapoint:Int):Unit =js.native
     def highlight(series:js.Dynamic,datapoint:Int):Unit =js.native
     
     def unhighlight(series:Int,datapoint:js.Array[Double]):Unit =js.native
     def unhighlight(series:js.Dynamic,datapoint:js.Array[Double]):Unit =js.native
     def unhighlight(series:Int,datapoint:Int):Unit =js.native
     def unhighlight(series:js.Dynamic,datapoint:Int):Unit =js.native
     def unhighlight():Unit =js.native
     
     def setData(data:js.Any):Unit =js.native
     def getData():js.Array[js.Dynamic] =js.native
     def setupGrid():Unit =js.native     
     def draw():Unit =js.native
     def triggerRedrawOverlay():Unit =js.native
     def width():Int =js.native
     def height():Int =js.native
     def offset():js.Object =js.native
     def resize():Unit =js.native
     def getAxes():js.Dynamic=js.native     
     def getPlaceholder():js.Dynamic=js.native
     def getCanvas():org.scalajs.dom.html.Canvas=js.native
     def getPlotOffset():PlotOffset=js.native
     def pointOffset(offset:js.Dynamic):PointOffset=js.native
     def getOptions():js.Dynamic=js.native
   }

@js.native
   class PointOffset extends js.Object {
    val left:Int=js.native
    val top:Int=js.native
}

@js.native
   class PlotOffset extends js.Object {
    val left:Int=js.native
    val right:Int=js.native
    val top:Int=js.native
    val bottom:Int=js.native
}