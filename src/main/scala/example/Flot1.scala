package example

//import org.scalajs.dom
//import org.scalajs.dom.html._
import scalajs.js
import scalajs.js.annotation.JSExport
import js.Dynamic.literal
import com.felstar.scalajs.flot._
import scalajs.js.JSNumberOps._

@JSExport
object Flot1 extends {  
    
  @JSExport
  def main(el:String):Unit = {
        
   //def $(sel:String)=dom.document.querySelector(sel).asInstanceOf[Element]
   //def $$(sel:String)=dom.document.querySelectorAll(sel)
   
     // raw series data for 1st series, then more detailed series 
   val data=js.Array(series(0.0->0.2,0.5->0.4,1.0->1),
                     literal(color="red",                             
                             label="2nd series",
                             data=series(0.1->0.2,0.4->0.4,1.1->1.7)),
                     literal(color="blue",                             
                             label="3nd series",
                             data=series(0.1->0.1,0.4->0.3,1.1->1.5)))                                                                        
                             
   val show=literal(show=true)
   val hide=literal(show=false) 
   
   val labelF: (String,js.Dynamic)=>String=(label, series)=>
     s"""<a href="#$label">$label!</a>"""   
   
     // axis dynamic, for now, obv should make more type safe later
   val tickF: (Double,js.Dynamic)=>String=(tick, axis)=>
     //f"""$tick%2.2f!"""
     tick.toFixed(axis.tickDecimals.asInstanceOf[Int])+"!"
     
   val options=literal(lines=show,
                       points=show,
                       legend=literal(labelFormatter=labelF),
                       xaxis=literal(tickFormatter=tickF,tickColor="green",tickDecimals=2))
   
   plot(el,data,options)   
  }
  
  @JSExport
  def main2(el:String):Unit = {
        
   val x=(0.0 to 2 by 0.05).map(_*Math.PI)
    // currently a bug https://github.com/scala-js/scala-js/issues/1974 with ranges ending in non integer  
  
   val y=x.map(Math.sin)
    
   import scalajs.js.JSConverters._
   val seriesData=x.zip(y).toJSArray.map(toPointArray)
    
   val data=js.Array(seriesData)                            
   
   plot(el,data,null)   
  }
}