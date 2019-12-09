package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var premiumModel:PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        premiumModel = ViewModelProviders.of(this).get(PremiumModel::class.java)

        btnCalculate.setOnClickListener(){
            var premium = 0;
            var extraMale= 0;
            var extraSmoker = 0;
            if(spinner.selectedItemPosition == 0){
                premium = 60;
            }else if(spinner.selectedItemPosition == 1){
                premium = 70;
                if(radioGroup.checkedRadioButtonId == radioMale.id){
                    extraMale = 50
                }
                if(checkBox.isChecked == true){
                    extraSmoker =100;
                }
            }else if(spinner.selectedItemPosition == 2){
                premium = 90;
                if(radioGroup.checkedRadioButtonId == radioMale.id){
                    extraMale = 100
                }
                if(checkBox.isChecked == true){
                    extraSmoker =150;
                }
            }else if(spinner.selectedItemPosition == 3){
                premium = 120;
                if(radioGroup.checkedRadioButtonId == radioMale.id){
                    extraMale = 150
                }
                if(checkBox.isChecked == true){
                    extraSmoker =200;
                }
            }else if(spinner.selectedItemPosition == 4){
                premium = 150;
                if(radioGroup.checkedRadioButtonId == radioMale.id){
                    extraMale = 200
                }
                if(checkBox.isChecked == true){
                    extraSmoker =250;
                }
            }else if(spinner.selectedItemPosition == 5){
                premium = 150;
                if(radioGroup.checkedRadioButtonId == radioMale.id){
                    extraMale = 200
                }
                if(checkBox.isChecked == true){
                    extraSmoker =300;
                }
            }else{

            }
            var total = premium +extraMale +extraSmoker;

            premiumModel.premium = total.toString().toDouble()
            txtTotal.text = "RM"+ premiumModel.premium
        }
        txtTotal.text = "RM"+ premiumModel.premium
    }
}
