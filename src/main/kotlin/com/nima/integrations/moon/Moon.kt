package com.nima.integrations.moon

/*
{
    "Error":0,
    "ErrorMsg":"success",
    "TargetDate":"486886100",
    "Moon":["Honey Moon"],
    "Index":18,
    "Age":18.162976303061267,
    "Phase":"Waning Gibbous",
    "Distance":381625.36,
    "Illumination":0.87,
    "AngularDiameter":0.521868244934728,
    "DistanceToSun":1.5181602606764594E8,
    "SunAngularDiameter":0.5253407770828018
}
 */
data class Moon(
    val Error:Int,
    val ErrorMsg:String,
    val TargetDate:String,
    val Moon: List<String>,
    val Index:Int,
    val Age: Double,
    val Phase: String,
    val Distance: Double,
    val Illumination: Double,
    val AngularDiameter: Double,
    val DistanceToSun: Double,
    val SunAngularDiameter: Double
    )
