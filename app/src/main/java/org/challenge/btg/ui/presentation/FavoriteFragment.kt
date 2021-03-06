package org.challenge.btg.ui.presentation


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_movies.view.*

import org.challenge.btg.R
import org.challenge.btg.ui.presentation.adapter.MovieAdapter

class FavoriteFragment : Fragment() {

    lateinit var adapterRecycleViewFavorite: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies, container, false)

        val recyclerView = rootView.recyclerView as RecyclerView
        recyclerView.adapter = MovieAdapter(emptyList())
        adapterRecycleViewFavorite = recyclerView.adapter as MovieAdapter

        val editSearch = rootView.edit_search as EditText
        editSearch.hint = R.string.find_name_year.toString()
        editSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                adapterRecycleViewFavorite.setFilter(charSequence.toString())
            }
        })

        return rootView
    }

    override fun onResume() {
        adapterRecycleViewFavorite.updateListFavorites()
        super.onResume()
    }

}
