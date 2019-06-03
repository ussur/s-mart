package com.example.s_mart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoritesAddFragment extends Fragment{

    public FavoritesAddFragment() {
    }

    public static FavoritesAddFragment newInstance() {
        return new FavoritesAddFragment();
    }

    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_search_main, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList dataSearch = new ArrayList<DataSearch>();
        for (int i = 0; i <Iphone.id.length; i++)
        {
            dataSearch.add(
                    new DataSearch
                            (
                                    Iphone.nameArray[i],
                                    Iphone.priceArray[i],
                                    Iphone.categoryArray[i],
                                    Iphone.ratingArray[i]
                            ));
        }
        mListAdapter = new ListAdapter(dataSearch);
        mRecyclerView.setAdapter(mListAdapter);
        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        private ArrayList<DataSearch> dataList;

        public ListAdapter(ArrayList<DataSearch> dataSearch)
        {
            this.dataList = dataSearch;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewName;
            TextView textViewPrice;
            TextView textViewCategory;
            TextView textViewRating;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewName = (TextView) itemView.findViewById(R.id.name);
                this.textViewPrice = (TextView) itemView.findViewById(R.id.price);
                this.textViewCategory = (TextView) itemView.findViewById(R.id.category);
                this.textViewRating = (TextView) itemView.findViewById(R.id.rating);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_search, parent, false);
            ListAdapter.ViewHolder viewHolder = new ListAdapter.ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.textViewName.setText(dataList.get(position).getName());
            holder.textViewPrice.setText(dataList.get(position).getPrice());
            holder.textViewCategory.setText(dataList.get(position).getCategory());
            holder.textViewRating.setText(dataList.get(position).getRating());

        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }
}
