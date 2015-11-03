package example

import org.scalajs.dom
import org.scalajs.dom.html._
import dom.ext.Ajax
import scalajs.js
import scalajs.js.annotation.JSExport
import js.Dynamic.literal
import com.felstar.scalajs.flot._
import scalajs.js.JSNumberOps._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow
import org.scalajs.jquery.JQueryEventObject

@JSExport
object Time1 extends {  
    
  val weatherkey="4ef01dbbb326222af5ec69053f824bde"
  
  implicit class ToDynamicArray(dyn:js.Dynamic){      
      def toArray=dyn.asInstanceOf[js.Array[js.Dynamic]]
      def foreach(f: js.Dynamic=>Unit)=toArray.foreach(f)
      def map[B](f: js.Dynamic=>B)=toArray.map(f)
    }
  
  def getWeatherData()={
    val city="London"
    
     val fXHR = Ajax.get(s"http://api.openweathermap.org/data/2.5/forecast/daily?q=$city&cnt=7&appid=$weatherkey")

      fXHR.onSuccess { case xhr =>
          if (xhr.status == 200) {
            val json = js.JSON.parse(xhr.responseText)
                       
              def dt2Date(dt:js.Dynamic)=dt.asInstanceOf[Double]*1000
              def celsius(kelvins: js.Dynamic) = kelvins.asInstanceOf[Double] - 273.15
            
              val dateTemps=json.list.map{el=> (dt2Date(el.dt),celsius(el.temp.max),celsius(el.temp.min))}
             
              plotData(dateTemps)
          }
      }    
  }
  
  def plotData(tempData:js.Array[(Double,Double,Double)])={
                                                                         
    val maxSeriesData=tempData.map(t=>toPointArray(t._1,t._2))
    val minSeriesData=tempData.map(t=>toPointArray(t._1,t._3))
        
    val data=js.Array(literal(data=maxSeriesData,label="Max"),
                      literal(data=minSeriesData,label="Min"))
                    
   val options=literal(lines=literal(show=true,fill=true),
                       points=literal(show=true,radius=6),
                       xaxis=literal(mode="time",timeformat= "%d/%m/%y"),
                       grid=literal(clickable=true,backgroundColor=literal(colors=js.Array("#FFF","#999"))))
      
   var currentPlot:Plot=null                       
   var highlights:Set[Int]=Set.empty //flot doesn't expose list of current highlights, so must track them 
                       
   def listener2(event:FlotEvent,pos:Pos,item:Item)={
      
      if (item!=null){
        if (!highlights(item.dataIndex)){
         currentPlot.highlight(item.seriesIndex, item.dataIndex) 
         highlights+=item.dataIndex
        }         
        else{
          currentPlot.unhighlight(item.seriesIndex, item.dataIndex)
          highlights-=item.dataIndex
        }          
      }
    } 
    
   import org.scalajs.jquery.jQuery 
    
   jQuery("#placeholder").bind("plotclick",listener2 _)
                         
   currentPlot=plot("#placeholder",data,options)  
   
     // get PointOffet for 2nd date and y=5    
   val po=currentPlot.pointOffset(literal(x=tempData(1)._1,y=5))
     // draw a triangle via canvas context   
   val ctx=currentPlot.getCanvas().getContext("2d").asInstanceOf[org.scalajs.dom.raw.CanvasRenderingContext2D]
   ctx.beginPath()
     ctx.moveTo(po.left,po.top)
     ctx.lineTo(po.left+12.5,po.top)
     ctx.lineTo(po.left+12.5,po.top+22)
     ctx.fillStyle="#F00"
     ctx.fillText("Canvas drawing", po.left, po.top, 100)
   ctx.fill()   
  }
  
  @JSExport
  def main():Unit = getWeatherData()           
}