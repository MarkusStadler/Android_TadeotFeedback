package at.htl.tadeotfeedback_02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.htl.tadeotfeedback_02.databinding.FragmentQuestionBinding
import at.htl.tadeotfeedback_02.databinding.FragmentWelcomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentQuestionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_question, container, false
        )

        binding.ratingBtn1.setOnClickListener{
                view -> rateButtonClicked(view)
        }
        binding.ratingBtn2.setOnClickListener{
                view -> rateButtonClicked(view)
        }
        binding.ratingBtn3.setOnClickListener{
                view -> rateButtonClicked(view)
        }
        binding.ratingBtn4.setOnClickListener{
                view -> rateButtonClicked(view)
        }
        binding.ratingBtn5.setOnClickListener{
                view -> rateButtonClicked(view)
        }
        binding.ratingBtn6.setOnClickListener{
                view -> rateButtonClicked(view)
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun rateButtonClicked(view: View){
        val rating = Integer.parseInt(view.tag.toString())
        Toast.makeText(this.context, "Rating: $rating", Toast.LENGTH_LONG).show()
        view.findNavController().navigate(QuestionFragmentDirections.actionQuestionFragmentToSummaryFragment(rating))
    }
}