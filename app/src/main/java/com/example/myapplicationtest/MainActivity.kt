package com .example.myapplicationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var rr : TextView? =null
    private var totalSquare : EditText? =null
    private var tileHeight : EditText? =null
    private var tileWidth : EditText? =null
    private var jointWidth: EditText? =null
    private var jointHeight : EditText? =null


    private var rrF : Float? =null
    private var totalSquareF : Float? =1.0f
    private var tileHeightF : Float? =0.0f
    private var tileWidthF : Float? =0.0f
    private var jointWidthF: Float? =0.0f
    private var jointHeightF : Float? =0.0f
    private var jointDensityF : Float? =1.6f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spiner : Spinner=findViewById(R.id.jointName)

    totalSquare=this.findViewById(R.id.totalSquare)
    tileHeight=this.findViewById(R.id.tileHeight)
    tileWidth=this.findViewById(R.id.tileWidth)
    jointHeight=this.findViewById(R.id.jointHeight)
    jointWidth=this.findViewById(R.id.jointWidth)
    rr=this.findViewById(R.id.jointAmount)



        totalSquare?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString()=="")

                    totalSquareF=0.0f
else
              totalSquareF= totalSquare?.text.toString().toFloat()
                println(totalSquareF)

         rr?.text= kuku(totalSquareF!!,tileHeightF!!, tileWidthF!!, jointWidthF!!, jointHeightF!!, jointDensityF!!
         ).toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        )


        tileHeight?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString()=="")

                    tileHeightF=0.0f

                else

                tileHeightF= tileHeight?.text.toString().toFloat()
                println(tileHeightF)

                rr?.text= kuku(totalSquareF!!,tileHeightF!!, tileWidthF!!, jointWidthF!!, jointHeightF!!, jointDensityF!!
                ).toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        )


        tileWidth?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString()=="")

                    tileWidthF=0.0f

                else

                tileWidthF= tileWidth?.text.toString().toFloat()
                println(tileWidthF)

                rr?.text= kuku(totalSquareF!!,tileHeightF!!, tileWidthF!!, jointWidthF!!, jointHeightF!!, jointDensityF!!
                ).toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        )


        jointHeight?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString()=="")

                    jointHeightF=0.0f

                else

                jointHeightF= jointHeight?.text.toString().toFloat()
                println(jointHeightF)

                rr?.text= kuku(totalSquareF!!,tileHeightF!!, tileWidthF!!, jointWidthF!!, jointHeightF!!, jointDensityF!!
                ).toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        )


        jointWidth?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString()=="")

                    jointWidthF=0.0f

                else

                jointWidthF= jointWidth?.text.toString().toFloat()
                println(jointWidthF)
                rr?.text= kuku(totalSquareF!!,tileHeightF!!, tileWidthF!!, jointWidthF!!, jointHeightF!!, jointDensityF!!
                ).toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        )

        spiner.onItemSelectedListener= this

        ArrayAdapter.createFromResource(
            this,
            R.array.jointsArr,
            android.R.layout.simple_spinner_item
        ).also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spiner.adapter=adapter
        }



    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when (p2) {
            0 -> jointDensityF=1.6f
            1 -> jointDensityF=1.7f
            2 -> jointDensityF=2.2f
            3 -> jointDensityF=1.7f


            else -> {
                print("x is neither 1 nor 2")
            }
        }
    //  rr?.text=jointDensityF.toString()
        rr?.text= kuku(totalSquareF!!,tileHeightF!!, tileWidthF!!, jointWidthF!!, jointHeightF!!, jointDensityF!!
        ).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        println("NOthing")
    }

    fun kuku(
        totSquare: Float = 1.0f,
        tilHeight: Float=0.0f,
        tilWidth: Float=0.0f,
        joinWidth: Float=0.0f,
        joinHeight: Float=0.0f,
        joinDensity: Float=0.0f,

        ): Float {

        if (tilHeight==0.0f || tilWidth == 0.0f || joinHeight==0.0f || joinWidth ==0.0f || joinDensity==0.0f)

            return  0.0f

        var sumLength: Float = (totSquare) / (tilHeight/1000 )+ 1


        sumLength += totSquare / (tilWidth / 1000)


            // println(sumLength * (joinHeight / 1000 )* (joinWidth / 1000)*joinDensity)

        //return (11*0.006*0.005*100).toFloat()

        return   (((sumLength/100)*87) * (joinHeight / 1000 )* (joinWidth / 1000)*1000*joinDensity)
    }

}



