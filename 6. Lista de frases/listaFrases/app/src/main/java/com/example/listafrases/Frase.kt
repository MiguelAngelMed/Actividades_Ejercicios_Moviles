package com.example.listafrases

class Frase {
    private var idFrase: Int
    private var frase: String
    private var autor: String
    private var imgFrase: Int

    constructor(idFrase: Int,frase: String, autor: String, imgFrase: Int){
        this.idFrase = idFrase
        this.frase = frase
        this.autor = autor
        this.imgFrase = imgFrase
    }

    fun getIdFrase():Int{
        return this.idFrase
    }

    fun setIdFrase(idFrase: Int){
        this.idFrase = idFrase
    }

    fun getFrase():String{
        return this.frase
    }

    fun setFrase(frase: String){
        this.frase = frase
    }

    fun getAutor(): String{
        return this.autor
    }

    fun setAutor(autor: String){
        this.autor = autor
    }

    fun getImgFrase():Int{
        return this.imgFrase
    }

    fun setImgFrase(imgFrase: Int){
        this.imgFrase = imgFrase
    }


}