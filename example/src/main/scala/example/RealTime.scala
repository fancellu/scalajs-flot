package example

import org.scalajs.dom
import org.scalajs.dom.html._
import scalajs.js
import scalajs.js.annotation.JSExport
import js.Dynamic.literal
import com.felstar.scalajs.flot._
import scalajs.js.JSConverters._

@JSExport
object RealTime extends {  
    
  @JSExport
  def main():Unit = {

    val startLen=100
    
    var nextX:Double=startLen
    
    var lastY:Double=50
    
    val xx=(1 to startLen).toArray.toJSArray.map(_.toDouble)
    
    val maxSeriesData:js.Array[PointArray]=xx.map(x=> x->lastY ).map(toPointArray)          
    
    val data=js.Array(literal(data=maxSeriesData,label="Streaming Data") )
    
    val options=literal(lines=literal(show=true,fill=true),                       
                       series=literal(shadowSize=0),
                       grid=literal(clickable=true,backgroundColor=literal(colors=js.Array("#FFF","#999"))))
    val currentPlot:Plot=plot("#placeholder",data,options)  
    
    def run()={
      nextX+=1
      lastY+=(scala.util.Random.nextDouble()-0.5)*10.0      
      
      maxSeriesData.shift()                 
      maxSeriesData.push(toPointArray(nextX,lastY))      

      currentPlot.setData(data)
      currentPlot.setupGrid()
      currentPlot.draw()
    }
    
    dom.window.setInterval(run _, 100)    
  }
}