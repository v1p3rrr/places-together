package com.vpr.places_together.ui.groups_list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.MaterialToolbar
import com.vpr.places_together.R
import com.vpr.places_together.databinding.FragmentGroupListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupsListFragment: Fragment() {
    private val viewModel: GroupsListViewModel by viewModels()
    private lateinit var binding: FragmentGroupListBinding
    private lateinit var navController: NavController
    private lateinit var adapter: GroupsListAdapter
    private lateinit var searchView: SearchView
    private var unfilteredList: List<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupMenu()
        setAdapter()
        setListeners()
    }

    private fun setupMenu() {
        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.top_app_bar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.title = getString(R.string.groups_screen_title)
        toolbar.setNavigationOnClickListener {
            println("back btn pressed")
            navController.navigateUp()
        }

        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                menuInflater.inflate(R.menu.menu_search, menu)
                val searchItem = menu.findItem(R.id.action_search)
                val searchView = searchItem.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        // Handle search query submission
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        // Handle search query text change
                        return true
                    }
                })

                searchView.setOnSearchClickListener {
                    toolbar.title = null
                    toolbar.isTitleCentered = false
                }

                searchView.setOnCloseListener {
                    toolbar.title = getString(R.string.groups_screen_title)
                    toolbar.isTitleCentered = true
                    false
                }

                searchView.queryHint = getString(R.string.search_hint)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_done -> {
                        println("clicked on done btn")
                        true
                    }

                    else -> false
                }
            }

            override fun onMenuClosed(menu: Menu) {
                menu.clear()
                super.onMenuClosed(menu)
            }

        })
    }

    private fun setAdapter() {
        adapter = GroupsListAdapter{ groupId -> groupId.apply { onGroupSelect(groupId) } }
        //todo collect flow
        binding.groupRecyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onGroupSelect(id: Long) {
        val directions = GroupsListFragmentDirections.actionGroupsListFragmentToGroupFragment(id)
        searchView.setQuery("", false)
        navController.navigate(directions)
    }

    private fun setListeners() {

    }

    fun filterGroupsInRecycler(query: CharSequence?) {
        val list = mutableListOf<String>() //todo group entity
        val queryList = query?.split(Regex("\\W"))

        // perform the data filtering
        if (query.isNullOrEmpty()) {
            list.addAll(unfilteredList)
        } else {
            list.addAll(unfilteredList.filter {
                checkQueryEntry(it, queryList)
            })
        }
        adapter.submitList(list)
    }

    private fun checkQueryEntry(group: String, queryList: List<String>?) : Boolean{
        queryList?.let {
            for (queryWord in it) {
                queryWord.let {
                    //if (!(group.name.contains(queryWord, ignoreCase = true)))
                    return false
                }
            }
            return true
        }
        return false
    }
}