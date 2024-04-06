package com.example.lab2mealla

interface ContadorListener {
    fun incrementar()//metodo que será llamado para incrementar el valor del contador
    fun getValorActual():Int //metodo que será llamado para obtener el valor actual del contador
    fun resetear() //metodo que será llamado para inicializar en 0 el valor actual del cont
    fun reducir() //meotod que será llamado para reducir el valor actual del contador
}