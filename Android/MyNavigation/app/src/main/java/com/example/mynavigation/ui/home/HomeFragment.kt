package com.example.mynavigation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mynavigation.R
import com.example.mynavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
private lateinit var mActivity :AppCompatActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
       mActivity = activity as AppCompatActivity
/*        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        mActivity.setSupportActionBar(binding.toolbar)
        val actionBar = mActivity.supportActionBar
        actionBar?.title = "dddddddddd"
        actionBar?.setDisplayShowTitleEnabled(true);
        actionBar?.setDisplayHomeAsUpEnabled(true)


        return root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.getItemId() == android.R.id.home) {
            Log.e("NavigationItem22", item.getItemId().toString())
            return true;
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("NavigationItem", "销毁了吗")
        _binding = null
    }
}