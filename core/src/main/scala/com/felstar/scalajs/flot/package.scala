package com.felstar.scalajs

import scalajs.js
//import org.scalajs.dom._
import js.Dynamic.literal
import scalajs.js.JSConverters._

package object flot {

  type Point= Tuple2[Double,Double]
  type PointArray=js.Array[Double]
  type SeriesData=js.Array[PointArray]
  
  def toPointArray(t:Point):PointArray=js.Array(t._1,t._2)    
  def series(points:Point*):SeriesData= points.toJSArray.map(toPointArray)
  def plot(el:js.Any,data: js.Any,options:js.Dynamic):Plot = jQuery.plot(el, data, options)
}