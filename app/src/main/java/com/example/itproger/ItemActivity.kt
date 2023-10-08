package com.example.itproger

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()
        co.setKeyID("rzp_test_JQOX5jmEilxXbT")


        val title: TextView = findViewById(R.id.item_list_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val btn: TextView = findViewById(R.id.button_buy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        btn.setOnClickListener{
            startPayment()
        }


    }

        private fun startPayment() {
            val activity: Activity = this
            val co = Checkout()

            try {
                val options = JSONObject()
                options.put("name","Broke")
                options.put("description","Demoing Charges")
                //You can omit the image option to fetch the image from the dashboard
                options.put("image","https://metaratings.ru/upload/iblock/53f/53f4eaff306a4c76aec076f22d8bff4c.jpg")
                options.put("theme.color", "#3399cc");
                options.put("currency","USD");
                options.put("order_id", "order_MjRXTC3DPEXuHA");
                options.put("amount",10000)
                co.open(activity,options)
            }catch (e: Exception){
                Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }
        }


}