package com.example.itproger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)


        val itemsList: RecyclerView = findViewById(R.id.Items_list)
        val items = arrayListOf<Item>()

        items.add(Item(1, "divan", "divan", "диван просто огонь",
            "Глубина - 91 см\n" +
                "Ширина - 203 см\n" +
                "Высота - 80 см\n" +
                "Высота посадки - 44 см\n" +
                "Глубина посадки - 60 см\n" +
                "Материал ткань, металл",1000))
        items.add(Item(2, "lampa", "lampa", "топ лампа ",
            "Параметры основания\n" +
                "\n" +
                "Материал основания\n" +
                "дерево, сталь\n" +
                "Цвет основания\n" +
                "коричневый, черный\n" +
                "Параметры плафонов\n" +
                "\n" +
                "Материал плафона\n" +
                "сталь\n" +
                "Цвет плафона\n" +
                "кремовый, черный",500))
        items.add(Item(3, "kichen", "kyxnya", "лучшая кухня", "Классический стиль кухни тяготеет к эпохе античности, от которого он взял простые формы и линии с умеренным количеством декора. Его выбирают люди традиционных семейных ценностей, стремящиеся прочно занять свое место в жизни согласно общепринятым представлениям об успехе (карьера, семья, дети).",2000))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}