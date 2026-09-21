package com.week02

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.week02.ui.theme.Kotlinweek02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlinweek02Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        week04Classes()

    }
}
private fun week04Collections() {
    println("==============================")

    val fruits = listOf("Apple" , "Banana" , "Orange")
    var mutablefruits = mutableListOf("Kiwi", "watermelon")

    //imutable
    //fruits.add()

    //mutable
    mutablefruits.add("banana")

    println("$fruits")
    println("$mutablefruits")

    val scores = mapOf("Kim" to 100, "park" to 20, "Lee" to 80)
    println("$scores")

    scores.forEach { name, age -> println("$name -> $age") }
    fruits.forEach { fruit -> println("$fruit") }
}
private fun week04Class() {
    println("========================")

    class Student{
        var name: String = ""
        var age: Int = 0

        fun introduce(){
            println("HI I'm $name and I am $age years old")
        }
    }
    val student1 = Student()
    student1.name = "추추추"
    student1.age = 23
    student1.introduce()

    data class Person(val name: String,val age: Int) //Java toString()

    val person1 = Person("KIM", 23)
    val person2 = Person("JANG",22)

    println("$person1")
    println("${person1.name}")
}
private fun week04Classes(){
    Log.d("KotlinWeek04", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("KotlinWeek04", "안녕하세요, $name ($age 세)입니다.")
        }
        fun birthday(){
            age++
            Log.d("KotlinWeek04", "$name 의 생일! 이제 $age 세...")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek04", "$species 의 무게 : $weight kg")
        }
        fun makeSound(){
            Log.d("KotlinWeek04", "$species 가 소리를 냅니다.")
        }
    }
    val puppy = Animal("웰시코기", 10.5)
    puppy.makeSound()
}

private fun week03Variables() {
    println("Week 03: Variables")

    val courseName = "Mobile Programming"  // java final
    // courseName = "Data Structure"  // error

    var week = 2
    week = 3
    println("Course : $courseName")
    println("Week : $week")

    println("========= Kotlin Variables =========")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8

    println("Hi $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = false

    println("Age: $age, Height: $height, Student: $isStudent")

//    var nickname:String = null
    var nickname: String? = null
    nickname = "mirae"
    println("Nickname: $nickname ${nickname?.length}")
}

private fun week03Functions(){
//    println("Week 03: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("========= Kotlin Functions =========")

    fun greet(name: String): String {
        return "Hello, $name!"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("Kim", 7)
    introduce("Park")

    fun printAll(vip: Boolean,name: String){
        println("$vip $name")
    }
    printAll(true,"dy")
    printAll(name="dd",vip=true)

    fun printMany(vararg msg: String){
        for(m in msg){
            println(m)
        }
    }

    printMany("A","B","C","D")
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlinweek02Theme {
        Greeting("Android")
    }
}