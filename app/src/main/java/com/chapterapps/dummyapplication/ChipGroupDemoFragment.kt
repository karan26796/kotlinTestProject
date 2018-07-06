package com.chapterapps.dummyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class ChipGroupDemoFragment : Fragment() {

    private var singleSelectionSwitch: Switch? = null

    @Nullable
    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(
                R.layout.cat_chip_group_fragment, container, false /* attachToRoot */)

//        val content: ViewGroup = view.findViewById(R.id.content)

        singleSelectionSwitch = view.findViewById(R.id.single_selection)
        val reflowGroup: ChipGroup = view.findViewById(R.id.reflow_group)
        val scrollGroup: ChipGroup = view.findViewById(R.id.scroll_group)

        singleSelectionSwitch!!.setOnCheckedChangeListener { buttonView, isChecked ->
            reflowGroup.setSingleSelection(isChecked)
            scrollGroup.setSingleSelection(isChecked)

            initChipGroup(reflowGroup)
            initChipGroup(scrollGroup)
        }
        initChipGroup(reflowGroup)
        initChipGroup(scrollGroup)

        return view
    }

    @LayoutRes
    protected fun getChipGroupItem(singleSelection: Boolean): Int {
        return if (singleSelection)
            R.layout.cat_chip_group_item_choice
        else
            R.layout.cat_chip_group_item_filter
    }

    private fun initChipGroup(chipGroup: ChipGroup) {
        chipGroup.removeAllViews()

        val singleSelection = singleSelectionSwitch!!.isChecked
        val textArray = getResources().getStringArray(R.array.cat_chip_group_text_array)
        for (text in textArray) {
            val chip = getLayoutInflater().inflate(getChipGroupItem(singleSelection), chipGroup, false) as Chip
            chip.setChipText(text)
            chipGroup.addView(chip)
        }
    }
}