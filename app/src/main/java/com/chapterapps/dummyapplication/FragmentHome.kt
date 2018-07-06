package com.chapterapps.dummyapplication

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment(), View.OnClickListener {

    private lateinit var recyclerHome: RecyclerView
    private var items: ArrayList<String> = ArrayList()
    private var tickCross: ImageView? = null
    private var tickToCross: AnimatedVectorDrawable? = null
    private var crossToTick: AnimatedVectorDrawable? = null
    private var tick = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        tickCross = view.findViewById(R.id.tick_cross)
        tickToCross = context?.let { ContextCompat.getDrawable(it, R.drawable.avd_tick_to_cross) } as AnimatedVectorDrawable
        crossToTick = ContextCompat.getDrawable(context!!, R.drawable.avd_cross_to_tick) as AnimatedVectorDrawable
        recyclerHome = view.findViewById(R.id.recycler_home)
        recyclerHome.layoutManager = LinearLayoutManager(context)
        recyclerHome.adapter = RecyclerAdapter(items(), context)
        tickCross!!.setImageDrawable(tickToCross)
        tickCross!!.setOnClickListener(this)
        return view
    }

    fun animate() {
        val drawable = if (tick) tickToCross else crossToTick
        tickCross!!.setImageDrawable(drawable)
        drawable!!.start()
        tick = !tick
    }

    override fun onClick(view: View) {
        Toast.makeText(context, "App", Toast.LENGTH_SHORT).show()
        animate()
    }

    private fun items(): ArrayList<String> {
        for (i in 1..20)
            items.add(i.toString())
        return items
    }

    // taken from http://stackoverflow.com/a/6692725#0#L0
    fun writeOnDrawable(drawableId: Int, text: String): BitmapDrawable {
        val bm = BitmapFactory.decodeResource(resources, drawableId)
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.textSize = 20f
        val canvas = Canvas(bm)
        canvas.drawText(text, 0f, (bm.height / 2).toFloat(), paint)
        return BitmapDrawable(bm)
    }

}
