package com.example.ejemplodb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper (context: Context) :
    /*Se define una clase llamada SQLiteHelper que hereda de SQLiteOpenHelper. Recibe un parámetro de tipo Context
    *que se utiliza para acceder al contexto de la aplicación.
    *Se llama al constructor de la superclase SQLiteOpenHelper pasando el contexto, el nombre de la base de datos ("FrasesChuck.db"),
    * null como valor para el cursorFactory y la versión de la base de datos (1).
    * */
    SQLiteOpenHelper(context, "FrasesChuck.db",null, 1){


    /*El método onCreate se llama cuando la base de datos se crea por primera vez.
    *Se ejecuta la sentencia SQL utilizando el objeto db proporcionado como parámetro.*/
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table Frases(idFrase integer primary key autoincrement," +
                " frase text, autor text)"
        db?.execSQL(sql)
    }

    /*Este método se llama cuando la versión de la base de datos existente es más baja
    que la versión especificada en el constructor.*/
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table if exists Frases")
        onCreate(db)
    }

    /*
    * Se obtiene una referencia a la base de datos en modo de escritura utilizando writableDatabase.
    * Se crea un objeto ContentValues que se utiliza para almacenar los valores de las columnas.
    * Se insertan los valores de frase.frase y frase.autor en el objeto contentValues.
    * Se utiliza el método insert de la base de datos para insertar una nueva fila en la tabla "Frases" con los valores proporcionados.
    *Se devuelve true si el resultado de la inserción es diferente de -1, lo que indica que la inserción fue exitosa.*/
    fun create(frase : Frase): Boolean{
        val db = writableDatabase

        val contentValues = ContentValues()
        contentValues.put("frase", frase.getFrase())
        contentValues.put("autor", frase.getAutor())

        val resultado : Long = db.insert("Frases", null, contentValues)
        return resultado != -1 .toLong()

    }

    fun readAll() : Cursor {
        val db = writableDatabase
        /*
        * Se utiliza el método rawQuery de la base de datos para ejecutar una consulta SQL directamente.*/
        val cursor = db.rawQuery("SELECT * FROM Frases", null)
        return  cursor
    }
}


/*
* Un CursorFactory es una clase que se utiliza para crear instancias de objetos Cursor a partir de los resultados de una
* consulta a la base de datos. Proporciona una forma de personalizar la creación y configuración de los objetos Cursor.
* El Cursor se utiliza para acceder y manipular los resultados de la consulta.*/