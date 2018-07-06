package com.chapterapps.dummyapplication

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        animate()
    }

    private var imageView: ImageView? = null
    private var emptyHeart: AnimatedVectorDrawable? = null
    private var fillHeart: AnimatedVectorDrawable? = null
    private var full = false

    val items: ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        imageView = view.findViewById(R.id.heart_fill) as ImageView
        emptyHeart = context?.let { ContextCompat.getDrawable(it, R.drawable.avd_heart_empty) } as AnimatedVectorDrawable?
        fillHeart = ContextCompat.getDrawable(context!!, R.drawable.avd_heart_fill) as AnimatedVectorDrawable?
        imageView!!.setOnClickListener(this)
        /*tickToCross = getDrawable(avd_tick_to_cross) as AnimatedVectorDrawable
        crossToTick = getDrawable(R.drawable.avd_cross_to_tick) as AnimatedVectorDrawable*/
        return view
    }

    fun addItems() {
        for (i in 1..20)
            items.add(i.toString())
    }

    fun animate() {
        val drawable = if (full) emptyHeart else fillHeart
        imageView?.setImageDrawable(drawable)
        drawable?.start()
        full = !full
    }
}