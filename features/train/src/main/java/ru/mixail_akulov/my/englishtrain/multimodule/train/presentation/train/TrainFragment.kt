package ru.mixail_akulov.my.englishtrain.multimodule.train.presentation.train

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.viewBinding
import ru.mixail_akulov.my.englishtrain.multimodule.train.R
import ru.mixail_akulov.my.englishtrain.multimodule.train.databinding.FragmentTrainBinding

class TrainFragment : Fragment() {

    private val binding by viewBinding<FragmentTrainBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_train, container, false)
    }

}