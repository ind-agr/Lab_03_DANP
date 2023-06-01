package com.example.lab_03_danp.navigation

sealed class Route(
    val route: String
){
    object Home: Route("home")
    object CourseRegister: Route("courseRegister")
    object StudentRegister: Route("studentRegister")
    object CourseList: Route("courseList")

}