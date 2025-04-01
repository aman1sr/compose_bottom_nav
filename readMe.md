# Bottom Navigation in Jetpack Compose

## Overview
This Android project demonstrates example of Bottom Navigation, This project is a subset of Compose News App check out the compose app given link below: 
[https://github.com/aman1sr/Compose-NewsApp](https://github.com/aman1sr/Compose-NewsApp)


## Screenshots


![Sample GIF](https://content.gorillalogic.com/img/2021/03/Gif-6.gif)


## Fundamental Concepts of implementing Bottom Navigation in Jetpack Compose
- The Navigation component has three main parts:
    - NavController: Responsible for navigating between destinations—that is, the screens in your app.
    - NavGraph: Maps composable destinations to navigate to. 
    - NavHost: Composable acting as a container for displaying the current destination of the NavGraph.

- Route :  
  - fundamental concepts of navigation in a Compose app is the route. 
  - a route is a string that corresponds to a destination. This idea is similar to the concept of a URL
  - a route is a string that maps to a destination and serves as its unique identifier
    - in the given project Route is being defined via enum class
- 
---

### App Demo
<div align="center">
  <img src="https://github.com/aman1sr/compose_bottom_nav/blob/main/app/src/main/res/drawable/compose_bottom_nav.gif?raw=true" 
       alt="App Demo" 
       style="max-width: 100%; height: auto; max-height: 500px; width: auto; display: block; margin: 0 auto;">
</div>

---
##  Article references:
- [Article Link: codelab](https://developer.android.com/codelabs/basic-android-kotlin-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-2)
- [google off doc](https://developer.android.com/develop/ui/compose/navigation)
- [Article Link: geek4geeks ](https://www.geeksforgeeks.org/bottom-navigation-bar-in-android-jetpack-compose/)







